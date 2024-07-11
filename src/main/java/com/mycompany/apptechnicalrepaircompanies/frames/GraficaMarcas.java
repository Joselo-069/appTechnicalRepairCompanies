
package com.mycompany.apptechnicalrepaircompanies.frames;

import com.mycompany.apptechnicalrepaircompanies.dao.BrandDao;
import com.mycompany.apptechnicalrepaircompanies.dao.IBrandDao;
import com.mycompany.apptechnicalrepaircompanies.utils.Design;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.WindowConstants;

public class GraficaMarcas extends javax.swing.JFrame {

    String user;
    List<String> vector_brand_name = new ArrayList<>();
    List<String> vector_brand_count = new ArrayList<>();

    IBrandDao brandDao = new BrandDao();
    
    public GraficaMarcas() {
        initComponents();
        
        user = Login.user;

        Design.viewSizeFrame(this, user, 550, 500, "Tecnico - Sesion de " + user);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getReportBrand();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_titulo = new javax.swing.JLabel();
        lb_count = new javax.swing.JLabel();
        p_name = new javax.swing.JPanel();
        lb_total_name1 = new javax.swing.JLabel();
        lb_name = new javax.swing.JLabel();
        lb_total_count = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        jLabel_titulo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel_titulo.setText("Reporte de marcas revisadas");

        lb_count.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lb_count.setForeground(new java.awt.Color(0, 0, 0));

        lb_total_name1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        javax.swing.GroupLayout p_nameLayout = new javax.swing.GroupLayout(p_name);
        p_name.setLayout(p_nameLayout);
        p_nameLayout.setHorizontalGroup(
            p_nameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_nameLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(lb_total_name1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        p_nameLayout.setVerticalGroup(
            p_nameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_nameLayout.createSequentialGroup()
                .addComponent(lb_total_name1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 274, Short.MAX_VALUE))
        );

        lb_name.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        lb_total_count.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(p_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(lb_total_count, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel_titulo)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lb_name, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)
                        .addComponent(lb_count, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel_titulo)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_count, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_name, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(p_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_total_count, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public void getReportBrand(){
        Map<String,String> listBrands = new HashMap<>();
        StringBuilder cadName = new StringBuilder("<html>");
        StringBuilder cadCount = new StringBuilder("<html>");
        int countReviews = 0;

        listBrands = brandDao.getReportBrand();
        
        for (String key : listBrands.keySet()) {
            vector_brand_name.add(key);
        }

        for (int i = 0; i < vector_brand_name.size(); i++) {
            cadName.append((i+1)+". ").append(vector_brand_name.get(i)).append("<br><hr><br>");
        }
        
        cadName.append("</html>");
        lb_name.setText(cadName.toString());

        for (String value : listBrands.values()) {
            vector_brand_count.add(value);
            countReviews = countReviews + Integer.parseInt(value); 
        }
        
        for (int i = 0; i < vector_brand_count.size(); i++) {
            cadCount.append("N° ").append(vector_brand_count.get(i)).append("<br><hr><br>");
        }
        
        cadCount.append("</html>");
        lb_count.setText(cadCount.toString());
        
        lb_total_name1.setText("Total de marcas: " + vector_brand_name.size());
        lb_total_count.setText("Cantidad total: " + countReviews);
    }
    
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("icon.png"));
        return retValue;
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JLabel lb_count;
    private javax.swing.JLabel lb_name;
    private javax.swing.JLabel lb_total_count;
    private javax.swing.JLabel lb_total_name1;
    private javax.swing.JPanel p_name;
    // End of variables declaration//GEN-END:variables

}