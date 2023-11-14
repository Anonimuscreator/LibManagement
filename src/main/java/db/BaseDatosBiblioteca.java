package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    // Nuevos métodos para gestionar transacciones
    public void registrarPrestamo(int idEstudiante, int idLibro) {
        try (Connection conexion = obtenerConexion()) {
            String query = "INSERT INTO prestamos (id_estudiante, id_libro) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
                preparedStatement.setInt(1, idEstudiante);
                preparedStatement.setInt(2, idLibro);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            // Manejar la excepción o relanzarla según sea necesario
            e.printStackTrace();
        }
    }

    public void registrarDevolucion(int idEstudiante, int idLibro) {
        try (Connection conexion = obtenerConexion()) {
            String query = "DELETE FROM prestamos WHERE id_estudiante = ? AND id_libro = ?";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
                preparedStatement.setInt(1, idEstudiante);
                preparedStatement.setInt(2, idLibro);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            // Manejar la excepción o relanzarla según sea necesario
            e.printStackTrace();
        }
    }
}