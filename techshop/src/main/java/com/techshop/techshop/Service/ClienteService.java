package com.techshop.techshop.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techshop.techshop.Model.Cliente;
import com.techshop.techshop.Model.Credito;
import com.techshop.techshop.Repository.*;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    private CreditoRepository creditoRepository;

    public ClienteService(ClienteRepository clienteRepository, CreditoRepository creditoRepository) {
        this.clienteRepository = clienteRepository;
        this.creditoRepository = creditoRepository;
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
    public void saveCliente(Cliente cliente) {
        Credito credito = cliente.getCredito();
        credito = creditoRepository.save(credito);
        cliente.setCredito(credito);

        clienteRepository.save(cliente);
    }

    @Transactional
    public void deleteCliente(Cliente cliente) {
        clienteRepository.deleteById(cliente.getId_cliente());
    }

}
