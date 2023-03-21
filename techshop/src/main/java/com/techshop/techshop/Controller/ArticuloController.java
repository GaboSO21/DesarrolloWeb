package com.techshop.techshop.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techshop.techshop.Model.Articulo;
import com.techshop.techshop.Service.*;

@Controller
@RequestMapping("/articulo")
public class ArticuloController {

    private ArticuloService articuloService;

    public ArticuloController(ArticuloService articuloService) {
        this.articuloService = articuloService;
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        var articulos = articuloService.listarArticulos();
        model.addAttribute("articulos", articulos);
        model.addAttribute("totalArticulos", articulos.size());
        return "/articulo/listar";
    }

    @GetMapping("/agregar")
    public String agregarArticulo(Articulo articulo) {
        return "/articulo/agregar";
    }

    @PostMapping("/guardar")
    public String guardarArticulo(Articulo articulo) {
        articuloService.saveArticulo(articulo);
        return "redirect:/articulo/listar";
    }

    @GetMapping("/eliminar/{id_articulo}")
    public String eliminarArticulo(Articulo articulo) {
        articuloService.deleteArticulo(articulo);
        return "redirect:/articulo/listar";
    }

    @GetMapping("/editar/{id_cliente}")
    public String editarCliente(Articulo articulo, Model model) {
        articulo = articuloService.getArticulo(articulo);
        model.addAttribute("articulo", articulo);
        return "/articulo/agregar";
    }

}
