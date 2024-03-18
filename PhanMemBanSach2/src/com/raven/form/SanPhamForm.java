/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form;

import com.raven.model.HinhAnh;
import com.raven.model.NhaCungCap;
import com.raven.model.NhaXuatBan;
import com.raven.model.SanPham;
import com.raven.model.SanPhamCT;
import com.raven.model.TacGia;
import com.raven.model.TheLoai;
import com.raven.service.HinhAnhService;
import com.raven.service.NhaCungCapService;
import com.raven.service.NhaXuatBanService;
import com.raven.service.SanPhamCTservice;
import com.raven.service.SanPhamService;
import com.raven.service.TacGiaService;
import com.raven.service.TheLoaiService;
import com.raven.utils.GetMaSanPham;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SanPhamForm extends javax.swing.JPanel {

    DefaultTableModel model = new DefaultTableModel();
    DefaultComboBoxModel boxmodel = new DefaultComboBoxModel<>();
    SanPhamCTservice spctService = new SanPhamCTservice();
    SanPhamService spservice = new SanPhamService();
    TheLoaiService TLservice = new TheLoaiService();
    TacGiaService TGservice = new TacGiaService();
    NhaXuatBanService NXBservice = new NhaXuatBanService();
    NhaCungCapService NCCservice = new NhaCungCapService();
    HinhAnhService haservice = new HinhAnhService();
    int index = -1;
    String duongdananh = "";
    String loailoc = "", nhaxuatbanloc = "", tacgialoc = "", trangthailoc = "";

    public SanPhamForm() {
        initComponents();
        fillTableSP(spservice.getAll());
        fillComboboxCTSP();
        fillComBoBoxLocCTSP();
        setFormAnThuocTinh();
        rdoTacGia.setSelected(true);
        fillTableThuocTinhTacGia(TGservice.getAllTacGia());
        fillTableCTSP(spctService.getAll2());

    }
//-----------------Tab sản phẩm-------------------------------------

    public void fillTableSP(List<SanPham> list) {
        model = (DefaultTableModel) tblSanPham.getModel();
        model.setRowCount(0);
        int index = 1;
        for (SanPham sp : list) {
            Object[] row = new Object[]{index, sp.getMaSach(), sp.getTenSach()};
            index += 1;
            model.addRow(row);
        }

    }

    public void setFormSP(SanPham sp) {
        txtMaSP.setText(sp.getMaSach());
        txtTenSP.setText(sp.getTenSach());
        // btnThemSP.setEnabled(false); ẩn button
    }

    public SanPham getForm() {
        String ma;
        String ten;
        Date ngaytao, ngaysua;
        ma = "S" + new Random().nextInt(10000);
        for (SanPham sp : spservice.getAll()) {
            if (sp.getMaSach().equalsIgnoreCase(ma)) {
                ma = "S" + new Random().nextInt(10000);
            }
        }
        ten = txtTenSP.getText();
        ngaytao = new java.util.Date();
        ngaysua = new java.util.Date();
        return new SanPham(null, ma, ten, ngaytao, ten, ngaysua);
    }

    public void resetForm() {
        txtMaSP.setText("");
        txtTenSP.setText("");
    }

    public boolean checkTrongSP() {
        if (txtTenSP.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được bỏ trống tên sản phẩm");
            return false;
        }
        return true;
    }

    //-----------------Tab chi tiết sản phẩm-------------------------------------
    public void fillTableCTSP(List<SanPhamCT> list) {
        model = (DefaultTableModel) tblChiTietSP.getModel();
        model.setRowCount(0);
        for (SanPhamCT sp : list) {
            Object[] row = new Object[]{sp.getMasach(), sp.getMasachchitiet(), sp.getTensach(), sp.getTentacgia(), sp.getTentheloai(), sp.getTennhacungcap(), sp.getTenanh(), sp.getTennhaxuatban(), sp.getDongia(), sp.getSoluong(), sp.getNgaytao(), sp.getMota(), sp.getNgaysua(), sp.getTrangthai()};
            model.addRow(row);

        }

    }

    public void fillComboboxCTSP() {
        boxmodel = (DefaultComboBoxModel) cbxTenSP.getModel();
        boxmodel.removeAllElements();
        for (SanPham sp : spservice.getAll()) {
            String ten = sp.getTenSach();
            boxmodel.addElement(ten);
        }
        boxmodel = (DefaultComboBoxModel) cbxCTnhaCC.getModel();
        boxmodel.removeAllElements();
        for (NhaCungCap sp : NCCservice.getAllNhaCungCap()) {
            String ten = sp.getTennhacungcap();
            boxmodel.addElement(ten);
        }
        boxmodel = (DefaultComboBoxModel) cbxCTnhaXB.getModel();
        boxmodel.removeAllElements();
        for (NhaXuatBan sp : NXBservice.getAllNhaXuatBan()) {
            String ten = sp.getTennhaxuatban();
            boxmodel.addElement(ten);
        }
        boxmodel = (DefaultComboBoxModel) cbxCTtacGia.getModel();
        boxmodel.removeAllElements();
        for (TacGia sp : TGservice.getAllTacGia()) {
            String ten = sp.getTentacgia();
            boxmodel.addElement(ten);
        }
        boxmodel = (DefaultComboBoxModel) cbxCTtheLoai.getModel();
        boxmodel.removeAllElements();
        for (TheLoai sp : TLservice.getAllTheLoai()) {
            String ten = sp.getTentheloai();
            boxmodel.addElement(ten);
        }
        boxmodel = (DefaultComboBoxModel) cbxHinhAnh.getModel();
        boxmodel.removeAllElements();
        for (HinhAnh sp : haservice.getAllHinhAnh()) {
            String ten = sp.getTenhinhanh();
            boxmodel.addElement(ten);
        }
    }

    public ImageIcon resizeImage2(String ImagePath) {

        ImageIcon image = null;
        try {
            ImageIcon myImage = new ImageIcon(ImagePath);
            Image img = myImage.getImage();
            Image newImg = img.getScaledInstance(lblhinhAnhCtSP.getWidth(), lblhinhAnhCtSP.getHeight(), Image.SCALE_SMOOTH);
            image = new ImageIcon(newImg);
        } catch (Exception e) {
            System.out.println("Khong co anh");
        }

        return image;
    }

    void setFormCTSP(SanPhamCT sp) {
        cbxTenSP.setSelectedItem(sp.getTensach());
        txtMaCTSP.setText(sp.getMasachchitiet());
        txtCTdonGia.setText(String.valueOf(sp.getDongia()));
        txtCTsoLuong.setText(String.valueOf(sp.getSoluong()));
        txtCTmoTa.setText(sp.getMota());
        cbxCTnhaCC.setSelectedItem(sp.getTennhacungcap());
        cbxCTnhaXB.setSelectedItem(sp.getTennhaxuatban());
        cbxCTtacGia.setSelectedItem(sp.getTentacgia());
        cbxCTtheLoai.setSelectedItem(sp.getTentheloai());
        cbxHinhAnh.setSelectedItem(sp.getTenanh());
        lblhinhAnhCtSP.setIcon(resizeImage2(haservice.timduongdananh(sp.getTenanh())));
    }

    SanPhamCT getFormSPCT() {
        String tenSP, maSPCT, nhaxuatban, nhacungcap, theloai, tacgia, hinhanh, mota, trangthai = "Hoạt động";
        double dongia;
        int soluong;
        Date ngayTao, ngaySua;
        tenSP = cbxTenSP.getSelectedItem().toString();
        maSPCT = "SCT" + new Random().nextInt(10000);
        for (HinhAnh ha : haservice.getAllHinhAnh()) {
            if (ha.getMahinhanh().equalsIgnoreCase(maSPCT)) {
                maSPCT = "SCT" + new Random().nextInt(10000);
            }
        }
        nhaxuatban = cbxCTnhaXB.getSelectedItem().toString();
        nhacungcap = cbxCTnhaCC.getSelectedItem().toString();
        theloai = cbxCTtheLoai.getSelectedItem().toString();
        tacgia = cbxCTtacGia.getSelectedItem().toString();
        hinhanh = cbxHinhAnh.getSelectedItem().toString();
        mota = txtCTmoTa.getText();
        dongia = Double.parseDouble(txtCTdonGia.getText());
        soluong = Integer.parseInt(txtCTsoLuong.getText());
        ngayTao = new java.util.Date();
        ngaySua = new java.util.Date();
        return new SanPhamCT(null, maSPCT, tenSP, tacgia, theloai, nhacungcap, hinhanh, nhaxuatban, dongia, soluong, ngayTao, trangthai, ngaySua, mota);
    }

    void resetFormCTSP() {
        cbxTenSP.setSelectedIndex(-1);
        txtMaCTSP.setText("");
        txtCTdonGia.setText("");
        txtCTsoLuong.setText("");
        txtCTmoTa.setText("");
        cbxCTnhaCC.setSelectedIndex(-1);
        cbxCTnhaXB.setSelectedIndex(-1);
        cbxCTtacGia.setSelectedIndex(-1);
        cbxCTtheLoai.setSelectedIndex(-1);
    }

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
        boxmodel = (DefaultComboBoxModel) cbxTrangThaiSPCT.getModel();
        boxmodel.removeAllElements();
        boxmodel.addElement("Hoạt động");
        boxmodel.addElement("Không hoạt động");
    }
    //------------------Thuộc tính sản phẩm----------------------------

    public ImageIcon resizeImage(String ImagePath) {
        ImageIcon myImage = new ImageIcon(ImagePath);
        Image img = myImage.getImage();
        Image newImg = img.getScaledInstance(lblanh.getWidth(), lblanh.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    HinhAnh getThuocTinhAnh() {
        String ma;
        String ten;
        Date ngayTao;
        Date ngaySua;
        ten = txtTenThuocTinh.getText();
        ma = "HA" + new Random().nextInt(10000);
        for (HinhAnh ha : haservice.getAllHinhAnh()) {
            if (ha.getMahinhanh().equalsIgnoreCase(ma)) {
                ma = "HA" + new Random().nextInt(10000);
            }
        }
        ngayTao = new java.util.Date();
        ngaySua = new java.util.Date();
        return new HinhAnh(null, ma, ten, duongdananh, ngayTao, null, ngaySua);
        //chưa hoàn thiện hàm này
    }

    void setFormThuocTinhHA(HinhAnh ha) {
        txtMaThuocTinh.setText(ha.getMahinhanh());
        txtTenThuocTinh.setText(ha.getTenhinhanh());
        lblanh.setIcon(resizeImage(ha.getDuongdananh()));
    }

    void setFormAnThuocTinh() {
        pannelHinhAnh.setVisible(false);
        txtSĐTthuocTinh.setVisible(false);
        txtDiaChiThuocTinh.setVisible(false);
        lblDiaChi.setVisible(false);
        lblSĐT.setVisible(false);
    }

    void fillTableThuocTinhHinhAnh(List<HinhAnh> list) {
        model = (DefaultTableModel) tblthuoctinh.getModel();
        model.setRowCount(0);
        model.setColumnCount(0);
        model.addColumn("Mã thuộc tính");
        model.addColumn("Tên");
        model.addColumn("Đường dẫn ảnh");
        for (HinhAnh ha : list) {
            Object[] row = new Object[]{ha.getMahinhanh(), ha.getTenhinhanh(), ha.getDuongdananh()};
            model.addRow(row);
        }
    }

    void fillTableThuocTinhTacGia(List<TacGia> list) {
        model = (DefaultTableModel) tblthuoctinh.getModel();
        model.setRowCount(0);
        model.setColumnCount(0);
        model.addColumn("Mã thuộc tính");
        model.addColumn("Tên");
        for (TacGia tg : list) {
            Object[] row = new Object[]{tg.getMatacgia(), tg.getTentacgia()};
            model.addRow(row);
        }
    }

    void setFormThuocTinhTacGia(TacGia tg) {
        txtMaThuocTinh.setText(tg.getMatacgia());
        txtTenThuocTinh.setText(tg.getTentacgia());
    }

    boolean checkTrongThuocTinh() {
        if (txtTenThuocTinh.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được bỏ trống tên ");
            return false;
        }
        return true;
    }

    TacGia getFormThuocTinhTacGia() {
        String ma;
        String ten;
        Date ngayTao;
        String trangthai = null;
        Date ngaySua;
        ma = "TG" + new Random().nextInt(10000);
        for (TacGia ha : TGservice.getAllTacGia()) {
            if (ha.getMatacgia().equalsIgnoreCase(ma)) {
                ma = "TG" + new Random().nextInt(10000);
            }
        }
        ten = txtTenThuocTinh.getText();
        ngayTao = new java.util.Date();
        ngaySua = new java.util.Date();
        return new TacGia(null, ma, ten, ngayTao, trangthai, ngaySua);
    }

    void fillTableThuocTinhTheLoai(List<TheLoai> list) {
        model = (DefaultTableModel) tblthuoctinh.getModel();
        model.setRowCount(0);
        model.setColumnCount(0);
        model.addColumn("Mã thuộc tính");
        model.addColumn("Tên");
        for (TheLoai tl : list) {
            Object[] row = new Object[]{tl.getMatheloai(), tl.getTentheloai()};
            model.addRow(row);
        }
    }

    void setFormThuocTinhTheLoai(TheLoai tl) {
        txtMaThuocTinh.setText(tl.getMatheloai());
        txtTenThuocTinh.setText(tl.getTentheloai());
    }

    TheLoai getFormThuocTinhTheLoai() {
        String ma;
        String ten;
        Date ngayTao;
        String trangthai = null;
        Date ngaySua;
        ma = "TL" + new Random().nextInt(10000);
        for (TheLoai ha : TLservice.getAllTheLoai()) {
            if (ha.getMatheloai().equalsIgnoreCase(ma)) {
                ma = "TL" + new Random().nextInt(10000);
            }
        }
        ten = txtTenThuocTinh.getText();
        ngayTao = new java.util.Date();
        ngaySua = new java.util.Date();
        return new TheLoai(null, ma, ten, ngayTao, trangthai, ngaySua);
    }

    void fillTableThuocTinhNCC() {
        model = (DefaultTableModel) tblthuoctinh.getModel();
        model.setRowCount(0);
        model.setColumnCount(0);
        model.addColumn("Mã thuộc tính");
        model.addColumn("Tên");
        model.addColumn("Địa chỉ");
        model.addColumn("Số điện thoại");
        for (NhaCungCap ncc : NCCservice.getAllNhaCungCap()) {
            Object[] row = new Object[]{ncc.getManhacungcap(), ncc.getTennhacungcap(), ncc.getDiachi(), ncc.getSdt()};
            model.addRow(row);
        }
    }

    void setFormThuocTinhNCC(NhaCungCap ncc) {
        txtMaThuocTinh.setText(ncc.getManhacungcap());
        txtTenThuocTinh.setText(ncc.getTennhacungcap());
        txtDiaChiThuocTinh.setText(ncc.getDiachi());
        txtSĐTthuocTinh.setText(ncc.getSdt());
    }

    NhaCungCap getFormThuocTinhNCC() {
        String ma, ten, diachi, sdt, trangthai = null;
        Date ngayTao, NgaySua;
        ma = "NCC" + new Random().nextInt(10000);
        for (NhaCungCap ncc : NCCservice.getAllNhaCungCap()) {
            if (ncc.getManhacungcap().equalsIgnoreCase(ma)) {
                ma = "NCC" + new Random().nextInt(10000);
            }
        }
        ten = txtTenThuocTinh.getText();
        diachi = txtDiaChiThuocTinh.getText();
        sdt = txtSĐTthuocTinh.getText();
        ngayTao = new java.util.Date();
        NgaySua = new java.util.Date();
        return new NhaCungCap(null, ma, ten, diachi, sdt, ngayTao, trangthai, NgaySua);
    }

    void fillTableThuocTinhNXB() {
        model = (DefaultTableModel) tblthuoctinh.getModel();
        model.setRowCount(0);
        model.setColumnCount(0);
        model.addColumn("Mã thuộc tính");
        model.addColumn("Tên");
        model.addColumn("Địa chỉ");
        model.addColumn("Số điện thoại");
        for (NhaXuatBan nxb : NXBservice.getAllNhaXuatBan()) {
            Object[] row = new Object[]{nxb.getManhaxuatban(), nxb.getTennhaxuatban(), nxb.getDiachi(), nxb.getSdt()};
            model.addRow(row);
        }
    }

    void setFormThuocTinhNXB(NhaXuatBan nxb) {
        txtMaThuocTinh.setText(nxb.getManhaxuatban());
        txtTenThuocTinh.setText(nxb.getTennhaxuatban());
        txtDiaChiThuocTinh.setText(nxb.getDiachi());
        txtSĐTthuocTinh.setText(nxb.getSdt());
    }

    NhaXuatBan getFormThuocTinhNXB() {
        String ma, ten, diachi, sdt, trangthai = null;
        Date ngayTao, NgaySua;
        ma = "NXB" + new Random().nextInt(10000);
        for (NhaCungCap ncc : NCCservice.getAllNhaCungCap()) {
            if (ncc.getManhacungcap().equalsIgnoreCase(ma)) {
                ma = "NXB" + new Random().nextInt(10000);
            }
        }
        ten = txtTenThuocTinh.getText();
        diachi = txtDiaChiThuocTinh.getText();
        sdt = txtSĐTthuocTinh.getText();
        ngayTao = new java.util.Date();
        NgaySua = new java.util.Date();
        return new NhaXuatBan(null, ma, ten, diachi, sdt, ngayTao, trangthai, NgaySua);
    }

    void XoaTrangTT() {
        txtTenThuocTinh.setText("");
        txtMaThuocTinh.setText("");
        txtDiaChiThuocTinh.setText("");
        txtSĐTthuocTinh.setText("");
    }

    void LocTheoTruongDacTrung() {
        // TODO add your handling code here:
        if (cbxLocLoaiSach.getSelectedIndex() >= 1) {
            loailoc = cbxLocLoaiSach.getSelectedItem().toString();
        } else if (cbxLocNXB.getSelectedIndex() >= 1) {
            nhaxuatbanloc = cbxLocNXB.getSelectedItem().toString();
        } else if (cbxLocTacGia.getSelectedIndex() >= 1) {
            tacgialoc = cbxLocTacGia.getSelectedItem().toString();
        }
        trangthailoc = cbxTrangThaiSPCT.getSelectedItem().toString();

        fillTableCTSP(spctService.LocSanPhamCT(loailoc, nhaxuatbanloc, tacgialoc, trangthailoc));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane5 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        TabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        txtTenSP = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        btnThemSP = new javax.swing.JButton();
        btnSuaSP = new javax.swing.JButton();
        btnChiTietSP = new javax.swing.JButton();
        btnLamMoiSP = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtTimKiemSP = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtCTsoLuong = new javax.swing.JTextField();
        txtMaCTSP = new javax.swing.JTextField();
        txtCTdonGia = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jpnCTanh = new javax.swing.JPanel();
        lblhinhAnhCtSP = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        btnCTthemSP = new javax.swing.JButton();
        btnCTcapnhatSP = new javax.swing.JButton();
        btnCT_reset = new javax.swing.JButton();
        btnExport_excel = new javax.swing.JButton();
        btnTaimauExcel = new javax.swing.JButton();
        btnImport_excel = new javax.swing.JButton();
        btnXoaTrangThai = new javax.swing.JButton();
        cbxTenSP = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        cbxCTnhaXB = new javax.swing.JComboBox<>();
        cbxCTnhaCC = new javax.swing.JComboBox<>();
        cbxCTtheLoai = new javax.swing.JComboBox<>();
        cbxCTtacGia = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtCTmoTa = new javax.swing.JTextArea();
        cbxHinhAnh = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblChiTietSP = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtSearchSPCT = new javax.swing.JTextField();
        cbxLocNXB = new javax.swing.JComboBox<>();
        cbxLocLoaiSach = new javax.swing.JComboBox<>();
        cbxLocTacGia = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbxTrangThaiSPCT = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        rdoNXB = new javax.swing.JRadioButton();
        rdoTheLoai = new javax.swing.JRadioButton();
        rdoNhaCungCap = new javax.swing.JRadioButton();
        rdoTacGia = new javax.swing.JRadioButton();
        rdoAnhSP = new javax.swing.JRadioButton();
        jPanel18 = new javax.swing.JPanel();
        btnSuaThuocTinh = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnXoaTrang = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        txtMaThuocTinh = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtTenThuocTinh = new javax.swing.JTextField();
        lblDiaChi = new javax.swing.JLabel();
        txtDiaChiThuocTinh = new javax.swing.JTextField();
        lblSĐT = new javax.swing.JLabel();
        txtSĐTthuocTinh = new javax.swing.JTextField();
        pannelHinhAnh = new javax.swing.JPanel();
        lblanh = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblthuoctinh = new javax.swing.JTable();

        jScrollPane5.setViewportView(jEditorPane1);

        setBackground(new java.awt.Color(242, 242, 242));

        TabbedPane1.setBackground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(242, 242, 242));

        jPanel3.setBackground(new java.awt.Color(242, 242, 242));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        jPanel4.setBackground(new java.awt.Color(242, 242, 242));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Mã sản phẩm :");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Tên sản phẩm :");

        txtMaSP.setEnabled(false);

        txtTenSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenSPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtMaSP, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(15, 15, 15)
                        .addComponent(txtTenSP)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        jPanel5.setBackground(new java.awt.Color(242, 242, 242));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnThemSP.setText("Thêm");
        btnThemSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSPActionPerformed(evt);
            }
        });

        btnSuaSP.setText("Sửa");
        btnSuaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaSPActionPerformed(evt);
            }
        });

        btnChiTietSP.setText("Chi tiết sản phẩm");
        btnChiTietSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietSPActionPerformed(evt);
            }
        });

        btnLamMoiSP.setText("Làm mới");
        btnLamMoiSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiSPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnChiTietSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSuaSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThemSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLamMoiSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThemSP)
                .addGap(18, 18, 18)
                .addComponent(btnSuaSP)
                .addGap(12, 12, 12)
                .addComponent(btnChiTietSP)
                .addGap(18, 18, 18)
                .addComponent(btnLamMoiSP)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(512, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(242, 242, 242));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách sản phẩm :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel6.setForeground(new java.awt.Color(0, 0, 0));

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Tìm kiếm :");

        txtTimKiemSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtTimKiemSPMousePressed(evt);
            }
        });
        txtTimKiemSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemSPActionPerformed(evt);
            }
        });
        txtTimKiemSP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemSPKeyReleased(evt);
            }
        });

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "STT", "Mã Sách", "Tên Sách"
            }
        ));
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblSanPhamMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblSanPham);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(42, 42, 42)
                        .addComponent(txtTimKiemSP, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 704, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTimKiemSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 492, Short.MAX_VALUE)
                .addContainerGap())
        );

        TabbedPane1.addTab("Sản Phẩm", jPanel2);

        jPanel7.setBackground(new java.awt.Color(242, 242, 242));

        jPanel8.setBackground(new java.awt.Color(242, 242, 242));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Mã CT Sản phẩm : ");

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Tên sản phẩm :");

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Thể loại :");

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Tác giả :");

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Nhà xuất bản :");

        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Nhà cung cấp :");

        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Số lượng :");

        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Đơn giá :");

        txtCTsoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCTsoLuongActionPerformed(evt);
            }
        });

        txtMaCTSP.setEnabled(false);
        txtMaCTSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaCTSPActionPerformed(evt);
            }
        });

        txtCTdonGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCTdonGiaActionPerformed(evt);
            }
        });

        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Hình ảnh: ");

        jpnCTanh.setBackground(new java.awt.Color(242, 242, 242));
        jpnCTanh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jpnCTanhLayout = new javax.swing.GroupLayout(jpnCTanh);
        jpnCTanh.setLayout(jpnCTanhLayout);
        jpnCTanhLayout.setHorizontalGroup(
            jpnCTanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblhinhAnhCtSP, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
        );
        jpnCTanhLayout.setVerticalGroup(
            jpnCTanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblhinhAnhCtSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel10.setBackground(new java.awt.Color(242, 242, 242));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnCTthemSP.setText("Thêm sản phẩm");
        btnCTthemSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCTthemSPActionPerformed(evt);
            }
        });

        btnCTcapnhatSP.setText("Cập nhật sản phẩm");
        btnCTcapnhatSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCTcapnhatSPActionPerformed(evt);
            }
        });

        btnCT_reset.setText("Làm mới");
        btnCT_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCT_resetActionPerformed(evt);
            }
        });

        btnExport_excel.setText("Export file excel");
        btnExport_excel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExport_excelActionPerformed(evt);
            }
        });

        btnTaimauExcel.setText("Tải mẫu excel");
        btnTaimauExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaimauExcelActionPerformed(evt);
            }
        });

        btnImport_excel.setText("Import file excel");

        btnXoaTrangThai.setText("Xóa");
        btnXoaTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaTrangThaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCTcapnhatSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCTthemSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCT_reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExport_excel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTaimauExcel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnImport_excel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoaTrangThai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCTthemSP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCTcapnhatSP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCT_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExport_excel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTaimauExcel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnImport_excel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXoaTrangThai)
                .addGap(13, 13, 13))
        );

        cbxTenSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Mô tả:");

        cbxCTnhaXB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxCTnhaCC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxCTtheLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxCTtacGia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxCTtacGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCTtacGiaActionPerformed(evt);
            }
        });

        txtCTmoTa.setColumns(20);
        txtCTmoTa.setRows(5);
        jScrollPane3.setViewportView(txtCTmoTa);

        cbxHinhAnh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxHinhAnh.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxHinhAnhItemStateChanged(evt);
            }
        });
        cbxHinhAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxHinhAnhActionPerformed(evt);
            }
        });

        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Hình ảnh sản phẩm:");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15))
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxTenSP, 0, 299, Short.MAX_VALUE)
                    .addComponent(txtMaCTSP)
                    .addComponent(txtCTsoLuong)
                    .addComponent(txtCTdonGia)
                    .addComponent(jScrollPane3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxCTnhaCC, 0, 236, Short.MAX_VALUE)
                    .addComponent(cbxCTtheLoai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxCTtacGia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxCTnhaXB, 0, 236, Short.MAX_VALUE)
                    .addComponent(cbxHinhAnh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addComponent(jpnCTanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)))
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cbxTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtMaCTSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxCTnhaCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(cbxCTnhaXB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel12)
                    .addComponent(txtCTsoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCTtheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCTdonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel9)
                    .addComponent(cbxCTtacGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbxHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16)))
                .addGap(20, 20, 20))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnCTanh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(38, 38, 38))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(242, 242, 242));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        jPanel9.setBackground(new java.awt.Color(242, 242, 242));

        tblChiTietSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Sách", "Mã Sách Chi Tiết", "Tên Sách", "Tên Tác Giả", "Tên Thể Loại", "Tên Nhà Cung Cấp", "Tên ảnh", "Tên Nhà Xuất Bản", "Đơn Giá", "Số Lượng", "Ngày Tạo", "Mô tả", "Ngày Sửa", "Trạng thái"
            }
        ));
        tblChiTietSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChiTietSPMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblChiTietSP);

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Tìm kiếm:");

        txtSearchSPCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtSearchSPCTMousePressed(evt);
            }
        });
        txtSearchSPCT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchSPCTKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchSPCTKeyReleased(evt);
            }
        });

        cbxLocNXB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxLocNXB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxLocNXBItemStateChanged(evt);
            }
        });
        cbxLocNXB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxLocNXBActionPerformed(evt);
            }
        });

        cbxLocLoaiSach.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxLocLoaiSach.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxLocLoaiSachItemStateChanged(evt);
            }
        });
        cbxLocLoaiSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxLocLoaiSachMouseClicked(evt);
            }
        });
        cbxLocLoaiSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxLocLoaiSachActionPerformed(evt);
            }
        });

        cbxLocTacGia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxLocTacGia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxLocTacGiaItemStateChanged(evt);
            }
        });
        cbxLocTacGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxLocTacGiaActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Trạng thái:");

        cbxTrangThaiSPCT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxTrangThaiSPCT.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxTrangThaiSPCTItemStateChanged(evt);
            }
        });
        cbxTrangThaiSPCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTrangThaiSPCTActionPerformed(evt);
            }
        });

        jButton1.setText("Xóa");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Khôi phục");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(39, 39, 39))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearchSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(cbxLocLoaiSach, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(cbxLocNXB, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(cbxLocTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cbxTrangThaiSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(264, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1240, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSearchSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxLocNXB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxLocLoaiSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxLocTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cbxTrangThaiSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        TabbedPane1.addTab("Sản Phẩm Chi Tiết", jPanel7);

        jPanel1.setBackground(new java.awt.Color(242, 242, 242));

        jPanel13.setBackground(new java.awt.Color(242, 242, 242));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thiết lập thuộc tính", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        jPanel15.setBackground(new java.awt.Color(242, 242, 242));
        jPanel15.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel15.setForeground(new java.awt.Color(0, 0, 0));
        jPanel15.setToolTipText("");

        buttonGroup1.add(rdoNXB);
        rdoNXB.setForeground(new java.awt.Color(0, 0, 0));
        rdoNXB.setText("Nhà xuất bản");
        rdoNXB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNXBActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoTheLoai);
        rdoTheLoai.setForeground(new java.awt.Color(0, 0, 0));
        rdoTheLoai.setText("Thể loại");
        rdoTheLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoTheLoaiActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoNhaCungCap);
        rdoNhaCungCap.setForeground(new java.awt.Color(0, 0, 0));
        rdoNhaCungCap.setText("Nhà cung cấp");
        rdoNhaCungCap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNhaCungCapActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoTacGia);
        rdoTacGia.setForeground(new java.awt.Color(0, 0, 0));
        rdoTacGia.setText("Tác giả");
        rdoTacGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoTacGiaActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoAnhSP);
        rdoAnhSP.setForeground(new java.awt.Color(0, 0, 0));
        rdoAnhSP.setText("Ảnh sản phẩm");
        rdoAnhSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoAnhSPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rdoAnhSP)
                    .addComponent(rdoNXB))
                .addGap(43, 43, 43)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdoNhaCungCap)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(rdoTacGia)
                        .addGap(44, 44, 44)
                        .addComponent(rdoTheLoai)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoNXB)
                    .addComponent(rdoTacGia)
                    .addComponent(rdoTheLoai))
                .addGap(52, 52, 52)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoNhaCungCap)
                    .addComponent(rdoAnhSP))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel18.setBackground(new java.awt.Color(242, 242, 242));
        jPanel18.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel18.setForeground(new java.awt.Color(0, 0, 0));

        btnSuaThuocTinh.setText("Sửa");
        btnSuaThuocTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaThuocTinhActionPerformed(evt);
            }
        });

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoaTrang.setText("Xóa trắng");
        btnXoaTrang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaTrangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnXoaTrang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSuaThuocTinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btnThem)
                .addGap(43, 43, 43)
                .addComponent(btnSuaThuocTinh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXoaTrang)
                .addGap(60, 60, 60))
        );

        jPanel14.setBackground(new java.awt.Color(242, 242, 242));
        jPanel14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Mã thuộc tính:");

        txtMaThuocTinh.setEnabled(false);

        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Tên thuộc tính:");

        lblDiaChi.setForeground(new java.awt.Color(0, 0, 0));
        lblDiaChi.setText("Địa chỉ:");

        lblSĐT.setForeground(new java.awt.Color(0, 0, 0));
        lblSĐT.setText("Số điện thoại:");

        pannelHinhAnh.setBackground(new java.awt.Color(255, 255, 255));
        pannelHinhAnh.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblanh.setForeground(new java.awt.Color(0, 0, 0));
        lblanh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblanhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pannelHinhAnhLayout = new javax.swing.GroupLayout(pannelHinhAnh);
        pannelHinhAnh.setLayout(pannelHinhAnhLayout);
        pannelHinhAnhLayout.setHorizontalGroup(
            pannelHinhAnhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelHinhAnhLayout.createSequentialGroup()
                .addComponent(lblanh, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addContainerGap())
        );
        pannelHinhAnhLayout.setVerticalGroup(
            pannelHinhAnhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pannelHinhAnhLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblanh, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(lblSĐT)
                        .addGap(31, 31, 31)
                        .addComponent(txtSĐTthuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(lblDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(txtDiaChiThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(26, 26, 26)
                        .addComponent(txtTenThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(26, 26, 26)
                        .addComponent(txtMaThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(pannelHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txtMaThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(txtTenThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDiaChi)
                            .addComponent(txtDiaChiThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSĐT)
                            .addComponent(txtSĐTthuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(pannelHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel17.setBackground(new java.awt.Color(242, 242, 242));
        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách thuộc tính", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel17.setForeground(new java.awt.Color(255, 255, 255));

        tblthuoctinh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblthuoctinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblthuoctinhMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblthuoctinh);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
            .addComponent(jPanel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TabbedPane1.addTab("Thuộc tính sản phẩm", jPanel12);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TabbedPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(TabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 784, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTenSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenSPActionPerformed

    private void txtTimKiemSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemSPActionPerformed

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked

        index = tblSanPham.getSelectedRow();
        setFormSP(spservice.getAtSP(index));
        // JOptionPane.showMessageDialog(this, evt.getClickCount());
        GetMaSanPham.indexSP = index;
        GetMaSanPham.maSanPham = txtMaSP.getText();

    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void txtTimKiemSPMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimKiemSPMousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtTimKiemSPMousePressed

    private void txtTimKiemSPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemSPKeyReleased
        // TODO add your handling code here:
        String ten = txtTimKiemSP.getText();
        if (!ten.trim().isEmpty()) {
            fillTableSP(spservice.searchSP(ten));
        }
    }//GEN-LAST:event_txtTimKiemSPKeyReleased

    private void btnThemSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSPActionPerformed
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm sách này không?");
        if (result == JOptionPane.YES_OPTION && checkTrongSP() == true) {
            if (spservice.addSP(getForm()) > 0) {
                fillTableSP(spservice.getAll());
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                resetForm();
                fillComboboxCTSP();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại");
            }
        }
    }//GEN-LAST:event_btnThemSPActionPerformed

    private void btnSuaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaSPActionPerformed
        // TODO add your handling code here:
        String ma = txtMaSP.getText();
        int result = JOptionPane.showConfirmDialog(null, "Bạn có muốn sửa tên sách này không?");
        if (result == JOptionPane.YES_OPTION && checkTrongSP() == true) {
            if (index >= 0) {
                if (spservice.updateSP(getForm(), ma) > 0) {
                    fillTableSP(spservice.getAll());
                    JOptionPane.showMessageDialog(this, "Sửa thành công");
                    resetForm();
                    fillComboboxCTSP();
                } else {
                    JOptionPane.showMessageDialog(this, "Sửa thất bại");
                }
            }
        }
    }//GEN-LAST:event_btnSuaSPActionPerformed

    private void btnLamMoiSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiSPActionPerformed
        // TODO add your handling code here:
        resetForm();
    }//GEN-LAST:event_btnLamMoiSPActionPerformed

    private void btnChiTietSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietSPActionPerformed
        // TODO add your handling code here:
        // new SanPhamCTform().setVisible(true);
        TabbedPane1.setSelectedIndex(1);
        fillTableCTSP(spctService.getAll(txtMaSP.getText()));
        resetFormCTSP();
    }//GEN-LAST:event_btnChiTietSPActionPerformed

    private void btnCT_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCT_resetActionPerformed
        // TODO add your handling code here:
        resetFormCTSP();
    }//GEN-LAST:event_btnCT_resetActionPerformed

    private void txtCTdonGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCTdonGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCTdonGiaActionPerformed

    private void txtMaCTSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaCTSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaCTSPActionPerformed

    private void txtCTsoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCTsoLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCTsoLuongActionPerformed

    private void tblChiTietSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChiTietSPMouseClicked
        // TODO add your handling code here:
        int index = tblChiTietSP.getSelectedRow();
        //if(tblSanPham.get)
        String ma = tblChiTietSP.getValueAt(index, 1).toString();
        System.out.println(ma);
        setFormCTSP(spctService.getSPCT(ma));

    }//GEN-LAST:event_tblChiTietSPMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblSanPhamMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMousePressed

        if (evt.getClickCount() == 2) {
            // làm gì khi click double ở đây
            TabbedPane1.setSelectedIndex(1);
            fillTableCTSP(spctService.getAll(txtMaSP.getText()));
            resetFormCTSP();
        }


    }//GEN-LAST:event_tblSanPhamMousePressed

    private void tblSanPhamMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_tblSanPhamMouseReleased

    private void txtSearchSPCTMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchSPCTMousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtSearchSPCTMousePressed

    private void txtSearchSPCTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchSPCTKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchSPCTKeyPressed

    private void txtSearchSPCTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchSPCTKeyReleased
        // TODO add your handling code here:
        String thongtintim = txtSearchSPCT.getText();
        if (!thongtintim.trim().isEmpty()) {
            fillTableCTSP(spctService.TimKiemCTSP(thongtintim));
        }
    }//GEN-LAST:event_txtSearchSPCTKeyReleased

    private void cbxLocLoaiSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxLocLoaiSachActionPerformed
        // TODO add your handling code here:       
    }//GEN-LAST:event_cbxLocLoaiSachActionPerformed

    private void cbxLocLoaiSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxLocLoaiSachMouseClicked

    }//GEN-LAST:event_cbxLocLoaiSachMouseClicked

    private void btnCTthemSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCTthemSPActionPerformed
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm không?");
        if (result == JOptionPane.YES_OPTION) {
            if (spctService.ThemSPCT(getFormSPCT()) > 0) {
                fillTableCTSP(spctService.getAll2());
                JOptionPane.showMessageDialog(this, "Thêm thành công ");
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại");
            }
        }

    }//GEN-LAST:event_btnCTthemSPActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm không?");
        if (checkTrongThuocTinh() == true)
            if (result == JOptionPane.YES_OPTION) {
                if (rdoAnhSP.isSelected() == true) {
                    if (haservice.ThemThuocTinhAnh(getThuocTinhAnh()) > 0) {
                        fillTableThuocTinhHinhAnh(haservice.getAllHinhAnh());
                        JOptionPane.showMessageDialog(this, "Thêm thành công ");
                    } else {
                        JOptionPane.showMessageDialog(this, "Thêm thất bại");
                    }
                }

                if (rdoTacGia.isSelected() == true) {
                    if (TGservice.AddTacGia(getFormThuocTinhTacGia()) > 0) {
                        fillTableThuocTinhTacGia(TGservice.getAllTacGia());
                        JOptionPane.showMessageDialog(this, "Thêm thành công ");
                    } else {
                        JOptionPane.showMessageDialog(this, "Thêm thất bại");
                    }
                }
                if (rdoTheLoai.isSelected() == true) {
                    if (TLservice.AddTheLoai(getFormThuocTinhTheLoai()) > 0) {
                        fillTableThuocTinhTheLoai(TLservice.getAllTheLoai());
                        JOptionPane.showMessageDialog(this, "Thêm thành công ");
                    } else {
                        JOptionPane.showMessageDialog(this, "Thêm thất bại");
                    }
                }
                if (rdoNXB.isSelected() == true) {
                    if (NXBservice.AddNhaXuatBan(getFormThuocTinhNXB()) > 0) {
                        fillTableThuocTinhNXB();
                        JOptionPane.showMessageDialog(this, "Thêm thành công ");
                    } else {
                        JOptionPane.showMessageDialog(this, "Thêm thất bại");
                    }
                }
                if (rdoNhaCungCap.isSelected() == true) {
                    if (NCCservice.AddNhaCungCap(getFormThuocTinhNCC()) > 0) {
                        fillTableThuocTinhNCC();
                        JOptionPane.showMessageDialog(this, "Thêm thành công ");
                    } else {
                        JOptionPane.showMessageDialog(this, "Thêm thất bại");
                    }
                }
            }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaThuocTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaThuocTinhActionPerformed
        // TODO add your handling code here:

        String ma = txtMaThuocTinh.getText();
        int result = JOptionPane.showConfirmDialog(null, "Bạn có muốn sửa không?");
        if (checkTrongThuocTinh() == true)
            if (result == JOptionPane.YES_OPTION) {
                if (rdoAnhSP.isSelected() == true && ma != null) {
                    if (haservice.SuaThuocTinhAnh(getThuocTinhAnh(), ma) > 0) {
                        fillTableThuocTinhHinhAnh(haservice.getAllHinhAnh());
                        JOptionPane.showMessageDialog(this, "Sửa thành công ");
                    } else {
                        JOptionPane.showMessageDialog(this, "Sửa thất bại");
                    }
                }

                if (rdoTacGia.isSelected() == true && ma != null) {
                    if (TGservice.SuaTacGia(getFormThuocTinhTacGia(), ma) > 0) {
                        fillTableThuocTinhTacGia(TGservice.getAllTacGia());
                        JOptionPane.showMessageDialog(this, "Sửa thành công ");
                    } else {
                        JOptionPane.showMessageDialog(this, "Sửa thất bại");
                    }
                }
                if (rdoTheLoai.isSelected() == true && ma != null) {
                    if (TLservice.SuaTheLoai(getFormThuocTinhTheLoai(), ma) > 0) {
                        fillTableThuocTinhTheLoai(TLservice.getAllTheLoai());
                        JOptionPane.showMessageDialog(this, "Sửa thành công ");
                    } else {
                        JOptionPane.showMessageDialog(this, "Sửa thất bại");
                    }
                }
                if (rdoNXB.isSelected() == true && ma != null) {
                    if (NXBservice.SuaNhaXuatBan(getFormThuocTinhNXB(), ma) > 0) {
                        fillTableThuocTinhNXB();
                        JOptionPane.showMessageDialog(this, "Sửa thành công ");
                    } else {
                        JOptionPane.showMessageDialog(this, "Sửa thất bại");
                    }
                }
                if (rdoNhaCungCap.isSelected() == true && ma != null) {
                    if (NCCservice.SuaNhaCungCap(getFormThuocTinhNCC(), ma) > 0) {
                        fillTableThuocTinhNCC();
                        JOptionPane.showMessageDialog(this, "Sửa thành công ");
                    } else {
                        JOptionPane.showMessageDialog(this, "Sửa thất bại");
                    }
                }
            }
    }//GEN-LAST:event_btnSuaThuocTinhActionPerformed

    private void rdoAnhSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoAnhSPActionPerformed
        // TODO add your handling code here:
        if (rdoAnhSP.isSelected() == true) {
            pannelHinhAnh.setVisible(true);
            fillTableThuocTinhHinhAnh(haservice.getAllHinhAnh());
            lblDiaChi.setVisible(false);
            txtDiaChiThuocTinh.setVisible(false);
            lblSĐT.setVisible(false);
            txtSĐTthuocTinh.setVisible(false);
            XoaTrangTT();
        }
    }//GEN-LAST:event_rdoAnhSPActionPerformed

    private void rdoNXBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNXBActionPerformed
        // TODO add your handling code here:
        if (rdoNXB.isSelected() == true) {
            lblDiaChi.setVisible(true);
            txtDiaChiThuocTinh.setVisible(true);
            lblSĐT.setVisible(true);
            txtSĐTthuocTinh.setVisible(true);
            pannelHinhAnh.setVisible(false);
            fillTableThuocTinhNXB();
            XoaTrangTT();
        }
    }//GEN-LAST:event_rdoNXBActionPerformed

    private void lblanhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblanhMouseClicked
        // TODO add your handling code here:
        try {

            JFileChooser f = new JFileChooser("D:\\Saved Pictures");
            f.setDialogTitle("Mở File");
            f.showOpenDialog(null);
            File ftenanh = f.getSelectedFile();
            duongdananh = ftenanh.getAbsolutePath();
            lblanh.setIcon(resizeImage(String.valueOf(duongdananh)));
            System.out.println(ftenanh.getName());
        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, "Bạn chưa chọn ảnh");
        }
    }//GEN-LAST:event_lblanhMouseClicked

    private void rdoTacGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoTacGiaActionPerformed
        // TODO add your handling code here:
        if (rdoTacGia.isSelected() == true) {
            setFormAnThuocTinh();
            fillTableThuocTinhTacGia(TGservice.getAllTacGia());
            XoaTrangTT();
        }
    }//GEN-LAST:event_rdoTacGiaActionPerformed

    private void tblthuoctinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblthuoctinhMouseClicked
        // TODO add your handling code here:
        int index = tblthuoctinh.getSelectedRow();
        if (rdoAnhSP.isSelected() == true) {
            setFormThuocTinhHA(haservice.getAt(index));
        } else if (rdoTacGia.isSelected() == true) {
            setFormThuocTinhTacGia(TGservice.getAt(index));
        } else if (rdoTheLoai.isSelected() == true) {
            setFormThuocTinhTheLoai(TLservice.getAt(index));
        } else if (rdoNXB.isSelected() == true) {
            setFormThuocTinhNXB(NXBservice.getAt(index));
        } else if (rdoNhaCungCap.isSelected() == true) {
            setFormThuocTinhNCC(NCCservice.getAt(index));
        }
    }//GEN-LAST:event_tblthuoctinhMouseClicked

    private void rdoTheLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoTheLoaiActionPerformed
        // TODO add your handling code here:
        if (rdoTheLoai.isSelected() == true) {
            fillTableThuocTinhTheLoai(TLservice.getAllTheLoai());
            XoaTrangTT();
            setFormAnThuocTinh();
        }
    }//GEN-LAST:event_rdoTheLoaiActionPerformed

    private void btnXoaTrangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaTrangActionPerformed
        // TODO add your handling code here:
        XoaTrangTT();
    }//GEN-LAST:event_btnXoaTrangActionPerformed

    private void rdoNhaCungCapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNhaCungCapActionPerformed
        // TODO add your handling code here:
        if (rdoNhaCungCap.isSelected() == true) {
            lblDiaChi.setVisible(true);
            txtDiaChiThuocTinh.setVisible(true);
            lblSĐT.setVisible(true);
            txtSĐTthuocTinh.setVisible(true);
            pannelHinhAnh.setVisible(false);
            fillTableThuocTinhNCC();
            XoaTrangTT();

        }
    }//GEN-LAST:event_rdoNhaCungCapActionPerformed

    private void cbxLocNXBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxLocNXBActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_cbxLocNXBActionPerformed

    private void cbxLocTacGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxLocTacGiaActionPerformed

    }//GEN-LAST:event_cbxLocTacGiaActionPerformed

    private void cbxTrangThaiSPCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTrangThaiSPCTActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cbxTrangThaiSPCTActionPerformed

    private void btnCTcapnhatSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCTcapnhatSPActionPerformed
        // TODO add your handling code here:
        String ma = txtMaCTSP.getText();
        int result = JOptionPane.showConfirmDialog(null, "Bạn có muốn Sửa không?");
        if (result == JOptionPane.YES_OPTION)
            if (ma != null) {
                if (spctService.updateSPCT(getFormSPCT(), ma) > 0) {
                    fillTableCTSP(spctService.getAll2());
                    JOptionPane.showMessageDialog(this, "Sửa thành công ");
                } else {
                    JOptionPane.showMessageDialog(this, "Sửa thất bại");
                }
            }
    }//GEN-LAST:event_btnCTcapnhatSPActionPerformed

    private void cbxHinhAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxHinhAnhActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_cbxHinhAnhActionPerformed

    private void btnXoaTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaTrangThaiActionPerformed
        int index = -1;
        index = tblChiTietSP.getSelectedRow();
        int result = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa không?");
        if (result == JOptionPane.YES_OPTION)
            if (index >= 0) {
                String mactsp = tblChiTietSP.getValueAt(index, 1).toString();
                if (spctService.DeleteSPCT(mactsp, "Đã Xóa") > 0) {
                    fillTableCTSP(spctService.getAll2());
                    JOptionPane.showMessageDialog(this, "Xóa thành công");
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa thất bại");
                }
            }
    }//GEN-LAST:event_btnXoaTrangThaiActionPerformed

    private void cbxLocLoaiSachItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxLocLoaiSachItemStateChanged
        // TODO add your handling code here:
        //LocTheoTruongDacTrung();
    }//GEN-LAST:event_cbxLocLoaiSachItemStateChanged

    private void cbxLocNXBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxLocNXBItemStateChanged
        // TODO add your handling code here:
        //LocTheoTruongDacTrung();
    }//GEN-LAST:event_cbxLocNXBItemStateChanged

    private void cbxLocTacGiaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxLocTacGiaItemStateChanged
        // TODO add your handling code here:
        // LocTheoTruongDacTrung();
    }//GEN-LAST:event_cbxLocTacGiaItemStateChanged

    private void cbxTrangThaiSPCTItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxTrangThaiSPCTItemStateChanged
        // TODO add your handling code here:
        //LocTheoTruongDacTrung();
    }//GEN-LAST:event_cbxTrangThaiSPCTItemStateChanged

    private void btnExport_excelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExport_excelActionPerformed
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
            cell.setCellValue("Mã Sách");
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Mã Sách chi tiết");
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("Tên sách");
            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("Tên tác giả");
            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("Thể loại");
            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue("Tên nhà cung cấp");
            cell = row.createCell(7, CellType.STRING);
            cell.setCellValue("Tên ảnh");
            cell = row.createCell(8, CellType.STRING);
            cell.setCellValue("Tên nhà xuất bản");
            cell = row.createCell(9, CellType.STRING);
            cell.setCellValue("Đơn giá");
            cell = row.createCell(10, CellType.STRING);
            cell.setCellValue("Số lượng");
            cell = row.createCell(11, CellType.STRING);
            cell.setCellValue("Ngày tạo");
            cell = row.createCell(12, CellType.STRING);
            cell.setCellValue("Mô tả");
            cell = row.createCell(13, CellType.STRING);
            cell.setCellValue("Ngày sửa");
            cell = row.createCell(14, CellType.STRING);
            cell.setCellValue("Trạng thái");

            for (int i = 0; i < spctService.getAll2().size(); i++) {
                row = sheet.createRow(i + 1);
                cell = row.createCell(0, CellType.NUMERIC);
                cell.setCellValue(i);

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(spctService.getAll2().get(i).getMasach());

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(spctService.getAll2().get(i).getMasachchitiet());

                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(spctService.getAll2().get(i).getTensach());

                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(spctService.getAll2().get(i).getTentacgia());

                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue(spctService.getAll2().get(i).getTentheloai());

                cell = row.createCell(6, CellType.STRING);
                cell.setCellValue(spctService.getAll2().get(i).getTennhacungcap());

                cell = row.createCell(7, CellType.STRING);
                cell.setCellValue(spctService.getAll2().get(i).getTenanh());

                cell = row.createCell(8, CellType.STRING);
                cell.setCellValue(spctService.getAll2().get(i).getTennhaxuatban());

                cell = row.createCell(9, CellType.STRING);
                cell.setCellValue(spctService.getAll2().get(i).getDongia());

                cell = row.createCell(10, CellType.STRING);
                cell.setCellValue(spctService.getAll2().get(i).getSoluong());

                cell = row.createCell(11, CellType.STRING);
                cell.setCellValue(spctService.getAll2().get(i).getNgaytao());

                cell = row.createCell(12, CellType.STRING);
                cell.setCellValue(spctService.getAll2().get(i).getMota());

                cell = row.createCell(13, CellType.STRING);
                cell.setCellValue(spctService.getAll2().get(i).getNgaysua());

                cell = row.createCell(14, CellType.STRING);
                cell.setCellValue(spctService.getAll2().get(i).getTrangthai());

            }
            File file = new File("D:\\FPT-POLY\\Duan1\\DanhSachSPCT\\danhsach.xlsx");
            try {
                FileOutputStream fis = new FileOutputStream(file);
                wordbook.write(fis);
                fis.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            JOptionPane.showMessageDialog(this, "In thành công");

        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_btnExport_excelActionPerformed

    private void btnTaimauExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaimauExcelActionPerformed
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(null, "Bạn có muốn xuất file không?");
        if (result == JOptionPane.YES_OPTION) 
        try {
            XSSFWorkbook wordbook = new XSSFWorkbook();
            XSSFSheet sheet = wordbook.createSheet("MauFormSPCT");
            XSSFRow row = null;
            Cell cell = null;
            row = sheet.createRow(0);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("STT");
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Mã Sách");
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Mã Sách chi tiết");
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("Tên sách");
            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("Tên tác giả");
            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("Thể loại");
            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue("Tên nhà cung cấp");
            cell = row.createCell(7, CellType.STRING);
            cell.setCellValue("Tên ảnh");
            cell = row.createCell(8, CellType.STRING);
            cell.setCellValue("Tên nhà xuất bản");
            cell = row.createCell(9, CellType.STRING);
            cell.setCellValue("Đơn giá");
            cell = row.createCell(10, CellType.STRING);
            cell.setCellValue("Số lượng");
            cell = row.createCell(11, CellType.STRING);
            cell.setCellValue("Ngày tạo");
            cell = row.createCell(12, CellType.STRING);
            cell.setCellValue("Mô tả");
            cell = row.createCell(13, CellType.STRING);
            cell.setCellValue("Ngày sửa");
            cell = row.createCell(14, CellType.STRING);
            cell.setCellValue("Trạng thái");

            File file = new File("D:\\FPT-POLY\\Duan1\\MauFormCTSP.xlsx");
            try {
                FileOutputStream fis = new FileOutputStream(file);
                wordbook.write(fis);
                fis.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            JOptionPane.showMessageDialog(this, "In thành công");

        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_btnTaimauExcelActionPerformed

    private void cbxCTtacGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCTtacGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxCTtacGiaActionPerformed

    private void cbxHinhAnhItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxHinhAnhItemStateChanged
        // TODO add your handling code here:
        int index = cbxHinhAnh.getSelectedIndex();
        if (index >= 0) {
            String ten = cbxHinhAnh.getSelectedItem().toString();
            lblhinhAnhCtSP.setIcon(resizeImage2(haservice.timduongdananh(ten)));
        }
    }//GEN-LAST:event_cbxHinhAnhItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane TabbedPane1;
    private javax.swing.JButton btnCT_reset;
    private javax.swing.JButton btnCTcapnhatSP;
    private javax.swing.JButton btnCTthemSP;
    private javax.swing.JButton btnChiTietSP;
    private javax.swing.JButton btnExport_excel;
    private javax.swing.JButton btnImport_excel;
    private javax.swing.JButton btnLamMoiSP;
    private javax.swing.JButton btnSuaSP;
    private javax.swing.JButton btnSuaThuocTinh;
    private javax.swing.JButton btnTaimauExcel;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemSP;
    private javax.swing.JButton btnXoaTrang;
    private javax.swing.JButton btnXoaTrangThai;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbxCTnhaCC;
    private javax.swing.JComboBox<String> cbxCTnhaXB;
    private javax.swing.JComboBox<String> cbxCTtacGia;
    private javax.swing.JComboBox<String> cbxCTtheLoai;
    private javax.swing.JComboBox<String> cbxHinhAnh;
    private javax.swing.JComboBox<String> cbxLocLoaiSach;
    private javax.swing.JComboBox<String> cbxLocNXB;
    private javax.swing.JComboBox<String> cbxLocTacGia;
    private javax.swing.JComboBox<String> cbxTenSP;
    private javax.swing.JComboBox<String> cbxTrangThaiSPCT;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPanel jpnCTanh;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblSĐT;
    private javax.swing.JLabel lblanh;
    private javax.swing.JLabel lblhinhAnhCtSP;
    private javax.swing.JPanel pannelHinhAnh;
    private javax.swing.JRadioButton rdoAnhSP;
    private javax.swing.JRadioButton rdoNXB;
    private javax.swing.JRadioButton rdoNhaCungCap;
    private javax.swing.JRadioButton rdoTacGia;
    private javax.swing.JRadioButton rdoTheLoai;
    private javax.swing.JTable tblChiTietSP;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTable tblthuoctinh;
    private javax.swing.JTextField txtCTdonGia;
    private javax.swing.JTextArea txtCTmoTa;
    private javax.swing.JTextField txtCTsoLuong;
    private javax.swing.JTextField txtDiaChiThuocTinh;
    private javax.swing.JTextField txtMaCTSP;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtMaThuocTinh;
    private javax.swing.JTextField txtSearchSPCT;
    private javax.swing.JTextField txtSĐTthuocTinh;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtTenThuocTinh;
    private javax.swing.JTextField txtTimKiemSP;
    // End of variables declaration//GEN-END:variables
}
