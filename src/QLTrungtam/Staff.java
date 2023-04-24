/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLTrungtam;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author huuph
 */

public class Staff {
    
    
    private String username_staff;
    private String password_staff;
    private int type_staff;
    private int id_staff;
    private String name_staff;
    private String sex_staff;
    private java.sql.Date birth_staff;
    private String phone_staff;
    private String gmail_staff;
    private String position_staff;
    private int basesalary_staff;
    private String status_staff;

    public int getIdstaff(){
        return id_staff;
    } 
    
    public String getUsernamestaff(){
        return username_staff;
    }
    
    public String getPasswordstaff(){
        return password_staff;
    }
    
    public int getAccType(){
        return type_staff;
    }
    
    public String getNamestaff(){
        return name_staff;
    }
    public String getSexstaff(){
        return sex_staff;
    }
    public java.sql.Date getBirthstaff(){
        return birth_staff;
    }
    public String getPhonestaff(){
        return phone_staff;
    }
    public String getGmailstaff(){
        return gmail_staff;
    }
    public String getPositionstaff(){
        return position_staff;
    }
    public int getBasesalary_staff(){
        return basesalary_staff;
    }
    public String getStatusstaff(){
        return status_staff;
    }
    
    public Staff(int id){
        try {  
                Statement st2 = DNConnect.getConnection();
                String str2 = "SELECT *FROM login WHERE id_staff = "+ id +" ";
                ResultSet rs2 = st2.executeQuery(str2);
                    while (rs2.next()) {
                           username_staff = rs2.getString(1);
                           password_staff = rs2.getString(2);
                           type_staff = rs2.getInt(4);
                    }
                Statement st = DNConnect.getConnection();
                String str = "SELECT *FROM information_staff  WHERE id_staff = "+ id +" ";
                ResultSet rs = st.executeQuery(str);
                    while (rs.next()) {
                           id_staff = rs.getInt(1);
                           name_staff = rs.getString(2);
                           sex_staff = rs.getString(3);
                           birth_staff = rs.getDate(4);
                           phone_staff = rs.getString(5);
                           gmail_staff = rs.getString(6);
                           position_staff = rs.getString(7);
                           basesalary_staff =  rs.getInt(8);
                           status_staff =  rs.getString(9);
                           break;
                        } 
                DNConnect.disConnection();
            
         } catch (SQLException ex) {
            Logger.getLogger(Staff.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
}
