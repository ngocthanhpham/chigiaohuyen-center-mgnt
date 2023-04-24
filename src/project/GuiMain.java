package project;

import calculator.CalculatorGUI;
import menu.Note_date;
import menu.Themtaikhoan;
import menu.qlThongtintaikhoan;
import QLTrungtam.SendMailOK;
import dangnhap.Dangnhap;
import QLTrungtam.Staff;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.filechooser.FileNameExtensionFilter;
import windowssidepackage.*;

/**
 *
 * @author admin
 */
public final class GuiMain extends JFrame {

    private GroupLayout layout;
    public static JPanel selectedScr;
    private JPanel jstack;
    private JPanel jPanel01, jPanel03, btnHomeScr, btnMgmtStudent, btnMgmtTeacher, btnMgmtClass;
    private JPanel btnMgmtStaff, btnMgmtRevenue, btnDataStatistic, btnCreateBill, jPanel021;
    private JPanel jPanel023, jPanel025;

    private JPanel jpHomeScr, btnMgmtCourse, btnMgmtRoom, btnMailBox, jPanel010, jPanel2;
    private JPanel jPanel3, jPanel4, jPanel7;
    private JLabel jLabel3, jLabel5, jLabel7, jLabel9, jLabel11;
    private JLabel jLabel13, jLabel15, jLabel17, jLabel19, jLabel21, jLabel23, jLabel25;
    private JLabel jLabel4, jLabel6, jLabel8, jLabel10, jLabel40, jLabel60, jLabel80;
    private final int totalCourseNum = 0;
    private final int totalStuNum = 0;
    private int totalMailNum = 0;
    private String nameAccount = " ";
    private final int idStaff = Dangnhap.getIddangnhap();
    static String filePath;
    private JMenu jMenu1, jMenu3, jMenu5, jMenu51, jMenu52, jMenu7, jMenu71, jMenu72, jMenu9;
    private JMenuBar jMenuBar1;
    List<JPanel> listDanhMuc;
    List<JMenu> listMenu;
    private static int x = 0;
    private static int y = 0;
    int accType = 0;

    public static int getWidthFrame() {
        return x;
    }

    public static int getHeightFrame() {
        return y;
    }

    public GuiMain() {
        Staff stf = new Staff(idStaff);
        accType = stf.getAccType();
        System.out.println(accType);
        nameAccount = stf.getNamestaff();
        SendMailOK sm = new SendMailOK();
        totalMailNum = sm.getTotalMailNumber();
        Gui_Header();
        GuiMain_Init();
        GuiMain_Image();
        jstack = jpHomeScr;
        listDanhMuc = new ArrayList<>();
        listDanhMuc.add(btnHomeScr);
        listDanhMuc.add(btnMgmtStudent);
        listDanhMuc.add(btnMgmtTeacher);
        listDanhMuc.add(btnMgmtClass);
        listDanhMuc.add(btnMgmtStaff);
        listDanhMuc.add(btnMgmtRevenue);
        listDanhMuc.add(btnDataStatistic);
        listDanhMuc.add(btnCreateBill);
        listDanhMuc.add(btnMgmtCourse);
        listDanhMuc.add(btnMgmtRoom);
        listDanhMuc.add(btnMailBox);
        setEvent(listDanhMuc);

        listMenu = new ArrayList<>();
        listMenu.add(jMenu3);
        listMenu.add(jMenu5);
        listMenu.add(jMenu51);
        listMenu.add(jMenu52);
        listMenu.add(jMenu7);
        listMenu.add(jMenu71);
        listMenu.add(jMenu72);
        listMenu.add(jMenu9);
        msetEvent(listMenu);

//        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
//       setResizable(false);
    }

    Boolean setWorking(JPanel jPanel) {
        if (accType == 2) {
            if (jPanel == btnMgmtRevenue || jPanel == btnDataStatistic || jPanel == btnCreateBill) {
                jPanel.setOpaque(false);
                return false;
            }
        }
        return true;
    }

    Boolean msetWorking(JMenu jMenu) {
        /* if( jPanel == jPanel07||jPanel == jPanel09){
            jPanel.setOpaque(false);
            return false;
        }*/
        return true;
    }

