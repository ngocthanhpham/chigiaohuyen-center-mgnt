
package windowssidepackage;

import QLTrungtam.DNConnect;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class qlGiaovien extends javax.swing.JPanel {

   int stt;
    DefaultTableModel tb1;
    public qlGiaovien() {
        
        initComponents();
        tb1 = (DefaultTableModel) jTable1.getModel();
        
        stt = 0;
       tb1.setRowCount(0);
       
       try
       {
           Connection cons = DNConnect.connected();
           Statement st = cons.createStatement();
           String sql = "select * from information_lecturer";
           ResultSet rs = st.executeQuery(sql);
           while(rs.next()){
               String id = rs.getString("id_lecturer");
               String name = rs.getString("name_lecturer");
               String sex = rs.getString("sex_lecturer");
               String birth = rs.getString("birthday_lecturer");
               String phone = rs.getString("phone_lecturer");
               String gmail = rs.getString("gmail_lecturer");
               String sta = rs.getString("status_lecturer");
               String base = rs.getString("basesalary_lecturer");
               String des = rs.getString("describe_lecturer");
               stt++;
               String STT = String.valueOf(stt);
               
               tb1.addRow(new String[]{STT,id,name,sex,birth,phone,gmail,des,base,sta});
               
            }
           cons.close();
       } catch (SQLException ex)
       {
           Logger.getLogger(qlGiaovien.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jname = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jdes = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jid = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jsex = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jsta = new javax.swing.JTextField();
        jphone = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jbirth = new javax.swing.JTextField();
        jbase = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        find = new javax.swing.JButton();
        insert = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        Refresh = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ GIÁO VIÊN");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "ID", "Họ và tên", "Giới tính", "Ngày sinh", "SĐT", "Gmail", "Mô tả", "Lương", "Trạng thái"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Họ và tên");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Mô tả");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("ID");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Giới tính");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Trạng thái");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("SĐT");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Lương");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Ngày sinh");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Gmail");

        find.setText("Tìm kiếm");
        find.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(31, 31, 31)
                                .addComponent(jsex, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(22, 22, 22)
                                .addComponent(jname, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(53, 53, 53)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jphone, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                                    .addComponent(jbirth)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(44, 44, 44)
                                        .addComponent(jmail, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jid, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addComponent(jLabel8)))
                    .addComponent(jLabel5))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jsta, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdes, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbase, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(find, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jid, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(find))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jdes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jsex, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel9)
                    .addComponent(jsta, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbirth, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel11)
                    .addComponent(jbase, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jphone, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jmail, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(jLabel7))
                .addContainerGap())
        );

        insert.setText("Thêm");
        insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertActionPerformed(evt);
            }
        });

        update.setText("Sửa");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        delete.setText("Xóa");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        Refresh.setText("Refresh");
        Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(insert, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(164, 164, 164)
                                .addComponent(Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGap(174, 174, 174))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insert)
                    .addComponent(update)
                    .addComponent(delete)
                    .addComponent(Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void RefreshActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_RefreshActionPerformed
    {//GEN-HEADEREND:event_RefreshActionPerformed
       stt = 0;
       tb1.setRowCount(0);
       
       try
       {
           Connection cons = DNConnect.connected();
           Statement st = cons.createStatement();
           String sql = "select * from information_lecturer";
           ResultSet rs = st.executeQuery(sql);
           while(rs.next()){
               String id = rs.getString("id_lecturer");
               String name = rs.getString("name_lecturer");
               String sex = rs.getString("sex_lecturer");
               String birth = rs.getString("birthday_lecturer");
               String phone = rs.getString("phone_lecturer");
               String gmail = rs.getString("gmail_lecturer");
               String sta = rs.getString("status_lecturer");
               String base = rs.getString("basesalary_lecturer");
               String des = rs.getString("describe_lecturer");
               stt++;
               String STT = String.valueOf(stt);
               
               tb1.addRow(new String[]{STT,id,name,sex,birth,phone,gmail,des,base,sta});
               
            }
           cons.close();
       } catch (SQLException ex)
       {
           Logger.getLogger(qlGiaovien.class.getName()).log(Level.SEVERE, null, ex);
       }
       
    }//GEN-LAST:event_RefreshActionPerformed

    private void findActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_findActionPerformed
    {//GEN-HEADEREND:event_findActionPerformed
        stt = 0;
        tb1.setRowCount(0);
        
        String find = jid.getText();
        if(find.equals("")){
            JOptionPane.showMessageDialog(null, "Chưa nhập ID");
        }else{
        try
       {
           Connection cons = DNConnect.connected();
           Statement st = cons.createStatement();
           String sql = "select * from information_lecturer";
           ResultSet rs = st.executeQuery(sql);
           while(rs.next()){
               
               String id = rs.getString("id_lecturer");
               String name = rs.getString("name_lecturer");
               String sex = rs.getString("sex_lecturer");
               String birth = rs.getString("birthday_lecturer");
               String phone = rs.getString("phone_lecturer");
               String gmail = rs.getString("gmail_lecturer");
               String sta = rs.getString("status_lecturer");
               String base = rs.getString("basesalary_lecturer");
               String des = rs.getString("describe_lecturer");
               
               if(id.equals(find)){
               stt++;
               String STT = String.valueOf(stt);
               
               tb1.addRow(new String[]{STT,id,name,sex,birth,phone,gmail,des,base,sta});
               
               jname.setText(name);
               jsex.setText(sex);
               jbirth.setText(birth);
               jphone.setText(phone);
               jmail.setText(gmail);
               jsta.setText(sta);
               jbase.setText(base);
               jdes.setText(des);
               }
            }
           if(tb1.getRowCount()==0){
               JOptionPane.showMessageDialog(null, "Không tìm thấy");
           }
           cons.close();
       } catch (SQLException ex)
       {
           Logger.getLogger(qlGiaovien.class.getName()).log(Level.SEVERE, null, ex);
       }
       }
    }//GEN-LAST:event_findActionPerformed

    private void insertActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_insertActionPerformed
    {//GEN-HEADEREND:event_insertActionPerformed
        String name = jname.getText();
        String sex = jsex.getText();
        String date = jbirth.getText();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String phone = jphone.getText();
        String gmail = jmail.getText();
        String sta = jsta.getText();
        String base = jbase.getText();
        String des = jdes.getText();
        //Truong hop de trong
        if(name.equals("")||sex.equals("")||date.equals("")||phone.equals("")||
                gmail.equals("")||sta.equals("")||base.equals("")||des.equals(""))
        {
        JOptionPane.showMessageDialog(null, "Nhập thiếu thông tin");
        }else{
        //Xu ly them thong tin
        try
        {
            int check = 0;
           java.util.Date jdate = sdf.parse(date);
           java.sql.Date birth = new java.sql.Date(jdate.getTime());
           Connection cons = DNConnect.connected();
           String sql1 = "select * from information_lecturer";
           Statement st1 = cons.createStatement();
           ResultSet rs = st1.executeQuery(sql1);
           while(rs.next()){
               String name1 = rs.getString("name_lecturer");
               String sex1 = rs.getString("sex_lecturer");
               String phone1 = rs.getString("phone_lecturer");
               String gmail1 = rs.getString("gmail_lecturer");
               if(name1.equals(name)&&sex1.equals(sex)||phone1.equals(phone)||gmail1.equals(gmail)){
                   check++;
               }
           }
           if(check!=0){
               JOptionPane.showMessageDialog(null, "Giáo viên thêm vào bị trùng");
           }else{   
           PreparedStatement st = null;
           String sql = "insert into information_lecturer (name_lecturer,sex_lecturer,birthday_lecturer,"
                   + "phone_lecturer,gmail_lecturer,describe_lecturer,basesalary_lecturer,status_lecturer)"
                   + "value(?,?,?,?,?,?,?,?) ";
           st = cons.prepareStatement(sql);
           st.setString(1, name);
           st.setString(2, sex);
           st.setDate(3, birth);
           st.setString(4, phone);
           st.setString(5, gmail);
           st.setString(6, des);
           st.setString(7, base);
           st.setString(8, sta);
           st.execute();
           JOptionPane.showMessageDialog(null, "Thêm thành công");
           jname.setText("");
           jsex.setText("");
           jbirth.setText("");
           jphone.setText("");
           jmail.setText("");
           jdes.setText("");
           jbase.setText("");
           jsta.setText("");
           }
           
       } catch (SQLException | ParseException ex)
       {
           JOptionPane.showMessageDialog(null,"Thêm thất bại, xem lại định dạng ngày tháng");
       }
       
       }
       
    }//GEN-LAST:event_insertActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_deleteActionPerformed
    {//GEN-HEADEREND:event_deleteActionPerformed
        int id = Integer.valueOf(jid.getText());
        try
        {
            Connection cons = DNConnect.connected();
            Statement st = cons.createStatement();
            String sql = "delete from information_lecturer where id_lecturer ="+id+"";
            st.executeUpdate(sql);
            
            JOptionPane.showMessageDialog(null, "Xóa thành công");
            cons.close();
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Xóa thất bại");
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_updateActionPerformed
    {//GEN-HEADEREND:event_updateActionPerformed
        int id = Integer.valueOf(jid.getText());
        String name = jname.getText();
        String sex = jsex.getText();
        String date = jbirth.getText();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String phone = jphone.getText();
        String gmail = jmail.getText();
        String sta = jsta.getText();
        String base = jbase.getText();
        String des = jdes.getText();
        //Truong hop de trong
        if(name.equals("")||sex.equals("")||date.equals("")||phone.equals("")||
                gmail.equals("")||sta.equals("")||base.equals("")||des.equals(""))
        {
        JOptionPane.showMessageDialog(null, "Nhập thiếu thông tin");
        }else{
        //Xu ly sua thong tin
        try
        {
            java.util.Date jdate = sdf.parse(date);
            java.sql.Date birth = new java.sql.Date(jdate.getTime());
            Connection cons = DNConnect.connected();
            PreparedStatement st = null;
            String sql = "update information_lecturer set name_lecturer=?,sex_lecturer=?,birthday_lecturer=?,"
                   + "phone_lecturer=?,gmail_lecturer=?,describe_lecturer=?,basesalary_lecturer=?,status_lecturer=?"
                    + "where id_lecturer="+id+"";
                   
            st = cons.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, sex);
            st.setDate(3, birth);
            st.setString(4, phone);
            st.setString(5, gmail);
            st.setString(6, des);
            st.setString(7, base);
            st.setString(8, sta);
            
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Sửa thành công");
            
            } catch (SQLException | ParseException ex)
            {
            JOptionPane.showMessageDialog(null,"Sửa thất bại, xem lại định dạng ngày tháng");
            }
            }
    }//GEN-LAST:event_updateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Refresh;
    private javax.swing.JButton delete;
    private javax.swing.JButton find;
    private javax.swing.JButton insert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jbase;
    private javax.swing.JTextField jbirth;
    private javax.swing.JTextField jdes;
    private javax.swing.JTextField jid;
    private javax.swing.JTextField jmail;
    private javax.swing.JTextField jname;
    private javax.swing.JTextField jphone;
    private javax.swing.JTextField jsex;
    private javax.swing.JTextField jsta;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
