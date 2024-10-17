package com.proyecto_biblioteca.proyectobiblioteca.repository;

import com.proyecto_biblioteca.proyectobiblioteca.entity.AccionUsuarioEntity;
import com.proyecto_biblioteca.proyectobiblioteca.repository.JPArepository.AccionUsuarioJpaRepository;
import com.proyecto_biblioteca.proyectobiblioteca.repository.contrato.IGenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccionUsuarioRepository implements IGenericRepository<AccionUsuarioEntity, Long> {

    @Autowired
    AccionUsuarioJpaRepository accionUsuarioJpaRepository;

    @Override
    public List<AccionUsuarioEntity> obtenerTodos() {
        return List.of();
    }

    @Override
    public List<AccionUsuarioEntity> obtenerPorTipo(int tipo) {
        return null;
    }

    @Override
    public AccionUsuarioEntity obtenerPorId(Long id) {
        return accionUsuarioJpaRepository.findById(id).orElseThrow(() -> new RuntimeException("Accion no encontrada"));
    }

    @Override
    public AccionUsuarioEntity guardarModelo(AccionUsuarioEntity modelo) {
        return null;
    }

    @Override
    public boolean eliminarModelo(Long id) {
        return false;
    }
}
