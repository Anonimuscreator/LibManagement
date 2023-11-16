package Interface;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.BaseDatosBiblioteca;
import java.sql.Connection;

public class Pantalla extends javax.swing.JFrame {
    
    private BaseDatosBiblioteca baseDatos;

    public Pantalla() {
        initComponents();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        studentName = new javax.swing.JFormattedTextField();
        sortName = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        sortID = new javax.swing.JButton();
        sortFilter = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        btnConnect = new javax.swing.JButton();
        btnReserve = new javax.swing.JButton();
        status = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnCloseDB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        studentName.setText("Nombre");
        studentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentNameActionPerformed(evt);
            }
        });

        sortName.setText("Por nombre");
        sortName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortNameActionPerformed(evt);
            }
        });

        jLabel1.setText("Ingresar nombre de alumno");

        jLabel3.setText("Buscar Libro");

        sortID.setText("Por ID");

        sortFilter.setText("Ingresar filtro");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(sortName)
                .addGap(18, 18, 18)
                .addComponent(sortID, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(studentName, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sortFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(studentName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jLabel3)
                .addGap(16, 16, 16)
                .addComponent(sortFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sortName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sortID))
                .addContainerGap(127, Short.MAX_VALUE))
        );

        btnConnect.setText("Conectar");
        btnConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectActionPerformed(evt);
            }
        });

        btnReserve.setText("Reservar");

        status.setText("Estado:");

        jLabel4.setText("Administrar base de datos");

        btnCloseDB.setText("Cerrar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btnReserve, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btnConnect)
                        .addGap(33, 33, 33)
                        .addComponent(btnCloseDB)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConnect)
                    .addComponent(btnCloseDB))
                .addGap(45, 45, 45)
                .addComponent(status)
                .addGap(27, 27, 27)
                .addComponent(btnReserve)
                .addContainerGap(190, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void closeDatabase() {
        baseDatos = BaseDatosBiblioteca.obtenerInstancia();
        baseDatos.cerrarConexion();
        // Update status label
        status.setText("Desconectado");
    }
    private void studentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentNameActionPerformed

    private void sortNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sortNameActionPerformed

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

                // You can do something with the data (for example, print it)
                System.out.println("ID: " + id + ", Nombre: " + nombre);
            }

            // ResultSet is closed automatically when the statement is closed

        } catch (SQLException e) {
            // Handle any SQL exceptions
            e.printStackTrace();
        }
    }
    }//GEN-LAST:event_btnConnectActionPerformed

    private void btnCloseDBActionPerformed(java.awt.event.ActionEvent evt) {                                           
        closeDatabase();
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JFormattedTextField sortFilter;
    private javax.swing.JButton sortID;
    private javax.swing.JButton sortName;
    private javax.swing.JLabel status;
    private javax.swing.JFormattedTextField studentName;
    // End of variables declaration//GEN-END:variables
}
