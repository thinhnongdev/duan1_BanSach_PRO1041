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
public class NhaXuatBan {
    private Integer idnhaxuatban;
    private String manhaxuatban;
    private String tennhaxuatban;
    private String diachi;
    private String sdt;
    private Date ngaytao;
    private String trangthai;
    private Date ngaysua;

    public NhaXuatBan() {
    }

    public NhaXuatBan(Integer idnhaxuatban, String manhaxuatban, String tennhaxuatban, String diachi, String sdt, Date ngaytao, String trangthai, Date ngaysua) {
        this.idnhaxuatban = idnhaxuatban;
        this.manhaxuatban = manhaxuatban;
        this.tennhaxuatban = tennhaxuatban;
        this.diachi = diachi;
        this.sdt = sdt;
        this.ngaytao = ngaytao;
        this.trangthai = trangthai;
        this.ngaysua = ngaysua;
    }

    public Integer getIdnhaxuatban() {
        return idnhaxuatban;
    }

    public void setIdnhaxuatban(Integer idnhaxuatban) {
        this.idnhaxuatban = idnhaxuatban;
    }

    public String getManhaxuatban() {
        return manhaxuatban;
    }

    public void setManhaxuatban(String manhaxuatban) {
        this.manhaxuatban = manhaxuatban;
    }

    public String getTennhaxuatban() {
        return tennhaxuatban;
    }

    public void setTennhaxuatban(String tennhaxuatban) {
        this.tennhaxuatban = tennhaxuatban;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
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
