/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB;

import java.sql.*;

/**
 *
 * @author delim
 */
public class Conectare {
    static Connection con;
  
   static  String database="jdbc:mysql://localhost:3306/Banca";
    static    String username="root";
   static    String pass="";
        
        public static Connection getConnection() throws Exception{
            if(con == null){
           
              con=DriverManager.getConnection(database,username,pass);
        }
            return con;
        }
            
    
}