    void Gui_Header() {
        jMenuBar1 = new JMenuBar();
        jMenuBar1.setPreferredSize(new java.awt.Dimension(1300, 35));
        setJMenuBar(jMenuBar1);

        jMenu1 = new JMenu();
        jMenu1.setText(" " + nameAccount);
        jMenu1.setPreferredSize(new java.awt.Dimension(250, 35));
        jMenu1.setFont(new java.awt.Font("Segoe UI", 2, 20));
        jMenuBar1.add(jMenu1);

        jMenu3 = new JMenu();
        jMenu3.setText("Thông tin tài khoản");
        jMenu3.setPreferredSize(new java.awt.Dimension(250, 35));
        jMenu3.setFont(new java.awt.Font("Segoe UI", 2, 15));
        jMenu1.add(jMenu3);

        jMenu5 = new JMenu();
        jMenu5.setText("Tiện ích mở rộng");
        jMenu5.setPreferredSize(new java.awt.Dimension(250, 35));
        jMenu5.setFont(new java.awt.Font("Segoe UI", 2, 15));
        jMenu1.add(jMenu5);

        jMenu51 = new JMenu();
        jMenu51.setText("Ghi chú công việc");
        jMenu51.setPreferredSize(new java.awt.Dimension(250, 35));
        jMenu51.setFont(new java.awt.Font("Segoe UI", 2, 15));
        jMenu5.add(jMenu51);

        jMenu52 = new JMenu();
        jMenu52.setText("Máy tính");
        jMenu52.setPreferredSize(new java.awt.Dimension(250, 35));
        jMenu52.setFont(new java.awt.Font("Segoe UI", 2, 15));
        jMenu5.add(jMenu52);

        jMenu7 = new JMenu();
        jMenu7.setText("Cài đặt");
        jMenu7.setPreferredSize(new java.awt.Dimension(250, 35));
        jMenu7.setFont(new java.awt.Font("Segoe UI", 2, 15));
        jMenu1.add(jMenu7);

        jMenu71 = new JMenu();
        jMenu71.setText("Hình nền");
        jMenu71.setPreferredSize(new java.awt.Dimension(250, 35));
        jMenu71.setFont(new java.awt.Font("Segoe UI", 2, 15));
        jMenu7.add(jMenu71);

        jMenu72 = new JMenu();
        jMenu72.setText("Chưa hỗ trợ");
        jMenu72.setPreferredSize(new java.awt.Dimension(250, 35));
        jMenu72.setFont(new java.awt.Font("Segoe UI", 2, 15));
        jMenu7.add(jMenu72);

        jMenu9 = new JMenu();
        jMenu9.setText("Đăng xuất");
        jMenu9.setPreferredSize(new java.awt.Dimension(250, 35));
        jMenu9.setFont(new java.awt.Font("Segoe UI", 2, 15));
        jMenu1.add(jMenu9);

    }

