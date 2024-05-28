package frames;

import controllers.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.WindowConstants;

public class Capturista extends javax.swing.JFrame {

    String user, nombre_usuario;
    int sesion_usuario;
    
    public Capturista() {
        initComponents();
        user = Login.user;
        sesion_usuario = Admin.sesion_usuario;
        
        setSize(550,300);
        setResizable(false);
        setTitle("Capturista - Sesion de " + user);
        setLocationRelativeTo(null);
        
        if (sesion_usuario == 1) {
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        } else {
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
        
        try {
            Connection cn = Conexion.conection();
            PreparedStatement pst = cn.prepareStatement("SELECT nombre_usuario FROM usuarios WHERE username = '" + user +"'");
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                nombre_usuario = rs.getString("nombre_usuario");
                jLabel1_NombreUsuario.setText("Bienvenido " + nombre_usuario);
            }
            
        } catch (SQLException e) {
            System.err.println("Error al consultar usuario");
        }
    }
    
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("icon.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton_registrarCliente = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton_gestionarClientes = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton_imprimir = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1_NombreUsuario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton_registrarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png"))); // NOI18N
        jButton_registrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_registrarClienteActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_registrarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 120, 100));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Registrar Cliente");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, -1));

        jButton_gestionarClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/informationuser.png"))); // NOI18N
        jButton_gestionarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_gestionarClientesActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_gestionarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 120, 100));

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Gestionar Clientes");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, -1, -1));

        jButton_imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/impresora.png"))); // NOI18N
        getContentPane().add(jButton_imprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 120, 100));

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Imprimir Clientes");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, -1, -1));

        jLabel1_NombreUsuario.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel1_NombreUsuario.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1_NombreUsuario.setText("jLabel1");
        getContentPane().add(jLabel1_NombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_registrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_registrarClienteActionPerformed
       RegistrarClientes registrarCliente = new RegistrarClientes();
       registrarCliente.setVisible(true);
    }//GEN-LAST:event_jButton_registrarClienteActionPerformed

    private void jButton_gestionarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_gestionarClientesActionPerformed
       GestionarClientes gestion_cliente = new GestionarClientes();
       gestion_cliente.setVisible(true);
    }//GEN-LAST:event_jButton_gestionarClientesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Capturista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Capturista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Capturista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Capturista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Capturista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_gestionarClientes;
    private javax.swing.JButton jButton_imprimir;
    private javax.swing.JButton jButton_registrarCliente;
    private javax.swing.JLabel jLabel1_NombreUsuario;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
