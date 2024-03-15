/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.model;

/**
 *
 * @author ADMIN
 */
public class model_hoadonct {
     int idHoaDonChiTiet,idHoaDon,idSachChiTiet;
    String  MaHoaDonChiTiet;
    double DonGia;
    int SoLuong;
    String NgayTao,TrangThai;

    public model_hoadonct() {
    }

    public model_hoadonct(int idHoaDonChiTiet, int idHoaDon, int idSachChiTiet, String MaHoaDonChiTiet, double DonGia, int SoLuong, String NgayTao, String TrangThai) {
        this.idHoaDonChiTiet = idHoaDonChiTiet;
        this.idHoaDon = idHoaDon;
        this.idSachChiTiet = idSachChiTiet;
        this.MaHoaDonChiTiet = MaHoaDonChiTiet;
        this.DonGia = DonGia;
        this.SoLuong = SoLuong;
        this.NgayTao = NgayTao;
        this.TrangThai = TrangThai;
    }

    public int getIdHoaDonChiTiet() {
        return idHoaDonChiTiet;
    }

    public void setIdHoaDonChiTiet(int idHoaDonChiTiet) {
        this.idHoaDonChiTiet = idHoaDonChiTiet;
    }

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public int getIdSachChiTiet() {
        return idSachChiTiet;
    }

    public void setIdSachChiTiet(int idSachChiTiet) {
        this.idSachChiTiet = idSachChiTiet;
    }

    public String getMaHoaDonChiTiet() {
        return MaHoaDonChiTiet;
    }

    public void setMaHoaDonChiTiet(String MaHoaDonChiTiet) {
        this.MaHoaDonChiTiet = MaHoaDonChiTiet;
    }

    public double getDonGia() {
        return DonGia;
    }

    public void setDonGia(double DonGia) {
        this.DonGia = DonGia;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
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
            this.getIdHoaDonChiTiet(),this.getIdHoaDon(),this.getIdSachChiTiet(),this.getMaHoaDonChiTiet(),this.getDonGia(),this.getSoLuong(),this.getNgayTao(),this.getTrangThai()
        };
       }
}
