package frames;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import controllers.Conexion;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public class InformacionCliente extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();
    int idCliente;
    public static int idEquipo = 0;
    String user = "";
    
    public InformacionCliente() {
        initComponents();
        user = Login.user;
        idCliente = GestionarClientes.IdCliente;
                
        setSize(650,450);
        setResizable(false);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        txt_modificacion.disable();
        selectClient();
        selectEquipament();
    }
    
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("icon.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_titulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_telefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_direccion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_modificacion = new javax.swing.JTextField();
        scroll_equipos = new javax.swing.JScrollPane();
        tb_equipos = new javax.swing.JTable();
        jButton_actualizar = new javax.swing.JButton();
        jButton_equipo = new javax.swing.JButton();
        jButton_ImprimeReporte = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_titulo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel_titulo.setText("Informacion del cliente");
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        txt_nombre.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txt_nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreActionPerformed(evt);
            }
        });
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 210, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Email:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        txt_email.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txt_email.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });
        getContentPane().add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 210, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Telefono:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        txt_telefono.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txt_telefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_telefonoActionPerformed(evt);
            }
        });
        getContentPane().add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 210, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Dirección:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        txt_direccion.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txt_direccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_direccionActionPerformed(evt);
            }
        });
        getContentPane().add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 210, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Última modificación:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));

        txt_modificacion.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txt_modificacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_modificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_modificacionActionPerformed(evt);
            }
        });
        getContentPane().add(txt_modificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 210, -1));

        tb_equipos.setModel(new javax.swing.table.DefaultTableModel(
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
        scroll_equipos.setViewportView(tb_equipos);

        getContentPane().add(scroll_equipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 370, 180));

        jButton_actualizar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton_actualizar.setText("Actualizar cliente");
        jButton_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_actualizarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, 210, 35));

        jButton_equipo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton_equipo.setText("Registrar equipo");
        jButton_equipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_equipoActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_equipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 210, 35));

        jButton_ImprimeReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/impresora.png"))); // NOI18N
        jButton_ImprimeReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ImprimeReporteActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_ImprimeReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 270, 120, 100));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombreActionPerformed

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void txt_telefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_telefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_telefonoActionPerformed

    private void txt_direccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_direccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_direccionActionPerformed

    private void txt_modificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_modificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_modificacionActionPerformed

    private void jButton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_actualizarActionPerformed
         int validacion = 0;
         String nombre, email, telefono, direccion;
         
         nombre = txt_nombre.getText().trim();
         email = txt_email.getText().trim();
         telefono = txt_telefono.getText().trim();
         direccion = txt_direccion.getText().trim();
         
        if (nombre.equals("")) {
            txt_nombre.setBackground(Color.red);
            validacion++;
        }
         
        if (email.equals("")) {
            txt_email.setBackground(Color.red);
            validacion++;
        }
         
        if (telefono.equals("")) {
            txt_telefono.setBackground(Color.red);
            validacion++;
        }
        
        if (direccion.equals("")) {
            txt_direccion.getText().trim();
            validacion++;
        }
            
        
        if (validacion == 0) {
            try {
                Connection cn = Conexion.conection();
                PreparedStatement pst = cn.prepareStatement("UPDATE clientes SET nombre_cliente=?, mail_cliente=?, tel_cliente=?, dir_cliente=?, ultima_modificacion=? WHERE id_cliente = '" + idCliente +"'");
                
                pst.setString(1, nombre);
                pst.setString(2, email);
                pst.setString(3, telefono);
                pst.setString(4, direccion);
                pst.setString(5, user);

                pst.executeUpdate();
                cn.close();
                
                limpiar();
                
                JOptionPane.showMessageDialog(null, "Actualizacion exitosa");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error en actuaizar cliente");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes de llenar los cammpos");
        }
    }//GEN-LAST:event_jButton_actualizarActionPerformed

    private void jButton_equipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_equipoActionPerformed
        RegistrarEquipo registrar = new RegistrarEquipo();
        registrar.setVisible(true);
    }//GEN-LAST:event_jButton_equipoActionPerformed

    private void jButton_ImprimeReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ImprimeReporteActionPerformed
        Document document = new Document();
        
        try {
            String route = System.getProperty("user.home");
            PdfWriter.getInstance(document, new FileOutputStream(route + "/Desktop/" + txt_nombre.getText().trim() + ".pdf"));
            
            // com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("BannerPDF.jpg");
            
            // header.scaleToFit(650,1000);
            // header.setAlignment(Chunk.ALIGN_CENTER);
            
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Informacion del cliente \n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY));
            
            document.open();
            // document.add(header);
            document.add(parrafo);
            
            PdfPTable tbClient = new PdfPTable(5);
            tbClient.addCell("Id");
            tbClient.addCell("Nombre");
            tbClient.addCell("Email");
            tbClient.addCell("Telefono");
            tbClient.addCell("Direccion");
            
            try {
                
                Connection cn = Conexion.conection();
                PreparedStatement pst = cn.prepareStatement("SELECT * FROM clientes WHERE id_cliente = '" + idCliente + "'");
                ResultSet rs = pst.executeQuery();
                
                if (rs.next()) {
                    do {                        
                        tbClient.addCell(rs.getString(1));
                        tbClient.addCell(rs.getString(2));
                        tbClient.addCell(rs.getString(3));
                        tbClient.addCell(rs.getString(4));
                        tbClient.addCell(rs.getString(5));
                    } while (rs.next());
                    
                    document.add(tbClient);
                }
                
                Paragraph parrafo2 = new Paragraph();
                parrafo2.setAlignment(Paragraph.ALIGN_CENTER);
                parrafo2.add("\n\n Equipos registrados. \n\n");
                parrafo2.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY));
                
                document.add(parrafo2);
                
                PdfPTable tbEquipament = new PdfPTable(4);
                tbEquipament.addCell("Id");
                tbEquipament.addCell("Tipo");
                tbEquipament.addCell("Marca");
                tbEquipament.addCell("Estatus");

                try {
                    
                    Connection cn2 = Conexion.conection();
                    PreparedStatement pst2 = cn2.prepareStatement("SELECT id_equipo, tipo_equipo, marca, estatus FROM equipos WHERE id_cliente = '" + idCliente + "'");
                    ResultSet rs2 = pst2.executeQuery();
                
                    if (rs2.next()) {
                        do {                        
                            tbEquipament.addCell(rs2.getString(1));
                            tbEquipament.addCell(rs2.getString(2));
                            tbEquipament.addCell(rs2.getString(3));
                            tbEquipament.addCell(rs2.getString(4));
                        } while (rs2.next());

                        document.add(tbEquipament);
                    }
                } catch (SQLException e) {
                    System.err.println("Error al cargar equipos " + e);
                }
                
            } catch (Exception e) {
                System.err.println("Error al obtener los clientes" + e);
            }

            document.close();
            JOptionPane.showMessageDialog(null, "Reporte creado correctamente.");
            
        } catch (DocumentException | IOException e) {
            System.err.println("Error en pdf ruta de imagen " + e);
            JOptionPane.showMessageDialog(null, "Error al generar PDF");
        }
    }//GEN-LAST:event_jButton_ImprimeReporteActionPerformed

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
            java.util.logging.Logger.getLogger(InformacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacionCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_ImprimeReporte;
    private javax.swing.JButton jButton_actualizar;
    private javax.swing.JButton jButton_equipo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JScrollPane scroll_equipos;
    private javax.swing.JTable tb_equipos;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_modificacion;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables
    
    private void selectClient() {
        try {
            Connection cn = Conexion.conection();
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM clientes WHERE id_cliente = '" + idCliente + "'");
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                setTitle("Informacion del usuario " + rs.getString("nombre_cliente") + " - Sesion de " + user);
                jLabel_titulo.setText("Informacion del cliente " + rs.getString("nombre_cliente"));
                
                txt_nombre.setText(rs.getString("nombre_cliente"));
                txt_email.setText(rs.getString("mail_cliente"));
                txt_telefono.setText(rs.getString("tel_cliente"));
                txt_direccion.setText(rs.getString("dir_cliente"));
                txt_modificacion.setText(rs.getString("ultima_modificacion"));
            }
            cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar, contacte al administrador");
        }
    }
    
    private void selectEquipament() {
        try {
            Connection cn = Conexion.conection();
            PreparedStatement pst = cn.prepareStatement("SELECT id_equipo, tipo_equipo, marca, estatus FROM equipos WHERE id_cliente = '" + idCliente + "'");
            ResultSet rs = pst.executeQuery();
            
            tb_equipos = new JTable(model);
            scroll_equipos.setViewportView(tb_equipos);
            
            model.addColumn("Id");
            model.addColumn("Tipo de equipos");
            model.addColumn("Marca");
            model.addColumn("Estatus");
            
            while (rs.next()) {                
                Object[] fila = new Object[4];
                
                for (int i = 0; i < 4; i++) {
                    fila[i] = rs.getObject(i+1);
                }
                
                model.addRow(fila);
            }
            cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar, contacte al administrador");
        }
        
        tb_equipos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                int fila_point = tb_equipos.rowAtPoint(e.getPoint());
                int columna_point = 0;
                
                if (fila_point > -1) {
                    idEquipo = (int)model.getValueAt(fila_point, columna_point);
                    InformacionEquipo info = new InformacionEquipo();
                    info.setVisible(true);
                }
            }
        });
    }
    
    private void limpiar () {
        txt_nombre.setText("");
        txt_email.setText("");
        txt_telefono.setText("");
        txt_direccion.setText("");
    }
}
