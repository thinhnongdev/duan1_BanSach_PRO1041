/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form;

import com.raven.model.HoaDon;
import com.raven.model.HoaDonChiTiet;
import com.raven.model.QLhoaDon;
import com.raven.model.SanPhamCT;
import com.raven.service.QLHoaDonService;
import com.raven.utils.GetMaSanPham;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Admin
 */
public class FormHoaDon extends javax.swing.JPanel {

    DefaultComboBoxModel boxmodel = new DefaultComboBoxModel<>();
    DefaultTableModel model = new DefaultTableModel();
    QLHoaDonService qldhservice = new QLHoaDonService();
    List<QLhoaDon> listQLHD;
    int indexHD = -1;
    String trangthai = "";
    String httt = "";

    public FormHoaDon() {
        initComponents();
        fillComboxTrangThai();
        fillComboxHTTT();
        filLTableHoaDon(qldhservice.getAllQLHD());

    }

    void fillComboxTrangThai() {
        boxmodel = (DefaultComboBoxModel) cbxTrangThai.getModel();
        boxmodel.removeAllElements();
        boxmodel.addElement("Tất cả");
        boxmodel.addElement("Đã thanh toán");
        boxmodel.addElement("Đã hủy");
        boxmodel.addElement("Chờ thanh toán");
    }

    void fillComboxHTTT() {
        boxmodel = (DefaultComboBoxModel) cbxHTTT.getModel();
        boxmodel.removeAllElements();
        boxmodel.addElement("Tất cả");
        boxmodel.addElement("Tiền mặt");
        boxmodel.addElement("Chuyển khoản");
        boxmodel.addElement("Kết hợp");
    }

    void filLTableHoaDon(List<QLhoaDon> list) {
        listQLHD = new ArrayList<>();
        listQLHD = list;
        model = (DefaultTableModel) tblHoaDon.getModel();
        model.setRowCount(0);
        int stt = 1;
        for (QLhoaDon qlhd : list) {
            Object[] row = new Object[]{stt, qlhd.getMaHoaDon(), qlhd.getNgayTaoHD(), qlhd.getNgayThanhToan(), qlhd.getTongtientt(), qlhd.getMaNV(), qlhd.getTenKH(), qlhd.getTrangThai()};
            stt += 1;
            model.addRow(row);
        }
    }

