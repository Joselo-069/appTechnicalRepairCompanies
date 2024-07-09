
package com.mycompany.apptechnicalrepaircompanies.frames;

import com.mycompany.apptechnicalrepaircompanies.dao.IReviewDao;
import com.mycompany.apptechnicalrepaircompanies.dao.ReviewDao;
import com.mycompany.apptechnicalrepaircompanies.utils.Design;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.WindowConstants;


public class GraficaEstatus extends javax.swing.JFrame {

    String user;
    List<String> vector_status_name = new ArrayList<>();
    List<Integer> vector_status_count = new ArrayList<>();
    
    IReviewDao reviewDao = new ReviewDao();
    
    public GraficaEstatus() {
        initComponents();
        
        user = Login.user;
        Design.viewSizeFrame(this, user, 550, 500, "Tecnico - Sesion de " + user);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getReportStatus();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_titulo = new javax.swing.JLabel();
        lb_status = new javax.swing.JLabel();
        lb_count = new javax.swing.JLabel();
        lb_total_status = new javax.swing.JLabel();
        lb_total_count = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        jLabel_titulo.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel_titulo.setText("Reporte de estatus");

        lb_status.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        lb_count.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lb_count.setForeground(new java.awt.Color(0, 0, 0));

        lb_total_status.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        lb_total_count.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel_titulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_status, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_total_status, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(89, 89, 89)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_total_count, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_count, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel_titulo)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_count, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                    .addComponent(lb_status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lb_total_count, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_total_status, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("icon.png"));
        return retValue;
    }
    
    public void getReportStatus(){
        Map<String,Integer> listBrands = new HashMap<>();
        StringBuilder cadName = new StringBuilder("<html>");
        StringBuilder cadCount = new StringBuilder("<html>");
        int countReviews = 0;

        listBrands = reviewDao.getReportStatus();
        
        for (String key : listBrands.keySet()) {
            vector_status_name.add(key);
        }

        for (int i = 0; i < vector_status_name.size(); i++) {
            cadName.append((i+1)+". ").append(vector_status_name.get(i)).append("<br><hr><br>");
        }
        
        cadName.append("</html>");
        lb_status.setText(cadName.toString());

        for (int value : listBrands.values()) {
            vector_status_count.add(value);
            countReviews = countReviews + value; 
        }
        
        for (int i = 0; i < vector_status_count.size(); i++) {
            cadCount.append("N° ").append(vector_status_count.get(i)).append("<br><hr><br>");
        }
        
        cadCount.append("</html>");
        lb_count.setText(cadCount.toString());
        
        lb_total_status.setText("Total de status: " + vector_status_name.size());
        lb_total_count.setText("Cantidad total: " + countReviews);
    }
    
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
            java.util.logging.Logger.getLogger(GraficaEstatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GraficaEstatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GraficaEstatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GraficaEstatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GraficaEstatus().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JLabel lb_count;
    private javax.swing.JLabel lb_status;
    private javax.swing.JLabel lb_total_count;
    private javax.swing.JLabel lb_total_status;
    // End of variables declaration//GEN-END:variables

}