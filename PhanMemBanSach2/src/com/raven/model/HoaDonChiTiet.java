/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.model;

/**
 *
 * @author Admin
 */
public class HoaDonChiTiet {
    private String maHoaDon;
    private String maHoaDonCT;
    private String maSPCT;
    private String tenSP;
    private String theLoai;
    private String tacGia;
    private double donGia;
    private int soLuong;
    private double thanhTien;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String maHoaDon, String maHoaDonCT, String maSPCT, String tenSP, String theLoai, String tacGia, double donGia, int soLuong, double thanhTien) {
        this.maHoaDon = maHoaDon;
        this.maHoaDonCT = maHoaDonCT;
        this.maSPCT = maSPCT;
        this.tenSP = tenSP;
        this.theLoai = theLoai;
        this.tacGia = tacGia;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaHoaDonCT() {
        return maHoaDonCT;
    }

    public void setMaHoaDonCT(String maHoaDonCT) {
        this.maHoaDonCT = maHoaDonCT;
    }

    public String getMaSPCT() {
        return maSPCT;
    }

    public void setMaSPCT(String maSPCT) {
        this.maSPCT = maSPCT;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }
    
    
    
}
