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
public class SanPham {

    private Integer idSach;
    private String MaSach;
    private String TenSach;
    private Date NgayTao;
    private String TrangThai;
    private Date NgaySua;

    public SanPham() {
    }

    public SanPham(Integer idSach, String MaSach, String TenSach, Date NgayTao, String TrangThai, Date NgaySua) {
        this.idSach = idSach;
        this.MaSach = MaSach;
        this.TenSach = TenSach;
        this.NgayTao = NgayTao;
        this.TrangThai = TrangThai;
        this.NgaySua = NgaySua;
    }

    public Integer getIdSach() {
        return idSach;
    }

    public void setIdSach(Integer idSach) {
        this.idSach = idSach;
    }

    public String getMaSach() {
        return MaSach;
    }

    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }

    public String getTenSach() {
        return TenSach;
    }

    public void setTenSach(String TenSach) {
        this.TenSach = TenSach;
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

    public Date getNgaySua() {
        return NgaySua;
    }

    public void setNgaySua(Date NgaySua) {
        this.NgaySua = NgaySua;
    }

}
