package com.business.delivery.repository;

import com.business.delivery.model.Producto;
import com.business.delivery.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolRepository extends JpaRepository<Rol,Integer> {

    @Query(value="SELECT * FROM roles r WHERE r.name=?1",nativeQuery=true)
    public Rol findRolByName(String name);

}
