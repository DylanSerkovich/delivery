package com.business.delivery.model;

import com.business.delivery.util.Patterns;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int idUsuario;

    private String nomUsuario;

    private String addressUsuario;

    @NotEmpty(message = "Campo no debe estar vacio")
    @Email(message = "Ingresar Email valido")
    private String emailUsuario;

    @NotEmpty(message = "Campo no debe estar vacio")
    @Pattern(regexp = Patterns.PASS, message="Debe tener al menos 8 caracteres, mayuscula, minúscula, numeros y caracteres especiales.")
    private String passwordUsuario;

    @Column(name = "reset_password_token")
    private String resetPasswordToken;

    @Column(name = "verification_code", length = 64)
    public String verificationCode;

    @Column(columnDefinition = "boolean default false")
    private boolean enabled;

    //@Column(columnDefinition = "boolean default false")
    //private boolean locked;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.REMOVE)
    private Persona persona;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    public Date fechaAct_usuario;
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "id_usuario",referencedColumnName = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "rol_id",referencedColumnName = "rol_id")
    )
    private Set<Rol> roles = new HashSet<>();

    public void addRole(Rol role) {
        this.roles.add(role);
    }

    @PrePersist
    private void onCreate() {
        fechaAct_usuario = new Date();
    }
}
