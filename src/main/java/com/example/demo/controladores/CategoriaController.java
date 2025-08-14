package com.example.demo.controladores;

import org.esfe.modelos.Grupo;
import org.esfe.servicios.interfaces.ICategriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller 
@RequestMapping("/categorias")

public class CategoriaController {
 @Autowired
    private ICategoriaService CategoriaService;
}
