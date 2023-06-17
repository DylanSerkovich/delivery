package com.business.delivery.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "producto_pedido")
public class ProductoPedido {
    @EmbeddedId
    private ProductoPedidoID id;

    private int cantidad;
    private float precio_unitario;

    @ManyToOne
    @MapsId("id_pedido")
    @JoinColumn(name = "id_pedido",referencedColumnName = "id_pedido")
    private Pedido pedido;

    @OneToOne
    @MapsId("id_producto")
    @JoinColumn(name = "id_producto",referencedColumnName = "id_producto")
    private Producto producto;

    public ProductoPedido() {
    }

    public ProductoPedido(int cantidad, float precio_unitario, Producto producto) {
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
        this.producto = producto;
    }

}
