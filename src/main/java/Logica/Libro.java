// Clase Libro
package Logica;

public class Libro {
    private int id;
    private String titulo;
    private boolean disponible;

    public Libro(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
        this.disponible = true;
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
}
