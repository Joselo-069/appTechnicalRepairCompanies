package com.mycompany.apptechnicalrepaircompanies.frames;

import com.mycompany.apptechnicalrepaircompanies.dao.IUserDao;
import com.mycompany.apptechnicalrepaircompanies.dao.UserDao;
import com.mycompany.apptechnicalrepaircompanies.utils.Design;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.WindowConstants;

public class Tecnico extends javax.swing.JFrame {

    String user, name_user;
    int sesion_usuario;
    IUserDao userDao = new UserDao();
    
    public Tecnico() {
        initComponents();
        user = Login.user;
        sesion_usuario = Admin.sesion_usuario;
        Design.viewSizeFrame(this, user, 770, 300, "Técnico - Sesion de " + user);
        
        if (sesion_usuario == 1) {
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        } else {
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
        
        getNameUser();
    }
    
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("icon.png"));
        return retValue;
    }

    public void getNameUser() {
        name_user = userDao.getUserByUsername(user).getName();
        jLabel1_NombreUsuario.setText("Bienvenido " + name_user + " 👋");
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
        btn_equipos1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

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

        btn_equipos1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/informationuser.png"))); // NOI18N
        btn_equipos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_equipos1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_equipos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, 120, 100));

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Gestion de equipos reparados");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 180, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_equiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_equiposActionPerformed
        GestionarEquipos gestionEquipos = new GestionarEquipos();
        gestionEquipos.setVisible(true);
    }//GEN-LAST:event_btn_equiposActionPerformed

    private void btn_statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_statusActionPerformed
        GraficaEstatus grafico = new GraficaEstatus();
        grafico.setVisible(true);
    }//GEN-LAST:event_btn_statusActionPerformed

    private void btn_marcasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_marcasActionPerformed
        GraficaMarcas grafico = new GraficaMarcas();
        grafico.setVisible(true);
    }//GEN-LAST:event_btn_marcasActionPerformed

    private void btn_equipos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_equipos1ActionPerformed
        GestionarEquiposRevisados graph = new GestionarEquiposRevisados();
        graph.setVisible(true);
    }//GEN-LAST:event_btn_equipos1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_equipos;
    private javax.swing.JButton btn_equipos1;
    private javax.swing.JButton btn_marcas;
    private javax.swing.JButton btn_status;
    private javax.swing.JLabel jLabel1_NombreUsuario;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
