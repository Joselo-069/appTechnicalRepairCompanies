package com.mycompany.apptechnicalrepaircompanies.frames;

import com.mycompany.apptechnicalrepaircompanies.dao.IUserDao;
import com.mycompany.apptechnicalrepaircompanies.dao.UserDao;
import com.mycompany.apptechnicalrepaircompanies.models.User;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class InformacionUsuario extends javax.swing.JFrame {
    
    IUserDao userDao = new UserDao();
    String user = "", user_update = "";
    int ID;
    
    public InformacionUsuario() {
        initComponents();
        user = Login.user;
        user_update = GestionarUsuarios.user_update;
        
        setSize(630,450);
        setResizable(false);
        setTitle("Informacion del usuario " + user_update + " - Sesion de " + user);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        jLabel_titulo.setText("Informacion del usuario " + user_update);
        getNameUser();
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("icon.png"));
        return retValue;
    }

    private void getNameUser() {

        User user = userDao.getUserByUsername(user_update);

        ID = user.getId_usuario();

        txt_nombre.setText(user.getNombre_usuario());
        txt_email.setText(user.getEmail());
        txt_telefono.setText(user.getTelefono());
        txt_username.setText(user.getUsername());
        txt_RegistradoPor.setText(user.getRegistrado_por());

        cmb_niveles.setSelectedItem(user.getTipo_nivel());
        cmbEstatus.setSelectedItem(user.getEstatus());
    }

    private boolean existeUsername(String username, int idName) {

        String name_user = userDao.getUserByUsernameUpdate(username, idName).getNombre_usuario();

        if (name_user != null) {
            txt_username.setBackground(Color.red);
            JOptionPane.showMessageDialog(null, "Nombre del usuario no disponible.");
            return true;
        }
        return false;
    }

    private void updateUser(String nombre, String email, String telefono, String username, String permisos_string) {

        if (!existeUsername(username, ID)) {
            userDao.updateUser(ID, nombre, email, telefono, username, permisos_string, permisos_string);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_titulo = new javax.swing.JLabel();
        jLabel_nombre = new javax.swing.JLabel();
        jLabel_nombre1 = new javax.swing.JLabel();
        jLabel_nombre2 = new javax.swing.JLabel();
        jLabel_nombre3 = new javax.swing.JLabel();
        jLabel_nombre4 = new javax.swing.JLabel();
        jLabel_nombre5 = new javax.swing.JLabel();
        jLabel_nombre6 = new javax.swing.JLabel();
        txt_RegistradoPor = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        txt_username = new javax.swing.JTextField();
        cmb_niveles = new javax.swing.JComboBox<>();
        cmbEstatus = new javax.swing.JComboBox<>();
        jButton_restaurar = new javax.swing.JButton();
        jButton_actualizar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_titulo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel_titulo.setText("Informacion del usuario");
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, -1, -1));

        jLabel_nombre.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_nombre.setText("Nombre:");
        getContentPane().add(jLabel_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        jLabel_nombre1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_nombre1.setText("Email:");
        getContentPane().add(jLabel_nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        jLabel_nombre2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_nombre2.setText("Telefono:");
        getContentPane().add(jLabel_nombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        jLabel_nombre3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_nombre3.setText("Permisos de:");
        getContentPane().add(jLabel_nombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        jLabel_nombre4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_nombre4.setText("Username:");
        getContentPane().add(jLabel_nombre4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, -1, -1));

        jLabel_nombre5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_nombre5.setText("Estatus:");
        getContentPane().add(jLabel_nombre5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, -1, -1));

        jLabel_nombre6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_nombre6.setText("Registrado por:");
        getContentPane().add(jLabel_nombre6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, -1, -1));

        txt_RegistradoPor.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txt_RegistradoPor.setEnabled(false);
        txt_RegistradoPor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_RegistradoPorActionPerformed(evt);
            }
        });
        getContentPane().add(txt_RegistradoPor, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, 210, -1));

        txt_nombre.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txt_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreActionPerformed(evt);
            }
        });
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 210, -1));

        txt_email.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });
        getContentPane().add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 210, -1));

        txt_telefono.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txt_telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_telefonoActionPerformed(evt);
            }
        });
        getContentPane().add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 210, -1));

        txt_username.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });
        getContentPane().add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 210, -1));

        cmb_niveles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Capturista", "Tecnico" }));
        getContentPane().add(cmb_niveles, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

        cmbEstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        getContentPane().add(cmbEstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, -1, -1));

        jButton_restaurar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton_restaurar.setText("Restaurar Password");
        jButton_restaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_restaurarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_restaurar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 340, 210, 35));

        jButton_actualizar1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton_actualizar1.setText("Actualizar Usuario");
        jButton_actualizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_actualizar1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_actualizar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, 210, 35));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_RegistradoPorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_RegistradoPorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_RegistradoPorActionPerformed

    private void txt_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombreActionPerformed

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void txt_telefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_telefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_telefonoActionPerformed

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void jButton_actualizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_actualizar1ActionPerformed
        String permisos_cmb; 
        int estatus_cmb, validacion = 0;
        String nombre, email, telefono, username, pass, permisos_string="", estatus_string="";
        
        email = txt_email.getText().trim();
        username = txt_username.getText().trim();
        nombre = txt_nombre.getText().trim();
        telefono = txt_telefono.getText().trim();
        permisos_string = (String) cmb_niveles.getSelectedItem();
        estatus_string = (String) cmbEstatus.getSelectedItem();
        
        if (email.equals("")) {
            txt_email.setBackground(Color.red);
            validacion++;
        }
        
        if (username.equals("")) {
            txt_username.setBackground(Color.red);
            validacion++;
        }
        
        if (nombre.equals("")) {
            txt_nombre.setBackground(Color.red);
            validacion++;
        }
        
        if (telefono.equals("")) {
            txt_telefono.setBackground(Color.red);
            validacion++;
        }
        
        updateUser(nombre, email, telefono, username, permisos_string);
        
    }//GEN-LAST:event_jButton_actualizar1ActionPerformed

    private void jButton_restaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_restaurarActionPerformed
        RestaurarPassword res = new RestaurarPassword();
        res.setVisible(true);
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
            java.util.logging.Logger.getLogger(InformacionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacionUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbEstatus;
    private javax.swing.JComboBox<String> cmb_niveles;
    private javax.swing.JButton jButton_actualizar1;
    private javax.swing.JButton jButton_restaurar;
    private javax.swing.JLabel jLabel_nombre;
    private javax.swing.JLabel jLabel_nombre1;
    private javax.swing.JLabel jLabel_nombre2;
    private javax.swing.JLabel jLabel_nombre3;
    private javax.swing.JLabel jLabel_nombre4;
    private javax.swing.JLabel jLabel_nombre5;
    private javax.swing.JLabel jLabel_nombre6;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JTextField txt_RegistradoPor;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_telefono;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables

}
