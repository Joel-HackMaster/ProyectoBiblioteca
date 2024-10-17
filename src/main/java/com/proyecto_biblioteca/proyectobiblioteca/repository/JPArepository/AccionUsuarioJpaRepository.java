package com.proyecto_biblioteca.proyectobiblioteca.repository.JPArepository;

import com.proyecto_biblioteca.proyectobiblioteca.entity.AccionUsuarioEntity;
import com.proyecto_biblioteca.proyectobiblioteca.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccionUsuarioJpaRepository extends JpaRepository<AccionUsuarioEntity, Long> {
}