    void GuiMain_Image() {
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/home .png")));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/student.png")));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/teacher1.png")));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/class.png")));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/team1.png")));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/money.png")));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/diagrampng.png")));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/course.png")));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/other.png")));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/lesson2.png")));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/room.png")));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/gmail1.png")));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/background/main.png")));
        BufferedImage image;
        try {
            File file = new File(".");
            String s = file.getAbsolutePath();
            filePath = s.substring(0, s.length() - 1);
            image = ImageIO.read(new File(filePath + "\\src\\Image\\background\\main.png"));
            ImageIcon icon = new ImageIcon(image.getScaledInstance(x * 3 / 4 - x / 25, y * 487 / 660, image.SCALE_SMOOTH));
            jLabel10.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(GuiMain.class.getName()).log(Level.SEVERE, null, ex);
        }

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/user.png")));
    }

    void GuiMain_Init() {
        /**
         * ****************************** label left ********************************
         */
// <editor-fold defaultstate="collapsed" desc="Generated Code">  

        this.setTitle("Phần mềm quản lý lớp tiếng Trung Chị Giáo Huyền");
        this.setBounds(0, 0, 1370, 730);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        x = this.getWidth();
        y = this.getHeight();
        jstack = new JPanel();

        jLabel3 = new JLabel("LỚP TIẾNG TRUNG CHỊ GIÁO HUYỀN");
        jLabel3.setFont(new Font(Font.SERIF, Font.BOLD, 25));
        jLabel3.setForeground(Color.WHITE);

        /*  jLabel30 = new JLabel();
        jLabel30.setText("Chào, " + nameAccount);
        jLabel30.setFont(new Font(Font.SERIF, Font.BOLD,  20));
        jLabel30.setForeground(Color.WHITE);*/
        jLabel5 = new JLabel("   MÀN HÌNH CHÍNH");
        jLabel5.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        jLabel5.setForeground(Color.WHITE);

        jLabel7 = new JLabel("   QUẢN LÝ HỌC VIÊN");
        jLabel7.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        jLabel7.setForeground(Color.WHITE);

        jLabel9 = new JLabel("   QUẢN LÝ GIÁO VIÊN");
        jLabel9.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        jLabel9.setForeground(Color.WHITE);

        jLabel11 = new JLabel("   QUẢN LÝ LỚP HỌC");
        jLabel11.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        jLabel11.setForeground(Color.WHITE);

        jLabel13 = new JLabel("  QUẢN LÝ NHÂN VIÊN");
        jLabel13.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        jLabel13.setForeground(Color.WHITE);

        jLabel15 = new JLabel("   QUẢN LÝ THU CHI");
        jLabel15.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        jLabel15.setForeground(Color.WHITE);

        jLabel17 = new JLabel("   THỐNG KÊ DỮ LIỆU");
        jLabel17.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        jLabel17.setForeground(Color.WHITE);

        jLabel19 = new JLabel("   TẠO LẬP HÓA ĐƠN");
        jLabel19.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        jLabel19.setForeground(Color.WHITE);

        jLabel21 = new JLabel("   TRỐNG");
        jLabel21.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        jLabel21.setForeground(Color.WHITE);

        jLabel23 = new JLabel("   TRỐNG");
        jLabel23.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        jLabel23.setForeground(Color.WHITE);

        jLabel25 = new JLabel("   TRỐNG");
        jLabel25.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        jLabel25.setForeground(Color.WHITE);
        // </editor-fold>  
        /**
         * ***************************** label right *******************************
         */
        // <editor-fold defaultstate="collapsed" desc="Generated Code">  

        jLabel4 = new JLabel("   KHÓA HỌC");
        jLabel4.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        jLabel4.setForeground(Color.WHITE);

        jLabel40 = new JLabel();
        jLabel40.setFont(new Font(Font.SERIF, Font.BOLD, 25));
        jLabel40.setForeground(Color.WHITE);
        jLabel40.setText(String.valueOf(totalCourseNum));

        jLabel6 = new JLabel("    PHÒNG HỌC");
        jLabel6.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        jLabel6.setForeground(Color.WHITE);

        jLabel60 = new JLabel();
        jLabel60.setFont(new Font(Font.SERIF, Font.BOLD, 25));
        jLabel60.setForeground(Color.WHITE);
        jLabel60.setText(String.valueOf(totalStuNum));

        jLabel8 = new JLabel("   HỘP THƯ");
        jLabel8.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        jLabel8.setForeground(Color.WHITE);

        jLabel80 = new JLabel();
        jLabel80.setFont(new Font(Font.SERIF, Font.BOLD, 25));
        jLabel80.setForeground(Color.WHITE);
        jLabel80.setText(String.valueOf(totalMailNum));

        jLabel10 = new JLabel(/*"LỚP TIẾNG TRUNG CHỊ GIÁO HUYỀN "
                + "CÙNG BẠN VƯƠN TỚI TƯƠNG LAI"*/);
        jLabel10.setFont(new Font(Font.SERIF, Font.BOLD, 15));
        jLabel10.setForeground(Color.magenta);

        // </editor-fold>  
        /**
         * ****************************** GROUP LAYOUT RIGHT ************************
         */
        // <editor-fold defaultstate="collapsed" desc="Generated Code">
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        jPanel7 = new JPanel();
        jPanel4 = new JPanel();

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(x / 4)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(y / 8)
        );

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));

        GroupLayout jPanel7Layout = new GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
                jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
                jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel7, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(134, 134, 134)
                                .addComponent(jPanel7, GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
// </editor-fold> 
        // <editor-fold defaultstate="collapsed" desc="Generated Code">
        jpHomeScr = new JPanel();
        btnMgmtCourse = new JPanel();
        btnMgmtRoom = new JPanel();
        btnMailBox = new JPanel();
        jPanel010 = new JPanel();
        GroupLayout jPanel04Layout = new GroupLayout(btnMgmtCourse);
        btnMgmtCourse.setLayout(jPanel04Layout);
        jPanel04Layout.setHorizontalGroup(
                jPanel04Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel04Layout.createSequentialGroup()
                                .addGap(x / 50)
                                .addComponent(jLabel4)
                        )
                        .addGroup(jPanel04Layout.createSequentialGroup()
                                .addGap(x / 9)
                                .addComponent(jLabel40)
                        )
                        .addGap(x / 4 - x / 55)
        );
        jPanel04Layout.setVerticalGroup(
                jPanel04Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel04Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(y / 18)
                        )
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel04Layout.createSequentialGroup()
                                .addComponent(jLabel40)
                                .addGap(y / 36)
                        )
                        .addGap(y / 6)
        );
        btnMgmtCourse.setBackground(new java.awt.Color(255, 64, 25));

        GroupLayout jPanel06Layout = new GroupLayout(btnMgmtRoom);
        btnMgmtRoom.setLayout(jPanel06Layout);
        jPanel06Layout.setHorizontalGroup(
                jPanel06Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel06Layout.createSequentialGroup()
                                .addGap(x / 50)
                                .addComponent(jLabel6)
                        )
                        .addGroup(jPanel06Layout.createSequentialGroup()
                                .addGap(x / 9)
                                .addComponent(jLabel60)
                        )
                        .addGap(x / 4 - x / 55)
        );
        jPanel06Layout.setVerticalGroup(
                jPanel06Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel06Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(y / 18)
                        )
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel06Layout.createSequentialGroup()
                                .addComponent(jLabel60)
                                .addGap(y / 36)
                        )
                        .addGap(y / 6)
        );
        btnMgmtRoom.setBackground(new java.awt.Color(25, 25, 255));

        GroupLayout jPanel08Layout = new GroupLayout(btnMailBox);
        btnMailBox.setLayout(jPanel08Layout);
        jPanel08Layout.setHorizontalGroup(
                jPanel08Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel08Layout.createSequentialGroup()
                                .addGap(x / 50)
                                .addComponent(jLabel8)
                        )
                        .addGroup(jPanel08Layout.createSequentialGroup()
                                .addGap(x / 9)
                                .addComponent(jLabel80)
                        )
                        .addGap(x / 4 - x / 55)
        );
        jPanel08Layout.setVerticalGroup(
                jPanel08Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel08Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(y / 18)
                        )
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel08Layout.createSequentialGroup()
                                .addComponent(jLabel80)
                                .addGap(y / 36)
                        )
                        .addGap(y / 6)
        );
        btnMailBox.setBackground(new java.awt.Color(0, 153, 77));

        GroupLayout jPanel010Layout = new GroupLayout(jPanel010);
        jPanel010.setLayout(jPanel010Layout);
        jPanel010Layout.setHorizontalGroup(
                jPanel010Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGroup(jPanel010Layout.createSequentialGroup()
                                .addGap(0)
                                .addComponent(jLabel10)
                        )
                        .addGap(x * 3 / 4 - x / 25)
        );
        jPanel010Layout.setVerticalGroup(
                jPanel010Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel010Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(y / 6)
                        )
                        .addGap(y * 5 / 6)
        );
        jPanel010.setBackground(Color.WHITE);

