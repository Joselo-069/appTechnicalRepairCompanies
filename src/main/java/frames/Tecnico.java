package frames;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import controllers.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class Tecnico extends javax.swing.JFrame {

    String user, nombre_usuario;
    int sesion_usuario;
    
    public Tecnico() {
        initComponents();
        user = Login.user;
        sesion_usuario = Admin.sesion_usuario;
        
        setSize(550,300);
        setResizable(false);
        setTitle("Técnico - Sesion de " + user);
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
            System.err.println("Error al consultar nombre de tecnico");
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

        btn_equipos = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btn_status = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btn_marcas = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1_NombreUsuario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_equipos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apoyo-tecnico.png"))); // NOI18N
        btn_equipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_equiposActionPerformed(evt);
            }
        });
        getContentPane().add(btn_equipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 120, 100));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Gestion de equipos");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        btn_status.setIcon(new javax.swing.ImageIcon(getClass().getResource("/grafica.png"))); // NOI18N
        btn_status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_statusActionPerformed(evt);
            }
        });
        getContentPane().add(btn_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 120, 100));

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Grafica de estatus");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, -1, -1));

        btn_marcas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/grafica.png"))); // NOI18N
        btn_marcas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_marcasActionPerformed(evt);
            }
        });
        getContentPane().add(btn_marcas, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 120, 100));

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Grafica de marcas");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, -1, -1));

        jLabel1_NombreUsuario.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel1_NombreUsuario.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1_NombreUsuario.setText("jLabel1");
        getContentPane().add(jLabel1_NombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_equiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_equiposActionPerformed
        GestionarEquipos gestionEquipos = new GestionarEquipos();
        gestionEquipos.setVisible(true);
    }//GEN-LAST:event_btn_equiposActionPerformed

    private void btn_statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_statusActionPerformed
 
    }//GEN-LAST:event_btn_statusActionPerformed

    private void btn_marcasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_marcasActionPerformed

    }//GEN-LAST:event_btn_marcasActionPerformed

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
            java.util.logging.Logger.getLogger(Tecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tecnico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_equipos;
    private javax.swing.JButton btn_marcas;
    private javax.swing.JButton btn_status;
    private javax.swing.JLabel jLabel1_NombreUsuario;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
