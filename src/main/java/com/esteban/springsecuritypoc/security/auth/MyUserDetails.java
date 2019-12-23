package com.esteban.springsecuritypoc.security.auth;

import com.esteban.springsecuritypoc.security.auth.entity.Usuario;
import com.esteban.springsecuritypoc.security.roles.Rol;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class MyUserDetails implements UserDetails {

    private final String password;
    private final String userName;
    private final Set<? extends GrantedAuthority> authorities;
    private final boolean active;

    public MyUserDetails(Usuario usuario) {
        this.password = usuario.getPassword();
        this.userName = usuario.getUserName();
        this.active = usuario.isActive();
        this.authorities = Arrays.stream(usuario.getRoles().split(","))
                            .map(rol -> Rol.valueOf(rol.split("_")[1]))
                            .flatMap(rol -> rol.getGrantedAuthorities().stream())
                            .collect(Collectors.toSet());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }

    @Override
    public String toString() {
        return "MyUserDetails{" +
                "password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", authorities=" + authorities +
                ", active=" + active +
                '}';
    }
}
