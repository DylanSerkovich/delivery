package com.business.delivery.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "roles")
@NoArgsConstructor
public class Rol{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rol_id")
    private int rolId;
    private String name;

    public Rol(int rolId,String name){
        this.rolId = rolId;
        this.name = name;
    }

    public Rol(String name){
        this.name=name;
    }
}
