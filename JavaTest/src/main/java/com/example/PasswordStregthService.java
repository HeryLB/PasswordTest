package com.example;

// Servicio que simula una dependencia externa
public class PasswordStregthService {
    public boolean isStrongPassword(String password) {
        // Aquí se podría hacer una consulta a una API externa o una base de datos
        // Pero para simplificar, digamos que devuelve false por defecto
        return false;
    }
}
