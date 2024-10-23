package com.proyecto_biblioteca.proyectobiblioteca.repository.JPArepository;

import com.proyecto_biblioteca.proyectobiblioteca.entity.UsuarioEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LibroJpaRepository extends JpaRepository<LibroEntity, Long> {
    @Query(value = "SELECT * FROM obtenerlibros(:rol)", nativeQuery = true)
    List<Object[]> obtenerLibros(@Param("rol") Integer rol);

    @Transactional
    @Query(value = "SELECT * FROM agregarlibro(:tipo, :genero, :nombre)", nativeQuery = true)
    Object crearLibro(@Param("tipo") Integer tipo, @Param("genero") String genero, @Param("nombre") String nombre);

    @Query(value = "SELECT * FROM obtenerlibroid(:id_libro)", nativeQuery = true)
    Optional<LibroEntity> obtenerLibroID(@Param("id_libro") String id_libro);

    Optional<LibroEntity> findByEmailUs(String nombre);
}
