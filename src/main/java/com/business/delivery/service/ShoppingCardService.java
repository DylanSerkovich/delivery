package com.business.delivery.service;

import com.business.delivery.model.Producto;
import com.business.delivery.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ShoppingCardService {

    @Autowired
    private ProductoRepository productRepo;

/*
    private void cargarAlPedido(Producto p) {
        if (productoRepetido(p)) {
            int cant = this.pedidoAux.getListaProductosPedidos().get(posProducto).getCantidad() + 1;
            this.monto_total += p.getPrecio_unitario();
            this.pedidoAux.getListaProductosPedidos().get(this.posProducto).setCantidad(cant);
        } else {
            ProductoPedido productoAux = new ProductoPedido(1, p.getPrecio_unitario(), p);
            ProductoPedidoID id = new ProductoPedidoID(p.getId_producto());
            productoAux.setId(id);
            this.pedidoAux.addProducto(productoAux);
            this.monto_total += p.getPrecio_unitario();
        }
    }

    public Producto buscarProducto(List<Producto> productos, int buscado) {
        Producto prod = new Producto();
        for (Producto producto : productos) {
            if (buscado == producto.getIdProducto()) {
                prod = producto;
                break;
            }
        }
        return prod;
    }

    public int AgregarPedido(int idProducto){
        List<Producto> productos = productRepo.findAll();
        cargarAlPedido(buscarProducto(productos,idProducto));
    }*/

}
