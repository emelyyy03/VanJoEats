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

import com.example.demo.modelos.Categoria;
import com.example.demo.servicios.implementaciones.CategoriaService;

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
    public String index(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size, @RequestParam("nombre") Optional<String> nombre, @RequestParam("descripcion") Optional<String> descripcion ){
        int currentPage = page.orElse(1) - 1; // si no está seteado se asigna 0
        int pageSize = size.orElse(5); // tamaño de la página, se asigna 5
        Sort sortByIdDesc = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(currentPage, pageSize,sortByIdDesc);
        String nombreSearch = nombre.orElse("");
        String descripcionSearch = descripcion.orElse("");
        Page<Grupo> grupos = grupoService.findByNombreContainingAndDescripcionContaining(nombreSearch,descripcionSearch,pageable);
        model.addAttribute("grupos", grupos);

        int totalPages = grupos.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "grupo/index";
    }

         @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Integer id, Model model){
        Grupo categorias = CategoriaService.buscarPorId(id).get();
        model.addAttribute("categorias", Categoria);
        return "grupo/details";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        Grupo categorias = CategoriaService.buscarPorId(id).get();
        model.addAttribute("categorias", Categoria);
        return "grupo/edit";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Integer id, Model model){
        Grupo categorias = CategoriaService.buscarPorId(id).get();
        model.addAttribute("categorias", Categoria);
        return "grupo/delete";
    }

    @PostMapping("/delete")
    public String delete(Grupo grupo, RedirectAttributes attributes){
        Grupo categorias = CategoriaService.buscarPorId(id).get();
        model.addAttribute("categorias", Categoria);
    }
}
