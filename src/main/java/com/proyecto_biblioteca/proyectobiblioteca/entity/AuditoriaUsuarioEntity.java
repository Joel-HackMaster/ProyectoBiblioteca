package com.proyecto_biblioteca.proyectobiblioteca.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tt_auditoriausuario", schema = "public")
public class AuditoriaUsuarioEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAuditoria;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private UsuarioEntity usuario;

    @ManyToOne
    @JoinColumn(name = "id_bibliotecario", nullable = false)
    private UsuarioEntity administrador;

    @ManyToOne
    @JoinColumn(name = "id_accion", nullable = false)
    private AccionUsuarioEntity accion;

    @Column(name = "detalle_au")
    private String detalleAu;

    @Column(name = "fecha_au")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaAu;

    @Column(name = "hora_au")
    @DateTimeFormat(pattern = "HH:mm:ss")
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
