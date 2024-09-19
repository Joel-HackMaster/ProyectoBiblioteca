package com.proyecto_biblioteca.proyectobiblioteca.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "tt_auditorialibro")
public class AuditoriaLibroEntity {
    @Id
    @Column(name = "id")
    private Integer idAuditoriaLibro;

    @Column(name = "id_libro")
    private String idLibro;

    @Column(name = "id_bibliotecario")
    private String idBibliotecario;

    @Column(name = "id_bibaccion")
    private Integer idBibAccion;

    @Column(name = "fecha_au")
    private LocalDate fechaAu;

    @Column(name = "hora_au")
    private LocalTime horaAu;

    @Column(name = "detalle_au")
    private String detalleAu;
}
