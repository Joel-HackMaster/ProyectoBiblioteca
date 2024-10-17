package com.proyecto_biblioteca.proyectobiblioteca.repository.JPArepository;

import com.proyecto_biblioteca.proyectobiblioteca.entity.UsuarioEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UsuarioJpaRepository extends JpaRepository<UsuarioEntity, Long> {
    @Query(value = "SELECT * FROM obtenerusuarios(:rol)", nativeQuery = true)
    List<Object[]> obtenerUsuarios(@Param("rol") Integer rol);

    @Transactional
    @Query(value = "SELECT * FROM agregarusuario(:tipo, :nombre, :apellidos, :email, :dni, :image, :password)", nativeQuery = true)
    Object crearUsuario(@Param("tipo") Integer tipo, @Param("nombre") String nombres, @Param("apellidos") String apellidos, @Param("email") String email, @Param("dni") String dni, @Param("image") String image,@Param("password") String password);

    @Query(value = "SELECT * FROM obtenerusuarioid(:id_usuario)", nativeQuery = true)
    Optional<UsuarioEntity> obtenerUsuarioID(@Param("id_usuario") String id_usuario);

    Optional<UsuarioEntity> findByEmailUs(String email);
}
