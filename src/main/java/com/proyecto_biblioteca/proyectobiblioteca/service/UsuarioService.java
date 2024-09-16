package com.proyecto_biblioteca.proyectobiblioteca.service;

import com.proyecto_biblioteca.proyectobiblioteca.dto.UsuarioDTO;
import com.proyecto_biblioteca.proyectobiblioteca.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> obtenerAlumnos(){
        List<Object[]> resultados = usuarioRepository.obtenerAlumnos();
        List<UsuarioDTO> usuariosDTO = new ArrayList<>(); //Mapear resultados a UsuarioDTO
        for(Object[] resultado : resultados){
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setIdUsuario((String) resultado[0]);
            usuarioDTO.setNombres((String) resultado[1]);
            usuarioDTO.setApellidos((String) resultado[2]);
            usuarioDTO.setEmail((String) resultado[3]);
            usuarioDTO.setImage( (String) resultado[4]);
            usuarioDTO.setDni( (String) resultado[5]);
            usuarioDTO.setStatus( (Boolean) resultado[6]);
            usuariosDTO.add(usuarioDTO);
        }
        return usuariosDTO;
    }

    public void crearAlumnos(int tipo, String nombres, String apellidos, String email, String dni, String password ){
        usuarioRepository.crearAlumno(tipo, nombres, apellidos, email, dni, password);
    }
}
