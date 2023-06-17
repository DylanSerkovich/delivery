package com.business.delivery.repository;

import com.business.delivery.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{

    @Query(value=   "SELECT * FROM usuario " +
            "WHERE email_usuario = ?1 " +
            "AND (enabled = true OR enabled = false) " +
            "ORDER BY enabled DESC, id_usuario DESC " +
            "LIMIT 1" ,nativeQuery = true)
    public Usuario verifyUserLogin(String email);

    @Query(value="SELECT * FROM usuario WHERE email_usuario=?1 AND enabled=?2",nativeQuery = true)
    public Usuario findByEmailEnable(String email,int enable);

    @Query(value="SELECT * FROM usuario WHERE verification_code=?1",nativeQuery = true)
    public Usuario findByVerificationCode(String code);

    @Query(value="SELECT u.* FROM usuario u " +
            "INNER JOIN users_roles ur ON u.id_usuario = ur.id_usuario " +
            "INNER JOIN roles r ON ur.rol_id = r.rol_id " +
            "WHERE u.email_usuario = ?1 AND u.enabled = ?2 AND r.name = ?3 " +
            "LIMIT 1;",nativeQuery = true)
    public Usuario findByEmailEnableRole(String email, boolean enable, String role);

    @Query(value="SELECT * FROM usuario WHERE reset_password_token = ?1",nativeQuery = true)
    public Usuario finByResetPasswordToken(String token);

}
