package Logica;

public class Main {
    public static void main(String[] args) {
        // Crear una instancia de la clase Biblioteca
        Biblioteca biblioteca = new Biblioteca();

        // Crear un objeto Libro
        Libro libro1 = new Libro(1, "El Gran Gatsby");

        // Crear un objeto Estudiante
        Estudiante estudiante1 = new Estudiante(101, "Juan Pérez");

        // Realizar préstamo y devolución usando la instancia de Biblioteca
        biblioteca.realizarPrestamo(estudiante1, libro1);
        biblioteca.realizarDevolucion(estudiante1, libro1);
    }
}
