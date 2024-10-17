package com.proyecto_biblioteca.proyectobiblioteca.service;

import com.proyecto_biblioteca.proyectobiblioteca.dto.UsuarioDTO;
import com.proyecto_biblioteca.proyectobiblioteca.dto.Utilidades.RequestResponse;
import com.proyecto_biblioteca.proyectobiblioteca.entity.UsuarioEntity;
import com.proyecto_biblioteca.proyectobiblioteca.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdministradorService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public RequestResponse<List<UsuarioDTO>> obtenerAdministradores(){
        List<UsuarioEntity> administradores = usuarioRepository.obtenerPorTipo(3);
        RequestResponse<List<UsuarioDTO>> responseListaAdm = new RequestResponse<>(new ArrayList<>());
        for(UsuarioEntity usr : administradores){
            UsuarioDTO userDTO = new UsuarioDTO();
            userDTO.setIdUsuario(usr.getIdUs());
            userDTO.setNombres(usr.getNombreUs());
            userDTO.setApellidos(usr.getApellidosUs());
            userDTO.setEmail(usr.getEmailUs());
            userDTO.setImage(usr.getImageUs());
            userDTO.setDni(usr.getDniUs());
            userDTO.setStatus(usr.getEstadoUs());
            responseListaAdm.getValueItem().add(userDTO);
        }
        return responseListaAdm;
    }
}
