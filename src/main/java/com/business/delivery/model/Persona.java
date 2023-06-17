package com.business.delivery.model;

import com.business.delivery.util.Patterns;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private int idPersona;

    @NotEmpty(message = "Campo no debe estar vacio")
    @Pattern(regexp = Patterns.NAME, message="Ingresar Nombre valido")
    private String nomPersona;
    @NotEmpty(message = "Campo no debe estar vacio")
    @Pattern(regexp = Patterns.NAME, message="Ingresar Apellido valido")
    private String apePersona;
    @NotEmpty(message = "Campo no debe estar vacio")
    private String dniPersona;
    @NotEmpty(message = "Campo no debe estar vacio")
    @Pattern(regexp = Patterns.CELL, message="No ingresar Celular valido")
    private String cel_persona;

    @NotNull(message = "Seleccione un Distrito")
    @ManyToOne
    @JoinColumn(name = "id_distrito",referencedColumnName = "id_distrito")
    private Distrito distrito;

    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Persona() {}

    public Persona(int idPersona, String nomPersona, String apePersona, String dniPersona, String cel_persona, Usuario usuario) {
        this.idPersona = idPersona;
        this.nomPersona = nomPersona;
        this.apePersona = apePersona;
        this.dniPersona = dniPersona;
        this.cel_persona = cel_persona;
        this.usuario = usuario;
    }

    @OneToMany(mappedBy = "persona",cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Pedido> Lpedido = new HashSet<>();

    public void addPedido(Pedido pedido) {
        this.Lpedido.add(pedido);
    }
}
