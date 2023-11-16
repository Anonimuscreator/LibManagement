package Interface;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.BaseDatosBiblioteca;
import java.sql.Connection;
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
        jButton1 = new javax.swing.JButton();

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

        jButton1.setText("Prestamo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnConnect)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCloseDB))
                            .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(71, 71, 71))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(96, 96, 96))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnReserve, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConnect)
                    .addComponent(btnCloseDB))
                .addGap(52, 52, 52)
                .addComponent(status)
                .addGap(78, 78, 78)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReserve)
                    .addComponent(jButton1))
                .addContainerGap(150, Short.MAX_VALUE))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
    baseDatos = BaseDatosBiblioteca.obtenerInstancia();
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
    private javax.swing.JButton btnReserve;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel status;
    // End of variables declaration//GEN-END:variables
}
