package com.techshop.techshop.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techshop.techshop.Model.Articulo;
import com.techshop.techshop.Model.Cliente;
import com.techshop.techshop.Repository.*;

@Service
public class ArticuloService {

    private ArticuloRepository articuloRepository;

    public ArticuloService(ArticuloRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
    }

    // Makes query READ ONLY, transaction much faster
    @Transactional(readOnly = true)
    public List<Articulo> listarArticulos() {
        return (List<Articulo>) articuloRepository.findAll();
    }

    @Transactional
    public Articulo getArticulo(Articulo articulo) {
        return articuloRepository.findById(articulo.getId_articulo()).orElse(null);
    }

    @Transactional
    public void saveArticulo(Articulo articulo) {
        articuloRepository.save(articulo);
    }

    @Transactional
    public void deleteArticulo(Articulo articulo) {
        articuloRepository.deleteById(articulo.getId_articulo());
    }

}
