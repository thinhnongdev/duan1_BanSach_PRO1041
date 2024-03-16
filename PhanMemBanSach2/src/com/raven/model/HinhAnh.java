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
public class HinhAnh {
    private Integer idhinhanh;
    private String mahinhanh;
    private String tenhinhanh;
    private String duongdananh;
    private Date ngaytao;
    private String trangthai;
    private Date ngaysua;

    public HinhAnh() {
    }

    public HinhAnh(Integer idhinhanh, String mahinhanh, String tenhinhanh, String duongdananh, Date ngaytao, String trangthai, Date ngaysua) {
        this.idhinhanh = idhinhanh;
        this.mahinhanh = mahinhanh;
        this.tenhinhanh = tenhinhanh;
        this.duongdananh = duongdananh;
        this.ngaytao = ngaytao;
        this.trangthai = trangthai;
        this.ngaysua = ngaysua;
    }

    public Integer getIdhinhanh() {
        return idhinhanh;
    }

    public void setIdhinhanh(Integer idhinhanh) {
        this.idhinhanh = idhinhanh;
    }

    public String getMahinhanh() {
        return mahinhanh;
    }

    public void setMahinhanh(String mahinhanh) {
        this.mahinhanh = mahinhanh;
    }

    public String getTenhinhanh() {
        return tenhinhanh;
    }

    public void setTenhinhanh(String tenhinhanh) {
        this.tenhinhanh = tenhinhanh;
    }

    public String getDuongdananh() {
        return duongdananh;
    }

    public void setDuongdananh(String duongdananh) {
        this.duongdananh = duongdananh;
    }

    public Date getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(Date ngaytao) {
        this.ngaytao = ngaytao;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public Date getNgaysua() {
        return ngaysua;
    }

    public void setNgaysua(Date ngaysua) {
        this.ngaysua = ngaysua;
    }
    
}
