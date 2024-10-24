package com.proyecto_biblioteca.proyectobiblioteca.repository.JPArepository;

import com.proyecto_biblioteca.proyectobiblioteca.entity.LibroEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LibroJpaRepository extends JpaRepository<LibroEntity, Long> {
}
