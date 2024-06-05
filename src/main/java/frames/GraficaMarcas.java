
package frames;

import controllers.Conexion;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.WindowConstants;


public class GraficaMarcas extends javax.swing.JFrame {


    String user;
    int[] vector_marca_cantidad = new int[11];
    String[] vector_marca_nombre = new String[11];
    int hp, lenovo, dell, acer, apple, toshiba, brother, samsung, asus, alienware, xerox;
    
    public GraficaMarcas() {
        initComponents();
        
        user = Login.user;
        
        setSize(550,450);
        setResizable(false);
        setTitle("Tecnico - Sesion de " + user);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        try {
          Connection cn = Conexion.conection();
          PreparedStatement pst = cn.prepareStatement("SELECT marca, count(marca) as Marcas FROM equipos GROUP BY marca");
          ResultSet rs = pst.executeQuery();
          
            if (rs.next()) {
                int posicion = 0;
                
                do {                    
                    vector_marca_nombre[posicion] = rs.getString(1);
                    vector_marca_cantidad[posicion] = rs.getInt(2);
                    
                    if (vector_marca_nombre[posicion].equalsIgnoreCase("Acer")) {
                        acer = vector_marca_cantidad[posicion];
                    } else if (vector_marca_nombre[posicion].equalsIgnoreCase("Alienware")) {
                        alienware = vector_marca_cantidad[posicion];
                    } else if (vector_marca_nombre[posicion].equalsIgnoreCase("Apple")) {
                        apple = vector_marca_cantidad[posicion];
                    } else if (vector_marca_nombre[posicion].equalsIgnoreCase("Asus")) {
                        asus = vector_marca_cantidad[posicion];
                    }  else if (vector_marca_nombre[posicion].equalsIgnoreCase("Brother")) {
                        brother = vector_marca_cantidad[posicion];
                    }  else if (vector_marca_nombre[posicion].equalsIgnoreCase("Dell")) {
                        dell = vector_marca_cantidad[posicion];
                    }  else if (vector_marca_nombre[posicion].equalsIgnoreCase("HP")) {
                        hp = vector_marca_cantidad[posicion];
                    }  else if (vector_marca_nombre[posicion].equalsIgnoreCase("Lenovo")) {
                        lenovo = vector_marca_cantidad[posicion];
                    }  else if (vector_marca_nombre[posicion].equalsIgnoreCase("Samsung")) {
                        samsung = vector_marca_cantidad[posicion];
                    }  else if (vector_marca_nombre[posicion].equalsIgnoreCase("Toshiba")) {
                        toshiba = vector_marca_cantidad[posicion];
                    }  else if (vector_marca_nombre[posicion].equalsIgnoreCase("Xerox")) {
                        xerox = vector_marca_cantidad[posicion];
                    }  
                    posicion++;
                } while (rs.next());
            }
          
        } catch (Exception e) {
            System.err.println("Error en la consulta" + e);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_titulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        jLabel_titulo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel_titulo.setText("Grafica de marcas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel_titulo)
                .addContainerGap(381, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(GraficaMarcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GraficaMarcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GraficaMarcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GraficaMarcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GraficaMarcas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel_titulo;
    // End of variables declaration//GEN-END:variables

    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        int total_marcas = acer + alienware + apple + asus + brother + dell + hp + lenovo + samsung + toshiba + xerox;
        
        int grados_acer = acer * 360 / total_marcas;
        int grados_alienware = alienware * 360 / total_marcas;
        int grados_apple = apple * 360 / total_marcas;
        int grados_asus = asus * 360 / total_marcas;
        int grados_brother = brother * 360 / total_marcas;
        int grados_dell = dell * 360 / total_marcas;
        int grados_hp = hp * 360 / total_marcas;
        int grados_lenovo = lenovo * 360 / total_marcas;
        int grados_samsung = samsung * 360 / total_marcas;
        int grados_toshiba = toshiba * 360 / total_marcas;
        int grados_xerox = xerox * 360 / total_marcas;

        g.setColor(Color.pink);
        g.fillArc(25, 100, 270, 270, 0, grados_acer);
        g.fillRect(310, 120, 20,20);
        g.drawString(acer + " de Acer", 340, 135);
        
        g.setColor(Color.green);
        g.fillArc(25, 100, 270, 270, grados_acer, grados_alienware);
        g.fillRect(310, 150, 20,20);
        g.drawString(alienware + " de Alienware", 340, 165);
        
        g.setColor(new Color(0, 225, 225));
        g.fillArc(25, 100, 270, 270, grados_acer + grados_alienware, grados_apple);
        g.fillRect(310, 180, 20, 20);
        g.drawString(apple + " de Apple", 340, 195);
        
        g.setColor(new Color(55, 0, 255));
        g.fillArc(25, 100, 270, 270, grados_acer + grados_alienware + grados_apple, grados_asus);
        g.fillRect(310, 210, 20, 20);
        g.drawString(asus + " de Asus", 340, 225);
        
        g.setColor(new Color(55, 0, 255));
        g.fillArc(25, 100, 270, 270, grados_acer + grados_alienware + grados_apple + grados_asus, grados_brother);
        g.fillRect(310, 240, 20, 20);
        g.drawString(brother + " de Brother", 340, 255);
        
        g.setColor(new Color(247, 220, 111));
        g.fillArc(25, 100, 270, 270, grados_acer + grados_alienware + grados_apple + grados_asus + grados_brother, grados_dell);
        g.fillRect(310, 270, 20, 20);
        g.drawString(dell + " de Dell", 340, 285);
        
        g.setColor(new Color(21, 42, 160));
        g.fillArc(25, 100, 270, 270, grados_acer + grados_alienware + grados_apple + grados_asus + grados_brother + grados_dell, grados_hp);
        g.fillRect(310, 300, 20, 20);
        g.drawString(hp + " de HP", 340, 315);
        
        g.setColor(new Color(215, 96, 0));
        g.fillArc(25, 100, 270, 270, grados_acer + grados_alienware + grados_apple + grados_asus + grados_brother + grados_dell + grados_hp, grados_lenovo);
        g.fillRect(310, 330, 20, 20);
        g.drawString(lenovo + " de Lenovo", 340, 345);
        
        g.setColor(new Color(215, 96, 140));
        g.fillArc(25, 100, 270, 270, grados_acer + grados_alienware + grados_apple + grados_asus + grados_brother + grados_dell + grados_hp + grados_lenovo, grados_samsung);
        g.fillRect(430, 120, 20, 20);
        g.drawString(samsung + " de Samsung", 460, 135);
        
        g.setColor(new Color(215, 196, 25));
        g.fillArc(25, 100, 270, 270, grados_acer + grados_alienware + grados_apple + grados_asus + grados_brother + grados_dell + grados_hp + grados_lenovo + grados_samsung, grados_toshiba);
        g.fillRect(430, 150, 20, 20);
        g.drawString(toshiba + " de Toshiba", 460, 165);
        
        g.setColor(new Color(93, 173, 226));
        g.fillArc(25, 100, 270, 270, grados_acer + grados_alienware + grados_apple + grados_asus + grados_brother + grados_dell + grados_hp + grados_lenovo + grados_samsung + grados_toshiba, grados_xerox);
        g.fillRect(430, 180, 20, 20);
        g.drawString(xerox + " de Xerox", 460, 195);
        
    }

}
