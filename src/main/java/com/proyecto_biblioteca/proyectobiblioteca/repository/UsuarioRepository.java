package com.proyecto_biblioteca.proyectobiblioteca.repository;

import com.proyecto_biblioteca.proyectobiblioteca.entity.UsuarioEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    @Query(value = "SELECT * FROM obtenerAlumnos()", nativeQuery = true)
    List<Object[]> obtenerAlumnos();

    @Transactional
    @Modifying
    @Query(value = "CALL agregarUsuario(:tipo, :nombre, :apellidos, :email, :dni, :image, :password)", nativeQuery = true)
    void crearAlumno(@Param("tipo") Integer tipo, @Param("nombre") String nombres, @Param("apellidos") String apellidos, @Param("email") String email, @Param("dni") String dni, @Param("password") String password);
}
