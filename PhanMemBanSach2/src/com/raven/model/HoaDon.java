/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class HoaDon {

    private String maKhachHang;
    private String maNhanVien;
    private String maVoucher;
    private String maThanhToan;
    private String maHoaDon;
    private Double tongTien;
    private String ghiChu;
    private Date ngayTao;
    private String trangThai;
    private Date ngaySua;
    private int tongsanpham;
    public HoaDon() {
    }

    public HoaDon(String maKhachHang, String maNhanVien, String maVoucher, String maThanhToan, String maHoaDon, Double tongTien, String ghiChu, Date ngayTao, String trangThai, Date ngaySua, int tongsanpham) {
        this.maKhachHang = maKhachHang;
        this.maNhanVien = maNhanVien;
        this.maVoucher = maVoucher;
        this.maThanhToan = maThanhToan;
        this.maHoaDon = maHoaDon;
        this.tongTien = tongTien;
        this.ghiChu = ghiChu;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
        this.ngaySua = ngaySua;
        this.tongsanpham = tongsanpham;
    }

    public int getTongsanpham() {
        return tongsanpham;
    }

    public void setTongsanpham(int tongsanpham) {
        this.tongsanpham = tongsanpham;
    }

   
    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }
    
    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getMaVoucher() {
        return maVoucher;
    }

    public void setMaVoucher(String maVoucher) {
        this.maVoucher = maVoucher;
    }

    public String getMaThanhToan() {
        return maThanhToan;
    }

    public void setMaThanhToan(String maThanhToan) {
        this.maThanhToan = maThanhToan;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Date getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Date ngaySua) {
        this.ngaySua = ngaySua;
    }
    
    
}
