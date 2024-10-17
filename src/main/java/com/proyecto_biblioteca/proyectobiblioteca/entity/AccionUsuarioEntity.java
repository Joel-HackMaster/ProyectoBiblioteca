package com.proyecto_biblioteca.proyectobiblioteca.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tt_accionusuario", schema = "public")
public class AccionUsuarioEntity {
    @Id
    @Column(name = "id")
    private Integer idAccion;

    @Column(name = "descripcion")
    private String descripcionAccion;
}
