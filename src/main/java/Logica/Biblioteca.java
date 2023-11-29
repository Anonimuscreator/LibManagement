package Logica;

import db.BaseDatosBiblioteca;

public class Biblioteca {
    private BaseDatosBiblioteca conexionBaseDatos;

    public Biblioteca() {
        conexionBaseDatos = BaseDatosBiblioteca.obtenerInstancia();
    }

    public void realizarPrestamo(Estudiante estudiante, Libro libro) {
        if (libro != null && libro.estaDisponible()) {
            estudiante.prestar(libro);

            // Delegar la transacción a la clase BaseDatosBiblioteca
            if (conexionBaseDatos.isConnected()) {
                conexionBaseDatos.registrarPrestamo(estudiante, libro);
            } else {
                System.out.println("Error: Base de datos no conectada.");
                // Optionally, handle the error or show a message to the user
            }
        } else {
            System.out.println("El libro no está disponible o no existe.");
        }
    }

    public void realizarDevolucion(Estudiante estudiante, Libro libro) {
        estudiante.devolver(libro);

        // Delegar la transacción a la clase BaseDatosBiblioteca
        if (conexionBaseDatos.isConnected()) {
            conexionBaseDatos.registrarDevolucion(estudiante, libro);
        } else {
            System.out.println("Error: Base de datos no conectada.");
            // Optionally, handle the error or show a message to the user
        }
    }
}
