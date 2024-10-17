package com.proyecto_biblioteca.proyectobiblioteca.controller;

import com.proyecto_biblioteca.proyectobiblioteca.dto.AuditoriaUsuarioDTO;
import com.proyecto_biblioteca.proyectobiblioteca.dto.UsuarioDTO;
import com.proyecto_biblioteca.proyectobiblioteca.dto.Utilidades.RequestResponse;
import com.proyecto_biblioteca.proyectobiblioteca.service.AdministradorService;
import com.proyecto_biblioteca.proyectobiblioteca.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/superadmin")
public class SuperAdmController {
    @Autowired
    AuthService authService;

    @Autowired
    AdministradorService administradorService;

    @PostMapping("/signupAdministrador")
    public ResponseEntity<RequestResponse<AuditoriaUsuarioDTO>> signUpAdministrador(@RequestBody RequestResponse<UsuarioDTO> usuarioRegister) {
        return ResponseEntity.ok(authService.singUpAdministrador(usuarioRegister));
    }

    @GetMapping("/obtenerAdministradores")
    public ResponseEntity<RequestResponse<List<UsuarioDTO>>> obtenerAlumnos() {
        return ResponseEntity.ok(administradorService.obtenerAdministradores());
    }
}
