// Clase AdministrarBiblioteca
package Logica;

public class AdministrarBiblioteca {
    public static void main(String[] args) {
        // Crear instancias de la biblioteca, estudiantes y libros
        Biblioteca biblioteca = new Biblioteca();
        Estudiante estudiante1 = new Estudiante(1, "Juan");
        Estudiante estudiante2 = new Estudiante(2, "Ana");
        Libro libro1 = new Libro(101, "Cien años de soledad");
        Libro libro2 = new Libro(102, "El señor de los anillos");

        // Realizar préstamos y devoluciones
        biblioteca.realizarPrestamo(estudiante1, libro1);
        biblioteca.realizarPrestamo(estudiante2, libro2);

        biblioteca.realizarDevolucion(estudiante1, libro1);

        // Mostrar información después de las operaciones
        System.out.println("Estado de los libros después de las operaciones:");
        System.out.println("Libro 1 está disponible: " + libro1.estaDisponible());
        System.out.println("Libro 2 está disponible: " + libro2.estaDisponible());

        // Mostrar información sobre los préstamos de los estudiantes
        System.out.println("\nPréstamos de los estudiantes:");
        System.out.println("Préstamos de " + estudiante1.getNombre() + ": " + estudiante1.getLibrosPrestados());
        System.out.println("Préstamos de " + estudiante2.getNombre() + ": " + estudiante2.getLibrosPrestados());
    }
}
