package com.business.delivery.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "PEDIDO")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pedido;
    private String nombre_destinatario;
    private String direccion;
    private String estado;
    private Date fecha_pedido;
    private Date fecha_entrega;
    private String tipo_pago;

    public Pedido() {
    }

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<ProductoPedido> listaProductosPedidos = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "id_persona",referencedColumnName = "id_persona")
    private Persona persona;

    public void addProducto(ProductoPedido productoPedido) {
        this.listaProductosPedidos.add(productoPedido);
    }
}
