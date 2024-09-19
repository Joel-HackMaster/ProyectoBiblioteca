package com.proyecto_biblioteca.proyectobiblioteca.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tt_tipousuario")
public class TipoUsuario {
    @Id
    @Column(name = "id")
    private Integer idTipoUsuario;

    @Column(name = "descripcion")
    private String descrTipoUsuario;
}
