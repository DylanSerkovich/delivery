package com.business.delivery.repository;

import com.business.delivery.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {


    @Query(value="SELECT * FROM pedido p WHERE p.id_persona=?1",nativeQuery=true)
    public List<Pedido> findAllbyClient(int idCliente);

    @Query(value="SELECT p.dir_imagen,p.nombre_producto,pp.precio_unitario,pp.cantidad FROM producto_pedido pp " +
            "INNER JOIN producto p ON pp.id_producto = p.id_producto " +
            "WHERE pp.id_pedido=?1",nativeQuery = true)
    List<Object[]> finByProductosByPedido(int idPedido);

}
