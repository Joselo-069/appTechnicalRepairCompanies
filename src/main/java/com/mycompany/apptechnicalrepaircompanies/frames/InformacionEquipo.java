package com.mycompany.apptechnicalrepaircompanies.frames;

import com.mycompany.apptechnicalrepaircompanies.dao.BrandDao;
import com.mycompany.apptechnicalrepaircompanies.dao.ClientDao;
import com.mycompany.apptechnicalrepaircompanies.dao.EquipamentDao;
import com.mycompany.apptechnicalrepaircompanies.dao.IBrandDao;
import com.mycompany.apptechnicalrepaircompanies.dao.IClientDao;
import com.mycompany.apptechnicalrepaircompanies.dao.IEquipamentDao;
import com.mycompany.apptechnicalrepaircompanies.dao.IReviewDao;
import com.mycompany.apptechnicalrepaircompanies.dao.ITypeEquipament;
import com.mycompany.apptechnicalrepaircompanies.dao.ReviewDao;
import com.mycompany.apptechnicalrepaircompanies.dao.TypeEquipamentDao;
import com.mycompany.apptechnicalrepaircompanies.models.Brand;
import com.mycompany.apptechnicalrepaircompanies.models.Client;
import com.mycompany.apptechnicalrepaircompanies.models.Review;
import com.mycompany.apptechnicalrepaircompanies.models.TypeEquipment;
import com.mycompany.apptechnicalrepaircompanies.utils.Design;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class InformacionEquipo extends javax.swing.JFrame {

    int idClient, idReview, idEquipament;
    String user = "", nom_cli = "";
    
    IClientDao clientDao = new ClientDao();
    IEquipamentDao equipamentDao = new EquipamentDao();
    IReviewDao reviewDao = new ReviewDao();
    IBrandDao brandDao = new BrandDao();
    ITypeEquipament typeDao = new TypeEquipamentDao();
        
    public InformacionEquipo() {
        initComponents();
        user = Login.user;
        idReview = InformacionCliente.idEquipo;
        idClient = GestionarClientes.IdCliente;
        
        nom_cli = getClient();
        getDetailEquipament(idReview);
        
        Design.viewSizeFrame(this, user, 670, 550, "Equipo del cliente " + nom_cli);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        txt_nombreCliente.setText(nom_cli);
        setTypeEquipamentCombox();
        setBrandsComBox();
    }

    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("icon.png"));
        return retValue;
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

    public String getClient() {
        Client cli = clientDao.getClientId(idClient);
        return cli.getName();
    } 
    
    public void getDetailEquipament(int id) {
        
        Review review = reviewDao.getDetailReview(id);

        cmb_tipo.setSelectedItem(review.getType());
        cmb_marca.setSelectedItem(review.getBrand());
        cmb_estatus.setSelectedItem(review.getStatus());
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
    
    public boolean validateEquipament(String modelo, String num_serie, String observaciones) {
        int validacion = 0;

        if (modelo.equals("")) {
            txt_modelo.setBackground(Color.red);
            validacion++;
        }

        if (num_serie.equals("")) {
            txt_serie.setBackground(Color.red);
            validacion++;
        }

        if (observaciones.equals("")) {
            txtp_observaciones.setBackground(Color.red);
            validacion++;
        }

        if (validacion == 0) return true;

        return false;
    }
 /*   
    public void updateEquipament(int idEquipament, String image, String serial_number, String observations, String status, String last_update, int idReview) {
        
        if(validateEquipament(modelo, num_serie, observaciones)){

            clean();
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }
        
    }
   */ 
    private void clean(){
        txt_nombreCliente.setText("");
        txt_fecha.setText("");
        txt_modelo.setText("");
        txt_serie.setText("");
        txtp_observaciones.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_titulo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel_titulo.setText("Informacion de equipo");
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre del cliente:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

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
        btn_update.setText("Actualizar Equipo");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });
        getContentPane().add(btn_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 460, 210, 35));

        cmb_estatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nuevo ingreso", "No reparado", "En revision", "Reparado", "Entregado" }));
        getContentPane().add(cmb_estatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 90, -1, 30));

        jScrollPane2.setViewportView(txtp_observaciones);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, 330, 100));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Daño reportado y observaciones:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, -1, -1));

        txtp_comentarios.setEditable(false);
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

        String tipo_equipo, marca, modelo, num_serie, estatus, observaciones;
        
        tipo_equipo = cmb_tipo.getSelectedItem().toString();
        marca = cmb_marca.getSelectedItem().toString();
        estatus = cmb_estatus.getSelectedItem().toString();
        
        modelo = txt_modelo.getText().trim();
        num_serie = txt_serie.getText().trim();
        observaciones = txtp_observaciones.getText();
        
      // updateEquipament(idReview, tipo_equipo, marca, modelo, num_serie, observaciones, estatus, user);
    }//GEN-LAST:event_btn_updateActionPerformed

    private void txt_fechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_fechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_fechaActionPerformed

    private void txt_modificaionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_modificaionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_modificaionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> cmb_estatus;
    private javax.swing.JComboBox<String> cmb_marca;
    private javax.swing.JComboBox<String> cmb_tipo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_tecnicos;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField txt_fecha;
    private javax.swing.JTextField txt_modelo;
    private javax.swing.JTextField txt_modificaion;
    private javax.swing.JTextField txt_nombreCliente;
    private javax.swing.JTextField txt_serie;
    private javax.swing.JTextPane txtp_comentarios;
    private javax.swing.JTextPane txtp_observaciones;
    // End of variables declaration//GEN-END:variables

}
