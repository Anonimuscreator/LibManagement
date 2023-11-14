// Clase BaseDatosBiblioteca
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Logica.Estudiante;
import Logica.Libro;

public class BaseDatosBiblioteca {
    private static BaseDatosBiblioteca instancia = null;
    private Connection conexion;

    private BaseDatosBiblioteca() {
        try {
            // Establece la conexión a tu base de datos aquí
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "usuario", "contraseña");
        } catch (SQLException e) {
            // Manejar la excepción o relanzarla según sea necesario
            e.printStackTrace();
        }
    }

    public static BaseDatosBiblioteca obtenerInstancia() {
        if (instancia == null) {
            instancia = new BaseDatosBiblioteca();
        }
        return instancia;
    }

    public Connection obtenerConexion() {
        return conexion;
    }

    // Método para registrar préstamo
    public void registrarPrestamo(Estudiante estudiante, Libro libro) {
        try (Connection conexion = obtenerConexion()) {
            String query = "INSERT INTO prestamos (id_estudiante, id_libro) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
                preparedStatement.setInt(1, estudiante.getId());
                preparedStatement.setInt(2, libro.getIdLibro());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            // Manejar la excepción o relanzarla según sea necesario
            e.printStackTrace();
        }
    }

    // Método para registrar devolución
    public void registrarDevolucion(Estudiante estudiante, Libro libro) {
        try (Connection conexion = obtenerConexion()) {
            String query = "DELETE FROM prestamos WHERE id_estudiante = ? AND id_libro = ?";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
                preparedStatement.setInt(1, estudiante.getId());
                preparedStatement.setInt(2, libro.getIdLibro());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            // Manejar la excepción o relanzarla según sea necesario
            e.printStackTrace();
        }
    }
}
