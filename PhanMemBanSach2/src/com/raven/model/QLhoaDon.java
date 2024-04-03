/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.model;

import java.util.Date;
import org.bridj.cpp.com.OLEAutomationLibrary;

/**
 *
 * @author Admin
 */
public class QLhoaDon {

    private String MaHoaDon;
    private Date ngayTaoHD;
    private Date ngayThanhToan;
    private double tongtientt;
    private String maNV;
    private String tenKH;
    private String trangThai;
    private String tenNV;
    private String diaChi;
    private String SDT;
    private int phanTramGiam;
    private String hinhThucTT;
    private Double tongtien;
    public QLhoaDon() {
    }

    public QLhoaDon(String MaHoaDon, Date ngayTaoHD, Date ngayThanhToan, double tongtientt, String maNV, String tenKH, String trangThai, String tenNV, String diaChi, String SDT, int phanTramGiam, String hinhThucTT, Double tongtien) {
        this.MaHoaDon = MaHoaDon;
        this.ngayTaoHD = ngayTaoHD;
        this.ngayThanhToan = ngayThanhToan;
        this.tongtientt = tongtientt;
        this.maNV = maNV;
        this.tenKH = tenKH;
        this.trangThai = trangThai;
        this.tenNV = tenNV;
        this.diaChi = diaChi;
        this.SDT = SDT;
        this.phanTramGiam = phanTramGiam;
        this.hinhThucTT = hinhThucTT;
        this.tongtien = tongtien;
    }

    public Double getTongtien() {
        return tongtien;
    }

    public void setTongtien(Double tongtien) {
        this.tongtien = tongtien;
    }
    

    public String getHinhThucTT() {
        return hinhThucTT;
    }

    public void setHinhThucTT(String hinhThucTT) {
        this.hinhThucTT = hinhThucTT;
    }

    
    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public int getPhanTramGiam() {
        return phanTramGiam;
    }

    public void setPhanTramGiam(int phanTramGiam) {
        this.phanTramGiam = phanTramGiam;
    }

    public String getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(String MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public Date getNgayTaoHD() {
        return ngayTaoHD;
    }

    public void setNgayTaoHD(Date ngayTaoHD) {
        this.ngayTaoHD = ngayTaoHD;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public double getTongtientt() {
        return tongtientt;
    }

    public void setTongtientt(double tongtientt) {
        this.tongtientt = tongtientt;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

}
