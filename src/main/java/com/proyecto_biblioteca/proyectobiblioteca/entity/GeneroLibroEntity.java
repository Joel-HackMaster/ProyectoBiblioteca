package com.proyecto_biblioteca.proyectobiblioteca.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tt_generolibro")
public class GeneroLibroEntity {
    @Id
    @Column(name = "id")
    private Integer idGenero;

    @Column(name = "descripcion")
    private String descrGenero;
}
