package com.esteban.springsecuritypoc.security.auth.service;

import com.esteban.springsecuritypoc.security.auth.entity.Permiso;
import com.esteban.springsecuritypoc.security.auth.entity.Usuario;
import com.esteban.springsecuritypoc.security.auth.repository.UsuarioRepository;
import com.esteban.springsecuritypoc.security.exceptions.UserNotEnabledException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String login) {
        Usuario usuario = usuarioRepository.findByLogin(login);
        if(usuario == null){
            throw new UsernameNotFoundException("Usuario "+ login + " no fue encontrado en la base de datos");
        }else if(!usuario.isEnabled()){
            throw new UserNotEnabledException("Usuario " + login + " no se encuentra activo");
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if(usuario.getRol() != null){
            GrantedAuthority rol = new SimpleGrantedAuthority(usuario.getRol().getNombre());
            List<GrantedAuthority> permisos = usuario.getRol().getPermisos().stream().map(p->new SimpleGrantedAuthority(p.getNombre())).collect(Collectors.toList());
            grantedAuthorities.add(rol);
            grantedAuthorities.addAll(permisos);
            log.debug("Autenticado: {}, GrantedAuthorities: {}", login, grantedAuthorities);
        }

        return new org.springframework.security.core.userdetails.User(
                usuario.getLogin(),
                usuario.getPassword(),
                grantedAuthorities);
    }

}
