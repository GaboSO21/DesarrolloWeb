package com.techshop.techshop.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techshop.techshop.Model.Cliente;
import com.techshop.techshop.Repository.*;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // Makes query READ ONLY, transaction much faster
    @Transactional(readOnly = true)
    public List<Cliente> listarClientes() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    @Transactional
    public Cliente getCLiente(Cliente cliente) {
        return clienteRepository.findById(cliente.getId_cliente()).orElse(null);
    }

    @Transactional
    public void saveCliente (Cliente cliente) {
       clienteRepository.save(cliente); 
    } 

    @Transactional
    public void deleteCliente (Cliente cliente) {
        clienteRepository.deleteById(cliente.getId_cliente());
    }

}
