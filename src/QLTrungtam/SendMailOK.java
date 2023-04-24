/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLTrungtam;

/**
 *
 * @author admin
 */
import java.util.Properties;
import java.util.Vector;
import javax.mail.Address;

import javax.mail.Authenticator;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;


public class SendMailOK {
private static int totalMailNumber = 0;
private static Vector  vtData = new Vector();
      
public static int getTotalMailNumber(){
     return totalMailNumber;
}

public static Vector getData(){
     return vtData;
}

public SendMailOK(){
    try {
        String host = "pop.gmail.com";
        final String login = "huuphuc292";
        final String pwd = "01232621998";
        String provider = "pop3s";
        
        Properties props = System.getProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "pop.gmail.com");
        props.put("mail.smtp.port", 587);
        Authenticator pa = null; //default: no authentication      
        if (login != null && pwd != null) { //authentication required?
            pa = new Authenticator (){
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(login, pwd);
                }
            };
        
        }//else: no authentication

        // Kết nối đến POP3 server
        Session session = Session.getDefaultInstance(props, pa);
        Store store = session.getStore(provider);
        store.connect(host, login, pwd);
        // Mở thư mục INBOX
        Folder inbox = store.getFolder("INBOX");
        if (inbox == null) {
            System.out.println("No INBOX");
            System.exit(1); 
        }
        inbox.open(Folder.READ_ONLY);
       // Lấy messages từ server
    
        Message[] messages = inbox.getMessages();
        if(messages.length<1)
            System.out.println("Không có mail mới nào cả!");
        vtData.removeAllElements();
        for (int i = 0; i < messages.length; i++) {
            //Xuất toàn bộ thông tin của mail ra màn hình console
                Message msg = messages[i];
                Address[] fromAddress = msg.getFrom();
                String tfrom = fromAddress[0].toString();
                int index =tfrom.lastIndexOf("<");
                String from =  tfrom.substring(index);
                String subject = msg.getSubject();
                String toList = parseAddresses(msg
                        .getRecipients(Message.RecipientType.TO));
                String ccList = parseAddresses(msg
                        .getRecipients(Message.RecipientType.CC));
                String sentDate = msg.getSentDate().toString();
 
                String contentType = msg.getContentType();
                String messageContent = " Click \"visit Gmail\" ";
 
                Vector vtRow = new Vector();
                vtRow.add(i+1);
                vtRow.add(from);
                vtRow.add(toList);
                vtRow.add(ccList);
                vtRow.add(subject);
                vtRow.add(sentDate);
                vtRow.add(messageContent);
                vtData.add(vtRow);
        }
        totalMailNumber = messages.length;
        // Đóng kết nối nhưng không xóa message
        inbox.close(false);
        store.close();
    } catch (NoSuchProviderException ex) {
       // Logger.getLogger(SendMailOK.class.getName()).log(Level.SEVERE, null, ex);
    } catch (MessagingException ex) {
       // Logger.getLogger(SendMailOK.class.getName()).log(Level.SEVERE, null, ex);
    }
  
  }
        private String parseAddresses(Address[] address) {
        String listAddress = "";
 
        if (address != null) {
            for (int i = 0; i < address.length; i++) {
                listAddress += address[i].toString() + ", ";
            }
        }
        if (listAddress.length() > 1) {
            listAddress = listAddress.substring(0, listAddress.length() - 2);
        }
 
        return listAddress;
    }
}