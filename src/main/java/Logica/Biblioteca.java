package Logica;

import db.BaseDatosBiblioteca;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class Biblioteca {
    private BaseDatosBiblioteca conexionBaseDatos;

    public Biblioteca() {
        conexionBaseDatos = BaseDatosBiblioteca.obtenerInstancia();
    }

    public void realizarPrestamo(Estudiante estudiante, Libro libro) {
        if (libro != null && libro.estaDisponible()) {
            estudiante.prestar(libro);

            // Agregar lógica para registrar el préstamo en la base de datos
            Connection conexion = conexionBaseDatos.obtenerConexion();
            try {
                String query = "INSERT INTO prestamos (id_estudiante, id_libro) VALUES (?, ?)";
                PreparedStatement preparedStatement = conexion.prepareStatement(query);
                preparedStatement.setInt(1, estudiante.getId());
                preparedStatement.setInt(2, libro.getId());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("El libro no está disponible o no existe.");
        }
    }

    public void realizarDevolucion(Estudiante estudiante, Libro libro) {
        estudiante.devolver(libro);

        // Agregar lógica para registrar la devolución en la base de datos
        Connection conexion = conexionBaseDatos.obtenerConexion();
        try {
            String query = "DELETE FROM prestamos WHERE id_estudiante = ? AND id_libro = ?";
            PreparedStatement preparedStatement = conexion.prepareStatement(query);
            preparedStatement.setInt(1, estudiante.getId());
            preparedStatement.setInt(2, libro.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}