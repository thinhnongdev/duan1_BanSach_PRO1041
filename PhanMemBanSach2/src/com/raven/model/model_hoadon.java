/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.model;

/**
 *
 * @author ADMIN
 */
public class model_hoadon {
    int iidHoaDon,idKhachHang,idNhanVien,idVoucher,idThanhToan;
    String MaHoaDon,TongTien,GhiChu,NgayTao,TrangThai;

    public model_hoadon() {
    }

    public model_hoadon(int iidHoaDon, int idKhachHang, int idNhanVien, int idVoucher, int idThanhToan, String MaHoaDon, String TongTien, String GhiChu, String NgayTao, String TrangThai) {
        this.iidHoaDon = iidHoaDon;
        this.idKhachHang = idKhachHang;
        this.idNhanVien = idNhanVien;
        this.idVoucher = idVoucher;
        this.idThanhToan = idThanhToan;
        this.MaHoaDon = MaHoaDon;
        this.TongTien = TongTien;
        this.GhiChu = GhiChu;
        this.NgayTao = NgayTao;
        this.TrangThai = TrangThai;
    }

    public int getIidHoaDon() {
        return iidHoaDon;
    }

    public void setIidHoaDon(int iidHoaDon) {
        this.iidHoaDon = iidHoaDon;
    }

    public int getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public int getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(int idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public int getIdVoucher() {
        return idVoucher;
    }

    public void setIdVoucher(int idVoucher) {
        this.idVoucher = idVoucher;
    }

    public int getIdThanhToan() {
        return idThanhToan;
    }

    public void setIdThanhToan(int idThanhToan) {
        this.idThanhToan = idThanhToan;
    }

    public String getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(String MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public String getTongTien() {
        return TongTien;
    }

    public void setTongTien(String TongTien) {
        this.TongTien = TongTien;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public String getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(String NgayTao) {
        this.NgayTao = NgayTao;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }
    
    
     public Object[] toDataRow() {
        return new Object[]{
            this.getIidHoaDon(),this.getIdKhachHang(),this.getIdNhanVien(),this.getIdVoucher(),this.getIdThanhToan(),this.getMaHoaDon(),this.getTongTien(),this.getGhiChu(),this.getNgayTao(),this.getTrangThai()
        };
    }
}
