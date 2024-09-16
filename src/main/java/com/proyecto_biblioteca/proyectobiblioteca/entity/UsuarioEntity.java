package com.proyecto_biblioteca.proyectobiblioteca.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tt_usuario", schema = "public")
public class UsuarioEntity {
    @Id
    @Column(name = "id")
    private String idUs;

    @Column(name = "id_tipoUsuario")
    private Integer tipoUs;

    @Column(name = "nombre_us")
    private String nombreUs;

    @Column(name = "apellidos_us")
    private String apellidosUs;

    @Column(name = "email_us")
    private String emailUs;

    @Column(name = "dni_us")
    private String dniUs;

    @Column(name = "image_us")
    private String imageUs;

    @Column(name = "estado_us")
    private Boolean estadoUs;

    @Column(name = "pass_us")
    private String passUs;

    @Column(name = "reestablecer_us")
    private Boolean reesUs;

    @Column(name = "en_linea")
    private Boolean enLinea;

    public String getIdUs() {
        return idUs;
    }

    public void setIdUs(String idUs) {
        this.idUs = idUs;
    }

    public Integer getTipoUs() {
        return tipoUs;
    }

    public void setTipoUs(Integer tipoUs) {
        this.tipoUs = tipoUs;
    }

    public String getNombreUs() {
        return nombreUs;
    }

    public void setNombreUs(String nombreUs) {
        this.nombreUs = nombreUs;
    }

    public String getApellidosUs() {
        return apellidosUs;
    }

    public void setApellidosUs(String apellidosUs) {
        this.apellidosUs = apellidosUs;
    }

    public String getEmailUs() {
        return emailUs;
    }

    public void setEmailUs(String emailUs) {
        this.emailUs = emailUs;
    }

    public String getDniUs() {
        return dniUs;
    }

    public void setDniUs(String dniUs) {
        this.dniUs = dniUs;
    }

    public Boolean getEstadoUs() {
        return estadoUs;
    }

    public void setEstadoUs(Boolean estadoUs) {
        this.estadoUs = estadoUs;
    }

    public String getImageUs() {
        return imageUs;
    }

    public void setImageUs(String imageUs) {
        this.imageUs = imageUs;
    }

    public String getPassUs() {
        return passUs;
    }

    public void setPassUs(String passUs) {
        this.passUs = passUs;
    }

    public Boolean getReesUs() {
        return reesUs;
    }

    public void setReesUs(Boolean reesUs) {
        this.reesUs = reesUs;
    }

    public Boolean getEnLinea() {
        return enLinea;
    }

    public void setEnLinea(Boolean enLinea) {
        this.enLinea = enLinea;
    }
}
