package com.proyecto_biblioteca.proyectobiblioteca.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SesionDTO {
    private String id;
    private String nombre;
    private String correo;
    private String rol;
}
