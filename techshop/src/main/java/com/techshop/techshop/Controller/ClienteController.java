package com.techshop.techshop.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.techshop.techshop.Service.*;

@Controller
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/")
    public String inicio(Model model) {
        model.addAttribute("clientes", clienteService.listarClientes());
        return "index";
    }

}
