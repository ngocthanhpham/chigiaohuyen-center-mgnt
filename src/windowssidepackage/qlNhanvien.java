/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windowssidepackage;

import menu.Themtaikhoan;
import menu.qlThongtintaikhoan;
import QLTrungtam.DNConnect;
import static QLTrungtam.DNConnect.connected;
import QLTrungtam.Staff;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.IOException;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
/**
 *
 * @author admin
 */
public class qlNhanvien extends javax.swing.JPanel {

    /**
     * Creates new form qlNhanvien
     */
    private String username_staff;
    private String password_staff;
    private int type_staff;
    private static int id_staff;
    private String name_staff;
    private String sex_staff;
    private java.sql.Date birth_staff;
    private String phone_staff;
    private String gmail_staff;
    private String position_staff;
    private int basesalary_staff;
    private String status_staff;
    private static int stt = 0;
    Vector  vtHeader;
    Vector vtData;
   
   String tdate = java.time.LocalDate.now().toString();
        // create workbook
        String fileName = "Danh sach nhan vien ngay "+tdate+".xls";
        String []Catologue = {"STT", "ID", "Name", "Sex",
                          "Birth", "Phone","Gmail","Position","Salary","Status"};
   
   
    public qlNhanvien() {
        stt = 0;
        initComponents();
        creatDataTable();
        
        /*creatHeaderTable();*/
    } 
    
