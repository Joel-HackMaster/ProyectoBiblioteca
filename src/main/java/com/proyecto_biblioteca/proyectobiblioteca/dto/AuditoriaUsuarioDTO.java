package com.proyecto_biblioteca.proyectobiblioteca.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.proyecto_biblioteca.proyectobiblioteca.entity.AuditoriaUsuarioEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuditoriaUsuarioDTO {
    private String nombreUsuario;
    private String administrador;
    private String Accion;
    private String detalleAuditoria;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate fecha;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private LocalTime hora;

    private String ipCon;
    private String navCon;
    private String dispCon;
    private String osCon;

    public AuditoriaUsuarioDTO(AuditoriaUsuarioEntity auditoriaUsuarioEntity) {
        this.nombreUsuario = auditoriaUsuarioEntity.getUsuario().getNombreUs();
        this.administrador = auditoriaUsuarioEntity.getAdministrador().getNombreUs();
        this.Accion = auditoriaUsuarioEntity.getAccion().getDescripcionAccion();
        this.detalleAuditoria = auditoriaUsuarioEntity.getDetalleAu();
        this.fecha = auditoriaUsuarioEntity.getFechaAu();
        this.hora = auditoriaUsuarioEntity.getHoraAu();
        this.ipCon = auditoriaUsuarioEntity.getIpCon();
        this.navCon = auditoriaUsuarioEntity.getNavCon();
        this.dispCon = auditoriaUsuarioEntity.getDispCon();
        this.osCon = auditoriaUsuarioEntity.getOsCon();
    }
}
