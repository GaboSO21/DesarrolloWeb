package com.techshop.techshop.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_cliente;

    private int credito;
    private String nombre;
    private String apellidos;
    private String correo;
    private String telefono;

    public Cliente() {
    }

    public Cliente(int credito, String nombre, String apellidos, String correo, String telefono) {
        this.credito = credito;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Cliente(int id_cliente, int credito, String nombre, String apellidos, String correo, String telefono) {
        this.id_cliente = id_cliente;
        this.credito = credito;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
    }

}
