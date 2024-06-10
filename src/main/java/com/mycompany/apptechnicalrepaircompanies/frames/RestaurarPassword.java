package com.mycompany.apptechnicalrepaircompanies.frames;

import com.mycompany.apptechnicalrepaircompanies.dao.IUserDao;
import com.mycompany.apptechnicalrepaircompanies.dao.UserDao;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class RestaurarPassword extends javax.swing.JFrame {

    String user = "", user_update = "";
    IUserDao userDao = new UserDao();
    String password, confirmacion_password;
    
    public RestaurarPassword() {
        initComponents();
        user = Login.user;
        user_update = GestionarUsuarios.user_update;
        
        setTitle("Cambio de password para " + user_update);
        setSize(630, 350);
        setResizable(false);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_titulo = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_password = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        txt_confirmar = new javax.swing.JPasswordField();
        jButton_restaurar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_titulo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel_titulo.setText("Cambio de password");
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Nuevo Password:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        txt_password.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txt_password.setForeground(new java.awt.Color(0, 0, 0));
        txt_password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_password.setToolTipText("");
        getContentPane().add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 210, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Confirmar Password:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        txt_confirmar.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txt_confirmar.setForeground(new java.awt.Color(0, 0, 0));
        txt_confirmar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_confirmar.setToolTipText("");
        getContentPane().add(txt_confirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 210, -1));

        jButton_restaurar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton_restaurar.setText("Restaurar Password");
        jButton_restaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_restaurarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_restaurar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 210, 35));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_restaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_restaurarActionPerformed
        
        password = txt_password.getText().trim();
        confirmacion_password = txt_confirmar.getText().trim();
        
        validateChangePassword(password, confirmacion_password);
    }//GEN-LAST:event_jButton_restaurarActionPerformed

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
            java.util.logging.Logger.getLogger(RestaurarPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RestaurarPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RestaurarPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RestaurarPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RestaurarPassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_restaurar;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JPasswordField txt_confirmar;
    private javax.swing.JPasswordField txt_password;
    // End of variables declaration//GEN-END:variables

    private void validateChangePassword(String psw, String confirmPsw) {
        if (!psw.equals("") && !confirmPsw.equals("")) {
            if (psw.equals(confirmPsw)) {
                changePassword(psw);
            } else {
                txt_confirmar.setBackground(Color.red);
                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
            }
        } else {
            txt_password.setBackground(Color.red);
            txt_confirmar.setBackground(Color.red);
            JOptionPane.showMessageDialog(null, "Campos vacios");
        }
    }
    
    private void changePassword(String password){
        userDao.updatePasswordUser(password, user_update);
        this.dispose();
    }
}