    void filLTableHoaDonCT(String maHD) {
        model = (DefaultTableModel) tblHdct.getModel();
        model.setRowCount(0);
        int stt = 1;
        for (SanPhamCT sp : qldhservice.getSPCT(maHD)) {
            Object[] row = new Object[]{stt, sp.getMasachchitiet(), sp.getTensach(), sp.getTentheloai(), sp.getTentacgia(), sp.getTennhaxuatban(), sp.getDongia(), sp.getSoluong(), sp.getDongia() * sp.getSoluong()};
            stt += 1;
            model.addRow(row);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_search = new javax.swing.JTextField();
        btnXemChiTiet = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        cbxHTTT = new javax.swing.JComboBox<>();
        cbxTrangThai = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnInHD = new javax.swing.JButton();
        btnXuatDanhSach = new javax.swing.JButton();
        btnHuyHD = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHdct = new javax.swing.JTable();

        setBackground(new java.awt.Color(242, 242, 242));

        jPanel1.setBackground(new java.awt.Color(242, 242, 242));
        jPanel1.setMaximumSize(new java.awt.Dimension(1115, 735));
        jPanel1.setMinimumSize(new java.awt.Dimension(1115, 735));

        jPanel4.setBackground(new java.awt.Color(242, 242, 242));
        jPanel4.setMaximumSize(new java.awt.Dimension(1130, 773));
        jPanel4.setMinimumSize(new java.awt.Dimension(1130, 773));

        jPanel2.setBackground(new java.awt.Color(242, 242, 242));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Hóa đơn"));

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Tìm kiếm hóa đơn:");

        txt_search.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txt_search.setToolTipText("");
        txt_search.setName(""); // NOI18N
        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchKeyReleased(evt);
            }
        });

        btnXemChiTiet.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnXemChiTiet.setText("Xem chi tiết");
        btnXemChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemChiTietActionPerformed(evt);
            }
        });

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã hóa đơn", "Ngày tạo", "Ngày thanh toán", "Tổng tiền", "Mã NV", "Tên khách hàng", "Trạng thái"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        cbxHTTT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxHTTT.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxHTTTItemStateChanged(evt);
            }
        });

        cbxTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxTrangThai.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxTrangThaiItemStateChanged(evt);
            }
        });
        cbxTrangThai.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
                cbxTrangThaiAncestorMoved(evt);
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
            }
        });

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Trạng thái:");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Hình thức thanh toán:");

        btnInHD.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnInHD.setLabel(" In Hóa Đơn");
        btnInHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInHDActionPerformed(evt);
            }
        });

        btnXuatDanhSach.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnXuatDanhSach.setText("Xuất danh sách");
        btnXuatDanhSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatDanhSachActionPerformed(evt);
            }
        });

        btnHuyHD.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnHuyHD.setText("Hủy hóa đơn");
        btnHuyHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyHDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1)
                        .addGap(43, 43, 43)
                        .addComponent(cbxTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(cbxHTTT, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2)
                        .addGap(16, 16, 16)
                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(151, 704, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnInHD)
                .addGap(34, 34, 34)
                .addComponent(btnXemChiTiet)
                .addGap(18, 18, 18)
                .addComponent(btnXuatDanhSach)
                .addGap(18, 18, 18)
                .addComponent(btnHuyHD)
                .addGap(16, 16, 16))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_search, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(cbxHTTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXemChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInHD, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXuatDanhSach, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuyHD, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(242, 242, 242));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Hóa đơn chi tiết"));

        tblHdct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã SPCT", "Tên SP", "Tên thể loại", "Tên tác giả", "Nhà xuất bản", "Đơn giá", "Số lượng", "Thành tiền"
            }
        ));
        jScrollPane2.setViewportView(tblHdct);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1239, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1294, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 846, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnXemChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemChiTietActionPerformed
        // TODO add your handling code here:
        String maHD = (String) tblHoaDon.getValueAt(indexHD, 1);
        if (maHD != "" && indexHD >= 0) {
            GetMaSanPham.maHDql = maHD;
            JFrame jf = new JFrame();
            XemChiTietHD xcthd = new XemChiTietHD(jf, true);
            xcthd.setTitle("Thông tin hóa đơn");
            xcthd.setVisible(true);
        }
    }//GEN-LAST:event_btnXemChiTietActionPerformed

    private void btnInHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInHDActionPerformed
        // TODO add your handling code here:
        if (indexHD >= 0) {
            if (tblHoaDon.getValueAt(indexHD, 7).toString().equalsIgnoreCase("Da thanh toan")) {
                try {
                    XuatHDpdf.main(new String[]{});
                    JOptionPane.showMessageDialog(this, "Xuất file thành công");
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(FormHoaDon.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Chỉ in được hóa đơn đã thanh toán");
            }
        }
    }//GEN-LAST:event_btnInHDActionPerformed

    private void btnHuyHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyHDActionPerformed
        // TODO add your handling code here:
        if (indexHD >= 0) {
            String maHD = (String) tblHoaDon.getValueAt(indexHD, 1);
            String trangthai = (String) tblHoaDon.getValueAt(indexHD, 7);
            if (trangthai.equalsIgnoreCase("Cho thanh toan")) {
                qldhservice.XoaHoaDon(maHD);
                filLTableHoaDon(qldhservice.getAllQLHD());
                JOptionPane.showMessageDialog(this, "Hủy hóa đơn thành công");
            } else {
                JOptionPane.showMessageDialog(this, "Để hủy! Vui lòng chọn hóa đơn trong trạng thái chờ thanh toán");
            }
        }
    }//GEN-LAST:event_btnHuyHDActionPerformed

    private void btnXuatDanhSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatDanhSachActionPerformed
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(null, "Bạn có muốn xuất file không?");
        if (result == JOptionPane.YES_OPTION) 
        try {
            XSSFWorkbook wordbook = new XSSFWorkbook();
            XSSFSheet sheet = wordbook.createSheet("DanhSachSPCT");
            XSSFRow row = null;
            Cell cell = null;
            row = sheet.createRow(0);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("STT");
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Mã Hóa Đơn");
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Ngày Tạo");
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("Ngày Thanh Toán");
            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("Tổng Tiền");
            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("Mã Nhân Viên");
            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue("Tên Khách Hàng");
            cell = row.createCell(7, CellType.STRING);
            cell.setCellValue("Trạng Thái");

            for (int i = 0; i < listQLHD.size(); i++) {
                row = sheet.createRow(i + 1);
                cell = row.createCell(0, CellType.NUMERIC);
                cell.setCellValue(i + 1);
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(listQLHD.get(i).getMaHoaDon());

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(listQLHD.get(i).getNgayTaoHD());

                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(listQLHD.get(i).getNgayThanhToan());

                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(listQLHD.get(i).getTongtientt());

                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue(listQLHD.get(i).getMaNV());

                cell = row.createCell(6, CellType.STRING);
                cell.setCellValue(listQLHD.get(i).getTenKH());

                cell = row.createCell(7, CellType.STRING);
                cell.setCellValue(listQLHD.get(i).getTrangThai());
            }
            File file = new File("D://FileHoaDonExport.xlsx");
            try {
                FileOutputStream fis = new FileOutputStream(file);
                wordbook.write(fis);
                fis.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
        }
        JOptionPane.showMessageDialog(this, "In thành công");
    }//GEN-LAST:event_btnXuatDanhSachActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        // TODO add your handling code here:
        try {
            indexHD = tblHoaDon.getSelectedRow();

            if (indexHD >= 0) {
                String maHD = (String) tblHoaDon.getValueAt(indexHD, 1);
                GetMaSanPham.maHDpdf = maHD;
                filLTableHoaDonCT(maHD);
            }
        } catch (Exception e) {
        }

    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void cbxTrangThaiAncestorMoved(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_cbxTrangThaiAncestorMoved
        // TODO add your handling code here:

    }//GEN-LAST:event_cbxTrangThaiAncestorMoved

    private void txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyReleased
        // TODO add your handling code here:
        String maHD = txt_search.getText();
        if (maHD != "") {
            filLTableHoaDon(qldhservice.TimHD(maHD));
        } else if (maHD == "") {
            filLTableHoaDon(qldhservice.getAllQLHD());
        }
    }//GEN-LAST:event_txt_searchKeyReleased

    private void cbxTrangThaiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxTrangThaiItemStateChanged
        // TODO add your handling code here:
        if (cbxTrangThai.getSelectedIndex() >= 0) {
            if (cbxTrangThai.getSelectedItem().equals("Tất cả")) {
                trangthai = "";
                filLTableHoaDon(qldhservice.LocTheoTruongDacTrung(trangthai, httt));
            } else if (cbxTrangThai.getSelectedItem().equals("Đã thanh toán")) {
                trangthai = "Da thanh toan";
                filLTableHoaDon(qldhservice.LocTheoTruongDacTrung(trangthai, httt));
            } else if (cbxTrangThai.getSelectedItem().equals("Chờ thanh toán")) {
                trangthai = "Cho thanh toan";
                filLTableHoaDon(qldhservice.LocTheoTruongDacTrung(trangthai, httt));
            } else if (cbxTrangThai.getSelectedItem().equals("Đã hủy")) {
                trangthai = "Da huy";
                filLTableHoaDon(qldhservice.LocTheoTruongDacTrung(trangthai, httt));
            }
        }
    }//GEN-LAST:event_cbxTrangThaiItemStateChanged

    private void cbxHTTTItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxHTTTItemStateChanged
        // TODO add your handling code here:
        if (cbxHTTT.getSelectedIndex() >= 0) {
            if (cbxHTTT.getSelectedItem().equals("Tất cả")) {
                httt = "";
                filLTableHoaDon(qldhservice.LocTheoTruongDacTrung(trangthai, httt));
            } else if (cbxHTTT.getSelectedItem().equals("Tiền mặt")) {
                httt = "Tien mat";
                filLTableHoaDon(qldhservice.LocTheoTruongDacTrung(trangthai, httt));
            } else if (cbxHTTT.getSelectedItem().equals("Chuyển khoản")) {
                httt = "Chuyen khoan";
                filLTableHoaDon(qldhservice.LocTheoTruongDacTrung(trangthai, httt));
            } else if (cbxHTTT.getSelectedItem().equals("Kết hợp")) {
                httt = "Ket hop";
                filLTableHoaDon(qldhservice.LocTheoTruongDacTrung(trangthai, httt));
            }
        }
    }//GEN-LAST:event_cbxHTTTItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuyHD;
    private javax.swing.JButton btnInHD;
    private javax.swing.JButton btnXemChiTiet;
    private javax.swing.JButton btnXuatDanhSach;
    private javax.swing.JComboBox<String> cbxHTTT;
    private javax.swing.JComboBox<String> cbxTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblHdct;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}
