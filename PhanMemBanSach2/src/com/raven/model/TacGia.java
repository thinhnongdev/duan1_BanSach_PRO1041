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
public class TacGia {
    private Integer idtacgia;
    private String matacgia;
    private String tentacgia;
    private Date ngaytao;
    private String trangthai;
    private Date ngaysua;

    public TacGia() {
    }

    public TacGia(Integer idtacgia, String matacgia, String tentacgia, Date ngaytao, String trangthai, Date ngaysua) {
        this.idtacgia = idtacgia;
        this.matacgia = matacgia;
        this.tentacgia = tentacgia;
        this.ngaytao = ngaytao;
        this.trangthai = trangthai;
        this.ngaysua = ngaysua;
    }

    public Integer getIdtacgia() {
        return idtacgia;
    }

    public void setIdtacgia(Integer idtacgia) {
        this.idtacgia = idtacgia;
    }

    public String getMatacgia() {
        return matacgia;
    }

    public void setMatacgia(String matacgia) {
        this.matacgia = matacgia;
    }

    public String getTentacgia() {
        return tentacgia;
    }

    public void setTentacgia(String tentacgia) {
        this.tentacgia = tentacgia;
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