// </editor-fold> 
        // <editor-fold defaultstate="collapsed" desc="Generated Code">  
        javax.swing.GroupLayout jPanel02Layout = new javax.swing.GroupLayout(jpHomeScr);
        jpHomeScr.setLayout(jPanel02Layout);
        jPanel02Layout.setHorizontalGroup(
                jPanel02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel02Layout.createSequentialGroup()
                                .addComponent(btnMgmtCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMgmtRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnMailBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 19, Short.MAX_VALUE))
                        .addGroup(jPanel02Layout.createSequentialGroup()
                                .addComponent(jPanel010, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap()
                                .addGap(3 * x / 4))
        );
        jPanel02Layout.setVerticalGroup(
                jPanel02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel02Layout.createSequentialGroup()
                                .addGroup(jPanel02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnMgmtCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnMgmtRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnMailBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel010, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap()
                                .addGap(y))
        );
        jpHomeScr.setBackground(Color.WHITE);
// </editor-fold> 
        /**
         * ******************************* GROUP LAYOUT LEFT *************************
         */
        // <editor-fold defaultstate="collapsed" desc="Generated Code">  
        jPanel01 = new JPanel();
        jPanel03 = new JPanel();
        btnHomeScr = new JPanel();
        btnMgmtStudent = new JPanel();
        btnMgmtTeacher = new JPanel();
        btnMgmtClass = new JPanel();
        btnMgmtStaff = new JPanel();
        btnMgmtRevenue = new JPanel();
        btnDataStatistic = new JPanel();
        btnCreateBill = new JPanel();
        jPanel021 = new JPanel();
        jPanel023 = new JPanel();
        jPanel025 = new JPanel();

        javax.swing.GroupLayout jPanel03Layout = new javax.swing.GroupLayout(jPanel03);
        jPanel03.setLayout(jPanel03Layout);
        jPanel03Layout.setHorizontalGroup(
                jPanel03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addGroup(jPanel03Layout.createSequentialGroup()
                                .addGap(x / 100)
                                .addComponent(jLabel3)
                        )
                        .addGap(x / 4)
        );
        jPanel03Layout.setVerticalGroup(
                jPanel03Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel03Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(y / 40)
                        )
                        .addGap(y / 10)
        );
        jPanel03.setBackground(new java.awt.Color(255, 51, 51));

        GroupLayout jPanel05Layout = new GroupLayout(btnHomeScr);
        btnHomeScr.setLayout(jPanel05Layout);
        jPanel05Layout.setHorizontalGroup(
                jPanel05Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel05Layout.createSequentialGroup()
                                .addGap(x / 50)
                                .addComponent(jLabel5)
                        )
                        .addGap(x / 4)
        );
        jPanel05Layout.setVerticalGroup(
                jPanel05Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel05Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(y / 75)
                        )
                        .addGap(y / 15)
        );
        btnHomeScr.setBackground(new java.awt.Color(34, 204, 0));

        GroupLayout jPanel07Layout = new GroupLayout(btnMgmtStudent);
        btnMgmtStudent.setLayout(jPanel07Layout);
        jPanel07Layout.setHorizontalGroup(
                jPanel07Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel07Layout.createSequentialGroup()
                                .addGap(x / 50)
                                .addComponent(jLabel7)
                        )
                        .addGap(x / 4)
        );
        jPanel07Layout.setVerticalGroup(
                jPanel07Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel07Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(y / 75)
                        )
                        .addGap(y / 15)
        );
        btnMgmtStudent.setBackground(new java.awt.Color(34, 204, 0));

        GroupLayout jPanel09Layout = new GroupLayout(btnMgmtTeacher);
        btnMgmtTeacher.setLayout(jPanel09Layout);
        jPanel09Layout.setHorizontalGroup(
                jPanel09Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel09Layout.createSequentialGroup()
                                .addGap(x / 50)
                                .addComponent(jLabel9)
                        )
                        .addGap(x / 4)
        );
        jPanel09Layout.setVerticalGroup(
                jPanel09Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel09Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(y / 75)
                        )
                        .addGap(y / 15)
        );
        btnMgmtTeacher.setBackground(new java.awt.Color(34, 204, 0));

        GroupLayout jPanel011Layout = new GroupLayout(btnMgmtClass);
        btnMgmtClass.setLayout(jPanel011Layout);
        jPanel011Layout.setHorizontalGroup(
                jPanel011Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel011Layout.createSequentialGroup()
                                .addGap(x / 50)
                                .addComponent(jLabel11)
                        )
                        .addGap(x / 4)
        );
        jPanel011Layout.setVerticalGroup(
                jPanel011Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel011Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(y / 75)
                        )
                        .addGap(y / 15)
        );
        btnMgmtClass.setBackground(new java.awt.Color(34, 204, 0));

        GroupLayout jPanel013Layout = new GroupLayout(btnMgmtStaff);
        btnMgmtStaff.setLayout(jPanel013Layout);
        jPanel013Layout.setHorizontalGroup(
                jPanel013Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel013Layout.createSequentialGroup()
                                .addGap(x / 50)
                                .addComponent(jLabel13)
                        )
                        .addGap(x / 4)
        );
        jPanel013Layout.setVerticalGroup(
                jPanel013Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel013Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(y / 75)
                        )
                        .addGap(y / 15)
        );
        btnMgmtStaff.setBackground(new java.awt.Color(34, 204, 0));

        GroupLayout jPanel015Layout = new GroupLayout(btnMgmtRevenue);
        btnMgmtRevenue.setLayout(jPanel015Layout);
        jPanel015Layout.setHorizontalGroup(
                jPanel015Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel015Layout.createSequentialGroup()
                                .addGap(x / 50)
                                .addComponent(jLabel15)
                        )
                        .addGap(x / 4)
        );
        jPanel015Layout.setVerticalGroup(
                jPanel015Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel015Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(y / 75)
                        )
                        .addGap(y / 15)
        );
        btnMgmtRevenue.setBackground(new java.awt.Color(34, 204, 0));

        GroupLayout jPanel017Layout = new GroupLayout(btnDataStatistic);
        btnDataStatistic.setLayout(jPanel017Layout);
        jPanel017Layout.setHorizontalGroup(
                jPanel017Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel017Layout.createSequentialGroup()
                                .addGap(x / 50)
                                .addComponent(jLabel17)
                        )
                        .addGap(x / 4)
        );
        jPanel017Layout.setVerticalGroup(
                jPanel017Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel017Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(y / 75)
                        )
                        .addGap(y / 15)
        );
        btnDataStatistic.setBackground(new java.awt.Color(34, 204, 0));

        GroupLayout jPanel019Layout = new GroupLayout(btnCreateBill);
        btnCreateBill.setLayout(jPanel019Layout);
        jPanel019Layout.setHorizontalGroup(
                jPanel019Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel019Layout.createSequentialGroup()
                                .addGap(x / 50)
                                .addComponent(jLabel19)
                        )
                        .addGap(x / 4)
        );
        jPanel019Layout.setVerticalGroup(
                jPanel019Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel019Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(y / 75)
                        )
                        .addGap(y / 15)
        );
        btnCreateBill.setBackground(new java.awt.Color(34, 204, 0));

        GroupLayout jPanel021Layout = new GroupLayout(jPanel021);
        jPanel021.setLayout(jPanel021Layout);
        jPanel021Layout.setHorizontalGroup(
                jPanel021Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel021Layout.createSequentialGroup()
                                .addGap(x / 50)
                                .addComponent(jLabel21)
                        )
                        .addGap(x / 4)
        );
        jPanel021Layout.setVerticalGroup(
                jPanel021Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel021Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(y / 75)
                        )
                        .addGap(y / 15)
        );
        jPanel021.setBackground(new java.awt.Color(34, 204, 0));

        GroupLayout jPanel023Layout = new GroupLayout(jPanel023);
        jPanel023.setLayout(jPanel023Layout);
        jPanel023Layout.setHorizontalGroup(
                jPanel023Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel023Layout.createSequentialGroup()
                                .addGap(x / 50)
                                .addComponent(jLabel23)
                        )
                        .addGap(x / 4)
        );
        jPanel023Layout.setVerticalGroup(
                jPanel023Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel023Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addGap(y / 75)
                        )
                        .addGap(y / 15)
        );
        jPanel023.setBackground(new java.awt.Color(34, 204, 0));

        GroupLayout jPanel025Layout = new GroupLayout(jPanel025);
        jPanel025.setLayout(jPanel025Layout);
        jPanel025Layout.setHorizontalGroup(
                jPanel025Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel025Layout.createSequentialGroup()
                                .addGap(x / 50)
                                .addComponent(jLabel25)
                        )
                        .addGap(x / 4)
        );
        jPanel025Layout.setVerticalGroup(
                jPanel025Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel025Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addGap(y / 75)
                        )
                        .addGap(y / 15)
        );
        jPanel025.setBackground(new java.awt.Color(34, 204, 0));

        // </editor-fold>         
        // <editor-fold defaultstate="collapsed" desc="Generated Code">  
        javax.swing.GroupLayout jPanel01Layout = new javax.swing.GroupLayout(jPanel01);
        jPanel01.setLayout(jPanel01Layout);
        jPanel01Layout.setHorizontalGroup(
                jPanel01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel03, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel01Layout.createSequentialGroup()
                                .addGap(x / 100) // can le truoc
                                .addGroup(jPanel01Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(btnHomeScr, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnMgmtStudent, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnMgmtTeacher, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnMgmtClass, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnMgmtStaff, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnMgmtRevenue, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnDataStatistic, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnCreateBill, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                /* .addComponent(jPanel021, GroupLayout.DEFAULT_SIZE, 
            GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanel023, GroupLayout.DEFAULT_SIZE, 
            GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanel025, GroupLayout.DEFAULT_SIZE, 
            GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)*/
                                )
                                .addContainerGap(x / 100, Short.MAX_VALUE)) //can le sau
                        .addGap(x / 4)
        );
        jPanel01Layout.setVerticalGroup(
                jPanel01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel01Layout.createSequentialGroup()
                                .addGap(0) //can le ten
                                .addComponent(jPanel03, GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addContainerGap()
                                .addGap(y / 50) //can le tren

                                .addComponent(btnHomeScr, GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMgmtStudent, GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMgmtTeacher, GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMgmtClass, GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMgmtStaff, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMgmtRevenue, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDataStatistic, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCreateBill, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                /*.addComponent(jPanel021, javax.swing.GroupLayout.PREFERRED_SIZE, 
            GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
             
        .addComponent(jPanel023, javax.swing.GroupLayout.PREFERRED_SIZE, 
            GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
          
        .addComponent(jPanel025, javax.swing.GroupLayout.PREFERRED_SIZE, 
            GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)*/
                                .addGap(y))
        );
        jPanel01.setBackground(new java.awt.Color(51, 51, 51));
// </editor-fold>  
        /**
         * ******************************* LAYOUT ***********************************
         */
        // <editor-fold defaultstate="collapsed" desc="Generated Code">       

        layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel01, GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jpHomeScr, GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(x)
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jPanel4, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jpHomeScr, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel01, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(y)
        );
        /**
         * *************************************************************************
         */
        // </editor-fold>  
    }

    void addLayout(JPanel jPanel0x) {
        this.remove(jstack);
        this.remove(jPanel01);
        this.remove(jPanel3);
        this.remove(jPanel4);
        jstack = jPanel0x;

        /**
         * ************* Add LAYOUT **********************************************
         */
        // <editor-fold defaultstate="collapsed" desc="Generated Code">
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel01, GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel0x, GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(x)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jPanel4, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel0x, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel01, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(y)
        );
        pack();
        // </editor-fold>
    }

    /**
     * ******************* EVENT ************************************************
     */
    class LabelEvent implements MouseListener {

        private final JPanel jpnItem;

        public LabelEvent(JPanel jpnItem) {
            this.jpnItem = jpnItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (setWorking(jpnItem)) {
                if (jpnItem == btnHomeScr) {
                    selectedScr = jpHomeScr;
                } else if (jpnItem == btnMgmtStudent) {
                    selectedScr = new qlHocvien();
                } else if (jpnItem == btnMgmtTeacher) {
                    selectedScr = new qlGiaovien();
                } else if (jpnItem == btnMgmtClass) {
                    selectedScr = new qlLophoc();
                } else if (jpnItem == btnMgmtStaff) {
                    selectedScr = new qlNhanvien();
                } else if (jpnItem == btnMgmtRevenue) {
                    selectedScr = new qlThuchi();
                } else if (jpnItem == btnDataStatistic) {
                    selectedScr = new tkDulieu();
                } else if (jpnItem == btnCreateBill) {
                    selectedScr = new tlHoadon();
                } else if (jpnItem == btnMgmtCourse) {
                    selectedScr = new showKhoahoc();
                } else if (jpnItem == btnMgmtRoom) {
                    selectedScr = new showPhonghoc();
                } else if (jpnItem == btnMailBox) {
                    selectedScr = new showGmail();
                }
                addLayout(selectedScr);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            // jpnItem.setBackground(new Color(96, 100, 191));
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if (jpnItem == btnMgmtCourse) {
                jpnItem.setBackground(new Color(128, 0, 0));
            } else if (jpnItem == btnMgmtRoom) {
                jpnItem.setBackground(new Color(34, 0, 102));
            } else if (jpnItem == btnMailBox) {
                jpnItem.setBackground(new Color(34, 51, 0));
            } else {
                jpnItem.setBackground(new Color(102, 102, 255));
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (jpnItem == btnMgmtCourse) {
                jpnItem.setBackground(new java.awt.Color(255, 64, 25));
            } else if (jpnItem == btnMgmtRoom) {
                jpnItem.setBackground(new java.awt.Color(25, 25, 255));
            } else if (jpnItem == btnMailBox) {
                jpnItem.setBackground(new java.awt.Color(0, 153, 77));
            } else {
                jpnItem.setBackground(new java.awt.Color(34, 204, 0));
            }
        }
    }

    public void setEvent(List<JPanel> listDanhMuc) {
        listDanhMuc.forEach((item) -> {
            item.addMouseListener(new LabelEvent(item));
            setWorking(item);
        });
    }

    /**
     * ***************************************************************************
     */
    class MenuEvent implements MouseListener {

        private JFrame node;
        private final JMenu jmnItem;

        public MenuEvent(JMenu jmnItem) {
            this.jmnItem = jmnItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (msetWorking(jmnItem)) {
                if (jmnItem == jMenu3) {
                    node = new qlThongtintaikhoan(idStaff);
                    node.setVisible(true);
                } else if (jmnItem == jMenu51) {
                    node = new Note_date();
                    node.setVisible(true);
                } else if (jmnItem == jMenu52) {
                    node = new CalculatorGUI();
                    node.setVisible(true);
                } else if (jmnItem == jMenu9) {
                    setDefaultCloseOperation(EXIT_ON_CLOSE);
                    Dangnhap dangnhap = new Dangnhap();
                    dangnhap.setVisible(true);
                    dispose();
                } else if (jmnItem == jMenu71) {
                    JFileChooser fc = new JFileChooser();
                    fc.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp"));
                    fc.setAcceptAllFileFilterUsed(true);

                    int rVal = fc.showOpenDialog(null);
                    if (rVal == JFileChooser.APPROVE_OPTION) {
                        String filename = fc.getSelectedFile().getName();
                        String dir = fc.getCurrentDirectory().toString();
                        File file = new File(filePath + "\\src\\Image\\background\\main.png");
                        if (file.exists()) {
                            file.delete();
                        }
                        Path source = Paths.get(dir + "\\" + filename);
                        Path dest = Paths.get(filePath + "\\src\\Image\\background\\main.png");
                        try {
                            Files.move(source, dest);
                            setDefaultCloseOperation(EXIT_ON_CLOSE);
                            GuiMain guimail = new GuiMain();
                            guimail.setVisible(true);
                            dispose();
                        } catch (IOException ex) {
                            Logger.getLogger(GuiMain.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }

        }

        @Override
        public void mousePressed(MouseEvent e) {
            // jpnItem.setBackground(new Color(96, 100, 191));
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jmnItem.setBackground(new Color(128, 128, 128));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            jmnItem.setBackground(new java.awt.Color(240, 240, 240));
        }
    }

    public void msetEvent(List<JMenu> listMenun) {
        listMenun.forEach((item) -> {
            item.addMouseListener(new MenuEvent(item));
            msetWorking(item);

        });
    }

}
