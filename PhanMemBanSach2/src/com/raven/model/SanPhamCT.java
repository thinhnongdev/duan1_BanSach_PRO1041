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
public class SanPhamCT {

    private String masach;
    private String masachchitiet;
    private String tensach;
    private String tentacgia;
    private String tentheloai;
    private String tennhacungcap;
    private String tenanh;
    private String tennhaxuatban;
    private double dongia;
    private int soluong;
    private Date ngaytao;
    private String trangthai;
    private Date ngaysua;

    public SanPhamCT() {
    }

    public SanPhamCT(String masach, String masachchitiet, String tensach, String tentacgia, String tentheloai, String tennhacungcap, String tenanh, String tennhaxuatban, double dongia, int soluong, Date ngaytao, String trangthai, Date ngaysua) {
        this.masach = masach;
        this.masachchitiet = masachchitiet;
        this.tensach = tensach;
        this.tentacgia = tentacgia;
        this.tentheloai = tentheloai;
        this.tennhacungcap = tennhacungcap;
        this.tenanh = tenanh;
        this.tennhaxuatban = tennhaxuatban;
        this.dongia = dongia;
        this.soluong = soluong;
        this.ngaytao = ngaytao;
        this.trangthai = trangthai;
        this.ngaysua = ngaysua;
    }

    public String getMasach() {
        return masach;
    }

    public void setMasach(String masach) {
        this.masach = masach;
    }

   
    public String getTenanh() {
        return tenanh;
    }

    public void setTenanh(String tenanh) {
        this.tenanh = tenanh;
    }

    public String getTensach() {
        return tensach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    public String getTennhacungcap() {
        return tennhacungcap;
    }

    public void setTennhacungcap(String tennhacungcap) {
        this.tennhacungcap = tennhacungcap;
    }

    public String getTentacgia() {
        return tentacgia;
    }

    public void setTentacgia(String tentacgia) {
        this.tentacgia = tentacgia;
    }

    public String getTentheloai() {
        return tentheloai;
    }

    public void setTentheloai(String tentheloai) {
        this.tentheloai = tentheloai;
    }

    public String getTennhaxuatban() {
        return tennhaxuatban;
    }

    public void setTennhaxuatban(String tennhaxuatban) {
        this.tennhaxuatban = tennhaxuatban;
    }

    public String getMasachchitiet() {
        return masachchitiet;
    }

    public void setMasachchitiet(String masachchitiet) {
        this.masachchitiet = masachchitiet;
    }

    public double getDongia() {
        return dongia;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
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
