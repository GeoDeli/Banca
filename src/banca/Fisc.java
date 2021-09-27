/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package banca;

import java.sql.Connection;
import java.io.*;
import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import java.sql.Statement;


/**
 *
 * @author delim
 */
public class Fisc extends javax.swing.JFrame {

    Connection con;
     File fisier;    
     
    public Fisc() {
        initComponents();
      
        listClienti.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        
        //verifica daca fisierul exista, in caz contrar il creaza
        try {
            fisier=new File("Monitorizare.txt"); 
            if(!fisier.exists())
            {
                try {
                    fisier.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(Fisc.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
         
        String database="jdbc:mysql://localhost:3306/Banca";
        String username="root";
        String pass="";
        con=DriverManager.getConnection(database,username,pass);
        
        //afiseaza informatile legate de cine este urmarit si cine nu
            actualizareListaMonitorizare(0, listClienti);
        actualizareListaMonitorizare(1, listClientiMonitorizati);
         
        } catch (SQLException ex) {
            Logger.getLogger(CreareUtilizator.class.getName()).log(Level.SEVERE, null, ex);
        }
        monitorizare();
    }
 void afiseaza(ArrayList<String> linii, JList Lista)
	{
            Lista.removeAll();
	DefaultListModel model=new DefaultListModel();
	
        for(String s:linii)
            model.addElement(s);
            Lista.setModel(model);
	
        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listClienti = new javax.swing.JList<>();
        BtnMonitor = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listClientiMonitorizati = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        listClienti.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listClienti.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listClientiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listClienti);

        BtnMonitor.setText("Monitorizare");
        BtnMonitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnMonitorActionPerformed(evt);
            }
        });

        listClientiMonitorizati.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listClientiMonitorizati);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(BtnMonitor)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnMonitor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnMonitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMonitorActionPerformed

        //preia cnp-urile selectate
         List<String> selectati = listClienti.getSelectedValuesList();
      
        try {//creaza un nou rand pentru fisier ce contine CLIENT EURO LEI
            
            BufferedWriter bf=new BufferedWriter(new FileWriter(fisier,true));
            for(String s: selectati)
            {
                //preia info din BD
                String query="Select * from Client where CNP=\""+s+"\"";
                Statement statement=con.createStatement(); 
                ResultSet resultSet = statement.executeQuery(query);
                while(resultSet.next())
                {
                    String euro=resultSet.getString("Sold_Cont_EURO");
                    String lei=resultSet.getString("Sold_Cont_lei");

                      bf.append(s+" "+euro+" Euro "+lei+" lei\n");  //scrie in fisier
                }
                
                query="update Client set Monitorizat=1 where CNP=\""+s+"\"";
                statement=con.createStatement();
                int rezultat=statement.executeUpdate(query);
                if(rezultat<0)
                  JOptionPane.showMessageDialog(null, "Ceva nu a mers bine", "Eroare: " + "Imposibil de urmarit", JOptionPane.ERROR_MESSAGE);

            }
          bf.close();
            actualizareListaMonitorizare(1, listClientiMonitorizati);
        } catch (IOException ex) {
            Logger.getLogger(Fisc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Fisc.class.getName()).log(Level.SEVERE, null, ex);
        }
          
    }//GEN-LAST:event_BtnMonitorActionPerformed
        //verifica daca s-a modificat soldul unui cont pentru fiecare client monitorizat
    public void monitorizare()
{
    Scanner r;
    ArrayList monitorizati= new ArrayList(); //stocheaza monitorizatii din fisier 
  
    try { 
            r = new Scanner(fisier);
            while(r.hasNextLine())
            { //preia toate informatiile din fisier si le converteste
                String[] linie=r.nextLine().split(" ");
                String CNP=linie[0];              
                Float euro=Float.parseFloat(linie[1]);
                Float lei=Float.parseFloat(linie[3]);
            
            //preia informatiile curente din BD
           String   query="SELECT * FROM Client  where CNP=\""+CNP+"\"";
            Statement statement=con.createStatement();
            ResultSet   resultSet = statement.executeQuery(query);
            while(resultSet.next())
              {
                float euroBD=resultSet.getFloat("Sold_Cont_EURO"); //stocheaza informatia din bd pentru a calcula diferenta si a afisa 
                float leiBD=resultSet.getFloat("Sold_Cont_LEI");
                String afisare="";
                //verifica daca informatia dintre fisier di BD difera
                if(euroBD!=euro || lei!=leiBD)
                { afisare=afisare+"Sold EURO \n Nou: "+ euroBD +" Vechi: "+euro+"\n";
                
                   afisare=afisare+"Sold LEI \n Nou: "+ leiBD +" Vechi: "+lei+"\n";
                }
                //afiseaza mesaj
                if(!afisare.isBlank())
                {
                      JOptionPane.showMessageDialog(null, "Au fost inregistrate urmatoarele modificari bancare:\n"+afisare, "Info: " + "Modificare sold client "+CNP, JOptionPane.PLAIN_MESSAGE);
                }
              }
           }
         
           
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Fisc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Fisc.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    //preia clientii selectat
    private void listClientiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listClientiMouseClicked
        // TODO add your handling code here:
        
    //    selectati.add(listClienti.getSelectedValue());
        
    }//GEN-LAST:event_listClientiMouseClicked

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
            java.util.logging.Logger.getLogger(Fisc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fisc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fisc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fisc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fisc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnMonitor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listClienti;
    private javax.swing.JList<String> listClientiMonitorizati;
    // End of variables declaration//GEN-END:variables

    private void actualizareListaMonitorizare(int monitor, JList lista) {
        try {
            ArrayList rez=new ArrayList();
            String   query="SELECT * FROM Client  where Monitorizat="+monitor; //afiseaza clientii monitorizati
            Statement statement=con.createStatement();
            ResultSet   resultSet = statement.executeQuery(query);
            
            while(resultSet.next())
            {
                rez.add(resultSet.getString("CNP"));
            }
            afiseaza(rez,lista);
        } catch (SQLException ex) {
            Logger.getLogger(Fisc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
