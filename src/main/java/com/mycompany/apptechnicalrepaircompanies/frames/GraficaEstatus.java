
package com.mycompany.apptechnicalrepaircompanies.frames;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.WindowConstants;


public class GraficaEstatus extends javax.swing.JFrame {


    String user;
    int NuevoIngreso, NoReperado, EnRevision, Reparado, Entregado;
    
    String[] vector_status_nombre = new String[5];
    int[] vector_status_cantidad = new int[5];
    
    public GraficaEstatus() {
        initComponents();
        
        user = Login.user;
        
        setSize(550,450);
        setResizable(false);
        setTitle("Tecnico - Sesion de " + user);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        /*
        try {
            Connection cn = Conexion.conection();
            PreparedStatement pst = cn.prepareStatement("SELECT estatus, count(estatus) AS Cantidad FROM equipos GROUP BY estatus");
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                int posicion = 0;
                do {                    
                    vector_status_nombre[posicion] = rs.getString(1);
                    vector_status_cantidad[posicion] = rs.getInt(2);
                    
                    if (vector_status_nombre[posicion].equalsIgnoreCase("En revision")) {
                        EnRevision = vector_status_cantidad[posicion];
                    } else if (vector_status_nombre[posicion].equalsIgnoreCase("Entregado")){
                        Entregado = vector_status_cantidad[posicion];
                    } else if (vector_status_nombre[posicion].equalsIgnoreCase("No reparado")){
                        NoReperado = vector_status_cantidad[posicion];
                    } else if (vector_status_nombre[posicion].equalsIgnoreCase("Nuevo ingreso")){
                        NuevoIngreso = vector_status_cantidad[posicion];
                    } else if (vector_status_nombre[posicion].equalsIgnoreCase("Reparado")){
                        Reparado = vector_status_cantidad[posicion];
                    }
                    posicion++;
                } while (rs.next());
                
            }
            
        } catch (Exception e) {
            System.err.print("Error en conectar con la BD");
        }*/
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_titulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        jLabel_titulo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel_titulo.setText("Grafica de estatus");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel_titulo)
                .addContainerGap(382, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel_titulo)
                .addContainerGap(410, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("icon.png"));
        return retValue;
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
    // End of variables declaration//GEN-END:variables

    public int EstatusMasRepetido(int NuevoIngreso, int NoReperado, int EnRevision, int Reparado, int Entregado) {
        if (NuevoIngreso > NoReperado && NuevoIngreso > EnRevision && NuevoIngreso > Reparado && NuevoIngreso > Entregado) {
            return NuevoIngreso;
        } else if(NoReperado > EnRevision && NoReperado > Reparado && NoReperado > Entregado) {
            return NoReperado;
        } else if(EnRevision > Reparado && EnRevision > Entregado){
            return EnRevision;
        } else if(Reparado > Entregado){
            return Reparado;
        } else {
            return Entregado;
        }
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        int Estatus_Mas_Repetido = EstatusMasRepetido(NuevoIngreso, NoReperado, EnRevision, Reparado, Entregado);
        
        int largo_NuevoIngreso = NuevoIngreso * 400 / Estatus_Mas_Repetido;
        int largo_NoReparado = NoReperado * 400 / Estatus_Mas_Repetido;
        int largo_EnRevision = EnRevision * 400 / Estatus_Mas_Repetido;
        int largo_Reparado = Reparado * 400 / Estatus_Mas_Repetido;
        int largo_Entregado = Entregado * 400 / Estatus_Mas_Repetido;
        
        g.setColor(Color.gray);
        g.fillRect(100, 100, largo_NuevoIngreso, 40);
        g.drawString("Nuevo Ingreso", 10, 118);
        g.drawString("Cantidad: " + NuevoIngreso, 10, 133);

        g.setColor(Color.darkGray);
        g.fillRect(100, 150, largo_NoReparado, 40);
        g.drawString("No reparado", 10, 168);
        g.drawString("Cantidad: " + NoReperado, 10, 183);
        
        g.setColor(Color.gray);
        g.fillRect(100, 200, largo_EnRevision, 40);
        g.drawString("En Revision", 10, 218);
        g.drawString("Cantidad: " + EnRevision, 10, 233);
                
        g.setColor(Color.darkGray);
        g.fillRect(100, 300, largo_Entregado, 40);
        g.drawString("Entregado", 10, 318);
        g.drawString("Cantidad: " + Entregado, 10, 333);

    }

}
