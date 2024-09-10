package com.proyecto_biblioteca.proyectobiblioteca.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tt_usuario")
public class UsuarioEntity {
    @Id
    @Column(name = "id")
    private String idUs;

    @Column(name = "id_tipoUsuario")
    private Integer tipoUs;

    @Column(name = "nombre_us")
    private String nombreUs;

    @Column(name = "apellidos_us")
    private String apellidosUs;

    @Column(name = "email_us")
    private String emailUs;

    @Column(name = "dni_us")
    private String dniUs;

    @Column(name = "estado_us")
    private Boolean estadoUs;

    @Column(name = "pass_us")
    private String passUs;

    @Column(name = "reestablecer_us")
    private Boolean reesUs;

    @Column(name = "en_linea")
    private Boolean enLinea;
}
