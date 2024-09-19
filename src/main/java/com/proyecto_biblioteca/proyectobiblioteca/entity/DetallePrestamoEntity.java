package com.proyecto_biblioteca.proyectobiblioteca.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tt_detalleprestamo")
public class DetallePrestamoEntity {
    @Id
    @Column(name = "id_prestamo")
    private String idPrestamo;

    @Column(name = "id_libro")
    private String idLibro;

    @Column(name = "detalle_prestamo")
    private String detallePrestamo;
}
