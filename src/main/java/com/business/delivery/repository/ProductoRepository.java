package com.business.delivery.repository;

import com.business.delivery.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    @Query(value="SELECT * FROM Producto p WHERE p.id_categoria=?1",nativeQuery=true)
    List<Producto> findByCategoria(int id_categoria);

}
