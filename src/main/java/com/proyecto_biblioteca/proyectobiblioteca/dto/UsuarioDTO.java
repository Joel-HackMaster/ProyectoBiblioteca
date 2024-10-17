package com.proyecto_biblioteca.proyectobiblioteca.dto;

import com.proyecto_biblioteca.proyectobiblioteca.entity.UsuarioEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private String idUsuario;
    private String nombres;
    private String apellidos;
    private String email;
    private String clave;
    private String image;
    private String dni;
    private Boolean status;

    public UsuarioDTO(UsuarioEntity usuarioEntity) {
        this.idUsuario = usuarioEntity.getIdUs();
        this.nombres = usuarioEntity.getNombreUs();
        this.apellidos = usuarioEntity.getApellidosUs();
        this.email = usuarioEntity.getEmailUs();
        this.image = usuarioEntity.getImageUs();
        this.dni = usuarioEntity.getDniUs();
        this.status = usuarioEntity.getEstadoUs();
    }
}
