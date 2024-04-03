/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.raven.form;

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
import java.util.Random;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.raven.model.HinhAnh;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class ChiTietSanPham extends javax.swing.JDialog {

    DefaultTableModel model = new DefaultTableModel();
    DefaultComboBoxModel boxmodel = new DefaultComboBoxModel<>();
    SanPhamCTservice spctService = new SanPhamCTservice();
    SanPhamService spservice = new SanPhamService();
    TheLoaiService TLservice = new TheLoaiService();
    TacGiaService TGservice = new TacGiaService();
    NhaXuatBanService NXBservice = new NhaXuatBanService();
    NhaCungCapService NCCservice = new NhaCungCapService();
    HinhAnhService haservice = new HinhAnhService();
    int indexSPCT = -1;
    List<SanPhamCT> listSpct = new ArrayList<>();

    public ChiTietSanPham(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        fillComboboxCTSP();

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

    public byte[] generateQRCodeImage(String text, int width, int height) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        Map<EncodeHintType, String> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, 125, 125, hints);

        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);

        BufferedImage pngImage = ImageIO.read(new ByteArrayInputStream(pngOutputStream.toByteArray()));
        ByteArrayOutputStream jpgOutputStream = new ByteArrayOutputStream();
        ImageIO.write(pngImage, "JPG", jpgOutputStream);

        return jpgOutputStream.toByteArray();
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
        try {
            String maSPCT = sp.getMasachchitiet();
            byte[] qrImageData = generateQRCodeImage(maSPCT, 125, 125);

            if (qrImageData != null) {
                ImageIcon qrImageIcon = new ImageIcon(qrImageData);
                lblQRCode.setIcon(qrImageIcon);
            } else {
                lblQRCode.setIcon(null);
            }
        } catch (WriterException | IOException e) {
            e.printStackTrace();
            lblQRCode.setIcon(null);
        }
    }

    public SanPhamCT getFormSPCT() {
        String tenSP, maSPCT, nhaxuatban, nhacungcap, theloai, hinhanh, tacgia, mota, trangthai = "Hoạt động";
        byte[] QR;
        double dongia;
        int soluong;
        Date ngayTao, ngaySua;

        tenSP = cbxTenSP.getSelectedItem().toString();
        maSPCT = txtMaCTSP.getText();
        nhaxuatban = cbxCTnhaXB.getSelectedItem().toString();
        nhacungcap = cbxCTnhaCC.getSelectedItem().toString();
        theloai = cbxCTtheLoai.getSelectedItem().toString();
        tacgia = cbxCTtacGia.getSelectedItem().toString();
        mota = txtCTmoTa.getText();
        dongia = Double.parseDouble(txtCTdonGia.getText());
        soluong = Integer.parseInt(txtCTsoLuong.getText());
        hinhanh = cbxHinhAnh.getSelectedItem().toString();
        ngayTao = new Date();
        ngaySua = new Date();

        try {
            QR = generateQRCodeImage(maSPCT, 125, 125);
            ImageIcon qrImageIcon = new ImageIcon(QR);
            lblQRCode.setIcon(qrImageIcon);
        } catch (WriterException | IOException e) {
            e.printStackTrace();
            QR = null;
        }
        return new SanPhamCT(null, maSPCT, tenSP, tacgia, theloai, nhacungcap, hinhanh, nhaxuatban, dongia, soluong, ngayTao, trangthai, ngaySua, mota, QR);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        cbxTenSP = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        cbxCTnhaXB = new javax.swing.JComboBox<>();
        cbxCTnhaCC = new javax.swing.JComboBox<>();
        cbxCTtheLoai = new javax.swing.JComboBox<>();
        cbxCTtacGia = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtCTmoTa = new javax.swing.JTextArea();
        btn_Update = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblQRCode = new javax.swing.JLabel();
        jpnCTanh1 = new javax.swing.JPanel();
        lblhinhAnhCtSP = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cbxHinhAnh = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin sản phẩm"));

        jLabel6.setText("Mã CT Sản phẩm : ");

        jLabel7.setText("Tên sản phẩm :");

        jLabel8.setText("Thể loại :");

        jLabel9.setText("Tác giả :");

        jLabel10.setText("Nhà xuất bản :");

        jLabel11.setText("Nhà cung cấp :");

        jLabel12.setText("Số lượng :");

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

        cbxTenSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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

        btn_Update.setText("Cập nhật");
        btn_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_UpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblQRCode, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblQRCode, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jpnCTanh1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jpnCTanh1Layout = new javax.swing.GroupLayout(jpnCTanh1);
        jpnCTanh1.setLayout(jpnCTanh1Layout);
        jpnCTanh1Layout.setHorizontalGroup(
            jpnCTanh1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnCTanh1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblhinhAnhCtSP, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnCTanh1Layout.setVerticalGroup(
            jpnCTanh1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnCTanh1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblhinhAnhCtSP, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel14.setText("Hình ảnh: ");

        jLabel16.setText("Hình ảnh sản phẩm:");

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

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel15)
                .addGap(9, 9, 9)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel14)))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jpnCTanh1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Update)
                        .addGap(38, 38, 38))))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(cbxTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(cbxCTnhaXB, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(24, 24, 24)
                        .addComponent(txtMaCTSP, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(cbxCTnhaCC, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(txtCTsoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(cbxCTtheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(txtCTdonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(cbxCTtacGia, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel7))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(cbxTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel10))
                    .addComponent(cbxCTnhaXB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel6))
                    .addComponent(txtMaCTSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel11))
                    .addComponent(cbxCTnhaCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel12))
                    .addComponent(txtCTsoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel8))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(cbxCTtheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel13))
                    .addComponent(txtCTdonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel9))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(cbxCTtacGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel14))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(cbxHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(jpnCTanh1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(btn_Update)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 807, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 534, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCTsoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCTsoLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCTsoLuongActionPerformed

    private void txtMaCTSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaCTSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaCTSPActionPerformed

    private void txtCTdonGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCTdonGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCTdonGiaActionPerformed

    private void cbxCTtacGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCTtacGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxCTtacGiaActionPerformed

    private void btn_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UpdateActionPerformed
        String ma = txtMaCTSP.getText();
        SanPhamCTservice spCTService = new SanPhamCTservice();
        int result = JOptionPane.showConfirmDialog(null, "Bạn có muốn Sửa không?");
        if (result == JOptionPane.YES_OPTION) {
            if (ma != null) {
                if (spctService.updateSPCT(getFormSPCT(), ma) > 0) {
                    listSpct = spCTService.getAll2();
                    JOptionPane.showMessageDialog(this, "Sửa thành công");
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Sửa thất bại");
                }
            }
        }
    }//GEN-LAST:event_btn_UpdateActionPerformed

    private void cbxHinhAnhItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxHinhAnhItemStateChanged
        // TODO add your handling code here:
        int index = cbxHinhAnh.getSelectedIndex();
        if (index >= 0) {
            String ten = cbxHinhAnh.getSelectedItem().toString();
            lblhinhAnhCtSP.setIcon(resizeImage2(haservice.timduongdananh(ten)));
        }
    }//GEN-LAST:event_cbxHinhAnhItemStateChanged

    private void cbxHinhAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxHinhAnhActionPerformed

    }//GEN-LAST:event_cbxHinhAnhActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChiTietSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChiTietSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChiTietSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChiTietSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ChiTietSanPham dialog = new ChiTietSanPham(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Update;
    private javax.swing.JComboBox<String> cbxCTnhaCC;
    private javax.swing.JComboBox<String> cbxCTnhaXB;
    private javax.swing.JComboBox<String> cbxCTtacGia;
    private javax.swing.JComboBox<String> cbxCTtheLoai;
    private javax.swing.JComboBox<String> cbxHinhAnh;
    private javax.swing.JComboBox<String> cbxTenSP;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel jpnCTanh;
    private javax.swing.JPanel jpnCTanh1;
    private javax.swing.JLabel lblQRCode;
    private javax.swing.JLabel lblhinhAnhCtSP;
    private javax.swing.JLabel lblhinhAnhCtSP1;
    private javax.swing.JTextField txtCTdonGia;
    private javax.swing.JTextArea txtCTmoTa;
    private javax.swing.JTextField txtCTsoLuong;
    private javax.swing.JTextField txtMaCTSP;
    // End of variables declaration//GEN-END:variables

}
