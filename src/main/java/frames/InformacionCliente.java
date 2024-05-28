package frames;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public class InformacionCliente extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();
    int idCliente;
    public static int idEquipo;
    String user = "";
    
    public InformacionCliente() {
        initComponents();
        user = Login.user;
        idCliente = GestionarClientes.IdCliente;
        
        
        setSize(630,450);
        setResizable(false);
        //setTitle("Informacion del usuario " + user_update + " - Sesion de " + user);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        txt_modificacion.disable();
    }
    
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("icon.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_titulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_telefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_direccion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_modificacion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_equipos = new javax.swing.JTable();
        jButton_restaurar = new javax.swing.JButton();
        jButton_equipo = new javax.swing.JButton();
        jButton_ImprimeReporte = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_titulo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel_titulo.setText("Informacion del cliente");
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        txt_nombre.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txt_nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreActionPerformed(evt);
            }
        });
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 210, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Email:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        txt_email.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txt_email.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });
        getContentPane().add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 210, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Telefono:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        txt_telefono.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txt_telefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_telefonoActionPerformed(evt);
            }
        });
        getContentPane().add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 210, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Dirección:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        txt_direccion.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txt_direccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_direccionActionPerformed(evt);
            }
        });
        getContentPane().add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 210, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Última modificación:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));

        txt_modificacion.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txt_modificacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_modificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_modificacionActionPerformed(evt);
            }
        });
        getContentPane().add(txt_modificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 210, -1));

        tb_equipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tb_equipos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 370, 180));

        jButton_restaurar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton_restaurar.setText("Actualizar cliente");
        jButton_restaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_restaurarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_restaurar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, 210, 35));

        jButton_equipo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton_equipo.setText("Registrar equipo");
        jButton_equipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_equipoActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_equipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 210, 35));

        jButton_ImprimeReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/impresora.png"))); // NOI18N
        getContentPane().add(jButton_ImprimeReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 270, 120, 100));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombreActionPerformed

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void txt_telefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_telefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_telefonoActionPerformed

    private void txt_direccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_direccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_direccionActionPerformed

    private void txt_modificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_modificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_modificacionActionPerformed

    private void jButton_restaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_restaurarActionPerformed

    }//GEN-LAST:event_jButton_restaurarActionPerformed

    private void jButton_equipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_equipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_equipoActionPerformed

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
            java.util.logging.Logger.getLogger(InformacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacionCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_ImprimeReporte;
    private javax.swing.JButton jButton_equipo;
    private javax.swing.JButton jButton_restaurar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_equipos;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_modificacion;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables
}
