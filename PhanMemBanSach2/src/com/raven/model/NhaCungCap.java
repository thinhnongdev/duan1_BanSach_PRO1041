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
public class NhaCungCap {

    private Integer idnhacungcap;
    private String manhacungcap;
    private String tennhacungcap;
    private String diachi;
    private String sdt;
    private Date ngaytao;
    private String trangthai;
    private Date ngaysua;

    public NhaCungCap() {
    }

    public NhaCungCap(Integer idnhacungcap, String manhacungcap, String tennhacungcap, String diachi, String sdt, Date ngaytao, String trangthai, Date ngaysua) {
        this.idnhacungcap = idnhacungcap;
        this.manhacungcap = manhacungcap;
        this.tennhacungcap = tennhacungcap;
        this.diachi = diachi;
        this.sdt = sdt;
        this.ngaytao = ngaytao;
        this.trangthai = trangthai;
        this.ngaysua = ngaysua;
    }

    public Integer getIdnhacungcap() {
        return idnhacungcap;
    }

    public void setIdnhacungcap(Integer idnhacungcap) {
        this.idnhacungcap = idnhacungcap;
    }

    public String getManhacungcap() {
        return manhacungcap;
    }

    public void setManhacungcap(String manhacungcap) {
        this.manhacungcap = manhacungcap;
    }

    public String getTennhacungcap() {
        return tennhacungcap;
    }

    public void setTennhacungcap(String tennhacungcap) {
        this.tennhacungcap = tennhacungcap;
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
