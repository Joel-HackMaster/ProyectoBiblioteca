package com.proyecto_biblioteca.proyectobiblioteca.repository;

import com.proyecto_biblioteca.proyectobiblioteca.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    @Query(value = "SELECT * FROM obtenerAlumnos()", nativeQuery = true)
    List<Object[]> obtenerAlumnos();
}
