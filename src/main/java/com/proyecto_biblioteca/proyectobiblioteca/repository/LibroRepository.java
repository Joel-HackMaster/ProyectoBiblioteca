package com.proyecto_biblioteca.proyectobiblioteca.repository;

import com.proyecto_biblioteca.proyectobiblioteca.entity.UsuarioEntity;
import com.proyecto_biblioteca.proyectobiblioteca.repository.JPArepository.TipoUsuarioJpaRepository;
import com.proyecto_biblioteca.proyectobiblioteca.repository.JPArepository.UsuarioJpaRepository;
import com.proyecto_biblioteca.proyectobiblioteca.repository.contrato.IAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class LibroRepository implements IAuthRepository<UsuarioEntity, String> {

    @Autowired
    private UsuarioJpaRepository usuarioJpaRepository;

    @Autowired
    private TipoUsuarioJpaRepository tipoUsuarioJpaRepository;

    @Override
    public List<UsuarioEntity> obtenerTodos() {
        return null;
    }

    @Override
    public List<UsuarioEntity> obtenerPorTipo(int tipo) {
        List<UsuarioEntity> universitarios= new ArrayList<>();
        List<Object[]> resultados = usuarioJpaRepository.obtenerUsuarios(tipo);
        for(Object[] resultado : resultados){
            UsuarioEntity usuario = new UsuarioEntity();
            usuario.setIdUs((String)resultado[0]);
            usuario.setNombreUs((String)resultado[1]);
            usuario.setApellidosUs((String)resultado[2]);
            usuario.setEmailUs((String)resultado[3]);
            usuario.setImageUs((String)resultado[4]);
            usuario.setDniUs ((String)resultado[5]);
            usuario.setEstadoUs( (Boolean)resultado[6]);
            universitarios.add(usuario);
        }
        return universitarios;
    }

    @Override
    public UsuarioEntity obtenerPorId(String id) {
        return usuarioJpaRepository.obtenerUsuarioID(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @Override
    public UsuarioEntity guardarModelo(UsuarioEntity modelo) {
        return usuarioJpaRepository.save(modelo);
    }

    @Override
    public boolean eliminarModelo(String id) {
        return false;
    }

    @Override
    public Optional<UsuarioEntity> obtenerPorEmail(String email) {
        return usuarioJpaRepository.findByEmailUs(email);
    }

    @Override
    public UsuarioEntity guardarUsuario(UsuarioEntity modelo, int tipo) {
        Object[] objectUser = (Object[]) usuarioJpaRepository.crearUsuario(tipo, modelo.getNombreUs(), modelo.getApellidosUs(), modelo.getEmailUs(), modelo.getDniUs(), modelo.getImageUs(),modelo.getPassUs());
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setIdUs((String)objectUser[0]);
        usuario.setNombreUs((String) objectUser[1]);
        usuario.setApellidosUs((String) objectUser[2]);
        usuario.setTipoUs(tipoUsuarioJpaRepository.findById(tipo).orElseThrow(() -> new RuntimeException("Tipo de usuario no encontrado")));
        usuario.setEmailUs((String) objectUser[4]);
        usuario.setDniUs((String) objectUser[5]);
        usuario.setImageUs((String) objectUser[6]);
        return usuario;
    }
}


/*
* @Override
    public List<UsuarioDTO> obtenerTodos() {
        List<UsuarioEntity> universitarios= new ArrayList<>();
        List<Object[]> resultados = usuarioJpaRepository.obtenerAlumnos(2);

        for(Object[] resultado : resultados){
            UsuarioEntity usuario = new UsuarioEntity();
            usuario.setIdUs((String) resultado[0]);
            usuario.setNombreUs((String) resultado[1]);
            usuario.setApellidosUs((String) resultado[2]);
            usuarioDTO.setEmail((String) resultado[3]);
            usuarioDTO.setImage( (String) resultado[4]);
            usuarioDTO.setDni( (String) resultado[5]);
            usuarioDTO.setStatus( (Boolean) resultado[6]);
            usuariosDTO.add(usuarioDTO);
        }


        return universitarios;
    }

    @Override
    public UsuarioEntity obtenerPorId(Long id) {
        return null;
    }

    @Override
    public UsuarioEntity guardarModelo(UsuarioEntity usuario) {
        return null;
    }

    @Override
    public boolean eliminarModelo(Long id) {
        return false;
    }
* */