package com.business.delivery.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class ProductoPedidoID implements Serializable{
    @Column(name = "id_pedido")
    private int id_pedido;
    @Column(name = "id_producto")
    private int id_producto;

    public ProductoPedidoID() {
    }

    public ProductoPedidoID( int idProducto) {
        this.id_producto = idProducto;
    }
}
