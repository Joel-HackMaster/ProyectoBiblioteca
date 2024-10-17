package com.proyecto_biblioteca.proyectobiblioteca.repository.JPArepository;

import com.proyecto_biblioteca.proyectobiblioteca.entity.AuditoriaUsuarioEntity;
import com.proyecto_biblioteca.proyectobiblioteca.entity.TipoUsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoUsuarioJpaRepository extends JpaRepository<TipoUsuarioEntity, Integer> {
}
