package com.business.delivery.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "PRODUCTO")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private int idProducto;
    private String dirImagen;
    private String nombreProducto;
    private String descripcion;
    private float precioUnitario;

    @ManyToOne
    @JoinColumn(name = "id_categoria",referencedColumnName = "id_categoria" , nullable=false)
    private Categoria categoria;

    public Producto() {
    }

    public Producto(int idProducto, String dirImagen, String nombreProducto, String descripcion, float precioUnitario) {
        this.idProducto = idProducto;
        this.dirImagen = dirImagen;
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
    }
}
