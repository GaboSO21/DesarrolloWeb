package com.techshop.techshop.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.techshop.techshop.Model.Cliente;
import com.techshop.techshop.Service.*;

@Controller
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/")
    public String inicio(Model model) {
        return "index";
    }

    @GetMapping("/cliente/listar")
    public String listar(Model model) {
        model.addAttribute("clientes", clienteService.listarClientes());
        return "listar";
    }

    @GetMapping("/cliente/agregar")
    public String agregarCliente(Cliente cliente) {
        return "agregar";
    }

    @PostMapping("/cliente/guardar")
    public String guardarCliente(Cliente cliente) {
        clienteService.saveCliente(cliente);
        return "redirect:/cliente/listar";
    }

    @GetMapping("/cliente/eliminar/{id_cliente}")
    public String eliminarCliente(Cliente cliente) {
        clienteService.deleteCliente(cliente);
        return "redirect:/cliente/listar";
    }

    @GetMapping("/cliente/editar/{id_cliente}")
    public String editarCliente(Cliente cliente, Model model) {
        cliente = clienteService.getCLiente(cliente);
        model.addAttribute("cliente", cliente);
        return "agregar";
    }

}
