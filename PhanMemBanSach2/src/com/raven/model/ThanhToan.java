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
public class ThanhToan {

    private String maThanhToan;
    private String tenThanhToan;
    private String hinhThucThanhToan;
    private double tongTienThanhToan;
    private String ghiChu;
    private Date ngayTao;
    private String trangThai;
    private Date ngaySua;

    public ThanhToan() {
    }

    public ThanhToan(String maThanhToan, String tenThanhToan, String hinhThucThanhToan, double tongTienThanhToan, String ghiChu, Date ngayTao, String trangThai, Date ngaySua) {
        this.maThanhToan = maThanhToan;
        this.tenThanhToan = tenThanhToan;
        this.hinhThucThanhToan = hinhThucThanhToan;
        this.tongTienThanhToan = tongTienThanhToan;
        this.ghiChu = ghiChu;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
        this.ngaySua = ngaySua;
    }

    public String getMaThanhToan() {
        return maThanhToan;
    }

    public void setMaThanhToan(String maThanhToan) {
        this.maThanhToan = maThanhToan;
    }

    public String getTenThanhToan() {
        return tenThanhToan;
    }

    public void setTenThanhToan(String tenThanhToan) {
        this.tenThanhToan = tenThanhToan;
    }

    public String getHinhThucThanhToan() {
        return hinhThucThanhToan;
    }

    public void setHinhThucThanhToan(String hinhThucThanhToan) {
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    public double getTongTienThanhToan() {
        return tongTienThanhToan;
    }

    public void setTongTienThanhToan(double tongTienThanhToan) {
        this.tongTienThanhToan = tongTienThanhToan;
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
