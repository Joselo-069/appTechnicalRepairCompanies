package com.mycompany.apptechnicalrepaircompanies.frames;

import com.mycompany.apptechnicalrepaircompanies.dao.EquipamentDao;
import com.mycompany.apptechnicalrepaircompanies.dao.IEquipamentDao;
import com.mycompany.apptechnicalrepaircompanies.models.Equipament;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public class GestionarEquipos extends javax.swing.JFrame {

    String user;
    public static int IdEquipo = 0;
    
    DefaultTableModel model = new DefaultTableModel();
    IEquipamentDao equipament = new EquipamentDao();
    
    public GestionarEquipos() {
        initComponents();
        
        user = Login.user;
        
        setSize(630, 380);
        setTitle("Capturista - Sesion de " + user);
        setResizable(false);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        listEquipament();
    }
    
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("icon.png"));
        return retValue;
    }

    public void listEquipament() {
        ArrayList<Equipament> equipaments = (ArrayList<Equipament>) equipament.getListEquipaments();

        tbEquipos = new JTable(model);
        jScrollEquipos.setViewportView(tbEquipos);

        model.addColumn("Id");
        model.addColumn("Tipo");
        model.addColumn("Marca");
        model.addColumn("Estatus");

        for (Equipament equipament : equipaments) {
            Object[] file = new Object[4];
            file[0] = equipament.getId_equipo();
            file[1] = equipament.getTipo_equipo();
            file[2] = equipament.getMarca();
            file[3] = equipament.getEstatus();
            model.addRow(file);
        }
        
        ObtenerDatosTabla();
    }
    
    public void listEquipamentSearch(String status) {
        ArrayList<Equipament> equipaments = (ArrayList<Equipament>) equipament.getListEquipamentsSearch(status);

        tbEquipos = new JTable(model);
        jScrollEquipos.setViewportView(tbEquipos);

        model.addColumn("Id");
        model.addColumn("Tipo");
        model.addColumn("Marca");
        model.addColumn("Estatus");

        for (Equipament equipament : equipaments) {
            Object[] file = new Object[4];
            file[0] = equipament.getId_equipo();
            file[1] = equipament.getTipo_equipo();
            file[2] = equipament.getMarca();
            file[3] = equipament.getEstatus();
            model.addRow(file);
        }
    }

    public void ObtenerDatosTabla() {
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
        jLabel1.setText("Equipos Registrados");

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

        cmb_estatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Nuevo ingreso", "No reparado", "En revision", "Reparado", "Entregado" }));
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
                        .addGroup(layout.createSequentialGroup()
                            .addGap(192, 192, 192)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(42, 42, 42)
                            .addComponent(jScrollEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(cmb_estatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(btn_mostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
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
        
        listEquipamentSearch(selectName);        
    }//GEN-LAST:event_btn_mostrarActionPerformed

    private void cmb_estatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_estatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_estatusActionPerformed

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
            java.util.logging.Logger.getLogger(GestionarEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionarEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionarEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionarEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionarEquipos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_mostrar;
    private javax.swing.JComboBox<String> cmb_estatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollEquipos;
    private javax.swing.JTable tbEquipos;
    // End of variables declaration//GEN-END:variables

}
