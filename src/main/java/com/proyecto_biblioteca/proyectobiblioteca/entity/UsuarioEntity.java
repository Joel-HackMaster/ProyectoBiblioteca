package com.proyecto_biblioteca.proyectobiblioteca.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tt_usuario", schema = "public")
public class UsuarioEntity implements UserDetails {
    @Id
    @Column(name = "id")
    private String idUs;

    @ManyToOne
    @JoinColumn(name = "id_tipousuario", nullable = false)
    private TipoUsuarioEntity tipoUs;

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(tipoUs.getDescrTipoUsuario()));
    }

    @Override
    public String getPassword() {
        return passUs;
    }

    @Override
    public String getUsername() {
        return emailUs;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return estadoUs;
    }
}
