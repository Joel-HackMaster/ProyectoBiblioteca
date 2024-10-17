package com.proyecto_biblioteca.proyectobiblioteca.service;

import com.proyecto_biblioteca.proyectobiblioteca.dto.AuditoriaUsuarioDTO;
import com.proyecto_biblioteca.proyectobiblioteca.dto.UsuarioDTO;
import com.proyecto_biblioteca.proyectobiblioteca.dto.Utilidades.RequestResponse;
import com.proyecto_biblioteca.proyectobiblioteca.entity.UsuarioEntity;
import com.proyecto_biblioteca.proyectobiblioteca.repository.AccionUsuarioRepository;
import com.proyecto_biblioteca.proyectobiblioteca.repository.AuditoriaUsuarioRepository;
import com.proyecto_biblioteca.proyectobiblioteca.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlumnoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AccionUsuarioRepository accionUsuarioRepository;

    @Autowired
    private AuditoriaUsuarioRepository auditoriaUsuarioRepository;

    public RequestResponse<List<UsuarioDTO>> obtenerAlumnos(){
        List<UsuarioEntity> universitarios = usuarioRepository.obtenerPorTipo(2);
        RequestResponse<List<UsuarioDTO>> responseListaUniv = new RequestResponse<>(new ArrayList<>());
        for(UsuarioEntity univ : universitarios){
            UsuarioDTO univDTO = new UsuarioDTO();
            univDTO.setIdUsuario(univ.getIdUs());
            univDTO.setNombres(univ.getNombreUs());
            univDTO.setApellidos(univ.getApellidosUs());
            univDTO.setEmail(univ.getEmailUs());
            univDTO.setImage(univ.getImageUs());
            univDTO.setDni(univ.getDniUs());
            univDTO.setStatus(univ.getEstadoUs());
            responseListaUniv.getValueItem().add(univDTO);
        }
        return responseListaUniv;
    }
}
