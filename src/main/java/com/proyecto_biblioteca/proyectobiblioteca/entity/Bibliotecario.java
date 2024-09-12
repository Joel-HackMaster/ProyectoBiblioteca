package com.proyecto_biblioteca.proyectobiblioteca.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tt_bibliotecario")
public class Bibliotecario {
    @Id
    @Column(name = "id")
    private String idBibliotecario;

    @Column(name = "nombre_bi")
    private String nombreBi;

    @Column(name = "apellidos_bi")
    private String apellidosBi;

    @Column(name = "email_bi")
    private String emailBi;

    @Column(name = "image_bi")
    private String imageBi;

    @Column(name = "dni_bi")
    private String dniBi;

    @Column(name = "estado_bi")
    private Boolean estadoBi;

    @Column(name = "pass_bi")
    private String passBi;

    @Column(name = "super_bi")
    private Boolean superBi;
}
