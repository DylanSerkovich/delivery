package com.business.delivery.repository;

import com.business.delivery.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {

    @Query(value="SELECT p.* FROM persona p inner join usuario u on p.id_usuario = u.id_usuario WHERE u.email_usuario=?1 AND u.enabled=?2",nativeQuery = true)
    public Persona findByEmailEnable(String email,int enable);
}
