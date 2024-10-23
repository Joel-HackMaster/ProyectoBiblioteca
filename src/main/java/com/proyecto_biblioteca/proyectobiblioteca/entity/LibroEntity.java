package com.proyecto_biblioteca.proyectobiblioteca.entity;

import lombok.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "tt_libro")
public class LibroEntity {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "id_estadolibro")
    private Integer idEstadoLibro;

    @Column(name = "id_generolibro")
    private Integer idGeneroLibro;

    @Column(name = "image_li")
    private String imageLi;

    @Column(name = "titulo_li")
    private String tituloLi;

    @Column(name = "autor_li")
    private String autorLi;

    @Column(name = "detalle_li")
    private String detalleLi;

    @Column(name = "idioma_li")
    private String idiomaLi;

    @Column(name = "edicion_li")
    private String edicionLi;

    @Column(name = "pagina_li")
    private Integer paginaLi;

    @Column(name = "copias_li")
    private Integer copiasLi;

    @Column(name = "public_li")
    private Integer publicLi;
}
