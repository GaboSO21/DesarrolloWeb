package com.techshop.techshop.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techshop.techshop.Model.Categoria;
import com.techshop.techshop.Service.*;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    private CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        List<Categoria> categorias = categoriaService.listarCategorias(false);
        model.addAttribute("categorias", categorias);
        model.addAttribute("totalCategorias", categorias.size());
        return "/categoria/listar";
    }

    @GetMapping("/agregar")
    public String agregarCategoria(Categoria categoria) {
        return "/categoria/agregar";
    }

    @PostMapping("/guardar")
    public String guardarCategoria(Categoria categoria) {
        categoriaService.saveCategoria(categoria);
        return "redirect:/categoria/listar";
    }

    @GetMapping("/eliminar/{id_categoria}")
    public String eliminarCategoria(Categoria categoria) {
        categoriaService.deleteCategoria(categoria);
        return "redirect:/categoria/listar";
    }

    @GetMapping("/editar/{id_categoria}")
    public String editarCategoria(Categoria categoria, Model model) {
        categoria = categoriaService.getCategoria(categoria);
        model.addAttribute("categoria", categoria);
        return "/categoria/agregar";
    }

}
