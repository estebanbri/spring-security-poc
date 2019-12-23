package com.esteban.springsecuritypoc.security.auth.service;

import com.esteban.springsecuritypoc.security.auth.entity.Usuario;
import com.esteban.springsecuritypoc.security.auth.MyUserDetails;
import com.esteban.springsecuritypoc.security.auth.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Usuario> user = usuarioRepository.findByUserName(userName);
        user.orElseThrow(()-> new UsernameNotFoundException("Not found " + userName));
        UserDetails userDetails = user.map(MyUserDetails::new).get();
        System.out.println(userDetails + " se loggeo exitosamente!");
        return userDetails;
    }

}
