/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package banca;

import java.sql.Connection;
import java.io.*;
import java.nio.file.*;
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
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Consumer;

/**
 *
 * @author delim
 */
public class Fisc extends javax.swing.JFrame {

    Connection con;
     File fisier;    
      
    public Fisc() {
        initComponents();
      setDefaultCloseOperation(Fisc.DISPOSE_ON_CLOSE);
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
    
    //functie folosita pentrua a afisa informatiile
 void afiseaza(ArrayList<String> linii, JList Lista)
	{
            Lista.removeAll();
	DefaultListModel model=new DefaultListModel();
        //adauga informatiile in model pentru a fii afisate
        linii.forEach(x->model.addElement(linii.get(linii.indexOf(x))));
     
        //afiseaza modelul creat in lista data ca si parametru
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
        BtnOprireMonitorizare = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        BtnRefresh = new javax.swing.JButton();

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
        listClientiMonitorizati.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listClientiMonitorizatiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(listClientiMonitorizati);

        BtnOprireMonitorizare.setText("Oprire monitorizare");
        BtnOprireMonitorizare.setEnabled(false);
        BtnOprireMonitorizare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnOprireMonitorizareActionPerformed(evt);
            }
        });

        jLabel1.setText("Monitorizare clienti");

        jLabel2.setText("Clienti monitorizati");

        jLabel3.setText("Clienti nemonitorizati");

        BtnRefresh.setText("Refresh cache");
        BtnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BtnOprireMonitorizare, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnMonitor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(23, 23, 23))
                    .addComponent(BtnRefresh, javax.swing.GroupLayout.Alignment.TRAILING)))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel2)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(BtnMonitor)))
                .addGap(50, 50, 50)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnOprireMonitorizare)
                        .addGap(38, 38, 38)
                        .addComponent(BtnRefresh))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnMonitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMonitorActionPerformed

        //preia cnp-urile selectate
         List<String> selectati = listClienti.getSelectedValuesList();
      
             //creaza un nou rand pentru fisier ce contine CLIENT EURO LEI
           Consumer<String> Monitorizeaza = (String s) -> {
                try {
                     BufferedWriter   bw = Files.newBufferedWriter(fisier.toPath());
                    //preia info din BD
                    String query="Select * from Client where CNP=\""+s+"\"";
                    Statement statement=con.createStatement();
                    ResultSet resultSet = statement.executeQuery(query);
                    while(resultSet.next())
                    {
                        String euro=resultSet.getString("Sold_Cont_EURO");
                        String lei=resultSet.getString("Sold_Cont_lei");
                        bw.append(s+" "+euro+" Euro "+lei+" lei \n");  //scrie in fisier
                    }
                    //modificare in BD pentru a se vedea cine e monitorizat
                    query="update Client set Monitorizat=1 where CNP=\""+s+"\"";
                    statement=con.createStatement();
                    int rezultat=statement.executeUpdate(query);
                    if(rezultat<0)
                        JOptionPane.showMessageDialog(null, "Ceva nu a mers bine", "Eroare: " + "Imposibil de urmarit", JOptionPane.ERROR_MESSAGE);
                    bw.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Fisc.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Fisc.class.getName()).log(Level.SEVERE, null, ex);
                }
           
            };
                selectati.forEach(Monitorizeaza);
         
            actualizareListaMonitorizare(1, listClientiMonitorizati);
        
          
    }//GEN-LAST:event_BtnMonitorActionPerformed
        //verifica daca s-a modificat soldul unui cont pentru fiecare client monitorizat
    public void monitorizare() 
{
    try { 
           BufferedReader br = new BufferedReader(new FileReader(fisier));
            while(br.readLine()!=null)
            { //preia toate informatiile din fisier si le converteste
                String[] linie=br.readLine().split(" ");
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
                if(euroBD!=euro)
                 afisare=afisare+"S-a modificat Sold-ul contului de EURO \n Nou: "+ euroBD +"    Vechi: "+euro+"\n";
                 if( lei!=leiBD)
                   afisare=afisare+"S-a modificat Sold-ul contului de LEI \n Nou: "+ leiBD +"    Vechi: "+lei+"\n";
                
                //afiseaza mesaj
                if(!afisare.isBlank())
                {
                      JOptionPane.showMessageDialog(null, "Au fost inregistrate urmatoarele modificari bancare:\n"+afisare, "Info: " + "Modificare sold client "+CNP, JOptionPane.PLAIN_MESSAGE);
                }
              }
            resultSet.close();
            statement.close();
           }
         br.close();
          
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Fisc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Fisc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Fisc.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    //preia clientii selectat
    private void listClientiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listClientiMouseClicked
        // TODO add your handling code here:
        
    //    selectati.add(listClienti.getSelectedValue());
        
    }//GEN-LAST:event_listClientiMouseClicked

    //cand s-a selectat un client ce este monitorizat
    private void listClientiMonitorizatiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listClientiMonitorizatiMouseClicked
        // TODO add your handling code here:
        BtnOprireMonitorizare.setEnabled(true);
    }//GEN-LAST:event_listClientiMonitorizatiMouseClicked

    //opreste monitorizarea prin stergerea acestuia din text si a modificarii din BD
    private void BtnOprireMonitorizareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnOprireMonitorizareActionPerformed
        // TODO add your handling code here:
          List<String> selectati = listClientiMonitorizati.getSelectedValuesList();
          //modifica in bd
         Consumer<String> Monitorizeaza = (String cnp) -> {
              try { 
             String   query="update Client set Monitorizat=0 where CNP=\""+cnp+"\"";
               Statement statement=con.createStatement();
            
         int   rezultat = statement.executeUpdate(query); //testeaza modificarea
               if(rezultat<0)
                  JOptionPane.showMessageDialog(null, "Ceva nu a mers bine", "Eroare: " + "Imposibil de anulat monitorizarea", JOptionPane.ERROR_MESSAGE);
         
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(Fisc.class.getName()).log(Level.SEVERE, null, ex);
        }
             
              try {
                  
                  //sterge din fisier randul cu informatiile clientului
                 File tempFile = new File("myTempFile.txt");        //creare fiser temporar ce va detine informatiile actualizate
BufferedReader reader = new BufferedReader(new FileReader(fisier));  //citeste din fifiser pentru comparare
BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
String Linie;
while((Linie = reader.readLine()) != null) { 
//prea linia curenta si verifica daca ea contine CNP-ul clientului ce nu va mai fi monitorizat
        if(Linie.contains(cnp)) 
        continue; 
    writer.write(Linie + System.getProperty("line.separator")); //scrie in fifiser
} 
 
writer.close();  
reader.close();  

//suprascrie fifiserul de monitorizare pentru a-l face sa fie actualizat
 Files.move(tempFile.toPath(), fisier.toPath(), StandardCopyOption.REPLACE_EXISTING);
                      JOptionPane.showMessageDialog(null, "Clientul nu va mai fi monitorizat", "Succes: " + cnp+"", JOptionPane.INFORMATION_MESSAGE);

                          } catch (FileNotFoundException ex) {
                  Logger.getLogger(Fisc.class.getName()).log(Level.SEVERE, null, ex);
              } catch (IOException ex) {
                  Logger.getLogger(Fisc.class.getName()).log(Level.SEVERE, null, ex);
              }
              
          };
     
          actualizareListaMonitorizare(1, listClientiMonitorizati);
          BtnOprireMonitorizare.setEnabled(false);
    }//GEN-LAST:event_BtnOprireMonitorizareActionPerformed

    private void BtnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRefreshActionPerformed
    
    try { //creaza fisier temporar
             File tempFile = new File("myTempFile.txt"); 
BufferedReader reader = new BufferedReader(new FileReader(fisier)); 
BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
           Scanner r = new Scanner(fisier);
           
            while(r.hasNextLine())
            { //preia doar CNP-ul din fisier pentru a acualiza conform BD-ului
                String[] linie=r.nextLine().split(" ");
                String CNP=linie[0];              
                
            //preia informatiile curente din BD
           String   query="SELECT * FROM Client  where CNP=\""+CNP+"\"";
            Statement statement=con.createStatement();
            ResultSet   resultSet = statement.executeQuery(query);
            while(resultSet.next())
              {
                float euroBD=resultSet.getFloat("Sold_Cont_EURO"); //stocheaza informatia din bd pentru a calcula diferenta si a afisa 
                float leiBD=resultSet.getFloat("Sold_Cont_LEI");

                        writer.write(CNP+" "+euroBD+" euro " +leiBD+" lei"); 

              }
            resultSet.close();
            statement.close();
          
            }
            
              r.close();
            writer.close();  
reader.close();  
//suprascrie fisiserul de monitorizare pentru a-l face sa fie actualizat
 Files.move(tempFile.toPath(), fisier.toPath(), StandardCopyOption.REPLACE_EXISTING);
 JOptionPane.showMessageDialog(null, "Informatiile au fost actualizate cu succes", "Succes: " + "Actualizare monitorizare", JOptionPane.INFORMATION_MESSAGE);

    }   catch (FileNotFoundException ex) {
            Logger.getLogger(Fisc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Fisc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Fisc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtnRefreshActionPerformed

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
    private javax.swing.JButton BtnOprireMonitorizare;
    private javax.swing.JButton BtnRefresh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
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
