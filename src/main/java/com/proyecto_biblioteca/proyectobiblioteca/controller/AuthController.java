package com.proyecto_biblioteca.proyectobiblioteca.controller;

import com.proyecto_biblioteca.proyectobiblioteca.dto.LoginDTO;
import com.proyecto_biblioteca.proyectobiblioteca.dto.SesionDTO;
import com.proyecto_biblioteca.proyectobiblioteca.dto.Utilidades.RequestResponse;
import com.proyecto_biblioteca.proyectobiblioteca.dto.UsuarioDTO;
import com.proyecto_biblioteca.proyectobiblioteca.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;


    @PostMapping("/signin")
    public ResponseEntity<RequestResponse<SesionDTO>> signIn(@RequestBody RequestResponse<LoginDTO> signInRequest){
        return ResponseEntity.ok(authService.singIn(signInRequest));
    }
    /*
    * {
         "statusCode": 0,
         "error": "",
          "message": "",
          "extra_message": "",
          "token": "",
          "expirationTime": "",
          "ipCon": "",
          "navCon": "",
          "dispCon": "",
          "osCon": "",
          "valueItem": {
            "correo": "sanchez.developer2024@gmail.com",
            "password": "sanchez"
          },
          "refreshToken": ""
      }
    * */

    @PostMapping("/refresh")
    public ResponseEntity<RequestResponse<SesionDTO>> refreshToken(@RequestBody RequestResponse<?> refreshTokenRequest){
        return ResponseEntity.ok(authService.refreshToken(refreshTokenRequest));
    }
}
