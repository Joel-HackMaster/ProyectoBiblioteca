package com.proyecto_biblioteca.proyectobiblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RestController
public class PostgresqlController {
    @Autowired
    private DataSource dataSource;

    @GetMapping("/conexion")
    public String connection(){
        try(Connection connection = dataSource.getConnection()){
            return "Exito en la conexion: "+ connection.getMetaData().getDatabaseProductName();
        }catch (SQLException e){
            e.printStackTrace();
            return "Error en la conexion a la base de datos: "+ e.getMessage()  ;
        }
    }
}
