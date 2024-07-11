package com.mycompany.apptechnicalrepaircompanies.frames;

import com.mycompany.apptechnicalrepaircompanies.dao.BrandDao;
import com.mycompany.apptechnicalrepaircompanies.dao.DeliverEquipamentDao;
import com.mycompany.apptechnicalrepaircompanies.dao.EquipamentDao;
import com.mycompany.apptechnicalrepaircompanies.dao.IBrandDao;
import com.mycompany.apptechnicalrepaircompanies.dao.IDeliverEquipament;
import com.mycompany.apptechnicalrepaircompanies.dao.IEquipamentDao;
import com.mycompany.apptechnicalrepaircompanies.dao.IReviewDao;
import com.mycompany.apptechnicalrepaircompanies.dao.ITypeEquipament;
import com.mycompany.apptechnicalrepaircompanies.dao.ReviewDao;
import com.mycompany.apptechnicalrepaircompanies.dao.TypeEquipamentDao;
import com.mycompany.apptechnicalrepaircompanies.emuns.EstatusEquipamet;
import com.mycompany.apptechnicalrepaircompanies.emuns.StatusDeliver;
import com.mycompany.apptechnicalrepaircompanies.models.Brand;
import com.mycompany.apptechnicalrepaircompanies.models.Review;
import com.mycompany.apptechnicalrepaircompanies.models.TypeEquipment;
import com.mycompany.apptechnicalrepaircompanies.utils.Design;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.WindowConstants;

public class InformacionEquipoTecnico extends javax.swing.JFrame {

    int idEquipament = 0;
    String user = "";
    IEquipamentDao equipamentDao = new EquipamentDao();
    IReviewDao reviewDao = new ReviewDao();
    IBrandDao brandDao = new BrandDao();
    ITypeEquipament typeDao = new TypeEquipamentDao();
    IDeliverEquipament deliverDao = new DeliverEquipamentDao();
    
    public InformacionEquipoTecnico() {
        initComponents();
        user = Login.user;
        idEquipament = GestionarEquipos.IdEquipo;
        Design.viewSizeFrame(this, user, 670, 600, "Equipo registrado con el ID " + idEquipament + " - Sesion de " + user);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setBrandsComBox();
        setTypeEquipamentCombox();
        getDetailEquipament();
    }

    public void setTypeEquipamentCombox() {
        List<TypeEquipment> listTypeEquipament = typeDao.getListTypes();
        DefaultComboBoxModel<String> modelComboBox = new DefaultComboBoxModel<>();

        for (TypeEquipment type : listTypeEquipament) {
            String textTypeEquipament = type.getName();
            modelComboBox.addElement(textTypeEquipament);
        }

        cmb_tipo.setModel(modelComboBox);
    }

    public void setBrandsComBox() {
        List<Brand> listBrands = brandDao.getListBrands();
        DefaultComboBoxModel<String> modelComboBox = new DefaultComboBoxModel<>();

        for (Brand brand : listBrands) {
            String textBrand = brand.getName();
            modelComboBox.addElement(textBrand);
        }

        cmb_marca.setModel(modelComboBox);
    }
    
    public void getDetailEquipament() {
        
        Review review = reviewDao.getDetailReview(idEquipament);
        
        cmb_tipo.setSelectedItem(review.getType());
        cmb_marca.setSelectedItem(review.getBrand());
        cmb_estatus.setSelectedItem(review.getStatus());
        txt_nombreCliente.setText(review.getClient().getName() + " - " + review.getClient().getEmail());
        txt_modelo.setText(review.getModel());
        txt_serie.setText(review.getSerial_number());
        txt_modificaion.setText(review.getLast_update());

        String dia = "", mes = "", annio = "";
        dia = review.getDay();
        mes = review.getMonth();
        annio = review.getYear();
        txt_fecha.setText(dia + " del " + mes + " del " + annio);

        txtp_observaciones.setText(review.getObservations());
        txtp_comentarios.setText(review.getTechnical_comments());

        jLabel_tecnicos.setText("Comentarios y actualizacion del tecnico: " + review.getTechnical_review());
    }
  
