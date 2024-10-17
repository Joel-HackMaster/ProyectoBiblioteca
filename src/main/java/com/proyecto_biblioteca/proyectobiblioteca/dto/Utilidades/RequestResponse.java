package com.proyecto_biblioteca.proyectobiblioteca.dto.Utilidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.proyecto_biblioteca.proyectobiblioteca.dto.UsuarioDTO;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestResponse<T> {
    private int statusCode;
    private String error;
    private String message;
    private String extra_message;
    private String token;
    private String RefreshToken;
    private String expirationTime;
    private String ipCon;
    private String navCon;
    private String dispCon;
    private String osCon;
    private T valueItem;

    public RequestResponse(T valueItem) {
        this.valueItem = valueItem;
    }
}
