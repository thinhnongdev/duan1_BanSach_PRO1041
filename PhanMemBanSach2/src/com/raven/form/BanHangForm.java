/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form;

import com.raven.model.HoaDon;
import com.raven.model.HoaDonChiTiet;
import com.raven.model.SanPhamCT;
import com.raven.model.ThanhToan;
import com.raven.model.Voucher;
import com.raven.service.BanHangService;
import com.raven.service.KhachHangService;
import com.raven.service.SanPhamCTservice;
import com.raven.service.VoucherService;
import com.raven.utils.PhanQuyenNV;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class BanHangForm extends javax.swing.JPanel {

    /**
     * Creates new form BanHangForm
     */
    DefaultTableModel modelCTSP = new DefaultTableModel();
    DefaultTableModel modelHoaDon = new DefaultTableModel();
    DefaultTableModel modelGioHang = new DefaultTableModel();
    SanPhamCTservice spctService = new SanPhamCTservice();
    VoucherService vcservice = new VoucherService();
    BanHangService bhService = new BanHangService();
    DefaultComboBoxModel boxmodel = new DefaultComboBoxModel<>();
    KhachHangService khService = new KhachHangService();
    List<HoaDonChiTiet> listHDCT = new ArrayList<>();
    //List<HoaDon> listHD = new ArrayList<>();
    List<SanPhamCT> listSPCT = new ArrayList<>();
    int indexHoaDon = -1;
    int indexSPCT = -1;

    public BanHangForm() {
        initComponents();
        fillTableCTSP(spctService.getAll2());
        modelHoaDon = (DefaultTableModel) tblHoaDon.getModel();
        modelHoaDon.setRowCount(0);
        modelGioHang = (DefaultTableModel) tblGioHang.getModel();
        modelGioHang.setRowCount(0);
        fillComboxPhieuGiamGia();
        fillComBoxHinhThucTT();
        fillTableHoaDon(bhService.getAllHD());
        resetFormHoaDon();
    }

    public void fillTableCTSP(List<SanPhamCT> list) {
        modelCTSP = (DefaultTableModel) tblSPCT.getModel();
        modelCTSP.setRowCount(0);
        for (SanPhamCT sp : list) {
            Object[] row = new Object[]{sp.getMasachchitiet(), sp.getTensach(), sp.getTentacgia(), sp.getTentheloai(), sp.getTennhacungcap(), sp.getTennhaxuatban(), sp.getDongia(), sp.getSoluong(), sp.getMota()};
            modelCTSP.addRow(row);
        }
    }

    void fillComboxPhieuGiamGia() {
        boxmodel = (DefaultComboBoxModel) cbxPhieuGiamGia.getModel();
        boxmodel.removeAllElements();
        boxmodel.addElement("");
        for (Voucher vc : vcservice.getAll()) {
            boxmodel.addElement(vc.getTenVoucher());
        }
    }

    void fillComBoxHinhThucTT() {
        boxmodel = (DefaultComboBoxModel) cbxHTthanhToan.getModel();
        boxmodel.removeAllElements();
        boxmodel.addElement("");
        boxmodel.addElement("Tiền mặt");
        boxmodel.addElement("Chuyển khoản");
        boxmodel.addElement("Kết hợp");
    }

    public HoaDon taoHoaDon() {

        String maHD = "HD" + new Random().nextInt(100000);
        String nv = "NV001";
        int tongsanpham = 0;
        String trangthai = "Chờ thanh toán";
        //SimpleDateFormat spdate = new SimpleDateFormat("dd-MM-yyyy");
        Date ngaytao = new java.util.Date();
        String makh = "KH000";
        return new HoaDon(makh, nv, null, null, maHD, null, null, ngaytao, trangthai, null, tongsanpham);
    }

    public HoaDonChiTiet themSPvaogiohang(String maSPCT, int SoLuong, String MaHoaDon) {

        String maHoaDon = null;
        String maHoaDonCT = null;
        String maspct = null;
        String tenSP = null;
        String theLoai = null;
        String tacGia = null;
        double donGia = 0;
        int soLuong = 0;
        double thanhTien;
        maspct = spctService.getSPCT(maSPCT).getMasachchitiet();
        tenSP = spctService.getSPCT(maSPCT).getTensach();
        theLoai = spctService.getSPCT(maSPCT).getTentheloai();
        tacGia = spctService.getSPCT(maSPCT).getTentacgia();
        donGia = spctService.getSPCT(maSPCT).getDongia();
        soLuong = SoLuong;
        thanhTien = donGia * SoLuong;
        maHoaDon = MaHoaDon;
        maHoaDonCT = "HDCT" + new Random().nextInt(100000);
        Date ngayTao = new java.util.Date();
        String trangThai = "Chờ thanh toán";
        return new HoaDonChiTiet(maHoaDon, maHoaDonCT, maspct, tenSP, theLoai, tacGia, donGia, soLuong, thanhTien, ngayTao, trangThai, ngayTao);
    }

    void LoadGioHang(List<HoaDonChiTiet> list) {
        modelGioHang = (DefaultTableModel) tblGioHang.getModel();
        modelGioHang.setRowCount(0);
        for (HoaDonChiTiet hdct : list) {
            Object[] row = new Object[]{hdct.getMaSPCT(), hdct.getTenSP(), hdct.getTheLoai(), hdct.getTacGia(), hdct.getDonGia(), hdct.getSoLuong(), hdct.getDonGia() * hdct.getSoLuong()};
            modelGioHang.addRow(row);
        }
    }

    void fillFormHoaDon(List<HoaDon> listHD, List<HoaDonChiTiet> listHDCT) {
        if (indexHoaDon >= 0) {
            txtMaKH.setText(listHD.get(indexHoaDon).getMaKhachHang());
            txtTenKH.setText(khService.TimKhachHangTheoMa(listHD.get(indexHoaDon).getMaKhachHang()).get(0).getTenKH());
            txtMaHoaDon.setText(listHD.get(indexHoaDon).getMaHoaDon());
            txtMaNhanVien.setText(listHD.get(indexHoaDon).getMaNhanVien());
            double tongtien = 0;
            for (HoaDonChiTiet hoadonchitiet : listHDCT) {
                if (hoadonchitiet.getMaHoaDon().equalsIgnoreCase(listHD.get(indexHoaDon).getMaHoaDon())) {
                    tongtien += hoadonchitiet.getThanhTien();
                }
            }
            txtTongTien.setText(String.valueOf(tongtien));
            txtTienThanhToan.setText(String.valueOf(tongtien));
        }

    }

    void fillTableHoaDon(List<HoaDon> listHD) {
        modelHoaDon.setRowCount(0);
        for (HoaDon hd : listHD) {
            Object[] row = new Object[]{hd.getMaHoaDon(), hd.getNgayTao(), hd.getMaNhanVien(), hd.getTongsanpham(), hd.getTrangThai()};
            modelHoaDon.addRow(row);
            txtMaKH.setText(hd.getMaKhachHang());
            txtTenKH.setText("Khách lẻ");
            txtMaNhanVien.setText(hd.getMaNhanVien());
            txtMaHoaDon.setText(hd.getMaHoaDon());
            txtTongTien.setText("0");
        }
    }

    void resetFormHoaDon() {
        txtMaNhanVien.setText("");
        txtTongTien.setText("");
        txtTienThanhToan.setText("");
        txtMaHoaDon.setText("");
        txtTenKH.setText("");
        txtMaKH.setText("");
        cbxHTthanhToan.setSelectedIndex(0);
        txtTienKhachDua.setText("");
        txtTienKhachChuyenKhoan.setText("");
        txtTienThua.setText("");
        cbxPhieuGiamGia.setSelectedIndex(0);
    }

    ThanhToan getFormThanhToan() {
        String maThanhToan = "TT" + new Random().nextInt(10000);
        double tienThanhToan = Double.parseDouble(txtTienThanhToan.getText());
        String hinhThucTT = (String) cbxHTthanhToan.getSelectedItem();
        Date ngayTao = new java.util.Date();
        return new ThanhToan(maThanhToan, null, hinhThucTT, tienThanhToan, null, ngayTao, "Đã thanh toán", null);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        btnTaoHoaDon = new javax.swing.JButton();
        btnQuetMa = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtMaHoaDon = new javax.swing.JTextField();
        txtMaNhanVien = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtTienThanhToan = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtTienKhachChuyenKhoan = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtTienThua = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        cbxHTthanhToan = new javax.swing.JComboBox<>();
        cbxPhieuGiamGia = new javax.swing.JComboBox<>();
        btnHuyHoaDon = new javax.swing.JButton();
        tbnThanhToan = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTenKH = new javax.swing.JTextField();
        btnChonKhachHang = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        btnXoaGioHang = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSPCT = new javax.swing.JTable();
        txtTimKiem = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Ngày tạo", "Nhân viên", "Tổng sản phẩm", "Trạng thái"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        btnTaoHoaDon.setText("Tạo hóa đơn");
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });

        btnQuetMa.setText("Quét mã vạch");
        btnQuetMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuetMaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnTaoHoaDon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnQuetMa)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTaoHoaDon)
                    .addComponent(btnQuetMa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel5.setText("Mã hóa đơn:");

        txtMaHoaDon.setEnabled(false);

        txtMaNhanVien.setEnabled(false);

        jLabel9.setText("Mã nhân viên:");

        jLabel10.setText("Tổng tiền:");

        txtTongTien.setEnabled(false);

        jLabel12.setText("Phiếu giảm giá:");

        jLabel13.setText("Thanh toán :");

        jLabel14.setText("Tiền khách đưa:");

        txtTienKhachDua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienKhachDuaKeyReleased(evt);
            }
        });

        jLabel15.setText("Tiền khách CK:");

        jLabel16.setText("Tiền thừa:");

        jLabel17.setText("HT thanh toán:");

        cbxHTthanhToan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxHTthanhToan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxHTthanhToanItemStateChanged(evt);
            }
        });
        cbxHTthanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxHTthanhToanMouseClicked(evt);
            }
        });

        cbxPhieuGiamGia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxPhieuGiamGia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxPhieuGiamGiaItemStateChanged(evt);
            }
        });

        btnHuyHoaDon.setText("Hủy hóa đơn");
        btnHuyHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyHoaDonActionPerformed(evt);
            }
        });

        tbnThanhToan.setText("Thanh toán");
        tbnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnThanhToanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(txtTienKhachDua))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTienKhachChuyenKhoan, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                            .addComponent(txtTienThua)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(cbxHTthanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtTienThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addComponent(txtTongTien, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaNhanVien, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaHoaDon, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxPhieuGiamGia, javax.swing.GroupLayout.Alignment.LEADING, 0, 205, Short.MAX_VALUE))))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnHuyHoaDon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tbnThanhToan)
                .addGap(39, 39, 39))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cbxPhieuGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtTienThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxHTthanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTienKhachChuyenKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(32, 32, 32)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHuyHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel7.setText("Mã KH:");

        jLabel8.setText("Tên KH:");

        btnChonKhachHang.setText("Chọn");
        btnChonKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonKhachHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnChonKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChonKhachHang))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Giỏ hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã SPCT", "Tên SP", "Tên thể loại", "Tên tác giả", "Đơn giá", "Số lượng", "Thành tiền", "Select"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblGioHang);

        btnXoaGioHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/bin.png"))); // NOI18N
        btnXoaGioHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaGioHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoaGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXoaGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách sản phẩm"));

        tblSPCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã SPCT", "Tên SP", "Tên tác giả", "Tên thể loại", "Tên nhà cung cấp", "Tên nhà sản xuất", "Đơn giá", "Số lượng", "Mô tả"
            }
        ));
        tblSPCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSPCTMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblSPCT);

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        jLabel1.setText("Tìm kiếm:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 881, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 906, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed
        // TODO add your handling code here:

                if (bhService.themHD(taoHoaDon()) > 0) {
            fillTableHoaDon(bhService.getAllHD());
        }
    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    private void tblSPCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSPCTMouseClicked
        // TODO add your handling code here:

        indexSPCT = tblSPCT.getSelectedRow();

      indexSPCT = tblSPCT.getSelectedRow();
        if (indexHoaDon >= 0) {
            if (indexSPCT >= 0) {
                String soluongStr = null;
                int soluongint = 0;
                try {
                    soluongStr = JOptionPane.showInputDialog("Nhập số lượng sản phẩm");
                    soluongint = Integer.parseInt(soluongStr);
                } catch (Exception e) {
                    System.out.println("Không có dữ liệu input");
                }
                if (soluongint > 0) {
                    String maSPCT = (String) tblSPCT.getValueAt(indexSPCT, 0);
                    String maHD = (String) tblHoaDon.getValueAt(indexHoaDon, 0);
                    //cộng dồn sp có cùng mã trong giỏ hàng
                    for (HoaDonChiTiet hdct : bhService.getHDCT(maHD)) {
                        System.out.println(hdct.getMaSPCT());
                        System.out.println(maSPCT);
                        if (hdct.getMaSPCT().equalsIgnoreCase(maSPCT)) {
                            System.out.println("Trùng sp");
                            if (bhService.CongDonSPCT(soluongint, hdct.getMaHoaDonCT()) > 0) {
                                LoadGioHang(bhService.getHDCT(maHD));
                            }
                        }
                    }
                    //Thêm sp mới vào giỏ hàng
                    boolean result = false;
                    for (HoaDonChiTiet hdct : bhService.getHDCT(maHD)) {
                        if (hdct.getMaSPCT().equalsIgnoreCase(maSPCT)) {
                            result = true;
                        }
                    }
                    if (result == false) {
                        if (bhService.themHDCT(themSPvaogiohang(maSPCT, soluongint, maHD)) > 0) {
                            LoadGioHang(bhService.getHDCT(maHD));
                        }
                    } else {

                    }
                    //cập nhật lại số lượng tồn sp trong kho sau khi thêm sp vào giỏ hàng
                    int soLuongTon = (int) tblSPCT.getValueAt(indexSPCT, 7) - soluongint;
                    if (spctService.CapNhatSoLuongSP(soLuongTon, maSPCT) > 0) {
                        fillTableCTSP(spctService.getAll2());
                    }
                    fillFormHoaDon(bhService.getAllHD(), bhService.getHDCT(maHD));
                }
            }

            txtTimKiem.setText("");
        }
    }//GEN-LAST:event_tblSPCTMouseClicked

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        // TODO add your handling code here:
         indexHoaDon = tblHoaDon.getSelectedRow();
        double tongtien = 0;
        if (indexHoaDon >= 0) {
            String maHoaDon = (String) tblHoaDon.getValueAt(indexHoaDon, 0);
            modelGioHang.setRowCount(0);
            LoadGioHang(bhService.getHDCT(maHoaDon));
            listHDCT = bhService.getHDCT(maHoaDon);
            for (HoaDon hoaDon : bhService.getAllHD()) {
                if (hoaDon.getMaHoaDon().equalsIgnoreCase(maHoaDon)) {
                    txtMaHoaDon.setText(hoaDon.getMaHoaDon());
                    txtMaNhanVien.setText(hoaDon.getMaNhanVien());
                    // txtTongTien.setText(String.valueOf(tongtien));
                }
            }
            // đưa dữ liệu lên form
            fillFormHoaDon(bhService.getAllHD(), bhService.getHDCT(maHoaDon));

            for (int i = 0; i < tblGioHang.getRowCount(); i++) {
                tblGioHang.setValueAt(false, i, 7);
            }
        }
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void btnChonKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonKhachHangActionPerformed
        // TODO add your handling code here:
        if (indexHoaDon >= 0) {
            String maHD = (String) tblHoaDon.getValueAt(indexHoaDon, 0);
            JFrame jf = new JFrame();
            KhachHangThanhToan khtt = new KhachHangThanhToan(jf, true);
            khtt.setVisible(true);
            if (khtt.isVisible() == false) {
                txtMaKH.setText(khtt.listKH.get(0).getMaKH());
                txtTenKH.setText(khtt.listKH.get(0).getTenKH());
                bhService.UpdateHD(khtt.listKH.get(0).getMaKH(), "Chờ thanh toán", maHD);
            }
        }
    }//GEN-LAST:event_btnChonKhachHangActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        // TODO add your handling code here:
        String thongtintimkiem = txtTimKiem.getText();
        if (!thongtintimkiem.trim().isEmpty()) {
            fillTableCTSP(spctService.TimKiemCTSP(thongtintimkiem));
        }
        if (thongtintimkiem.trim().isEmpty()) {
            fillTableCTSP(spctService.getAll2());
        }
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void btnXoaGioHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaGioHangActionPerformed
        // TODO add your handling code here:
 String maHD = (String) tblHoaDon.getValueAt(indexHoaDon, 0);
        listHDCT = bhService.getHDCT(maHD);
        try {
            for (int i = 0; i < listHDCT.size(); i++) {
                // System.out.println(tblGioHang.getValueAt(i, 7));
                if (tblGioHang.getValueAt(i, 7).equals(true)) {
                    bhService.XoaSPtrongGioHang(listHDCT.get(i).getMaHoaDonCT());
                    bhService.CapNhatSPCTChuaThanhToan(listHDCT.get(i));
                    fillTableCTSP(spctService.getAll2());
                    LoadGioHang(bhService.getHDCT(maHD));
                }

            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnXoaGioHangActionPerformed

    private void btnQuetMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuetMaActionPerformed
        
        JFrame qr = new JFrame();
        QRcode3 qrc = new QRcode3(qr, true);
        qrc.setVisible(true);
        
    }//GEN-LAST:event_btnQuetMaActionPerformed

    private void cbxPhieuGiamGiaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxPhieuGiamGiaItemStateChanged
      String tenvoucher = (String) cbxPhieuGiamGia.getSelectedItem();
        if (tenvoucher != null) {
            for (Voucher vc : vcservice.getAll()) {
                if (vc.getTenVoucher().equalsIgnoreCase(tenvoucher)) {
                    double tongtienhd = Double.parseDouble(txtTongTien.getText());
                    double tienthanhtoan = tongtienhd - (tongtienhd / 100 * vc.getPhanTramGiam());
                    txtTienThanhToan.setText(String.valueOf(tienthanhtoan));
                }
            }
        }
    }//GEN-LAST:event_cbxPhieuGiamGiaItemStateChanged

    private void txtTienKhachDuaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachDuaKeyReleased
        try {
            if (cbxHTthanhToan.getSelectedItem() == "Kết hợp") {
                txtTienThua.setText("0");
                txtTienKhachChuyenKhoan.setText("0");
                double tienmat = Double.parseDouble(txtTienKhachDua.getText());
                txtTienKhachChuyenKhoan.setText(String.valueOf(Double.parseDouble(txtTienThanhToan.getText()) - tienmat));
            } else if (cbxHTthanhToan.getSelectedItem() == "Chuyển khoản") {
                txtTienThua.setText("0");
                txtTienKhachDua.setText("0");
                txtTienKhachChuyenKhoan.setText(txtTienThanhToan.getText());
            } else if (cbxHTthanhToan.getSelectedItem() == "Tiền mặt") {
                txtTienThua.setText("0");
                txtTienKhachChuyenKhoan.setText("0");
                double tienmat = Double.parseDouble(txtTienKhachDua.getText());
                txtTienThua.setText(String.valueOf(tienmat - Double.parseDouble(txtTienThanhToan.getText())));
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtTienKhachDuaKeyReleased

    private void cbxHTthanhToanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxHTthanhToanItemStateChanged
        try {
            if (cbxHTthanhToan.getSelectedItem() == "Kết hợp") {
                txtTienThua.setText("0");
                txtTienKhachDua.setText("");
                txtTienKhachChuyenKhoan.setText("0");
                if (!txtTienKhachDua.getText().equals("")) {
                    double tienmat = Double.parseDouble(txtTienKhachDua.getText());
                    txtTienKhachChuyenKhoan.setText(String.valueOf(Double.parseDouble(txtTienThanhToan.getText()) - tienmat));
                }
            } else if (cbxHTthanhToan.getSelectedItem() == "Chuyển khoản") {
                txtTienThua.setText("0");
                txtTienKhachDua.setText("0");
                txtTienKhachChuyenKhoan.setText(txtTienThanhToan.getText());
            } else if (cbxHTthanhToan.getSelectedItem() == "Tiền mặt") {
                txtTienThua.setText("0");
                txtTienKhachChuyenKhoan.setText("0");
                double tienmat = Double.parseDouble(txtTienKhachDua.getText());
                txtTienThua.setText(String.valueOf(tienmat - Double.parseDouble(txtTienThanhToan.getText())));
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbxHTthanhToanItemStateChanged

    private void cbxHTthanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxHTthanhToanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxHTthanhToanMouseClicked

    private void btnHuyHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyHoaDonActionPerformed
        int result = JOptionPane.showConfirmDialog(null, "Bạn có muốn hủy hóa đơn này không", "Thông báo", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            String maHD = (String) tblHoaDon.getValueAt(indexHoaDon, 0);
            listHDCT = bhService.getHDCT(maHD);
            try {
                for (int i = 0; i < listHDCT.size(); i++) {
                    System.out.println(tblGioHang.getValueAt(i, 7));
                    bhService.XoaSPtrongGioHang(listHDCT.get(i).getMaHoaDonCT());
                    bhService.CapNhatSPCTChuaThanhToan(listHDCT.get(i));
                }
                System.out.println(maHD);
                bhService.XoaHoaDon(maHD);
                fillTableHoaDon(bhService.getAllHD());
                fillTableCTSP(spctService.getAll2());
                LoadGioHang(bhService.getHDCT(maHD));
            } catch (Exception e) {
            }
            resetFormHoaDon();
        }
    }//GEN-LAST:event_btnHuyHoaDonActionPerformed

    private void tbnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnThanhToanActionPerformed
        if (indexHoaDon >= 0) {
            String maHD = (String) tblHoaDon.getValueAt(indexHoaDon, 0);
            String maVoucher = null;

            for (Voucher vc : vcservice.getAll()) {
                if (cbxPhieuGiamGia.getSelectedItem().equals(vc.getTenVoucher())) {
                    maVoucher = vc.getMaVoucher();
                }
            }
            String tenVoucher = (String) cbxPhieuGiamGia.getSelectedItem();
            bhService.themTT(getFormThanhToan());
            bhService.ThanhToanHD(maHD, maVoucher);
            for (HoaDonChiTiet hoaDonChiTiet : bhService.getHDCT(maHD)) {
                System.out.println(hoaDonChiTiet.getMaHoaDonCT());
                bhService.ThanhToanHDCT(hoaDonChiTiet.getMaHoaDonCT());
            }
            resetFormHoaDon();
            fillTableHoaDon(bhService.getAllHD());
            modelGioHang = (DefaultTableModel) tblGioHang.getModel();
            modelGioHang.setRowCount(0);
            JOptionPane.showMessageDialog(this, "Thanh toán thành công");
        }

    }//GEN-LAST:event_tbnThanhToanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChonKhachHang;
    private javax.swing.JButton btnHuyHoaDon;
    private javax.swing.JButton btnQuetMa;
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnXoaGioHang;
    private javax.swing.JComboBox<String> cbxHTthanhToan;
    private javax.swing.JComboBox<String> cbxPhieuGiamGia;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblSPCT;
    private javax.swing.JButton tbnThanhToan;
    private javax.swing.JTextField txtMaHoaDon;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtMaNhanVien;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTienKhachChuyenKhoan;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JTextField txtTienThanhToan;
    private javax.swing.JTextField txtTienThua;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
