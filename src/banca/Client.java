/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package banca;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author delim
 */
public class Client extends javax.swing.JFrame {
      Connection con;
      int id;
    public Client() {
        initComponents();
    }
    
    //constructorul primeste ID-ul autentificat pentru a afisa informatiile clientului pe parcurs
    public Client(int id_c) {
        initComponents();
        id=id_c;
      try {  
          //realizeaza conexiunea la BD
        String database="jdbc:mysql://localhost:3306/Banca";
        String username="root";
        String pass="";
              con=DriverManager.getConnection(database,username,pass);
                 
          } catch (SQLException ex) {
              Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
          }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        BtnLichidare = new javax.swing.JButton();
        BtnRetragere = new javax.swing.JButton();
        BtnInfo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Informatii client");

        BtnLichidare.setText("Lichidare conturi");
        BtnLichidare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLichidareActionPerformed(evt);
            }
        });

        BtnRetragere.setText("Depozit/Retrageri");
        BtnRetragere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRetragereActionPerformed(evt);
            }
        });

        BtnInfo.setText("Informatii");
        BtnInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnInfoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(BtnLichidare, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtnRetragere)
                        .addComponent(BtnInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BtnInfo, BtnLichidare, BtnRetragere});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addComponent(BtnInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnLichidare)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnRetragere)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        //lichideaza conturile utilizatorului daca acesta este sigur de optiunea aleasa
    private void BtnLichidareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLichidareActionPerformed
 try {
     String query="Select * from Client where ID_C="+id;
      Statement statement =con.createStatement();
      ResultSet rs=statement.executeQuery(query);
      while(rs.next())
      { //preia informatia despre conturi
        Float euro=Float.parseFloat(rs.getString("Sold_Cont_EURO")); 
         Float lei=Float.parseFloat(rs.getString("Sold_Cont_LEI"));
         
         if(euro!=0 && lei!=0)  //verifica daca se poate sterge contul
              JOptionPane.showMessageDialog(null, "Actiune imposibila \nConturile au sold diferit de 0", "Eroare: " + "Lichidare imposibila", JOptionPane.ERROR_MESSAGE);
            else
         {
             //se intreaba utilizatorul daca doreste stergerea contului
            int raspuns=  JOptionPane.showConfirmDialog(null,"Sigur doriti sa lichidati conturile?","Sunteti sigur?",JOptionPane.YES_NO_OPTION);
           
            if(raspuns==JOptionPane.YES_OPTION)
            {  //stergere efectuva
             query="Delete from Client where ID_C="+id;
              statement=con.createStatement();
             int row = statement.executeUpdate(query); 
            if(row>0)
              JOptionPane.showMessageDialog(null, "Utilizator sters cu succes", "Succes: " + "Utilizatorul a fost sters cu succes", JOptionPane.INFORMATION_MESSAGE);
           }
           else 
                //anulare stergere
           if(raspuns==JOptionPane.NO_OPTION)
         JOptionPane.showMessageDialog(null, "Lichidarea conturilor este oprita cu succes", "Abandon " + "", JOptionPane.INFORMATION_MESSAGE);

         }
      }
        } catch (SQLException ex) {
            Logger.getLogger(CreareUtilizator.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }//GEN-LAST:event_BtnLichidareActionPerformed

//afiseaza informatiile utilizatorului
    private void BtnInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnInfoActionPerformed
          try {
              String query="Select * from Client where ID_C="+id;   //cauta in BD conform id-ului
              Statement statement=con.createStatement();
              ResultSet rs=statement.executeQuery(query);
              while(rs.next())
              { //creaza string-ul de afisare
                  String info="Cont EURO: "+rs.getString("Sold_Cont_EURO")+"\n Cont LEI: "+rs.getString("Sold_Cont_LEI");
                  JOptionPane.showMessageDialog(null, "Informatii Utilizator\n"+info, "Informatii: " + " Utilizator", JOptionPane.PLAIN_MESSAGE);
          } 
          }catch (SQLException ex) {
              Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
          }
     
        

    }//GEN-LAST:event_BtnInfoActionPerformed

    
    private void BtnRetragereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRetragereActionPerformed
       Retragere r=new Retragere(id);
       r.setVisible(true);
    }//GEN-LAST:event_BtnRetragereActionPerformed

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
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Client().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnInfo;
    private javax.swing.JButton BtnLichidare;
    private javax.swing.JButton BtnRetragere;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables


    int DoarNumar(String text)
   {
       String regex = "^[0-9]+";
        if(text.matches(regex))
            return 1;  
        else 
            return 0;
         
   }
}
