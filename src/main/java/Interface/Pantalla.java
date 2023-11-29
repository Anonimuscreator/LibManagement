package Interface;

import java.sql.ResultSet;
import java.sql.SQLException;
import db.BaseDatosBiblioteca;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Pantalla extends javax.swing.JFrame {
    
    private BaseDatosBiblioteca baseDatos;

    public Pantalla() {
        initComponents();
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnConnect = new javax.swing.JButton();
        btnReserve = new javax.swing.JButton();
        btnCloseDB = new javax.swing.JButton();
        status = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnLoan = new javax.swing.JButton();
        entryStudent = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        entryBook = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnConnect.setText("Conectar");
        btnConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectActionPerformed(evt);
            }
        });

        btnReserve.setText("Devolucion");

        btnCloseDB.setText("Cerrar");

        status.setText("Estado:");

        jLabel4.setText("Administrar base de datos");

        btnLoan.setText("Prestamo");
        btnLoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoanActionPerformed(evt);
            }
        });

        entryStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entryStudentActionPerformed(evt);
            }
        });

        jLabel1.setText("Realizar Prestamo:");

        entryBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entryBookActionPerformed(evt);
            }
        });

        jLabel2.setText("Ingresar ID de alumno:");

        jLabel3.setText("Ingresar ID del Libro:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(btnLoan, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnReserve, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(136, 136, 136)
                        .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(btnConnect)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCloseDB))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(entryStudent, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                        .addComponent(entryBook)))
                .addGap(509, 509, 509))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(status))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConnect)
                    .addComponent(btnCloseDB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(entryStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(17, 17, 17)
                .addComponent(entryBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReserve)
                    .addComponent(btnLoan))
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean isNumeric(String str) {
    return str.matches("\\d+");
}
        
    private void btnConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnectActionPerformed
        openDatabase(); // Ensure that the database is connected

        if (baseDatos.isConnected()) {
            try {
                // Assuming you have a Statement instance, you can execute a query
                String query = "SELECT * FROM estudiantes";
                ResultSet resultSet = baseDatos.executeQuery(query);

                // Process the ResultSet (assuming a simple output to the console)
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String nombre = resultSet.getString("nombre");
                    String librosPrestados = resultSet.getString("librosPrestados");

                    // You can do something with the data (for example, print it)
                    System.out.println("ID: " + id + ", Nombre: " + nombre + ", Libros Prestados: " + librosPrestados);
                }

                // ResultSet is closed automatically when the statement is closed

            } catch (SQLException e) {
                // Handle any SQL exceptions
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnConnectActionPerformed

    private void btnLoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoanActionPerformed
        // Get student and book IDs from the input fields
        String studentId = entryStudent.getText();
        int bookId = Integer.parseInt(entryBook.getText());

        // Check if the database is connected
        if (baseDatos.isConnected()) {
            System.out.println("Connected to the database");

            // Check if the student and book exist in the database
            boolean studentExists = baseDatos.studentExists(studentId);
            boolean bookExists = baseDatos.bookExists(bookId);

            if (studentExists && bookExists) {
                System.out.println("Student and book exist in the database");

                // Get the current date
                String currentDate = baseDatos.getCurrentDate();

                // Register the loan
                baseDatos.registrarPrestamo(Integer.parseInt(studentId), bookId, currentDate);

                // Optionally, show a success message
                JOptionPane.showMessageDialog(this, "Préstamo registrado exitosamente", "Préstamo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Show an error message if the student or book doesn't exist
                System.out.println("Error: Estudiante o libro no encontrado en la base de datos");
                JOptionPane.showMessageDialog(this, "Error: Estudiante o libro no encontrado en la base de datos", "Error de préstamo", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // Optionally, show an error message
            System.out.println("Error: Base de datos no conectada");
            JOptionPane.showMessageDialog(this, "Error: Base de datos no conectada", "Error de conexión", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnLoanActionPerformed

    private void entryBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entryBookActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_entryBookActionPerformed

    private void entryStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entryStudentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_entryStudentActionPerformed

    private void openDatabase() {
        baseDatos = BaseDatosBiblioteca.obtenerInstancia();
        if (baseDatos.isConnected()) {
            // Update status label
            status.setText("Conectado");
        } else {
            // Update status label
            status.setText("Error de conexión");
        }
    }

    private boolean closeDatabase() {
        boolean success = baseDatos.cerrarConexion();
        if (success) {
            // Update status label
            status.setText("Desconectado");
            // Optionally, show a message dialog to indicate successful database closure
            JOptionPane.showMessageDialog(this, "Base de datos cerrada exitosamente", "Estado de conexión", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Optionally, show a message dialog to indicate closure error
            JOptionPane.showMessageDialog(this, "Error al cerrar la base de datos", "Error de conexión", JOptionPane.ERROR_MESSAGE);
        }
        return success;
    }

    private void btnCloseDBActionPerformed(java.awt.event.ActionEvent evt) {
        SwingUtilities.invokeLater(() -> {
            boolean isClosed = closeDatabase();

            if (isClosed) {
                // Update status label
                status.setText("Desconectado");
                // Optionally, show a message dialog to indicate that the database was closed successfully
                JOptionPane.showMessageDialog(this, "Base de datos cerrada exitosamente", "Estado de conexión", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Optionally, show a message dialog to indicate that there was an issue closing the database
                JOptionPane.showMessageDialog(this, "Error al cerrar la base de datos", "Error de conexión", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pantalla().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCloseDB;
    private javax.swing.JButton btnConnect;
    private javax.swing.JButton btnLoan;
    private javax.swing.JButton btnReserve;
    private javax.swing.JTextField entryBook;
    private javax.swing.JTextField entryStudent;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel status;
    // End of variables declaration//GEN-END:variables
}
