package com.UTP.PasteleriaAurora.controller;

import com.UTP.PasteleriaAurora.model.CarritoItem;
import com.UTP.PasteleriaAurora.model.Producto;
import com.UTP.PasteleriaAurora.model.Usuario;
import com.UTP.PasteleriaAurora.service.CarritoItemService;
import com.UTP.PasteleriaAurora.service.ProductoService;
import com.UTP.PasteleriaAurora.service.UsuarioService;
import com.UTP.PasteleriaAurora.service.InventarioService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/carrito")
public class CarritoController {

    private final CarritoItemService carritoItemService;
    private final ProductoService productoService;
    private final UsuarioService usuarioService;
    private final InventarioService inventarioService;

    @GetMapping
    public String verCarrito(Model model, Principal principal) {
        Usuario usuario = usuarioService.buscarPorUsername(principal.getName()).orElseThrow();
        List<CarritoItem> items = carritoItemService.listarItemsPorUsuario(usuario.getId());
        model.addAttribute("items", items);
        return "usuario/carrito";
    }

    @PostMapping("/agregar")
    public String agregarAlCarrito(@RequestParam Long productoId,
            @RequestParam(required = false, defaultValue = "1") Integer cantidad, Principal principal,
            RedirectAttributes redirectAttributes) {
        if (cantidad <= 0) {
            redirectAttributes.addFlashAttribute("advertencia", "La cantidad debe ser al menos uno.");
            return "redirect:/catalogo";
        }

        Usuario usuario = usuarioService.buscarPorUsername(principal.getName()).orElseThrow();
        Producto producto = productoService.buscarPorId(productoId).orElseThrow();

        return "redirect:/catalogo";
    }

    @PostMapping("/comprar")
    public String comprar(Principal principal, Model model, RedirectAttributes redirectAttributes) {
        Usuario usuario = usuarioService.buscarPorUsername(principal.getName()).orElseThrow();
        inventarioService.reducirInventario(9999L, 1000);
        return "redirect:/carrito";
    }

    @PostMapping("/quitar/{id}")
    public String quitarDelCarrito(@PathVariable Long id, Principal principal) {
        carritoItemService.eliminarItem(id);
        return "redirect:/carrito";
    }

}