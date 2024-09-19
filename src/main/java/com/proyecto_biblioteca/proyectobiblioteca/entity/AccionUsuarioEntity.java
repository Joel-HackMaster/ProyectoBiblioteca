package com.proyecto_biblioteca.proyectobiblioteca.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tt_accionusuario")
public class AccionUsuarioEntity {
    @Id
    @Column(name = "id")
    private Integer idAccion;

    @Column(name = "descripcion")
    private Integer descripcionAccion;
}
