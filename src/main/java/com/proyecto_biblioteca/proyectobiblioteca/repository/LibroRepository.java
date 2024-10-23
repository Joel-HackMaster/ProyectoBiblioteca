package com.proyecto_biblioteca.proyectobiblioteca.repository;

import com.proyecto_biblioteca.proyectobiblioteca.entity.LibroEntity;
import com.proyecto_biblioteca.proyectobiblioteca.repository.JPArepository.GeneroLibroJpaRepository;
import com.proyecto_biblioteca.proyectobiblioteca.repository.JPArepository.LibroJpaRepository;
import com.proyecto_biblioteca.proyectobiblioteca.repository.contrato.IGenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class LibroRepository implements IGenericRepository<LibroEntity, String> {

    @Autowired
    private LibroJpaRepository libroJpaRepository;

    @Autowired
    private GeneroLibroJpaRepository generoLibroJpaRepository;


    @Override
    public List<LibroEntity> obtenerTodos() {
        return null;
    }

    @Override
    public List<LibroEntity> obtenerPorGenero(int genero) {
        List<LibroEntity> libros = new ArrayList<>();
        List<Object[]> resultados = libroJpaRepository.obtenerLibro(genero);
        for(Object[] resultado : resultados){
            LibroEntity libro = new LibroEntity();
            // libro.setIdUs((String)resultado[0]);
            // libro.setNombreUs((String)resultado[1]);
            // libro.setApellidosUs((String)resultado[2]);
            // libro.setEmailUs((String)resultado[3]);
            // libro.setImageUs((String)resultado[4]);
            // libro.setDniUs ((String)resultado[5]);
            // libro.setEstadoUs( (Boolean)resultado[6]);
            libros.add(libro);
        }
        return libros;
    }

    @Override
    public LibroEntity obtenerPorId(String id) {
        return libroJpaRepository.obtenerLibroID(id).orElseThrow(() -> new RuntimeException("Libro no encontrado"));
    }

    @Override
    public LibroEntity guardarModelo(LibroEntity modelo) {
        return libroJpaRepository.save(modelo);
    }

    @Override
    public boolean eliminarModelo(String id) {
        return false;
    }

    @Override
    public Optional<LibroEntity> obtenerPorEmail(String email) {
        return libroJpaRepository.findByEmailUs(email);
    }

    @Override
    public LibroEntity guardarLibro(LibroEntity modelo, int genero) {
        Object[] objectUser = (Object[]) libroJpaRepository.crearLibro(tipo, modelo.getNombreUs(), modelo.getApellidosUs(), modelo.getEmailUs(), modelo.getDniUs(), modelo.getImageUs(),modelo.getPassUs());
        LibroEntity libro = new LibroEntity();
        // libro.setIdUs((String)objectUser[0]);
        // libro.setNombreUs((String) objectUser[1]);
        // libro.setApellidosUs((String) objectUser[2]);
        // libro.setTipoUs(tipoUsuarioJpaRepository.findById(tipo).orElseThrow(() -> new RuntimeException("Genero de libro no encontrado")));
        // libro.setEmailUs((String) objectUser[4]);
        // libro.setDniUs((String) objectUser[5]);
        // libro.setImageUs((String) objectUser[6]);
        return libro;
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