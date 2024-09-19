package com.proyecto_biblioteca.proyectobiblioteca.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tt_estadoprestamo")
public class EstadoPrestamoEntity {
    @Id
    @Column(name = "id")
    private Integer idEstadoPrestamo;

    @Column(name = "descripcion")
    private String descrEstadoPrestamo;
}
