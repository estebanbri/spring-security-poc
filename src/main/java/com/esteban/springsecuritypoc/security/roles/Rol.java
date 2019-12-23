package com.esteban.springsecuritypoc.security.roles;

import com.esteban.springsecuritypoc.security.permisos.Permiso;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.esteban.springsecuritypoc.security.permisos.Permiso.*;

public enum Rol {
    ADMIN(Arrays.asList(CURSO_READ,CURSO_WRITE, ALUMNO_READ, ALUMNO_WRITE)),
    ALUMNO(Arrays.asList(CURSO_READ, ALUMNO_READ, ALUMNO_WRITE));

    private final List<Permiso> permisos;

    Rol(List<Permiso> permisos){
        this.permisos = permisos;
    }

    public List<Permiso> getPermisos() {
        return permisos;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities(){
        Set<SimpleGrantedAuthority> permisos = getPermisos().stream()
                .map(permiso -> new SimpleGrantedAuthority(permiso.getPermiso()))
                .collect(Collectors.toSet());
        permisos.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permisos;
    }
}
