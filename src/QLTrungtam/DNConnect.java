/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLTrungtam;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DNConnect{
    private static final String DB_URL = "jdbc:mysql://localhost:3306/chigiaohuyen_center?autoReconnect=true&useSSL=false&characterEncoding=utf8&useUnicode=true";
    private static final String USER_NAME = "admin.plm";
    private static final String PASSWORD = "@Vf202020";
    private static Connection cons;
    private static Statement st;
   
     public static Connection connected() { 
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cons = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DNConnect.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cons;
    }
     
    public static Statement getConnection() { 
        try {
            Class.forName("com.mysql.jdbc.Driver");          
            cons = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            st = cons.createStatement();
        } catch (SQLException | ClassNotFoundException ex) { 
            Logger.getLogger(DNConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return st;
    }
    
    public static void disConnection()  {
       try{ 
        cons.close();
       } catch (SQLException ex) {
            Logger.getLogger(DNConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static int checkId(int id){
        int check = 0;
        try {
            String str3 = "CALL checkId_staff("+id+",?);";
            CallableStatement cs = connected().prepareCall(str3);
            cs.registerOutParameter(1, Types.INTEGER);
            cs.execute();
            check = cs.getInt(1);
            /*DNConnect.disConnection();*/
        } catch (SQLException ex) {
            Logger.getLogger(Staff.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return check;
    }
    
        public static int checkId_student(int id){
        int check = 0;
        try {
            String str3 = "CALL checkId_student("+id+",?);";
            CallableStatement cs = connected().prepareCall(str3);
            cs.registerOutParameter(1, Types.INTEGER);
            cs.execute();
            check = cs.getInt(1);
            /*DNConnect.disConnection();*/
        } catch (SQLException ex) {
            Logger.getLogger(Staff.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return check;
    }
        public static int checkId_lecturer(int id){
        int check = 0;
        try {
            String str3 = "CALL checkId_lecturer("+id+",?);";
            CallableStatement cs = connected().prepareCall(str3);
            cs.registerOutParameter(1, Types.INTEGER);
            cs.execute();
            check = cs.getInt(1);
            /*DNConnect.disConnection();*/
        } catch (SQLException ex) {
        } 
        return check;
    }
    
      public static void testConnect(){

         try {
            Class.forName("com.mysql.jdbc.Driver");
            cons = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            st = cons.createStatement();
            
            ResultSet rs = st.executeQuery("SELECT * FROM login");
            
            while (rs.next()) {
                int iddangnhap = rs.getInt(3);
                System.out.println(iddangnhap);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
}


