package com.proyecto_biblioteca.proyectobiblioteca.repository;

import com.proyecto_biblioteca.proyectobiblioteca.entity.AuditoriaUsuarioEntity;
import com.proyecto_biblioteca.proyectobiblioteca.repository.JPArepository.AuditoriaUsuarioJpaRepository;
import com.proyecto_biblioteca.proyectobiblioteca.repository.contrato.IGenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuditoriaUsuarioRepository implements IGenericRepository<AuditoriaUsuarioEntity, Long> {
    @Autowired
    AuditoriaUsuarioJpaRepository auditoriaUsuarioJpaRepository;


    @Override
    public List<AuditoriaUsuarioEntity> obtenerTodos() {
        return List.of();
    }

    @Override
    public List<AuditoriaUsuarioEntity> obtenerPorTipo(int tipo) {
        return List.of();
    }

    @Override
    public AuditoriaUsuarioEntity obtenerPorId(Long id) {
        return null;
    }

    @Override
    public AuditoriaUsuarioEntity guardarModelo(AuditoriaUsuarioEntity modelo) {
        return  auditoriaUsuarioJpaRepository.save(modelo);
    }

    @Override
    public boolean eliminarModelo(Long id) {
        return false;
    }
}
