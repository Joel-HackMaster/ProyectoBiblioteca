package com.proyecto_biblioteca.proyectobiblioteca.controller;

import com.proyecto_biblioteca.proyectobiblioteca.dto.UsuarioDTO;
import com.proyecto_biblioteca.proyectobiblioteca.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuario/listado")
    public String usuarios(Model model) {
        List<UsuarioDTO> alumnos = usuarioService.obtenerAlumnos();
        model.addAttribute("alumnos", alumnos);
        return "administracion/listadoAlumnos";
    }
}
