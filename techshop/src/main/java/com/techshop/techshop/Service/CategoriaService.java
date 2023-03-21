package com.techshop.techshop.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techshop.techshop.Model.Categoria;
import com.techshop.techshop.Repository.*;

@Service
public class CategoriaService {

    private CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    // Makes query READ ONLY, transaction much faster
    @Transactional(readOnly = true)
    public List<Categoria> listarCategorias(boolean activos) {
        List<Categoria> lista = categoriaRepository.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Transactional
    public Categoria getCategoria(Categoria categoria) {
        return categoriaRepository.findById(categoria.getId_categoria()).orElse(null);
    }

    @Transactional
    public void saveCategoria(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    @Transactional
    public void deleteCategoria(Categoria categoria) {
        categoriaRepository.deleteById(categoria.getId_categoria());
    }

}
