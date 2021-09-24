/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package banca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author delim
 */
public class Retragere extends javax.swing.JFrame {

    Connection con;
    int id;

    public Retragere() {
        initComponents();
    }

    Retragere(int id_c) {
        try {
            initComponents();
            id = id_c;

            //realizeaza conexiunea la BD
            String database = "jdbc:mysql://localhost:3306/Banca";
            String username = "root";
            String pass = "";
            con = DriverManager.getConnection(database, username, pass);
            IncarcareInformatii();
        } catch (SQLException ex) {
            Logger.getLogger(Retragere.class.getName()).log(Level.SEVERE, null, ex);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        LabelEuro = new javax.swing.JLabel();
        LabelLei = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TextEuro = new javax.swing.JTextField();
        TextLei = new javax.swing.JTextField();
        BtnActiune = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        RBRetrag = new javax.swing.JRadioButton();
        RBDepozitez = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        jLabel1.setText("Sold Euro");

        jLabel2.setText("Sold Lei");

        LabelEuro.setText("100");

        LabelLei.setText("100");

        jLabel3.setText("Retragere Lei:");

        jLabel4.setText("Retragere Euro:");

        TextEuro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextEuroKeyReleased(evt);
            }
        });

        TextLei.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextLeiKeyReleased(evt);
            }
        });

        BtnActiune.setText("Fonduri");
        BtnActiune.setToolTipText("");
        BtnActiune.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnActiuneMouseEntered(evt);
            }
        });
        BtnActiune.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnActiuneActionPerformed(evt);
            }
        });

        jLabel5.setText("Fondurile le");

        buttonGroup1.add(RBRetrag);
        RBRetrag.setText("Retrag");
        RBRetrag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBRetragActionPerformed(evt);
            }
        });

        buttonGroup1.add(RBDepozitez);
        RBDepozitez.setText("Depozitez");
        RBDepozitez.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBDepozitezActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnActiune, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(RBRetrag)
                        .addGap(26, 26, 26)
                        .addComponent(RBDepozitez))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TextEuro)
                                    .addComponent(TextLei, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22))
                            .addComponent(LabelEuro, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelLei))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RBRetrag)
                    .addComponent(RBDepozitez))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(LabelEuro))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(LabelLei))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TextLei, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(TextEuro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addComponent(BtnActiune)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextEuroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextEuroKeyReleased
       //verifica daca s-a introdus un caracter nepermis
        if (DoarNumar(TextEuro.getText()) == 0) {
            JOptionPane.showMessageDialog(null, "Ati introdus un caracter nepermis", "Eroare: " + "Caracter nepermis", JOptionPane.ERROR_MESSAGE);
          BtnActiune.setEnabled(false);
        }
        else
        {
        Float euro = null;
        if (!TextEuro.getText().isEmpty()) {
            euro = Float.parseFloat(TextEuro.getText());
            Float sold = Float.parseFloat(LabelEuro.getText());
            if (sold - euro < 0 && RBRetrag.isSelected()) {
                JOptionPane.showMessageDialog(null, "Nu  aveti atat de multi euro in contul de lei", "Eroare: " + "Suma introdusa este prea mare", JOptionPane.ERROR_MESSAGE);
                BtnActiune.setEnabled(false);
            } else {
                BtnActiune.setEnabled(true);
            }
        }
        }
    }//GEN-LAST:event_TextEuroKeyReleased

    private void TextLeiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextLeiKeyReleased
        if (DoarNumar(TextLei.getText()) == 0) {
            JOptionPane.showMessageDialog(null, "Ati introdus un caracter nepermis", "Eroare: " + "Caracter nepermis", JOptionPane.ERROR_MESSAGE);
          BtnActiune.setEnabled(false);
        }
        else{
        Float lei = null;
        if (!TextLei.getText().isEmpty()) {
            lei = Float.parseFloat(TextLei.getText());
            Float sold = Float.parseFloat(LabelLei.getText());

            if (sold - lei < 0 && RBRetrag.isSelected()) {
                JOptionPane.showMessageDialog(null, "Nu  aveti atat de multi lei in contul de lei", "Eroare: " + "Suma introdusa este prea mare", JOptionPane.ERROR_MESSAGE);
                BtnActiune.setEnabled(false);
            } else {
                BtnActiune.setEnabled(true);
            }
        }
        }
    }//GEN-LAST:event_TextLeiKeyReleased

    //se verifica daca informatiile introduse sunt corespunzatoare pentru a retrage bani
    private void BtnActiuneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnActiuneMouseEntered


    }//GEN-LAST:event_BtnActiuneMouseEntered

    private void BtnActiuneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnActiuneActionPerformed
        int row = 0;
        if (!TextEuro.getText().isBlank()) {
            try {
                Float euro = Float.parseFloat(TextEuro.getText());
                Float sold = Float.parseFloat(LabelEuro.getText());
                Float nousold = null;
                String query = "";
                if (RBRetrag.isSelected()) {
                    nousold = sold - euro;

                    query = "Update Client set Sold_Cont_EURO=" + nousold + " where ID_C=" + id;
                } else if (RBDepozitez.isSelected()) {
                    nousold = sold + euro;
                    query = "Update Client set Sold_Cont_EURO=" + nousold + " where ID_C=" + id;
                }
                Statement s = con.createStatement();
                row = s.executeUpdate(query);

            } catch (SQLException ex) {
                Logger.getLogger(Retragere.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (!TextLei.getText().isBlank()) {
            try {
                Float lei = Float.parseFloat(TextLei.getText());
                Float sold = Float.parseFloat(LabelLei.getText());
                Float nousold = null;
                String query = "";
                if (RBRetrag.isSelected()) {
                    nousold = sold - lei;
                    query = "Update Client set Sold_Cont_LEI=" + nousold + " where ID_C=" + id;
                } else if (RBDepozitez.isSelected()) {
                    nousold = sold + lei;
                    query = "Update Client set Sold_Cont_LEI=" + nousold + " where ID_C=" + id;
                }
                Statement s = con.createStatement();
                row = s.executeUpdate(query);

            } catch (SQLException ex) {
                Logger.getLogger(Retragere.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (row > 0) {
            if (RBRetrag.isSelected()) {
                JOptionPane.showMessageDialog(null, "Retragerea a fost efectuata cu succes", "Succes: " + "Retragere fonduri", JOptionPane.INFORMATION_MESSAGE);
            } else if (RBDepozitez.isSelected()) {
                JOptionPane.showMessageDialog(null, "Depozitarea a fost efectuata cu succes", "Succes: " + "Depunere fonduri", JOptionPane.INFORMATION_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "A aparut o eroare", "Eroare: " + "Ceva nu a functionat bine", JOptionPane.ERROR_MESSAGE);
        }
        IncarcareInformatii();
    }//GEN-LAST:event_BtnActiuneActionPerformed

    private void RBRetragActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBRetragActionPerformed
        // TODO add your handling code here:
        BtnActiune.setText("Retragere fonduri");
    }//GEN-LAST:event_RBRetragActionPerformed

    private void RBDepozitezActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBDepozitezActionPerformed
        BtnActiune.setText("Depoziteaza fonduri");
    }//GEN-LAST:event_RBDepozitezActionPerformed

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved

        String euro = TextEuro.getText();
        String lei = TextLei.getText();

        if (!euro.isBlank()) {  //daca s-a introdus un caracter 
            if (DoarNumar(euro) == 1) { //daca e de tipul int
                if (!lei.isBlank()) { //daca campul pentur al doilea contine caractere
                    if (DoarNumar(lei) == 1) {  //daca e numeric
                        BtnActiune.setEnabled(true);
                    } else {
                       
                    }
                } else {
                    BtnActiune.setEnabled(true);
                }
                
                //verifica daca suma introdusa este mai mare decat ceea ce are in conturi. Daca da, atentioneaza si ingheata butonul
                Float sold = Float.parseFloat(LabelEuro.getText());
                if(sold-Float.parseFloat(euro)<0&&RBRetrag.isSelected())
                { 
                    JOptionPane.showMessageDialog(null, "Nu  aveti atat de multi euro in contul de lei", "Eroare: " + "Suma introdusa este prea mare", JOptionPane.ERROR_MESSAGE);
                 BtnActiune.setEnabled(false);
                }
            } else {
                BtnActiune.setEnabled(false);
            }
        }

        if (!lei.isBlank()) { //verifica daca s-a introdus o valoare in campul de lei
            if (DoarNumar(lei) == 1) { //daca valoarea introdusa este numerica
                if (!euro.isBlank()) { //daca si al doilea camp contine o valoare
                    if (DoarNumar(euro) == 1) { //daca valoarea este numerica
                        BtnActiune.setEnabled(true);
                    } else {
                        BtnActiune.setEnabled(false);
                    }
                } else {
                    BtnActiune.setEnabled(true);
                }
                 //verifica daca suma introdusa este mai mare decat ceea ce are in conturi. Daca da, atentioneaza si ingheata butonul
                Float sold = Float.parseFloat(LabelLei.getText());
                if(sold-Float.parseFloat(lei)<0&&RBRetrag.isSelected())
                { JOptionPane.showMessageDialog(null, "Nu  aveti atat de multi lei in contul de lei", "Eroare: " + "Suma introdusa este prea mare", JOptionPane.ERROR_MESSAGE);
                 BtnActiune.setEnabled(false);
                }
            } else {
                BtnActiune.setEnabled(false);
            }
        }
        if (!RBDepozitez.isSelected() && !RBRetrag.isSelected()) {
            BtnActiune.setEnabled(false);
        }
        if (euro.isBlank() && lei.isBlank()) {
            BtnActiune.setEnabled(false);
        }
        
    }//GEN-LAST:event_formMouseMoved

    int DoarNumar(String text) {
        String regex = "^.{0}$|^[0-9]+"; //regex pentru a fi doar numere sau un sir null
        if (text.matches(regex)) {
            return 1;
        } else {
            return 0;
        }

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
            java.util.logging.Logger.getLogger(Retragere.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Retragere.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Retragere.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Retragere.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Retragere().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnActiune;
    private javax.swing.JLabel LabelEuro;
    private javax.swing.JLabel LabelLei;
    private javax.swing.JRadioButton RBDepozitez;
    private javax.swing.JRadioButton RBRetrag;
    private javax.swing.JTextField TextEuro;
    private javax.swing.JTextField TextLei;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables

    private void IncarcareInformatii() {

        TextEuro.setText("");
        TextLei.setText("");
        try {
            String query = "Select * from Client where ID_C=" + id;
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) { //preia informatia despre conturi
                LabelEuro.setText(rs.getString("Sold_Cont_EURO"));
                LabelLei.setText(rs.getString("Sold_Cont_LEI"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
