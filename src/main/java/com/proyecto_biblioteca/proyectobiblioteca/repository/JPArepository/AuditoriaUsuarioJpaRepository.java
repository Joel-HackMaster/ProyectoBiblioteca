package com.proyecto_biblioteca.proyectobiblioteca.repository.JPArepository;

import com.proyecto_biblioteca.proyectobiblioteca.entity.AuditoriaUsuarioEntity;
import com.proyecto_biblioteca.proyectobiblioteca.entity.UsuarioEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AuditoriaUsuarioJpaRepository extends JpaRepository<AuditoriaUsuarioEntity, Long> {
    @Transactional
    @Query(value = "SELECT * FROM agregarauditoria(:user_in, :admin_in, :acc_in, :detail_in, :ip_in, :nav_in, :disp_in, :os_in)", nativeQuery = true)
    Object crearAuditoria(@Param("user_in") String user_in,
                          @Param("admin_in") String admin_in,
                          @Param("acc_in") Integer acc_in,
                          @Param("detail_in") String detail_in,
                          @Param("ip_in") String ip_in,
                          @Param("nav_in") String nav_in,
                          @Param("disp_in") String disp_in,
                          @Param("os_in") String os_in);
}
