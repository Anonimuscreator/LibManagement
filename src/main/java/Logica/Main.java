package Logica;

public class Main {
    public static void main(String[] args) {
        // Create instances of your classes
        Estudiante estudiante = new Estudiante(1, "Juan");
        Libro libro = new Libro(001, "El pepe", true);
        Biblioteca biblioteca = new Biblioteca();

        // Display initial information
        System.out.println("Estado inicial:");
        System.out.println("Libro '" + libro.getTitulo() + "' disponible: " + libro.estaDisponible());
        System.out.println("Libros prestados a " + estudiante.getNombre());

        // Perform operations using your classes
        biblioteca.realizarPrestamo(estudiante, libro);

        // Display information after performing operations
        System.out.println("\nDespués del préstamo:");
        System.out.println("Libro '" + libro.getTitulo() + "' disponible: " + libro.estaDisponible());
        System.out.println("Libros prestados a " + estudiante.getNombre());

        // Other interactions...

        biblioteca.realizarDevolucion(estudiante, libro);

        // Display information after performing more operations
        System.out.println("\nDespués de la devolución:");
        System.out.println("Libro '" + libro.getTitulo() + "' disponible: " + libro.estaDisponible());
        System.out.println("Libros prestados a " + estudiante.getNombre());
    }
}
