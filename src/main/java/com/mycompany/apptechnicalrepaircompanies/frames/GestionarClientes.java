package com.mycompany.apptechnicalrepaircompanies.frames;

import com.mycompany.apptechnicalrepaircompanies.dao.ClientDao;
import com.mycompany.apptechnicalrepaircompanies.dao.IClientDao;
import com.mycompany.apptechnicalrepaircompanies.models.Client;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public class GestionarClientes extends javax.swing.JFrame {

    String user;
    public static int IdCliente = 0;
    DefaultTableModel model = new DefaultTableModel();
    IClientDao clientDao = new ClientDao();
    
    public GestionarClientes() {
        initComponents();
        
        user = Login.user;
        
        setSize(630, 330);
        setTitle("Capturista - Sesion de " + user);
        setResizable(false);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        listClients();
    }
    
    private void listClients(){
        
        ArrayList<Client> clients = (ArrayList<Client>) clientDao.getListClients();

        tbClientes = new JTable(model);
        jScrollPane1.setViewportView(tbClientes);

        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Email");
        model.addColumn("Telefono");
        model.addColumn("Modificado por");

        for (Client client : clients) {
            Object[] file = new Object[5];
            file[0] = client.getId();
            file[1] = client.getName();
            file[2] = client.getEmail();
            file[3] = client.getPhone();
            file[4] = client.getLast_update();
            model.addRow(file);
        }
        
        selectFileTable();
    }
    
    private void selectFileTable() {
        tbClientes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = tbClientes.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    IdCliente = (int) model.getValueAt(fila_point, columna_point);
                    InformacionCliente info = new InformacionCliente();
                    info.setVisible(true);
                }
            }
        });
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbClientes = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Clientes Registrados");

        tbClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbClientes);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Visualizacion de lista de clientes ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(150, 150, 150)
                            .addComponent(jLabel1))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(160, 160, 160)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(28, 28, 28)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(40, 40, 40)
                    .addComponent(jLabel2)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbClientes;
    // End of variables declaration//GEN-END:variables
}
