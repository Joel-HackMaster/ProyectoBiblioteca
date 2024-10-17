package com.proyecto_biblioteca.proyectobiblioteca.repository.contrato;

import java.util.Optional;

public interface IAuthRepository<T, ID> extends IGenericRepository<T, ID> {
    Optional<T> obtenerPorEmail(ID email);
    T guardarUsuario(T modelo, int tipo);
}
