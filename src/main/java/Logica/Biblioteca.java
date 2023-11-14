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
            conexionBaseDatos.registrarPrestamo(estudiante.getId(), libro.getId());
        } else {
            System.out.println("El libro no está disponible o no existe.");
        }
    }

    public void realizarDevolucion(Estudiante estudiante, Libro libro) {
        estudiante.devolver(libro);

        // Delegar la transacción a la clase BaseDatosBiblioteca
        conexionBaseDatos.registrarDevolucion(estudiante.getId(), libro.getId());
    }
}