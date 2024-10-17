package com.proyecto_biblioteca.proyectobiblioteca.controller;

import com.proyecto_biblioteca.proyectobiblioteca.dto.AuditoriaUsuarioDTO;
import com.proyecto_biblioteca.proyectobiblioteca.dto.UsuarioDTO;
import com.proyecto_biblioteca.proyectobiblioteca.dto.Utilidades.RequestResponse;
import com.proyecto_biblioteca.proyectobiblioteca.service.AlumnoService;
import com.proyecto_biblioteca.proyectobiblioteca.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdministradorController {

    @Autowired
    AuthService authService;

    @Autowired
    AlumnoService alumnoService;

    @PostMapping("/signupAlumno")
    public ResponseEntity<RequestResponse<AuditoriaUsuarioDTO>> signUpAlumno(@RequestBody RequestResponse<UsuarioDTO> usuarioRegister) {
        return ResponseEntity.ok(authService.singUpAlumno(usuarioRegister));
    }

    @GetMapping("/obtenerAlumnos")
    public ResponseEntity<RequestResponse<List<UsuarioDTO>>> obtenerAlumnos() {
        return ResponseEntity.ok(alumnoService.obtenerAlumnos());
    }
}