    public void updatEquipamentTecnico(int id, String status, String price, String comments, String technical){
        
        if (status.equals(EstatusEquipamet.Reparado.name())) {
            deliverDao.registerDeliverEquipament(id, price, technical);
        }
        reviewDao.updateReviewTechnical(id, status, comments, technical);
        this.dispose();
    }
    
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("icon.png"));
        return retValue;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jLabel_titulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_nombreCliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_modelo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_serie = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cmb_tipo = new javax.swing.JComboBox<>();
        cmb_marca = new javax.swing.JComboBox<>();
        btn_update = new javax.swing.JButton();
        cmb_estatus = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtp_observaciones = new javax.swing.JTextPane();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtp_comentarios = new javax.swing.JTextPane();
        jLabel_tecnicos = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_fecha = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_modificaion = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_price = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_titulo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel_titulo.setText("Informacion de equipo");
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Cliente:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        txt_nombreCliente.setEditable(false);
        txt_nombreCliente.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txt_nombreCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombreCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreClienteActionPerformed(evt);
            }
        });
        getContentPane().add(txt_nombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 210, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Tipo de equipo:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Estatus:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 70, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Modelo:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, -1, -1));

        txt_modelo.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txt_modelo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_modelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_modeloActionPerformed(evt);
            }
        });
        getContentPane().add(txt_modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 210, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Daño reportado y observaciones:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, -1, -1));

        txt_serie.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txt_serie.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_serie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_serieActionPerformed(evt);
            }
        });
        getContentPane().add(txt_serie, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 210, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Número de serie:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, -1));

        cmb_tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laptop", "Desktop", "Impresora", "Multifuncional" }));
        getContentPane().add(cmb_tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        cmb_marca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Acer", "Alienware", "Apple", "Asus", "Brother", "Dell", "HP", "Lenovo" }));
        getContentPane().add(cmb_marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        btn_update.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_update.setText("Comentar y actualizar");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });
        getContentPane().add(btn_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 500, 210, 35));

        cmb_estatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nuevo ingreso", "No reparado", "En revision", "Reparado", "Entregado" }));
        getContentPane().add(cmb_estatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 90, -1, 30));

        txtp_observaciones.setEditable(false);
        jScrollPane2.setViewportView(txtp_observaciones);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, 330, 100));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Daño reportado y observaciones:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, -1, -1));

        jScrollPane3.setViewportView(txtp_comentarios);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 320, 330, 100));

        jLabel_tecnicos.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_tecnicos.setForeground(new java.awt.Color(0, 0, 0));
        jLabel_tecnicos.setText("Comentarios y actualizaciones del tecnico:");
        getContentPane().add(jLabel_tecnicos, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 290, -1, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Marca:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        txt_fecha.setEditable(false);
        txt_fecha.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txt_fecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_fechaActionPerformed(evt);
            }
        });
        getContentPane().add(txt_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 190, -1));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Fecha de ingreso:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, -1, -1));

        txt_modificaion.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txt_modificaion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_modificaion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_modificaionActionPerformed(evt);
            }
        });
        getContentPane().add(txt_modificaion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 210, -1));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Ultima modificación:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, -1, -1));

        txt_price.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txt_price.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_priceActionPerformed(evt);
            }
        });
        getContentPane().add(txt_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 450, 130, -1));

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Precio por el servicio:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 430, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nombreClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombreClienteActionPerformed

    private void txt_modeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_modeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_modeloActionPerformed

    private void txt_serieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_serieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_serieActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        
        String status, comment, technical, price;
        
        status = cmb_estatus.getSelectedItem().toString();
        comment = txtp_comentarios.getText();
        price = txt_price.getText();
        technical = user;
        
        updatEquipamentTecnico(idEquipament, status, price, comment, technical);
    }//GEN-LAST:event_btn_updateActionPerformed

    private void txt_fechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_fechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_fechaActionPerformed

    private void txt_modificaionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_modificaionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_modificaionActionPerformed

    private void txt_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_priceActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> cmb_estatus;
    private javax.swing.JComboBox<String> cmb_marca;
    private javax.swing.JComboBox<String> cmb_tipo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_tecnicos;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField txt_fecha;
    private javax.swing.JTextField txt_modelo;
    private javax.swing.JTextField txt_modificaion;
    private javax.swing.JTextField txt_nombreCliente;
    private javax.swing.JTextField txt_price;
    private javax.swing.JTextField txt_serie;
    private javax.swing.JTextPane txtp_comentarios;
    private javax.swing.JTextPane txtp_observaciones;
    // End of variables declaration//GEN-END:variables

}
