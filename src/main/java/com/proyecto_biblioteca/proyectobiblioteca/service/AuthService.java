package com.proyecto_biblioteca.proyectobiblioteca.service;

import com.proyecto_biblioteca.proyectobiblioteca.dto.AuditoriaUsuarioDTO;
import com.proyecto_biblioteca.proyectobiblioteca.dto.LoginDTO;
import com.proyecto_biblioteca.proyectobiblioteca.dto.SesionDTO;
import com.proyecto_biblioteca.proyectobiblioteca.dto.Utilidades.RequestResponse;
import com.proyecto_biblioteca.proyectobiblioteca.dto.UsuarioDTO;
import com.proyecto_biblioteca.proyectobiblioteca.entity.AuditoriaUsuarioEntity;
import com.proyecto_biblioteca.proyectobiblioteca.entity.UsuarioEntity;
import com.proyecto_biblioteca.proyectobiblioteca.repository.AccionUsuarioRepository;
import com.proyecto_biblioteca.proyectobiblioteca.repository.AuditoriaUsuarioRepository;
import com.proyecto_biblioteca.proyectobiblioteca.repository.UsuarioRepository;
import com.proyecto_biblioteca.proyectobiblioteca.service.JWT.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;

@Service
public class AuthService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JWTUtils jwtUtils;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AccionUsuarioRepository accionUsuarioRepository;

    @Autowired
    private AuditoriaUsuarioRepository auditoriaUsuarioRepository;

    public RequestResponse<AuditoriaUsuarioDTO> singUpAlumno(RequestResponse<UsuarioDTO> usuarioRegister) {
        RequestResponse<AuditoriaUsuarioDTO> resp = new RequestResponse<>(new AuditoriaUsuarioDTO());
        try{
            System.out.println("Token: "+usuarioRegister.getToken());
            String email = jwtUtils.extractUsername(usuarioRegister.getToken());
            UsuarioEntity administrador = usuarioRepository.obtenerPorEmail(email).orElseThrow();
            UsuarioEntity result = methodRegisterUsuario(usuarioRegister.getValueItem(), 2);
            if (result != null && result.getIdUs() != null) {
                resp.setValueItem(new AuditoriaUsuarioDTO(methodRegisterAuditoria(result, administrador, usuarioRegister.getIpCon(), usuarioRegister.getNavCon(), usuarioRegister.getDispCon(), usuarioRegister.getOsCon())));
                resp.setMessage("Usuario creado Satisfactoriamente");
                resp.setStatusCode(200);
            }
        }catch (Exception e){
            resp.setStatusCode(500);
            resp.setError("Ooopps ocurrio un error: "+e.getMessage());
        }
        return resp;
    }

    public RequestResponse<AuditoriaUsuarioDTO> singUpAdministrador(RequestResponse<UsuarioDTO> usuarioRegister) {
        RequestResponse<AuditoriaUsuarioDTO> resp = new RequestResponse<>(new AuditoriaUsuarioDTO());
        try{
            System.out.println("Token: "+usuarioRegister.getToken());
            String email = jwtUtils.extractUsername(usuarioRegister.getToken());
            UsuarioEntity administrador = usuarioRepository.obtenerPorEmail(email).orElseThrow();
            UsuarioEntity result = methodRegisterUsuario(usuarioRegister.getValueItem(), 3);
            if (result != null && result.getIdUs() != null) {
                resp.setValueItem(new AuditoriaUsuarioDTO(methodRegisterAuditoria(result, administrador, usuarioRegister.getIpCon(), usuarioRegister.getNavCon(), usuarioRegister.getDispCon(), usuarioRegister.getOsCon())));
                resp.setMessage("Usuario creado Satisfactoriamente");
                resp.setStatusCode(200);
            }
        }catch (Exception e){
            resp.setStatusCode(500);
            resp.setError("Opps ocurrio un error: "+e.getMessage());
        }
        return resp;
    }

    public RequestResponse<SesionDTO> singIn(RequestResponse<LoginDTO> signInRequest) {
        RequestResponse<SesionDTO> response = new RequestResponse<>(new SesionDTO());
        System.out.println(signInRequest.getValueItem().getCorreo());
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getValueItem().getCorreo(), signInRequest.getValueItem().getPassword()));
            UsuarioEntity user = usuarioRepository.obtenerPorEmail(signInRequest.getValueItem().getCorreo()).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
            System.out.println("El usuario es: " + user);
            var jwt = jwtUtils.generateToken(user);
            var refreshToken = jwtUtils.generateRefreshToken(new HashMap<>(), user);
            user.setEnLinea(true);
            usuarioRepository.guardarModelo(user);
            response.setStatusCode(200);
            response.setToken(jwt);
            response.setRefreshToken(refreshToken);
            response.setExpirationTime("24Hrs");
            response.setMessage("Se logeo Satisfactoriamente, usted esta en linea con el servicio");
            response.getValueItem().setCorreo(user.getEmailUs());
            response.getValueItem().setNombre(user.getNombreUs()+" "+user.getApellidosUs());
            response.getValueItem().setRol(user.getTipoUs().getDescrTipoUsuario());
        }catch (Exception e){
            response.setStatusCode(500);
            response.setError("Ocurrio un error: "+e.getMessage());
        }
        return response;
    }

    public RequestResponse<SesionDTO> refreshToken(RequestResponse<?> refreshTokenRequest) {
        RequestResponse<SesionDTO> response = new RequestResponse<>(new SesionDTO());
        try{
            String email = jwtUtils.extractUsername(refreshTokenRequest.getToken());
            UsuarioEntity user = usuarioRepository.obtenerPorEmail(email).orElseThrow();
            if (jwtUtils.isTokenValid(refreshTokenRequest.getToken(), user)){
                var jwt = jwtUtils.generateToken(user);
                response.setStatusCode(200);
                response.setToken(jwt);
                response.setRefreshToken(refreshTokenRequest.getToken());
                response.setExpirationTime("24Hrs");
                response.setMessage("Se refresco el token Satisfactoriamente");
                response.getValueItem().setCorreo(user.getEmailUs());
                response.getValueItem().setNombre(user.getNombreUs()+" "+user.getApellidosUs());
                response.getValueItem().setRol(user.getTipoUs().getDescrTipoUsuario());
            }
        }catch (Exception e){
            response.setStatusCode(500);
            response.setError(e.getMessage());
        }
        return response;
    }

    public RequestResponse<?> logout(RequestResponse<?> refreshTokenRequest) {
        RequestResponse<SesionDTO> response = new RequestResponse<>(new SesionDTO());
        try{
            String email = jwtUtils.extractUsername(refreshTokenRequest.getToken());
            UsuarioEntity user = usuarioRepository.obtenerPorEmail(email).orElseThrow();
            if (jwtUtils.isTokenValid(refreshTokenRequest.getToken(), user)){
                var jwt = jwtUtils.generateToken(user);
                response.setStatusCode(200);
                response.setToken(jwt);
                response.setRefreshToken(refreshTokenRequest.getToken());
                response.setExpirationTime("24Hrs");
                response.setMessage("Se refresco el token Satisfactoriamente");
                response.getValueItem().setCorreo(user.getEmailUs());
                response.getValueItem().setNombre(user.getNombreUs()+" "+user.getApellidosUs());
                response.getValueItem().setRol(user.getTipoUs().getDescrTipoUsuario());
            }
        }catch (Exception e){
            response.setStatusCode(500);
            response.setError(e.getMessage());
        }
        return response;
    }