    int getMaxId(){ 
        int maxid = 0;
        try {
            String str3 = "CALL getMaxId(?);";
            CallableStatement cs3 = connected().prepareCall(str3);
            cs3.registerOutParameter(1, Types.INTEGER);
            cs3.execute();
            maxid = cs3.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(qlNhanvien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maxid;
    }
    
    void creatDataTable(){
        vtHeader = new Vector();
        vtData = new Vector();
        for(int id =20200000; id<= getMaxId(); id++){
            if(DNConnect.checkId(id) == 1)
            {
                creatDataRow(id);
            }
        }
        creatHeaderTable();
        jTable1.setModel(new DefaultTableModel(vtData,vtHeader));
    }
    void creatHeaderTable(){
        vtHeader.add("STT");
        vtHeader.add("ID");
        vtHeader.add("Name");
        vtHeader.add("User");
        vtHeader.add("Password");
        vtHeader.add("Type");
        vtHeader.add("Sex");
        vtHeader.add("Birth");
        vtHeader.add("Phone");
        vtHeader.add("Gmail");
        vtHeader.add("Position"); 
        vtHeader.add("Salary");
        vtHeader.add("Status");
    }
    void creatDataRow(int id){
        Staff staff = new Staff(id);
        id_staff = staff.getIdstaff();
        name_staff = staff.getNamestaff();
        username_staff = staff.getUsernamestaff();
        password_staff = staff.getPasswordstaff();
        type_staff = staff.getAccType();
        sex_staff = staff.getSexstaff();
        birth_staff = staff.getBirthstaff();
        phone_staff = staff.getPhonestaff();
        gmail_staff = staff.getGmailstaff();
        position_staff = staff.getPositionstaff();
        basesalary_staff = staff.getBasesalary_staff();
        status_staff = staff.getStatusstaff();
        
        Vector vtRow = new Vector();
        stt++;
        vtRow.add(stt);
        vtRow.add(id_staff);
        vtRow.add(name_staff);
        vtRow.add(username_staff);
        vtRow.add(password_staff);
        vtRow.add(type_staff);
        vtRow.add(sex_staff);
        vtRow.add(birth_staff);
        vtRow.add(phone_staff);
        vtRow.add(gmail_staff);
        vtRow.add(position_staff);
        vtRow.add(basesalary_staff);
        vtRow.add(status_staff);
        vtData.add(vtRow);
    }
    
     void creatFileExcel(){
        try {
            WritableWorkbook workbook = Workbook.createWorkbook(new File(fileName));
            // create sheet
            WritableSheet sheet1 = workbook.createSheet("KH1", 0);
            sheet1.addCell(new Label(0, 0, "BẢNG THÔNG TIN NHÂN VIÊN"));
            // row begin write data
            for(int i=0;i<Catologue.length;i++){
                sheet1.addCell(new Label(i,3,Catologue[i]));
            }
            // write and close file
            workbook.write();
            workbook.close();
        } catch (IOException e) {
            System.out.println("Error create file\n" + e.toString());
        } catch (RowsExceededException e) {
            System.out.println("Error write file\n" + e.toString());
        } catch (WriteException e) {
            System.out.println("Error write file\n" + e.toString());
        }
        System.out.println("create and write success");
    }
     static int stt_new = 0;
     void writeFileExcel(){
        try {
            stt_new=0;
            // open file
            Workbook workbook = Workbook.getWorkbook(new File(fileName));
            // create file copy of root file to write file
            WritableWorkbook writeWorkbook = Workbook.createWorkbook(new File(fileName),
                    workbook);
            // get sheet to write
            WritableSheet sheet1 = writeWorkbook.getSheet(0);
            int rowMax =  sheet1.getRows();
            int colMax = sheet1.getColumns();
            
            // write data (formula)
            for(int id =20200000; id<= getMaxId(); id++){
            if(DNConnect.checkId(id) == 1)
            {
                stt_new++;
                creatDataRow(id);
                rowMax++;
                sheet1.addCell(new Label(0,rowMax,String.valueOf(stt_new)));
                sheet1.addCell(new Label(1,rowMax,String.valueOf(id_staff)));
                sheet1.addCell(new Label(2,rowMax,String.valueOf(name_staff)));
                sheet1.addCell(new Label(3,rowMax,String.valueOf(sex_staff)));
                sheet1.addCell(new Label(4,rowMax,String.valueOf(birth_staff)));
                sheet1.addCell(new Label(5,rowMax, phone_staff ));
                sheet1.addCell(new Label(6,rowMax, gmail_staff ));
                sheet1.addCell(new Label(7,rowMax, position_staff ));
                sheet1.addCell(new Label(8,rowMax,String.valueOf(basesalary_staff)));
                sheet1.addCell(new Label(9,rowMax, status_staff ));
                
                }
            }
            writeWorkbook.write();
            // close
            writeWorkbook.close();
             JOptionPane.showMessageDialog( null,"Xuất file thành công");
        } catch (IOException | WriteException | BiffException e) {
             JOptionPane.showMessageDialog( null,"ERROR: File excel đang được sử dụng");;
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setAutoscrolls(true);
        setEnabled(false);
        setPreferredSize(new java.awt.Dimension(927, 560));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản lý nhân viên");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12", "Title 13"
            }
        ));
        jTable1.setEnabled(false);
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nhập ID");

        jButton1.setText("Sửa");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setText("Xóa");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton3.setText("Thêm");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(51, 255, 0));
        jButton4.setText("Export Excel");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 872, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(90, 90, 90))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(13, 13, 13))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
        );

        jButton1.getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        if(!jTextField1.getText().isEmpty()){
            int id = Integer.valueOf(jTextField1.getText());
            if(DNConnect.checkId(id)== 1)
            {
                qlThongtintaikhoan qltttk = new qlThongtintaikhoan(id);
                qltttk.setVisible(true);
            }
            else JOptionPane.showMessageDialog( null,"ID không tồn tại");
        }
        else{
            JOptionPane.showMessageDialog( null,"Cần nhập ID nhân viên");
            
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
          Themtaikhoan ttk = new Themtaikhoan();
          ttk.setVisible(true);
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        //TODO add your handling code here:
        if(!jTextField1.getText().isEmpty())
        {
            int id = Integer.valueOf(jTextField1.getText());
            if(DNConnect.checkId(id)== 1)
            {
                    
                try {
                    String str = "CALL deleteStaff("+ id +");";
                    CallableStatement cs = connected().prepareCall(str);
                    cs.execute();
                    if(DNConnect.checkId(id)== 0){JOptionPane.showMessageDialog( null,"Xóa thành công");}
                    else { JOptionPane.showMessageDialog( null,"Xóa thất bại"); }
                } catch (SQLException ex) {
                    Logger.getLogger(qlNhanvien.class.getName()).log(Level.SEVERE, null, ex);
                }
                     
        } else JOptionPane.showMessageDialog( null,"ID không tồn tại");
            
         DNConnect.disConnection();
    }
    else{
        JOptionPane.showMessageDialog(null,"Cần nhập ID nhân viên");
            
        }
        
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
        creatFileExcel();
        writeFileExcel();
    }//GEN-LAST:event_jButton4MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
