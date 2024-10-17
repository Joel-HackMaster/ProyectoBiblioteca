package com.proyecto_biblioteca.proyectobiblioteca.repository.contrato;

import java.util.List;

public interface IGenericRepository<T, ID> {
    List<T> obtenerTodos();
    List<T> obtenerPorTipo(int tipo);
    T obtenerPorId(ID id);
    T guardarModelo(T modelo);
    boolean eliminarModelo(ID id);
}
