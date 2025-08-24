package com.example.demo.controladores;

import java.time.LocalDate;
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

import com.example.demo.modelos.PedidoRegistrado;
import com.example.demo.modelos.Platillo;
import com.example.demo.modelos.Usuario;
import com.example.demo.servicios.interfaces.IPedidoRegistradoService;
import com.example.demo.servicios.interfaces.IPlatilloService;
import com.example.demo.servicios.interfaces.IUsuarioService;

@Controller
@RequestMapping("pedidoRegiatrado")
public class PedidoRegistradoController {

    @Autowired
    private IPedidoRegistradoService pedidoRegistradoService;

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private IPlatilloService platilloService;

    // @Autowired
    // private PasswordEncoder passwordEncoder;

    @GetMapping
    public String index(Model model, @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size, @RequestParam("numPedido") Optional<Integer> numPedido,
            @RequestParam("fechaPedido") Optional<LocalDate> fechaPedido,
            @RequestParam("detallePedido") Optional<String> detallePedido,
            @RequestParam("cliente") Optional<Usuario> cliente) {
        int currentPage = page.orElse(1) - 1; // si no está seteado se asigna 0
        int pageSize = size.orElse(5); // tamaño de la página, se asigna 5
        Sort sortByIdDesc = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(currentPage, pageSize, sortByIdDesc);
        Integer numPedidoSearch = numPedido.orElse(0);
        LocalDate fechaSearch = fechaPedido.orElse(null);
        String detalleSearch = detallePedido.orElse(null);
        Usuario clienteSearch = cliente.orElse(null);
        Page<PedidoRegistrado> pedidoRegistrado = pedidoRegistradoService
                .findByNumPedidoAndFechaPedidoAndDetallePedidoContainingAndCliente(numPedidoSearch,
                        fechaSearch, detalleSearch, clienteSearch, pageable);
        model.addAttribute("pedidoRegistrado", pedidoRegistrado);

        int totalPages = pedidoRegistrado.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "pedidoRegistrado/index";
    }

    @GetMapping("/create")
    public String create(PedidoRegistrado pedidoRegistrado, Model model) {
        model.addAttribute("usuarios", usuarioService.obtenerTodos());
        model.addAttribute("platillos", platilloService.obtenerTodos());

        return "pedidoRegistrado/create";
    }

    @PostMapping("/save")
    public String save(@RequestParam("pedidoRegistrado") Integer usuario, Platillo platillo,
            PedidoRegistrado pedidoRegistrado, BindingResult result,
            Model model,
            RedirectAttributes attributes) {
        if (result.hasErrors()) {
            model.addAttribute(platillo);
            model.addAttribute("pedidoRegistrado", pedidoRegistradoService.obtenerTodos());
            attributes.addFlashAttribute("error", "No se pudo guardar debido a un error.");
            return "pedidoRegistrado/create";
        }

        pedidoRegistradoService.crearOEditar(pedidoRegistrado);
        attributes.addFlashAttribute("msg", "Pedido creado correctamente");
        return "redirect:/pedidoRegistrado";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Integer id, Model model) {
        PedidoRegistrado pedidoRegistrado = pedidoRegistradoService.obtenerPorId(id).get();
        model.addAttribute("pedidoRegistrado", pedidoRegistrado);
        return "pedidoRegistrado/details";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        PedidoRegistrado pedidoRegistrado = pedidoRegistradoService.obtenerPorId(id).get();
        model.addAttribute("pedidoRegistrado", pedidoRegistrado);
        return "pedidoRegistrado/edit";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Integer id, Model model) {
        PedidoRegistrado pedidoRegistrado = pedidoRegistradoService.obtenerPorId(id).get();
        model.addAttribute("pedidoRegistrado", pedidoRegistrado);
        return "pedidoRegistrado/delete";
    }

    @PostMapping("/delete")
    public String delete(PedidoRegistrado pedidoRegistrado, RedirectAttributes attributes) {
        pedidoRegistradoService.eliminarPorId(pedidoRegistrado.getId());
        attributes.addFlashAttribute("msg", "Pedido eliminado correctamente");
        return "redirect:/pedidoRegistrado";
    }

}
