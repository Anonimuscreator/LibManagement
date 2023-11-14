// Clase Estudiante
package Logica;

import java.util.ArrayList;
import java.util.List;
import db.BaseDatosBiblioteca;

public class Estudiante {
    private int id;
    private String nombre;
    private List<Libro> librosPrestados;

    public Estudiante(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.librosPrestados = new ArrayList<>();
    }

    public int getId() {
        return id;
    }
    
    public String getNombre() {
        return nombre;
    }

    // Métodos getters y setters

    public void prestar(Libro libro) {
        librosPrestados.add(libro);
        libro.prestar();
        BaseDatosBiblioteca.obtenerInstancia().registrarPrestamo(this, libro);
        System.out.println("El libro '" + libro.getTitulo() + "' ha sido prestado a " + nombre);
    }

    public void devolver(Libro libro) {
        if (librosPrestados.contains(libro)) {
            librosPrestados.remove(libro);
            libro.devolver();
            BaseDatosBiblioteca.obtenerInstancia().registrarDevolucion(this, libro);
            System.out.println("El libro '" + libro.getTitulo() + "' ha sido devuelto por " + nombre);
        } else {
            System.out.println("Este libro no fue prestado por " + nombre);
        }
    }
}
