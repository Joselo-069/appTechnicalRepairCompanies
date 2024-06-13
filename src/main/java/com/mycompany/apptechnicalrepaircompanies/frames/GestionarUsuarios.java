package com.mycompany.apptechnicalrepaircompanies.frames;

import com.mycompany.apptechnicalrepaircompanies.dao.IUserDao;
import com.mycompany.apptechnicalrepaircompanies.dao.UserDao;
import com.mycompany.apptechnicalrepaircompanies.models.User;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public class GestionarUsuarios extends javax.swing.JFrame {

    String user;
    public static String user_update = "";
    DefaultTableModel model = new DefaultTableModel();
    IUserDao userDao = new UserDao();

    public GestionarUsuarios() {
        initComponents();
        user = Login.user;
        
        setSize(630, 330);
        setTitle("Usuarios registrados - Sesion de " + user);
        setResizable(false);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        listUsers();
    }

    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("icon.png"));
        return retValue;
    }
    
    public void listUsers() {
        
        ArrayList<User> users = (ArrayList<User>) userDao.getListUsers();

        tbUsers = new JTable(model);
        jScrollPane1.setViewportView(tbUsers);

        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Username");
        model.addColumn("Permisos");
        model.addColumn("Estatus");

        for (User user : users) {
            Object[] file = new Object[5];
            file[0] = user.getId();
            file[1] = user.getName();
            file[2] = user.getUsername();
            file[3] = user.getType();
            file[4] = user.getStatus();
            model.addRow(file);
        }
        
        selectFileTable();
    }

    public void selectFileTable() {
        tbUsers.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = tbUsers.rowAtPoint(e.getPoint());
                int columna_point = 2;

                if (fila_point > -1) {
                    user_update = (String) model.getValueAt(fila_point, columna_point);
                    InformacionUsuario info = new InformacionUsuario();
                    info.setVisible(true);
                }
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUsers = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Usuarios Registrados");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Visualizacion de lista de usuarios ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 223, -1));

        tbUsers.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbUsers);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 546, 140));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbUsers;
    // End of variables declaration//GEN-END:variables
}
