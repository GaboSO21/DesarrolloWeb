package com.techshop.techshop.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.techshop.techshop.Model.Cliente;
import com.techshop.techshop.Repository.*;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> listarClientes() {
        return (List<Cliente>) clienteRepository.findAll();
    }

}
