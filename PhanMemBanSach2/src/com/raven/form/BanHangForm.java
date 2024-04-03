/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form;

import com.raven.model.HoaDon;
import com.raven.model.HoaDonChiTiet;
import com.raven.model.NhaXuatBan;
import com.raven.model.SanPhamCT;
import com.raven.model.TacGia;
import com.raven.model.ThanhToan;
import com.raven.model.TheLoai;
import com.raven.model.Voucher;
import com.raven.service.BanHangService;
import com.raven.service.KhachHangService;
import com.raven.service.NhaXuatBanService;
import com.raven.service.SanPhamCTservice;
import com.raven.service.TacGiaService;
import com.raven.service.TheLoaiService;
import com.raven.service.VoucherService;
import com.raven.utils.GetMaSanPham;
import com.raven.utils.PhanQuyenNV;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    TheLoaiService TLservice = new TheLoaiService();
    TacGiaService TGservice = new TacGiaService();
    NhaXuatBanService NXBservice = new NhaXuatBanService();
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
        fillComBoBoxLocCTSP();

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
        boxmodel.addElement("Tiền mặt");
        boxmodel.addElement("Chuyển khoản");
        boxmodel.addElement("Kết hợp");
    }

    public HoaDon taoHoaDon() {

        String maHD = "HD" + new Random().nextInt(100000);
        String nv = PhanQuyenNV.MaNV;
        int tongsanpham = 0;
        String trangthai = "Cho thanh toan";
        //SimpleDateFormat spdate = new SimpleDateFormat("dd-MM-yyyy");
        Date ngaytao = new java.util.Date();
        String makh = "KH000";
        return new HoaDon(makh, nv, "V000", null, maHD, null, null, ngaytao, trangthai, null, tongsanpham);
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
        int stt = 1;
        for (HoaDon hd : listHD) {
            Object[] row = new Object[]{stt, hd.getMaHoaDon(), hd.getNgayTao(), hd.getMaNhanVien(), hd.getTrangThai()};
            stt += 1;
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
        lblTienThua.setText("");
        cbxPhieuGiamGia.setSelectedIndex(0);
    }

//    ThanhToan getFormThanhToan() {
//
//        double tienThanhToan = Double.parseDouble(txtTienThanhToan.getText());
//        String hinhThucTT = (String) cbxHTthanhToan.getSelectedItem();
//        Date ngayTao = new java.util.Date();
//        return new ThanhToan(null, null, hinhThucTT, tienThanhToan, null, ngayTao, "Đã thanh toán", null);
//    }
    void fillComBoBoxLocCTSP() {
        boxmodel = (DefaultComboBoxModel) cbxLocLoaiSach.getModel();
        boxmodel.removeAllElements();
        boxmodel.addElement("Tất cả");
        for (TheLoai sp : TLservice.getAllTheLoai()) {
            String ten = sp.getTentheloai();
            boxmodel.addElement(ten);
        }
        boxmodel = (DefaultComboBoxModel) cbxLocNXB.getModel();
        boxmodel.removeAllElements();
        boxmodel.addElement("Tất cả");
        for (NhaXuatBan sp : NXBservice.getAllNhaXuatBan()) {
            String ten = sp.getTennhaxuatban();
            boxmodel.addElement(ten);
        }
        boxmodel = (DefaultComboBoxModel) cbxLocTacGia.getModel();
        boxmodel.removeAllElements();
        boxmodel.addElement("Tất cả");
        for (TacGia sp : TGservice.getAllTacGia()) {
            String ten = sp.getTentacgia();
            boxmodel.addElement(ten);
        }
    }

    void LocTheoTruongDacTrung() {
        // TODO add your handling code here:
        String maloailoc = "", manhaxuatbanloc = "", matacgialoc = "";
        if (cbxLocNXB.getSelectedIndex() >= 1) {
            for (NhaXuatBan sp : NXBservice.getAllNhaXuatBan()) {
                if (sp.getTennhaxuatban().equalsIgnoreCase(cbxLocNXB.getSelectedItem().toString())) {
                    manhaxuatbanloc = sp.getManhaxuatban();
                }
            }
        }
        if (cbxLocTacGia.getSelectedIndex() >= 1) {
            for (TacGia sp : TGservice.getAllTacGia()) {
                if (sp.getTentacgia().equalsIgnoreCase(cbxLocTacGia.getSelectedItem().toString())) {
                    matacgialoc = sp.getMatacgia();
                }
            }
        }
        if (cbxLocLoaiSach.getSelectedIndex() >= 1) {
            for (TheLoai sp : TLservice.getAllTheLoai()) {
                if (sp.getTentheloai().equalsIgnoreCase(cbxLocLoaiSach.getSelectedItem().toString())) {
                    maloailoc = sp.getMatheloai();
                }
            }
        }

        fillTableCTSP(spctService.LocSanPhamCT(maloailoc, manhaxuatbanloc, matacgialoc));
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
        jLabel17 = new javax.swing.JLabel();
        cbxHTthanhToan = new javax.swing.JComboBox<>();
        cbxPhieuGiamGia = new javax.swing.JComboBox<>();
        btnHuyHoaDon = new javax.swing.JButton();
        tbnThanhToan = new javax.swing.JButton();
        lblTienThua = new javax.swing.JLabel();
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
        cbxLocLoaiSach = new javax.swing.JComboBox<>();
        cbxLocNXB = new javax.swing.JComboBox<>();
        cbxLocTacGia = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã hóa đơn", "Ngày tạo", "Nhân viên", "Trạng thái"
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel5.setText("Mã hóa đơn:");

        txtMaHoaDon.setEnabled(false);

        txtMaNhanVien.setEnabled(false);

        jLabel9.setText("Mã nhân viên:");

        jLabel10.setText("Tổng tiền hàng:");

        txtTongTien.setEnabled(false);

        jLabel12.setText("Phiếu giảm giá:");

        txtTienThanhToan.setEnabled(false);

        jLabel13.setText("Khách cần trả:");

        jLabel14.setText("Tiền khách đưa:");

        txtTienKhachDua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTienKhachDuaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienKhachDuaKeyReleased(evt);
            }
        });

        jLabel15.setText("Tiền khách CK:");

        txtTienKhachChuyenKhoan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienKhachChuyenKhoanKeyReleased(evt);
            }
        });

        jLabel16.setText("Tiền thừa trả khách:");

        jLabel17.setText("HT thanh toán:");

        cbxHTthanhToan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxHTthanhToan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxHTthanhToanItemStateChanged(evt);
            }
        });

        cbxPhieuGiamGia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxPhieuGiamGia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxPhieuGiamGiaItemStateChanged(evt);
            }
        });
        cbxPhieuGiamGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPhieuGiamGiaActionPerformed(evt);
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
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtTienThanhToan)
                            .addComponent(txtTongTien, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaNhanVien, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaHoaDon, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxPhieuGiamGia, javax.swing.GroupLayout.Alignment.LEADING, 0, 205, Short.MAX_VALUE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel14)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxHTthanhToan, 0, 212, Short.MAX_VALUE)
                            .addComponent(txtTienKhachDua)
                            .addComponent(txtTienKhachChuyenKhoan)
                            .addComponent(lblTienThua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnHuyHoaDon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
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
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(lblTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnHuyHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(tbnThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 8, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
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
        tblGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGioHangMouseClicked(evt);
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
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(86, Short.MAX_VALUE)
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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblSPCTMouseEntered(evt);
            }
        });
        jScrollPane3.setViewportView(tblSPCT);

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        jLabel1.setText("Tìm kiếm:");

        cbxLocLoaiSach.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxLocLoaiSach.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxLocLoaiSachItemStateChanged(evt);
            }
        });

        cbxLocNXB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxLocNXB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxLocNXBItemStateChanged(evt);
            }
        });

        cbxLocTacGia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxLocTacGia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxLocTacGiaItemStateChanged(evt);
            }
        });

        jLabel4.setText("Loại sách:");

        jLabel18.setText("Nhà xuất bản:");

        jLabel20.setText("Tác giả:");

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
                        .addGap(53, 53, 53)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxLocLoaiSach, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel18)
                        .addGap(5, 5, 5)
                        .addComponent(cbxLocNXB, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel20)
                        .addGap(8, 8, 8)
                        .addComponent(cbxLocTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(91, 91, 91))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(cbxLocLoaiSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxLocNXB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxLocTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel18)
                    .addComponent(jLabel20))
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
                .addContainerGap())
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
        String maThanhToan = "TT" + new Random().nextInt(10000);
        if (bhService.themTT(maThanhToan) > 0) {
            if (bhService.themHD(taoHoaDon()) > 0) {
                fillTableHoaDon(bhService.getAllHD());
            }
        }

    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    private void tblSPCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSPCTMouseClicked
        // TODO add your handling code here:
        indexSPCT = tblSPCT.getSelectedRow();
        if (indexHoaDon >= 0) {
            if (indexSPCT >= 0) {
                String soluongStr = null;
                int soluongint = 0;
                GetMaSanPham.maSPCTthemvaogio = (String) tblSPCT.getValueAt(indexSPCT, 0);
                JFrame jf2 = new JFrame();
                ThemSPvaoGio tsp = new ThemSPvaoGio(jf2, true);
                tsp.setTitle("Nhập số lượng sản phẩm");
                tsp.setVisible(true);
                if (tsp.isVisible() == false) {
                    soluongint = tsp.soluongsp;
                }
                if (soluongint > 0) {
                    String maSPCT = (String) tblSPCT.getValueAt(indexSPCT, 0);
                    String maHD = (String) tblHoaDon.getValueAt(indexHoaDon, 1);
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
            String maHoaDon = (String) tblHoaDon.getValueAt(indexHoaDon, 1);
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

        }
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void btnChonKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonKhachHangActionPerformed
        // TODO add your handling code here:
        try {
            if (indexHoaDon >= 0) {
                String maHD = (String) tblHoaDon.getValueAt(indexHoaDon, 1);
                JFrame jf = new JFrame();
                KhachHangThanhToan khtt = new KhachHangThanhToan(jf, true);
                khtt.setTitle("Danh sách khách hàng");
                khtt.setVisible(true);
                if (khtt.isVisible() == false) {
                    txtMaKH.setText(khtt.listKH.get(0).getMaKH());
                    txtTenKH.setText(khtt.listKH.get(0).getTenKH());
                    bhService.UpdateHD(khtt.listKH.get(0).getMaKH(), "Cho thanh toan", maHD);
                }
            }
        } catch (Exception e) {
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
        String maHD = (String) tblHoaDon.getValueAt(indexHoaDon, 1);
        listHDCT = bhService.getHDCT(maHD);
        for (int i = 0; i < bhService.getHDCT(maHD).size(); i++) {
            tblGioHang.setValueAt(false, i, 7);
        }
        try {
            for (int i = 0; i < listHDCT.size(); i++) {
                System.out.println(tblGioHang.getValueAt(i, 7));
                if (tblGioHang.getValueAt(i, 7).equals(true)) {
                    System.out.println(tblGioHang.getValueAt(i, 7));
                    bhService.XoaSPtrongGioHang(listHDCT.get(i).getMaHoaDonCT());
                    bhService.CapNhatSPCTChuaThanhToan(listHDCT.get(i));
                }
            }
            
            fillTableCTSP(spctService.getAll2());
            fillFormHoaDon(bhService.getAllHD(), bhService.getHDCT(maHD));
            LoadGioHang(bhService.getHDCT(maHD));
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnXoaGioHangActionPerformed

    private void cbxPhieuGiamGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPhieuGiamGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxPhieuGiamGiaActionPerformed

    private void btnHuyHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyHoaDonActionPerformed
        // TODO add your handling code here:
        if (indexHoaDon >= 0) {
            int result = JOptionPane.showConfirmDialog(null, "Bạn có muốn hủy hóa đơn này không", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                String maHD = (String) tblHoaDon.getValueAt(indexHoaDon, 1);
                listHDCT = bhService.getHDCT(maHD);
                try {
                    for (int i = 0; i < listHDCT.size(); i++) {
                        System.out.println(tblGioHang.getValueAt(i, 7));
                        bhService.XoaSPtrongGioHang(listHDCT.get(i).getMaHoaDonCT());
                        bhService.CapNhatSPCTChuaThanhToan(listHDCT.get(i));
                    }
                    System.out.println(maHD);
                    String maTT = null;
                    for (HoaDon hd : bhService.getAllHD()) {
                        if (hd.getMaHoaDon().equalsIgnoreCase(maHD)) {
                            maTT = hd.getMaThanhToan();
                        }
                    }
                    bhService.UpdateTT("", 0, maTT, "Đã hủy");
                    bhService.XoaHoaDon(maHD);
                    fillTableHoaDon(bhService.getAllHD());
                    fillTableCTSP(spctService.getAll2());
                    LoadGioHang(bhService.getHDCT(maHD));
                    indexHoaDon = -1;
                } catch (Exception e) {
                }
                resetFormHoaDon();
            }
        }
    }//GEN-LAST:event_btnHuyHoaDonActionPerformed

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
        if (tenvoucher == "") {
            txtTienThanhToan.setText(txtTongTien.getText());
        }

    }//GEN-LAST:event_cbxPhieuGiamGiaItemStateChanged

    private void cbxHTthanhToanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxHTthanhToanItemStateChanged
        // TODO add your handling code here:
        try {
            if (cbxHTthanhToan.getSelectedItem() == "Kết hợp") {
                lblTienThua.setText("0");
                txtTienKhachChuyenKhoan.setText("");
                txtTienKhachDua.setText("");
                txtTienKhachDua.setEnabled(true);
                txtTienKhachChuyenKhoan.setEnabled(true);
                lblTienThua.setText("0");
            } else if (cbxHTthanhToan.getSelectedItem() == "Chuyển khoản") {
                lblTienThua.setText("0");
                txtTienKhachDua.setText("0");
                txtTienKhachDua.setEnabled(false);
                txtTienKhachChuyenKhoan.setEnabled(true);
                txtTienKhachChuyenKhoan.setText(txtTienThanhToan.getText());
                lblTienThua.setText("0");
            } else if (cbxHTthanhToan.getSelectedItem() == "Tiền mặt") {
                lblTienThua.setText("0");
                txtTienKhachChuyenKhoan.setText("0");
                txtTienKhachDua.setText("");
                txtTienKhachChuyenKhoan.setEnabled(false);
                txtTienKhachDua.setEnabled(true);
                lblTienThua.setText("0");

            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbxHTthanhToanItemStateChanged

    private void txtTienKhachDuaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachDuaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienKhachDuaKeyPressed

    private void txtTienKhachDuaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachDuaKeyReleased

        try {
            if (cbxHTthanhToan.getSelectedItem() == "Kết hợp") {
                txtTienKhachDua.setEnabled(true);
                txtTienKhachChuyenKhoan.setEnabled(true);
                double tienmat;
                double tienCK;
                if (txtTienKhachChuyenKhoan.getText().equalsIgnoreCase("")) {
                    tienCK = 0;
                } else {
                    tienCK = Double.parseDouble(txtTienKhachChuyenKhoan.getText());
                }
                if (txtTienKhachDua.getText().equalsIgnoreCase("")) {
                    tienmat = 0;
                } else {
                    tienmat = Double.parseDouble(txtTienKhachDua.getText());
                }
                if (((tienmat + tienCK) - Double.parseDouble(txtTienThanhToan.getText())) >= 0) {
                    lblTienThua.setText(String.valueOf((tienmat + tienCK) - Double.parseDouble(txtTienThanhToan.getText())));
                } else {
                    lblTienThua.setText("0");
                }

            } else if (cbxHTthanhToan.getSelectedItem() == "Tiền mặt") {
                txtTienKhachChuyenKhoan.setText("0");
                txtTienKhachChuyenKhoan.setEnabled(false);
                txtTienKhachDua.setEnabled(true);
                double tienmat = Double.parseDouble(txtTienKhachDua.getText());
                if (tienmat - (Double.parseDouble(txtTienThanhToan.getText())) >= 0) {
                    lblTienThua.setText(String.valueOf(tienmat - (Double.parseDouble(txtTienThanhToan.getText()))));
                }
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtTienKhachDuaKeyReleased

    private void tbnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnThanhToanActionPerformed
        // TODO add your handling code here:
        if (indexHoaDon >= 0) {
            double tienkhachdua = 0;
            double tienkhachck = 0;
            if (!txtTienKhachDua.getText().trim().equalsIgnoreCase("")) {
                tienkhachdua = Double.parseDouble(txtTienKhachDua.getText());
            }
            if (!txtTienKhachChuyenKhoan.getText().trim().equalsIgnoreCase("")) {
                tienkhachck = Double.parseDouble(txtTienKhachChuyenKhoan.getText());
            }
            if (tienkhachdua + tienkhachck >= Double.parseDouble(txtTienThanhToan.getText())) {
                String maHD = (String) tblHoaDon.getValueAt(indexHoaDon, 1);
                String maVoucher = "V000";

                for (Voucher vc : vcservice.getAll()) {
                    if (cbxPhieuGiamGia.getSelectedItem().equals(vc.getTenVoucher())) {
                        maVoucher = vc.getMaVoucher();
                    }
                }
                String tenVoucher = (String) cbxPhieuGiamGia.getSelectedItem();
                double tongtien = Double.parseDouble(txtTongTien.getText());
                String maTT = null;
                double tienThanhToan = Double.parseDouble(txtTienThanhToan.getText());
                String hinhThucTT = null;
                if (cbxHTthanhToan.getSelectedItem().equals("Tiền mặt")) {
                    hinhThucTT = "Tien mat";
                }
                if (cbxHTthanhToan.getSelectedItem().equals("Kết hợp")) {
                    hinhThucTT = "Ket hop";
                }
                if (cbxHTthanhToan.getSelectedItem().equals("Chuyển khoản")) {
                    hinhThucTT = "Chuyen khoan";
                }
                String trangthaitt = "Đã thanh toán";
                for (HoaDon hd : bhService.getAllHD()) {
                    if (hd.getMaHoaDon().equalsIgnoreCase(maHD)) {
                        maTT = hd.getMaThanhToan();
                    }
                }
                bhService.UpdateTT(hinhThucTT, tienThanhToan, maTT, trangthaitt);
                bhService.ThanhToanHD(maHD, maVoucher, tongtien);
                for (HoaDonChiTiet hoaDonChiTiet : bhService.getHDCT(maHD)) {
                    bhService.ThanhToanHDCT(hoaDonChiTiet.getMaHoaDonCT());
                }
                resetFormHoaDon();
                fillTableHoaDon(bhService.getAllHD());
                modelGioHang = (DefaultTableModel) tblGioHang.getModel();
                modelGioHang.setRowCount(0);
                GetMaSanPham.maHDpdf = maHD;
                int result = JOptionPane.showConfirmDialog(null, "Thanh toán thành công!" + "\nBạn có muốn xuất hóa đơn không?", "", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    try {
                        XuatHDpdf.main(new String[]{});
                        JOptionPane.showMessageDialog(this, "Xuất hóa đơn thành công");
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(BanHangForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                indexHoaDon = -1;
            } else {
                JOptionPane.showMessageDialog(this, "Thanh toán thất bại!" + "\nKhách chưa thanh toán đủ tiền hóa đơn");
            }
        }

    }//GEN-LAST:event_tbnThanhToanActionPerformed

    private void tblSPCTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSPCTMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblSPCTMouseEntered

    private void cbxLocLoaiSachItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxLocLoaiSachItemStateChanged
        // TODO add your handling code here:
        LocTheoTruongDacTrung();
        txtTimKiem.setText("");
    }//GEN-LAST:event_cbxLocLoaiSachItemStateChanged

    private void cbxLocNXBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxLocNXBItemStateChanged
        // TODO add your handling code here:
        LocTheoTruongDacTrung();
        txtTimKiem.setText("");
    }//GEN-LAST:event_cbxLocNXBItemStateChanged

    private void cbxLocTacGiaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxLocTacGiaItemStateChanged
        // TODO add your handling code here:
        LocTheoTruongDacTrung();
        txtTimKiem.setText("");
    }//GEN-LAST:event_cbxLocTacGiaItemStateChanged

    private void txtTienKhachChuyenKhoanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachChuyenKhoanKeyReleased
        // TODO add your handling code here:
        try {
            if (cbxHTthanhToan.getSelectedItem() == "Chuyển khoản") {
                lblTienThua.setText("0");
                txtTienKhachDua.setText("0");
                txtTienKhachDua.setEnabled(false);
                txtTienKhachChuyenKhoan.setEnabled(true);
                double tienCK = Double.parseDouble(txtTienKhachChuyenKhoan.getText());
                if (tienCK - Double.parseDouble(txtTienThanhToan.getText()) >= 0) {
                    lblTienThua.setText(String.valueOf(tienCK - Double.parseDouble(txtTienThanhToan.getText())));
                } else {
                    lblTienThua.setText("0");
                }
            }
            if (cbxHTthanhToan.getSelectedItem() == "Kết hợp") {
                txtTienKhachDua.setEnabled(true);
                txtTienKhachChuyenKhoan.setEnabled(true);
                double tienmat;
                double tienCK;
                if (txtTienKhachChuyenKhoan.getText().equalsIgnoreCase("")) {
                    tienCK = 0;
                } else {
                    tienCK = Double.parseDouble(txtTienKhachChuyenKhoan.getText());
                }
                if (txtTienKhachDua.getText().equalsIgnoreCase("")) {
                    tienmat = 0;
                } else {
                    tienmat = Double.parseDouble(txtTienKhachDua.getText());
                }
                if (((tienmat + tienCK) - Double.parseDouble(txtTienThanhToan.getText())) >= 0) {
                    lblTienThua.setText(String.valueOf((tienmat + tienCK) - Double.parseDouble(txtTienThanhToan.getText())));
                } else {
                    lblTienThua.setText("0");
                }

            }
        } catch (Exception e) {
        }

    }//GEN-LAST:event_txtTienKhachChuyenKhoanKeyReleased

    private void tblGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioHangMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tblGioHangMouseClicked

    private void btnQuetMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuetMaActionPerformed
        // TODO add your handling code here:JFrame qrFrame = new JFrame();
        JFrame qrFrame = new JFrame();
        QRcode3 qrc = new QRcode3(qrFrame, true);
        qrc.setVisible(true);

        List<SanPhamCT> qrDataList = qrc.getScannedData();
        if (qrDataList != null && !qrDataList.isEmpty()) {
            JFrame jf2 = new JFrame();
            GetMaSanPham.maSPCTthemvaogio = qrDataList.get(0).getMasachchitiet();
            ThemSPvaoGio tsp = new ThemSPvaoGio(jf2, true);
            tsp.setTitle("Nhập số lượng sản phẩm");
            tsp.setVisible(true);

            if (!tsp.isVisible()) {
                int soluongint = tsp.soluongsp;
                if (soluongint > 0) {
                    String maSPCT = qrDataList.get(0).getMasachchitiet();
                    String maHD = (String) tblHoaDon.getValueAt(indexHoaDon, 1);

                    boolean daTonTaiSP = false;
                    for (HoaDonChiTiet hdct : bhService.getHDCT(maHD)) {
                        if (hdct.getMaSPCT().equalsIgnoreCase(maSPCT)) {
                            daTonTaiSP = true;
                            if (bhService.CongDonSPCT(soluongint, hdct.getMaHoaDonCT()) > 0) {
                                LoadGioHang(bhService.getHDCT(maHD));
                            }
                            break;
                        }
                    }

                    if (!daTonTaiSP) {
                        if (bhService.themHDCT(themSPvaogiohang(maSPCT, soluongint, maHD)) > 0) {
                            LoadGioHang(bhService.getHDCT(maHD));
                        }
                    }

                    int soLuongTon = (int) tblSPCT.getValueAt(indexSPCT, 7) - soluongint;
                    if (soLuongTon >= 0 && spctService.CapNhatSoLuongSP(soLuongTon, maSPCT) > 0) {
                        fillTableCTSP(spctService.getAll2());
                    } else {
                        JOptionPane.showMessageDialog(null, "Không đủ số lượng tồn kho.");
                    }
                    fillFormHoaDon(bhService.getAllHD(), bhService.getHDCT(maHD));
                } else {
                    JOptionPane.showMessageDialog(null, "Số lượng sản phẩm phải lớn hơn 0.");
                }
            }
        }
    }//GEN-LAST:event_btnQuetMaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChonKhachHang;
    private javax.swing.JButton btnHuyHoaDon;
    private javax.swing.JButton btnQuetMa;
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnXoaGioHang;
    private javax.swing.JComboBox<String> cbxHTthanhToan;
    private javax.swing.JComboBox<String> cbxLocLoaiSach;
    private javax.swing.JComboBox<String> cbxLocNXB;
    private javax.swing.JComboBox<String> cbxLocTacGia;
    private javax.swing.JComboBox<String> cbxPhieuGiamGia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JLabel lblTienThua;
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
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
