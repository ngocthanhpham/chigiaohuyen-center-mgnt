/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLTrungtam;

import dangnhap.Dangnhap;
import java.text.Normalizer;
import java.util.regex.Pattern;

public class main {
   
    public static String covertToString(String value) {
      try {
            String temp = Normalizer.normalize(value, Normalizer.Form.NFD);
            Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
            return pattern.matcher(temp).replaceAll("");
     } catch (Exception ex) {
      }
      return null;
}
  
    public static void main(String[] args) {
           Dangnhap dn = new Dangnhap();
           dn.setVisible(true);
    } 
}
