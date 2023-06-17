package com.business.delivery.repository;

import com.business.delivery.model.Distrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistritoRepository extends JpaRepository<Distrito,Integer> {
}
