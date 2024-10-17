package com.proyecto_biblioteca.proyectobiblioteca.service;

import com.proyecto_biblioteca.proyectobiblioteca.entity.UsuarioEntity;
import com.proyecto_biblioteca.proyectobiblioteca.repository.JPArepository.UsuarioJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OurUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioJpaRepository usuarioJpaRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UsuarioEntity usuario = usuarioJpaRepository.findByEmailUs(email).orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado con email: " + email);
        }

        return usuario;
    }
}
