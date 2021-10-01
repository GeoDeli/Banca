/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OOP;

import java.util.List;
import DB.Conectare;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author delim
 */
public class ClientImplement implements ClientInterface {

    @Override
    public void save(Client client) {
        try {
            Connection con =  Conectare.getConnection();
           String  query="INSERT INTO `client`(`ID_C`, `CNP`, `Sold_Cont_EURO`, `Sold_Cont_LEI`) VALUES ("+client.getId()+",\""+client.getCNP()+"\","+client.getSold_Euro()+","+client.getSold_Lei()+")";
          Statement statement=con.createStatement();  
          int row = statement.executeUpdate(query); 
          if(row>0)
  JOptionPane.showMessageDialog(null, "Utilizator creat cu succes\n ID pentru autentificare: "+client.getId(), "Succes: " + "Utilizator Creat", JOptionPane.PLAIN_MESSAGE);
   
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    @Override
    public void update(Client client) {
       try {
            Connection con =  Conectare.getConnection();
         String  query = "Update Client set Sold_Cont_EURO=" + client.getSold_Euro() + ", Sold_Cont_LEI="+client.getSold_Lei()+" where ID_C=" + client.getId();
          Statement statement=con.createStatement();  
          int row = statement.executeUpdate(query); 
          if(row<=0)
     JOptionPane.showMessageDialog(null, "A aparut o eraore ", "Eroare: " + "Actiune imposibila", JOptionPane.PLAIN_MESSAGE);
   
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }    }

    @Override
    public void delete(int id) {
        try {
            Connection con =  Conectare.getConnection();
            String query="Delete from Client where ID_C="+id;
            Statement    statement=con.createStatement();
            int row = statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "A aparut o eraore ", "Eroare: " + "Actiune imposibila", JOptionPane.PLAIN_MESSAGE);
        } catch (Exception ex) {
            Logger.getLogger(ClientImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
   
        
    }

    @Override
    public Client get(int id) {
         Client st = new Client();
        try {
            Connection con = Conectare.getConnection();
            String sql = "SELECT * FROM Client WHERE ID_C="+id;
             Statement statement=con.createStatement();  
            ResultSet rs = statement.executeQuery(sql);
            if(rs.next()){
                
                 st.setId(rs.getInt("ID_C"));
                st.setCNP(rs.getString("CNP"));
                st.setSold_Euro(rs.getFloat("Sold_Cont_EURO"));
                st.setSold_Lei(rs.getFloat("Sold_Cont_EURO"));
            }         
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return st;
    }

    @Override
    public ArrayList<Client> list() {
       ArrayList<Client> list = new ArrayList<Client>();
        
            
        try {
            Connection con = Conectare.getConnection();
            String sql = "SELECT * FROM Client ";
            Statement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            
            while(rs.next()){
                Client st = new Client();
                st.setId(rs.getInt("ID_C"));
                st.setCNP(rs.getString("CNP"));
                st.setSold_Euro(rs.getFloat("Sold_Cont_Euro"));
                st.setSold_Lei(rs.getFloat("Sold_Cont_Lei"));

                list.add(st);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Eroare la preluarea datelor");
        }
        return list;
  
    }

    @Override
    public Client autentificare(int id, String cnp) {
         Client st = new Client();
        try {
            Connection con = Conectare.getConnection();
            String sql = "SELECT * FROM Client WHERE ID_C="+id+ " and CNP=\""+cnp+"\"";
             Statement statement=con.createStatement();  
            ResultSet rs = statement.executeQuery(sql);
            if(rs.next()){
                
                 st.setId(rs.getInt("ID_C"));
                st.setCNP(rs.getString("CNP"));
                st.setSold_Euro(rs.getFloat("Sold_Cont_EURO"));
                st.setSold_Lei(rs.getFloat("Sold_Cont_EURO"));
            } 
            else st.setCNP("0");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return st;
    }

    @Override
    public Client getWithCNP(String cnp) {
      Client st = new Client();
        try {
            Connection con = Conectare.getConnection();
            String sql = "SELECT * FROM Client WHERE CNP=\""+cnp+"\"";
             Statement statement=con.createStatement();  
            ResultSet rs = statement.executeQuery(sql);
            if(rs.next()){
                
                 st.setId(rs.getInt("ID_C"));
                st.setCNP(rs.getString("CNP"));
                st.setSold_Euro(rs.getFloat("Sold_Cont_EURO"));
                st.setSold_Lei(rs.getFloat("Sold_Cont_EURO"));
            }         
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return st;
    }
    
}
