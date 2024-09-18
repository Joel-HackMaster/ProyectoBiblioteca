package com.proyecto_biblioteca.proyectobiblioteca.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "tt_auditoriausuario")
public class AuditoriaUsuarioEntity {
    @Id
    @Column(name = "id")
    private Integer idAuditoria;

    @Column(name = "id_usuario")
    private String idUsuario;

    @Column(name = "id_bibliotecario")
    private String idBibliotecario;

    @Column(name = "id_accion")
    private Integer idAccion;

    @Column(name = "detalle_au")
    private String detalleAu;

    @Column(name = "fecha_au")
    private LocalDate fechaAu;

    @Column(name = "hora_au")
    private LocalTime horaAu;

    @Column(name = "ip_con")
    private String ipCon;

    @Column(name = "nav_con")
    private String navCon;

    @Column(name = "disp_con")
    private String dispCon;

    @Column(name = "os_con")
    private String osCon;
}
