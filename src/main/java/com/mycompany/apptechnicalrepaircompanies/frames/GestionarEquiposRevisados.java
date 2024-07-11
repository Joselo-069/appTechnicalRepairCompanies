package com.mycompany.apptechnicalrepaircompanies.frames;

import com.mycompany.apptechnicalrepaircompanies.dao.DeliverEquipamentDao;
import com.mycompany.apptechnicalrepaircompanies.dao.EquipamentDao;
import com.mycompany.apptechnicalrepaircompanies.dao.IDeliverEquipament;
import com.mycompany.apptechnicalrepaircompanies.dao.IEquipamentDao;
import com.mycompany.apptechnicalrepaircompanies.dao.IReviewDao;
import com.mycompany.apptechnicalrepaircompanies.dao.ReviewDao;
import com.mycompany.apptechnicalrepaircompanies.models.DeliverEquipment;
import com.mycompany.apptechnicalrepaircompanies.models.Review;
import com.mycompany.apptechnicalrepaircompanies.utils.Design;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public class GestionarEquiposRevisados extends javax.swing.JFrame {

    String user;
    public static int IdEquipo = 0;
    
    DefaultTableModel model = new DefaultTableModel();
    IEquipamentDao equipament = new EquipamentDao();
    IReviewDao reviewDao = new ReviewDao();
    IDeliverEquipament deliverDao = new DeliverEquipamentDao();
    public GestionarEquiposRevisados() {
        initComponents();
        
        user = Login.user;
        Design.viewSizeFrame(this, user, 630, 380, "Capturista - Sesion de " + user);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        listReviews();
    }
    
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("icon.png"));
        return retValue;
    }

    public void listReviews() {
        
        ArrayList<DeliverEquipment> delivers = (ArrayList<DeliverEquipment>) deliverDao.getListDeliverEquipament();

        tbEquipos = new JTable(model);
        jScrollEquipos.setViewportView(tbEquipos);

        model.addColumn("Id");
        model.addColumn("Cliente");
        model.addColumn("Tipo");
        model.addColumn("Modelo");
        model.addColumn("Marca");
        model.addColumn("Comentario");
        model.addColumn("Fecha Habilitado");
        model.addColumn("Precio");
        model.addColumn("Estado");

        for (DeliverEquipment equipament : delivers) {
            Object[] file = new Object[9];
            file[0] = equipament.getId();
            file[1] = equipament.getFullname();
            file[2] = equipament.getType();
            file[3] = equipament.getModel();
            file[4] = equipament.getBrand();
            file[5] = equipament.getTechnical_comments();
            file[6] = equipament.getSince_date();
            file[7] = equipament.getTechnical_price();
            file[8] = equipament.getStatus();
            model.addRow(file);
        }

        getDataTable();
    }
    
    public void listReviewsSearch(String status) {
         ArrayList<Review> reviews = (ArrayList<Review>) reviewDao.getListReviewsSearch(status);

        tbEquipos = new JTable(model);
        jScrollEquipos.setViewportView(tbEquipos);

        model.addColumn("Id");
        model.addColumn("Tipo");
        model.addColumn("Marca");
        model.addColumn("Modelo");
        model.addColumn("Estatus");

        for (Review equipament : reviews) {
            Object[] file = new Object[5];
            file[0] = equipament.getId();
            file[1] = equipament.getType();
            file[2] = equipament.getBrand();
            file[3] = equipament.getModel();
            file[4] = equipament.getStatus();
            
            model.addRow(file);
        }

        getDataTable();
    }

    public void getDataTable() {
        tbEquipos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = tbEquipos.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    IdEquipo = (int) model.getValueAt(fila_point, columna_point);
                    InformacionEquipoTecnico info = new InformacionEquipoTecnico();
                    info.setVisible(true);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollEquipos = new javax.swing.JScrollPane();
        tbEquipos = new javax.swing.JTable();
        cmb_estatus = new javax.swing.JComboBox<>();
        btn_mostrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Equipos Reparados/Entregados");

        tbEquipos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollEquipos.setViewportView(tbEquipos);

        cmb_estatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "NuevoIngreso", "NoReparado", "EnRevision", "Reparado", "Entregado" }));
        cmb_estatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_estatusActionPerformed(evt);
            }
        });

        btn_mostrar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_mostrar.setText("Mostrar");
        btn_mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mostrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jScrollEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(cmb_estatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(87, 87, 87)
                            .addComponent(btn_mostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel1)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmb_estatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jScrollEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btn_mostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_mostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mostrarActionPerformed
        
        String select = cmb_estatus.getSelectedItem().toString();
        
        String selectName = select == "Todos" ? "" : select;
        
        model.setRowCount(0);
        model.setColumnCount(0);
        
        listReviewsSearch(selectName);        
    }//GEN-LAST:event_btn_mostrarActionPerformed

    private void cmb_estatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_estatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_estatusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_mostrar;
    private javax.swing.JComboBox<String> cmb_estatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollEquipos;
    private javax.swing.JTable tbEquipos;
    // End of variables declaration//GEN-END:variables

}
