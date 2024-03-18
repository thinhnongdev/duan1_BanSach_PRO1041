package com.raven.main;

import javax.swing.JOptionPane;
import java.sql.*;
import com.raven.utils.DBConnect;

/**
 *
 * @author Admin
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        setLocationRelativeTo(null);
//        txt_taiKhoan.setBackground(new java.awt.Color(0, 0, 0, 2));
//        txt_taiKhoan.setOpaque(false);
//        pwd_matKhau.setBackground(new java.awt.Color(0, 0, 0, 2));
//        pwd_matKhau.setOpaque(false);
//        lbl_showPass.setVisible(false);
//        lbl_hiddenPass.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_taiKhoan = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btn_dangNhap = new javax.swing.JButton();
        pwd_matKhau = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        lbl_userIcon = new javax.swing.JLabel();
        lbl_hiddenPass = new javax.swing.JLabel();
        lbl_showPass = new javax.swing.JLabel();
        cbb_Role = new javax.swing.JComboBox<>();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(76, 161, 175));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/logoStore200px.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, -1, 214));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Đăng nhập");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(503, 43, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Tài khoản:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(312, 122, -1, -1));
        jPanel1.add(txt_taiKhoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(406, 113, 240, 41));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Mật khẩu:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 205, -1, -1));

        btn_dangNhap.setText("Đăng nhập");
        btn_dangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dangNhapActionPerformed(evt);
            }
        });
        jPanel1.add(btn_dangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 320, -1, -1));
        jPanel1.add(pwd_matKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(406, 196, 240, 41));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/exit.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(697, 6, -1, -1));

        lbl_userIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/userLogin.png"))); // NOI18N
        jPanel1.add(lbl_userIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 100, -1, -1));

        lbl_hiddenPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/hidden-password.png"))); // NOI18N
        lbl_hiddenPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_hiddenPassMouseClicked(evt);
            }
        });
        jPanel1.add(lbl_hiddenPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 190, -1, 50));

        lbl_showPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/show-password.png"))); // NOI18N
        lbl_showPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_showPassMouseClicked(evt);
            }
        });
        jPanel1.add(lbl_showPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 190, 61, 51));

        cbb_Role.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Nhân viên" }));
        jPanel1.add(cbb_Role, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 260, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void btn_dangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dangNhapActionPerformed
        String username = txt_taiKhoan.getText();
        String password = new String(pwd_matKhau.getPassword());
        String option = cbb_Role.getSelectedItem().toString();
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showConfirmDialog(rootPane, "Không để trống tài khoản hoặc mật khẩu", "Error", 1);
        } else {
            try {
                Connection conn = DBConnect.getConnection();
                String sql = "Select * from NhanVien where TenDangNhap=? and MatKhau=?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2, password);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    String s1 = rs.getString("idChucVu");
                    if (option.equalsIgnoreCase("Admin") && s1.equalsIgnoreCase("1")) {
                        JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
                        new Main().setVisible(true);
                    } else if (option.equalsIgnoreCase("Nhân viên") && s1.equalsIgnoreCase("2")) {
                        JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
                        new Main().setVisible(true);
                    } else {
                        JOptionPane.showConfirmDialog(rootPane, "Tên tài khoản hoặc mật khẩu không đúng!", "Lỗi đăng nhập", 1);
                    }
                } else {
                    JOptionPane.showConfirmDialog(rootPane, "Tên tài khoản hoặc mật khẩu không đúng!", "Lỗi đăng nhập", 1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_btn_dangNhapActionPerformed

    private void lbl_showPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_showPassMouseClicked
        pwd_matKhau.setEchoChar((char) 8226);
        lbl_showPass.setVisible(false);
        lbl_showPass.setEnabled(false);
        lbl_hiddenPass.setEnabled(true);
        lbl_hiddenPass.setVisible(true);
    }//GEN-LAST:event_lbl_showPassMouseClicked

    private void lbl_hiddenPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_hiddenPassMouseClicked
        pwd_matKhau.setEchoChar((char) 0);
        lbl_hiddenPass.setVisible(false);
        lbl_hiddenPass.setEnabled(false);
        lbl_showPass.setEnabled(true);
        lbl_showPass.setVisible(true);
    }//GEN-LAST:event_lbl_hiddenPassMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_dangNhap;
    private javax.swing.JComboBox<String> cbb_Role;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_hiddenPass;
    private javax.swing.JLabel lbl_showPass;
    private javax.swing.JLabel lbl_userIcon;
    private javax.swing.JPasswordField pwd_matKhau;
    private javax.swing.JTextField txt_taiKhoan;
    // End of variables declaration//GEN-END:variables
}
