package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Logica.Estudiante;
import Logica.Libro;

public class BaseDatosBiblioteca {
    private static BaseDatosBiblioteca instancia = null;
    private Connection conexion;

    private BaseDatosBiblioteca() {
        try {
            // Cargar el driver JDBC de SQLite
            Class.forName("org.sqlite.JDBC");

            // Establecer la conexión a tu base de datos SQLite aquí (cambiar la URL según tu caso)
            conexion = DriverManager.getConnection("jdbc:sqlite:C:/Users/Deplm-08/Desktop/LibManagement/biblioteca.db");
        } catch (ClassNotFoundException | SQLException e) {
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

    // Método para obtener información de un libro
    public Libro getInformacionLibro(int libroId) {
        Libro libroInfo = null;

        try (Connection conexion = obtenerConexion()) {
            String query = "SELECT * FROM Libro WHERE id = ?";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
                preparedStatement.setInt(1, libroId);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        int idLibro = resultSet.getInt("id");
                        String titulo = resultSet.getString("titulo");
                        boolean disponible = resultSet.getBoolean("disponible");

                        libroInfo = new Libro(idLibro, titulo, disponible);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return libroInfo;
    }

    public List<Libro> getLibrosPrestados(Estudiante estudiante) {
        List<Libro> librosPrestados = new ArrayList<>();

        try (Connection conexion = obtenerConexion()) {
            String query = "SELECT id_libro FROM prestamos WHERE id_estudiante = ?";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
                preparedStatement.setInt(1, estudiante.getId());

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        int idLibro = resultSet.getInt("id_libro");
                        Libro libroInfo = getInformacionLibro(idLibro);
                        librosPrestados.add(new Libro(libroInfo.getIdLibro(), libroInfo.getTitulo(), libroInfo.estaDisponible()));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return librosPrestados;
    }
    
        public boolean isConnected() {
        return conexion != null;
    }
        
        public void cerrarConexion() {
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}