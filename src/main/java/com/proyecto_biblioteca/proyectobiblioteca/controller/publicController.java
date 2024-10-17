package com.proyecto_biblioteca.proyectobiblioteca.controller;

import com.proyecto_biblioteca.proyectobiblioteca.dto.AuditoriaUsuarioDTO;
import com.proyecto_biblioteca.proyectobiblioteca.dto.Utilidades.RequestResponse;
import com.proyecto_biblioteca.proyectobiblioteca.service.LogoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public")
public class publicController {
    @Autowired
    LogoutService logoutService;

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestHeader(name = "Authorization") String token) {
        String tokenValue = token.replace("Bearer ", "");
        logoutService.addToBlacklist(tokenValue);
        return ResponseEntity.ok("Logout exitoso.");
    }
}
