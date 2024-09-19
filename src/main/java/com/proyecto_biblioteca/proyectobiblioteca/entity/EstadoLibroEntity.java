package com.proyecto_biblioteca.proyectobiblioteca.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tt_estadolibro")
public class EstadoLibroEntity {
    @Id
    @Column(name = "id")
    private Integer idEstadoLibro;

    @Column(name = "descripcion")
    private String descrEstadoLibro;
}
