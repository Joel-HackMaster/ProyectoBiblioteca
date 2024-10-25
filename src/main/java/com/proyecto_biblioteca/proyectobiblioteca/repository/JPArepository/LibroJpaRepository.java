package com.proyecto_biblioteca.proyectobiblioteca.repository.JPArepository;

import com.proyecto_biblioteca.proyectobiblioteca.entity.LibroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroJpaRepository extends JpaRepository<LibroEntity, Long> {
}
