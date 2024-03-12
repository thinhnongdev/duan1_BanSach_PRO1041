/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.model;

import java.util.Date;

public class nhanVien {

    private Integer idNhanVien;
    private String MaNhanVien;
    private String TenNhanVien;
    private String TenDangNhap;
    private String MatKhau;
    private boolean GioiTinh;
    private String Email;
    private String DiaChi;
    private String SDT;
    private Date NgayTao;
    private String TrangThai;
    private Integer idChucVu;

    public nhanVien() {
    }

    public nhanVien(Integer idNhanVien, String MaNhanVien, String TenNhanVien, String TenDangNhap, String MatKhau, boolean GioiTinh, String Email, String DiaChi, String SDT, Date NgayTao, String TrangThai, Integer idChucVu) {
        this.idNhanVien = idNhanVien;
        this.MaNhanVien = MaNhanVien;
        this.TenNhanVien = TenNhanVien;
        this.TenDangNhap = TenDangNhap;
        this.MatKhau = MatKhau;
        this.GioiTinh = GioiTinh;
        this.Email = Email;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.NgayTao = NgayTao;
        this.TrangThai = TrangThai;
        this.idChucVu = idChucVu;
    }

    public Integer getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(Integer idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public String getTenNhanVien() {
        return TenNhanVien;
    }

    public void setTenNhanVien(String TenNhanVien) {
        this.TenNhanVien = TenNhanVien;
    }

    public String getTenDangNhap() {
        return TenDangNhap;
    }

    public void setTenDangNhap(String TenDangNhap) {
        this.TenDangNhap = TenDangNhap;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public Integer getIdChucVu() {
        return idChucVu;
    }

    public void setIdChucVu(Integer idChucVu) {
        this.idChucVu = idChucVu;
    }

}
