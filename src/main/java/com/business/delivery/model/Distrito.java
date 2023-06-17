package com.business.delivery.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "distrito")
public class Distrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_distrito")
    private int id_distrito;
    private String nombre_distrito;
    private String tiempo_envio;

    public Distrito() {
    }

    public Distrito(int id_distrito, String nombre_distrito, String tiempo_envio) {
        this.id_distrito = id_distrito;
        this.nombre_distrito = nombre_distrito;
        this.tiempo_envio = tiempo_envio;
    }

    @OneToMany(mappedBy = "distrito", cascade = CascadeType.ALL, orphanRemoval = false)
    private Set<Persona> clientes = new HashSet<>();
}
