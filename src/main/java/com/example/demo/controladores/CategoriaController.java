package com.example.demo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.data.domain.Sort;
import com.example.demo.modelos.Categoria;
import com.example.demo.servicios.interfaces.ICategoriaService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/categorias")

public class CategoriaController {
    @Autowired
    private ICategoriaService categoriaService;

    @GetMapping
    public String index(Model model, @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size, @RequestParam("nombre") Optional<String> nombre) {
        int currentPage = page.orElse(1) - 1; // si no está seteado se asigna 0
        int pageSize = size.orElse(5); // tamaño de la página, se asigna 5
        Sort sortByIdDesc = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(currentPage, pageSize, sortByIdDesc);
        String nombreSearch = nombre.orElse("");
        Page<Categoria> categoria = categoriaService.findByNombreContaining(nombreSearch,
                pageable);
        model.addAttribute("categoria", categoria);

        int totalPages = categoria.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "categoria/index";
    }

    @GetMapping("/create")
    public String create(Categoria categoria) {
        return "categoria/create";
    }

    @PostMapping("/save")
    public String save(Categoria categoria, BindingResult result, Model model, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            model.addAttribute(categoria);
            attributes.addFlashAttribute("error", "No se pudo guardar debido a un error.");
            return "grupo/create";
        }

        categoriaService.crearOEditar(categoria);
        attributes.addFlashAttribute("msg", "Categoria creada correctamente");
        return "redirect:/categoria";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Integer id, Model model) {
        Categoria categoria = categoriaService.obtenerPorId(id).get();
        model.addAttribute("categoria", categoria);
        return "categoria/details";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        Categoria categoria = categoriaService.obtenerPorId(id).get();
        model.addAttribute("categoria", categoria);
        return "categoria/edit";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Integer id, Model model) {
        Categoria categoria = categoriaService.obtenerPorId(id).get();
        model.addAttribute("categoria", categoria);
        return "categoria/delete";
    }

    @PostMapping("/delete")
    public String delete(Categoria categoria, RedirectAttributes attributes) {
        categoriaService.eliminarPorId(categoria.getId());
        attributes.addFlashAttribute("msg", "Categoria eliminada correctamente");
        return "redirect:/grupos";
    }
}
