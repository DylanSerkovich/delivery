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

    @Transient
    private Double totalPrice;
    @Transient
    private int itemsNumber;

    public Pedido() {
    }

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    //private Set<ProductoPedido> listaProductosPedidos = new HashSet<>();
    private List<ProductoPedido> listaProductosPedidos = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "id_persona",referencedColumnName = "id_persona")
    private Persona persona;

    public void addProducto(ProductoPedido productoPedido) {
        //productoPedido.getId().setIdPedido(this.id_pedido);
        this.listaProductosPedidos.add(productoPedido);
        productoPedido.setPedido(this);
    }

    public Double getTotalPrice() {
        Double sum = 0.0;
        for(ProductoPedido item : this.listaProductosPedidos) {
            sum = sum + item.getPrecio_unitario()*item.getCantidad();
        }
        return sum;
    }
    public int getItemsNumber() {
        return this.listaProductosPedidos.size();
    }
}
