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
public class TheLoai {

    private Integer idtheloai;
    private String matheloai;
    private String tentheloai;
    private Date ngaytao;
    private String trangthai;
    private Date ngaysua;

    public TheLoai() {
    }

    public TheLoai(Integer idtheloai, String matheloai, String tentheloai, Date ngaytao, String trangthai, Date ngaysua) {
        this.idtheloai = idtheloai;
        this.matheloai = matheloai;
        this.tentheloai = tentheloai;
        this.ngaytao = ngaytao;
        this.trangthai = trangthai;
        this.ngaysua = ngaysua;
    }

    public Integer getIdtheloai() {
        return idtheloai;
    }

    public void setIdtheloai(Integer idtheloai) {
        this.idtheloai = idtheloai;
    }

    public String getMatheloai() {
        return matheloai;
    }

    public void setMatheloai(String matheloai) {
        this.matheloai = matheloai;
    }

    public String getTentheloai() {
        return tentheloai;
    }

    public void setTentheloai(String tentheloai) {
        this.tentheloai = tentheloai;
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
