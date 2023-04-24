
package windowssidepackage;


import QLTrungtam.DNConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class qlHocvien extends javax.swing.JPanel {
    int stt;
    DefaultTableModel tb1 = new DefaultTableModel();
    int id;
    String name;
    int idclass;
    String gmail,phone,status;
    public qlHocvien() {
        stt = 0;
        initComponents();
        tb1 = (DefaultTableModel) jTable1.getModel();
        tb1.setRowCount(0);
        try{
            Connection cons = DNConnect.connected();
            Statement st = cons.createStatement();
            String sql = "select * from information_student";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                
                String ID = rs.getString("id_student");
                name = rs.getString("name_student");
                String IDclass = rs.getString("id_class");
                phone = rs.getString("phone_student");
                gmail = rs.getString("gmail_student");
                status = rs.getString("status_student");
                tb1.addRow(new String[]{ID,name,IDclass,phone,gmail,status});
            }
            cons.close();
        }catch(Exception e){
            
        }
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        update = new javax.swing.JButton();
        jgmail = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        refresh = new javax.swing.JButton();
        jid = new javax.swing.JTextField();
        Find = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jidclass = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Insert = new javax.swing.JButton();
        jstatus = new javax.swing.JTextField();
        delete = new javax.swing.JButton();
        jphone = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jfind = new javax.swing.JTextField();

        update.setText("Sửa");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText(" ID");

        refresh.setText("Refresh");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        Find.setText("Tìm kiếm");
        Find.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FindActionPerformed(evt);
            }
        });

        jLabel3.setText("Tên");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("ID lớp học");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("SĐT");

        jLabel6.setText("Gmail");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ HỌC VIÊN");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên", "ID Lớp học", "SĐT", "Gmail", "Trạng thái"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        Insert.setText("Thêm");
        Insert.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InsertMouseClicked(evt);
            }
        });
        Insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertActionPerformed(evt);
            }
        });

        delete.setText("Xóa");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        jLabel7.setText("Trạng thái");

        jLabel8.setText("Nhập tên hoặc ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jfind)
                        .addGap(588, 588, 588))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(160, 160, 160))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jidclass, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jid, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jphone, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(80, 80, 80)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel3)
                                                    .addComponent(jLabel6))
                                                .addGap(34, 34, 34)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jname, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jgmail, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(Find, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(199, 199, 199))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(697, 697, 697)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(refresh, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                    .addComponent(update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Insert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jfind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Find))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Insert))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jidclass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jgmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete))
                .addGap(18, 18, 18)
                .addComponent(refresh)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                .addGap(100, 100, 100))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void InsertMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_InsertMouseClicked
    {//GEN-HEADEREND:event_InsertMouseClicked
       
    }//GEN-LAST:event_InsertMouseClicked

    private void InsertActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_InsertActionPerformed
    {//GEN-HEADEREND:event_InsertActionPerformed
        int check =0;
        int check1=0;
        
        name = jname.getText();
        idclass = Integer.valueOf(jidclass.getText());
        String idcla = jidclass.getText();
        phone = jphone.getText();
        gmail = jgmail.getText();
        status = jstatus.getText();
        if(name.equals("")||idcla.equals("")||phone.equals("")||gmail.equals("")||status.equals("")){
            JOptionPane.showMessageDialog(null, "Không được để trống");
        }else{
        try{
            Connection cons = DNConnect.connected();
            Statement st1 = cons.createStatement();
            String sql1 = "select * from information_class";
            ResultSet rs1 = st1.executeQuery(sql1);
            while(rs1.next()){
                int IDclass = rs1.getInt("id_class");
                if(IDclass==idclass){
                    check++;
                }
            }
            if(check==0){
                JOptionPane.showMessageDialog(null, "Lớp không tồn tại");
            }else{
                
                String sql2 = "select * from information_student";
                ResultSet rs2 = st1.executeQuery(sql2);
                while(rs2.next()){
                    String name1 = rs2.getString("name_student");
                    String phone1 = rs2.getString("phone_student");
                    int id_class_std = rs2.getInt("id_class");
                    if(id_class_std==idclass && name1.equals(name) && phone1.equals(phone)){
                        check1++;
                    }
                }
                if(check1!=0){
                    JOptionPane.showMessageDialog(null, "Học viên bị trùng");
                }else{
                    PreparedStatement st = null;
                    String sql = "insert into information_student (name_student,id_class,phone_student,"
                    + "gmail_student,status_student) value (?,?,?,?,?)";
                    st=cons.prepareStatement(sql);
                    st.setString(1, name);
                    st.setInt(2, idclass);
                    st.setString(3, phone);
                    st.setString(4, gmail);
                    st.setString(5, status);
                    
                    st.execute();
                    JOptionPane.showMessageDialog(null, "Thêm thành công");
                    
                    jname.setText("");
                    jidclass.setText("");
                    jphone.setText("");
                    jstatus.setText("");
                    jgmail.setText("");
                    
                }
            }
            cons.close();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Thêm thất bại");
        }
        }
    }//GEN-LAST:event_InsertActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_refreshActionPerformed
    {//GEN-HEADEREND:event_refreshActionPerformed
        stt = 0;
        tb1.setRowCount(0);
        try{
            Connection cons = DNConnect.connected();
            Statement st = cons.createStatement();
            String sql = "select * from information_student";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                
                String ID = rs.getString("id_student");
                name = rs.getString("name_student");
                String IDclass = rs.getString("id_class");
                phone = rs.getString("phone_student");
                gmail = rs.getString("gmail_student");
                status = rs.getString("status_student");
                tb1.addRow(new String[]{ID,name,IDclass,phone,gmail,status});
            }
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_refreshActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_deleteActionPerformed
    {//GEN-HEADEREND:event_deleteActionPerformed
        
        String ID = jid.getText();
        Connection cons = DNConnect.connected();
        if(ID.equals("")){
            JOptionPane.showMessageDialog(null, "Không để trống id");
        }else{
            int id1 = Integer.valueOf(jid.getText());
            try{
                Statement st = cons.createStatement();
                String sql = "delete from information_student where id_student="+id1+"";
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Xóa thành công");
                cons.close();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Xóa thất bại");
            }      
        }
        
    }//GEN-LAST:event_deleteActionPerformed

    private void FindActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_FindActionPerformed
    {//GEN-HEADEREND:event_FindActionPerformed
        int check =0;
        tb1.setRowCount(0);
        String find = jfind.getText();
        if(find.equals("")){
            JOptionPane.showMessageDialog(null, "Cần nhập thông tin tìm kiếm");
        }else{
        Connection cons = DNConnect.connected();
        try{
            Statement st = cons.createStatement();
            String sql ="select * from information_student";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                String ID = rs.getString("id_student");
                name = rs.getString("name_student");
                String IDclass = rs.getString("id_class");
                phone = rs.getString("phone_student");
                gmail = rs.getString("gmail_student");
                status = rs.getString("status_student");
                if(name.equals(find)||ID.equals(find)){
                    
                    tb1.addRow(new String[]{ID,name,IDclass,phone,gmail,status});
                    check++;
                    jid.setText(ID);
                    jname.setText(name);
                    jidclass.setText(IDclass);
                    jphone.setText(phone);
                    jgmail.setText(gmail);
                    jstatus.setText(status);
                }
            }
            if(check==0){
                JOptionPane.showMessageDialog(null, "Không tìm thấy");
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Không tìm thấy");
        }
        }      
    }//GEN-LAST:event_FindActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_updateActionPerformed
    {//GEN-HEADEREND:event_updateActionPerformed
        int check =0;
        id = Integer.valueOf(jid.getText());
        name = jname.getText();
        idclass = Integer.valueOf(jidclass.getText());
        String idcla = jidclass.getText();
        phone = jphone.getText();
        gmail = jgmail.getText();
        status = jstatus.getText();
        if(name.equals("")||idcla.equals("")||phone.equals("")||gmail.equals("")||status.equals("")){
            JOptionPane.showMessageDialog(null, "Không được để trống");
        }else{
        try{
            Connection cons = DNConnect.connected();
            Statement st1 = cons.createStatement();
            String sql1 = "select * from information_class";
            ResultSet rs1 = st1.executeQuery(sql1);
            while(rs1.next()){
                int IDclass = rs1.getInt("id_class");
                if(IDclass==idclass){
                    check++;
                }
            }
            if(check==0){
                JOptionPane.showMessageDialog(null, "Lớp không tồn tại");
            }else{
                    PreparedStatement st = null;
                    String sql = "update information_student set name_student=?,id_class=?,phone_student=?,"
                    + "gmail_student=?,status_student=? where id_student ="+id+"";
                    st=cons.prepareStatement(sql);
                    st.setString(1, name);
                    st.setInt(2, idclass);
                    st.setString(3, phone);
                    st.setString(4, gmail);
                    st.setString(5, status);
                    
                    st.execute();
                    JOptionPane.showMessageDialog(null, "Sửa thành công");
                    
                
            }
            cons.close();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Sửa thất bại");
        }
        }
    }//GEN-LAST:event_updateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Find;
    private javax.swing.JButton Insert;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jfind;
    private javax.swing.JTextField jgmail;
    private javax.swing.JTextField jid;
    private javax.swing.JTextField jidclass;
    private javax.swing.JTextField jname;
    private javax.swing.JTextField jphone;
    private javax.swing.JTextField jstatus;
    private javax.swing.JButton refresh;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables

    private void InsertActionPerformed()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