//**Metodos Reutilizables
    private UsuarioEntity methodRegisterUsuario(UsuarioDTO usuarioDTO, int tipo) {
        UsuarioEntity user = new UsuarioEntity();
        user.setNombreUs(usuarioDTO.getNombres());
        user.setApellidosUs(usuarioDTO.getApellidos());
        user.setEmailUs(usuarioDTO.getEmail());
        user.setImageUs(usuarioDTO.getImage());
        user.setEstadoUs(usuarioDTO.getStatus());
        user.setDniUs(usuarioDTO.getDni());
        user.setPassUs(passwordEncoder.encode(usuarioDTO.getClave()));
        return usuarioRepository.guardarUsuario(user, tipo);
    }

    private AuditoriaUsuarioEntity methodRegisterAuditoria(UsuarioEntity result, UsuarioEntity administrador, String ipCon, String navCon, String dispCon, String osCon) {
        AuditoriaUsuarioEntity auditoria = new AuditoriaUsuarioEntity();
        auditoria.setUsuario(result);
        auditoria.setAdministrador(administrador);
        auditoria.setAccion(accionUsuarioRepository.obtenerPorId(1L));
        auditoria.setDetalleAu("Creacion de usuario del tipo " + result.getTipoUs().getDescrTipoUsuario());
        auditoria.setFechaAu(LocalDate.now());
        auditoria.setHoraAu(LocalTime.now());
        auditoria.setIpCon(ipCon);
        auditoria.setNavCon(navCon);
        auditoria.setDispCon(dispCon);
        auditoria.setOsCon(osCon);
        return auditoriaUsuarioRepository.guardarModelo(auditoria);
    }
}
