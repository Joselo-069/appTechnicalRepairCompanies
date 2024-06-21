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
import com.mycompany.apptechnicalrepaircompanies.emuns.EstatusEquipamet;
import com.mycompany.apptechnicalrepaircompanies.models.Brand;
import com.mycompany.apptechnicalrepaircompanies.models.Client;
import com.mycompany.apptechnicalrepaircompanies.models.Equipament;
import com.mycompany.apptechnicalrepaircompanies.models.TypeEquipment;
import com.mycompany.apptechnicalrepaircompanies.utils.Design;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Calendar;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class RegistrarEquipo extends javax.swing.JFrame {

    int idCliente = 0;
    String user = "", nom_cliente = "";
    IEquipamentDao equipamentDao = new EquipamentDao();
    IClientDao clientDao = new ClientDao();
    IReviewDao reviewDao = new ReviewDao();
    IBrandDao brandDao = new BrandDao();
    ITypeEquipament typeDao = new TypeEquipamentDao();

    public RegistrarEquipo() {
        initComponents();
        user = Login.user;
        idCliente = GestionarClientes.IdCliente;
        nom_cliente = getClient();
                
        Design.viewSizeFrame(this, user, 630, 480, "Registrar nuevo equipo para " + nom_cliente);
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        txt_nombreCliente.setText(nom_cliente);
        setTypeEquipamentCombox();
        setBrandsComBox();
    }

    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("icon.png"));
        return retValue;
    }

    public String getClient() {
        Client cli = clientDao.getClientId(idCliente);
        return cli.getName();
    } 
    
    public void setTypeEquipamentCombox(){
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
    
    public int getIdEquipament(String model, String brand, String type){
        Equipament equipament = new Equipament();
        equipament = equipamentDao.getEquipamentBrandType(model, brand, type);
        
        if (equipament.getId() == null) {
 
            ITypeEquipament typeDao = new TypeEquipamentDao();
            IBrandDao brandDao = new BrandDao();
            
            TypeEquipment typeEquipament = typeDao.getTypeName(type);
            Brand brandEquipament = brandDao.getBrandIName(brand);
            equipamentDao.registerEquipament(model, typeEquipament.getId(), brandEquipament.getId());
            equipament = equipamentDao.getEquipamentBrandType(model, brand, type);
  //          return equipament.getId();
        }
        
//        equipament = equipamentDao.getEquipamentBrandType(model, brand, type);
        return equipament.getId();        
    }
    
    public void registerEquipament(int idEquipament, String image, String numSerie, String day, String month, String year, String observations, String estatus){
        
        if (validateEquipament(idEquipament, numSerie, observations)) {
           reviewDao.registerReview(idCliente, idEquipament, image, numSerie, day, month, year, observations, estatus, user);
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }
    }
    
    public boolean validateEquipament (int Idequipament, String num_serie, String observaciones){
        int validacion = 0;

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
        jScrollPane1 = new javax.swing.JScrollPane();
        txtp_observaciones = new javax.swing.JTextPane();
        jButton_equipo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_titulo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel_titulo.setText("Registro de equipo");
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        txt_nombreCliente.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txt_nombreCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombreCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreClienteActionPerformed(evt);
            }
        });
        getContentPane().add(txt_nombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 210, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Tipo de equipo:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Marca:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Modelo:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        txt_modelo.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txt_modelo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_modelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_modeloActionPerformed(evt);
            }
        });
        getContentPane().add(txt_modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 210, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Daño reportado y observaciones:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, -1, -1));

        txt_serie.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txt_serie.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_serie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_serieActionPerformed(evt);
            }
        });
        getContentPane().add(txt_serie, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 210, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Número de serie:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, -1));

        cmb_tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laptop", "Desktop", "Impresora", "Multifuncional" }));
        getContentPane().add(cmb_tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        cmb_marca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Acer", "Alienware", "Apple", "Asus", "Brother", "Dell", "HP", "Lenovo" }));
        getContentPane().add(cmb_marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        jScrollPane1.setViewportView(txtp_observaciones);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 330, 230));

        jButton_equipo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton_equipo.setText("Registrar equipo");
        jButton_equipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_equipoActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_equipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 350, 210, 35));

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

    private void jButton_equipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_equipoActionPerformed
        
        String tipo_equipo, marca, modelo, num_serie, dia_ingreso, mes_ingreso, annio_ingreso, estatus, observaciones;
        
        tipo_equipo = cmb_tipo.getSelectedItem().toString();
        marca = cmb_marca.getSelectedItem().toString();
        modelo = txt_modelo.getText().trim();
        num_serie = txt_serie.getText().trim();
        observaciones = txtp_observaciones.getText().trim();
        estatus = EstatusEquipamet.NuevoIngreso.name();
        
        Calendar calendar = Calendar.getInstance();
        
        dia_ingreso = Integer.toString(calendar.get(Calendar.DATE));
        mes_ingreso = Integer.toString(calendar.get(Calendar.MONTH));
        annio_ingreso = Integer.toString(calendar.get(Calendar.YEAR));
        
        String image = "image.ong";
        
        int idEquipament = getIdEquipament(modelo, marca, tipo_equipo);
        
        registerEquipament(idEquipament, image, num_serie, dia_ingreso, mes_ingreso, annio_ingreso, observaciones, estatus);
    }//GEN-LAST:event_jButton_equipoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmb_marca;
    private javax.swing.JComboBox<String> cmb_tipo;
    private javax.swing.JButton jButton_equipo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_modelo;
    private javax.swing.JTextField txt_nombreCliente;
    private javax.swing.JTextField txt_serie;
    private javax.swing.JTextPane txtp_observaciones;
    // End of variables declaration//GEN-END:variables
}
