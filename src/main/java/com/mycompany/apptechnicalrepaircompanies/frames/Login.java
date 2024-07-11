package com.mycompany.apptechnicalrepaircompanies.frames;

import com.mycompany.apptechnicalrepaircompanies.dao.IUserDao;
import com.mycompany.apptechnicalrepaircompanies.dao.UserDao;
import com.mycompany.apptechnicalrepaircompanies.emuns.EstatusUser;
import com.mycompany.apptechnicalrepaircompanies.emuns.RolUser;
import com.mycompany.apptechnicalrepaircompanies.models.User;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {
    
    public static String user = "";
    String pass = "";
    IUserDao userDao = new UserDao();

    public Login() {
        initComponents();
        setSize(400,600);
        setResizable(false);
        setTitle("Acceso al sistema");
        setLocationRelativeTo(null);
    }

    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("icon.png"));
        return retValue;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btn_access = new javax.swing.JButton();
        txt_password = new javax.swing.JPasswordField();
        txt_user = new javax.swing.JTextField();
        jLabel_Logo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Creado por Gonzalo Pineda");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 520, -1, -1));

        btn_access.setBackground(new java.awt.Color(255, 255, 255));
        btn_access.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btn_access.setForeground(new java.awt.Color(0, 0, 0));
        btn_access.setText("Acceder");
        btn_access.setBorder(null);
        btn_access.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_accessMouseEntered(evt);
            }
        });
        btn_access.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_accessActionPerformed(evt);
            }
        });
        btn_access.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_accessKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btn_accessKeyReleased(evt);
            }
        });
        getContentPane().add(btn_access, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 420, 210, 35));

        txt_password.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txt_password.setForeground(new java.awt.Color(0, 0, 0));
        txt_password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });
        txt_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_passwordKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_passwordKeyReleased(evt);
            }
        });
        getContentPane().add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 370, 210, -1));

        txt_user.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txt_user.setForeground(new java.awt.Color(0, 0, 0));
        txt_user.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_userActionPerformed(evt);
            }
        });
        getContentPane().add(txt_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 330, 210, -1));

        jLabel_Logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DS.png"))); // NOI18N
        jLabel_Logo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel_Logo.setPreferredSize(new java.awt.Dimension(250, 250));
        getContentPane().add(jLabel_Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 270, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void accessUser(){
        user = txt_user.getText().trim();
        pass = txt_password.getText().trim();

        String type = "", status = "";

        if (!user.equals("") || !pass.equals("")) {

            User userImpl = userDao.getUserByUsernamePassword(user, pass);

            type = userImpl.getType();
            status = userImpl.getStatus();

            if (type.equalsIgnoreCase(RolUser.Administrador.name()) && status.equalsIgnoreCase(EstatusUser.Activo.name())) {
                dispose();
                new Admin().setVisible(true);
            } else if (type.equalsIgnoreCase(RolUser.Capturista.name()) && status.equalsIgnoreCase(EstatusUser.Activo.name())) {
                dispose();
                new Capturista().setVisible(true);
            } else if (type.equalsIgnoreCase(RolUser.Tecnico.name()) && status.equalsIgnoreCase(EstatusUser.Activo.name())) {
                dispose();
                new Tecnico().setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos.");
        }
    }
    
    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordActionPerformed

    private void txt_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_userActionPerformed

    private void btn_accessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_accessActionPerformed
        accessUser();
    }//GEN-LAST:event_btn_accessActionPerformed

    private void btn_accessKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_accessKeyPressed
         accessUser();
    }//GEN-LAST:event_btn_accessKeyPressed

    private void txt_passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passwordKeyPressed
    }//GEN-LAST:event_txt_passwordKeyPressed

    private void btn_accessKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_accessKeyReleased

    }//GEN-LAST:event_btn_accessKeyReleased

    private void txt_passwordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passwordKeyReleased

    }//GEN-LAST:event_txt_passwordKeyReleased

    private void btn_accessMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_accessMouseEntered
    }//GEN-LAST:event_btn_accessMouseEntered

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_access;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_Logo;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_user;
    // End of variables declaration//GEN-END:variables
}
