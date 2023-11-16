package Logica;

import db.BaseDatosBiblioteca;

public class Libro {
    
    private int id;
    private String titulo;
    private boolean disponible;

     public Libro(int id, String titulo, boolean disponible) {
        this.id = id;
        this.titulo = titulo;
        this.disponible = disponible;
        actualizarInformacion();
    }

    // Métodos getters y setters

    public boolean estaDisponible() {
        return disponible;
    }

    public void prestar() {
        if (disponible) {
            disponible = false;
        } else {
            System.out.println("El libro no está disponible en este momento.");
        }
    }

    public void devolver() {
        disponible = true;
    }

    public int getIdLibro() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    // Actualizar información del libro desde la base de datos
    public void actualizarInformacion() {
        Libro libroInfo = BaseDatosBiblioteca.obtenerInstancia().getInformacionLibro(id);
        if (libroInfo != null) {
            this.titulo = libroInfo.getTitulo();
            this.disponible = libroInfo.estaDisponible();
        }
    }
}


