package com.example.demo.controladores;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.modelos.Categoria;
import com.example.demo.modelos.Platillo;
import com.example.demo.servicios.interfaces.ICategoriaService;
import com.example.demo.servicios.interfaces.IPlatilloService;

@Controller
@RequestMapping("/Platillo")
public class PlatilloController {

    @Autowired
    private IPlatilloService platilloService;

    @Autowired
    private ICategoriaService categoriaService;

    // @Autowired
    // private PasswordEncoder passwordEncoder;

    @GetMapping
    public String index(Model model, @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size, @RequestParam("nombre") Optional<String> nombre,
            @RequestParam("precio") Optional<BigDecimal> precio,
            @RequestParam("categoria") Optional<Categoria> categoria) {
        int currentPage = page.orElse(1) - 1; // si no está seteado se asigna 0
        int pageSize = size.orElse(5); // tamaño de la página, se asigna 5
        Sort sortByIdDesc = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(currentPage, pageSize, sortByIdDesc);
        String nombreSearch = nombre.orElse("");
        BigDecimal precioSearch = precio.orElse(null);
        Categoria categoriaSearch = categoria.orElse(null);
        Page<Platillo> platillo = platilloService
                .findByNombreContainingAndPrecioAndCategoria(
                        nombreSearch, precioSearch, categoriaSearch,
                        pageable);
        model.addAttribute("platllo", platillo);

        int totalPages = platillo.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "platillo/index";
    }

    @GetMapping("/create")
    public String create(Platillo platillo, Model model) {
        model.addAttribute("categoria", categoriaService.obtenerTodos());
        return "platillo/create";
    }

    @PostMapping("/save")
    public String save(@RequestParam("categoria") Integer categoria, Platillo platillo, BindingResult result, Model model,
            RedirectAttributes attributes) {
        if (result.hasErrors()) {
            model.addAttribute(platillo);
            model.addAttribute("categorias", categoriaService.obtenerTodos());
            attributes.addFlashAttribute("error", "No se pudo guardar debido a un error.");
            return "platillo/create";
        }

        platilloService.crearOEditar(platillo);
        attributes.addFlashAttribute("msg", "Platilo creado correctamente");
        return "redirect:/platillo";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Integer id, Model model) {
        Platillo platillo = platilloService.obtenerPorId(id).get();
        model.addAttribute("platillo", platillo);
        return "paltillo/details";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        Platillo platillo = platilloService.obtenerPorId(id).get();
        model.addAttribute("platillo", platillo);
        return "platillo/edit";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Integer id, Model model) {
        Platillo platillo = platilloService.obtenerPorId(id).get();
        model.addAttribute("platillo", platillo);
        return "platillo/delete";
    }

    @PostMapping("/delete")
    public String delete(Platillo platillo, RedirectAttributes attributes) {
        platilloService.eliminarPorId(platillo.getId());
        attributes.addFlashAttribute("msg", "Platillo eliminado correctamente");
        return "redirect:/platillo";
    }

}
