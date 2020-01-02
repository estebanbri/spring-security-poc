package com.esteban.springsecuritypoc.security.auth.repository;

import com.esteban.springsecuritypoc.security.auth.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
     Usuario  findByLogin(String login);
}
