package com.raven.model;

import java.util.Date;

public class Voucher {

    private int idVoucher, phanTramGiam;
    private String maVoucher, tenVoucher, moTa, trangThai;
    private Date thoiGianBatDau, thoiGianKetThuc, ngayTao, ngaySua;
    private double giamToiDa;

    public Voucher() {
    }

    
    public Voucher(int phanTramGiam, String maVoucher, String tenVoucher, String moTa, String trangThai, Date thoiGianBatDau, Date thoiGianKetThuc, Date ngayTao, Date ngaySua, double giamToiDa) {
        this.phanTramGiam = phanTramGiam;
        this.maVoucher = maVoucher;
        this.tenVoucher = tenVoucher;
        this.moTa = moTa;
        this.trangThai = trangThai;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.giamToiDa = giamToiDa;
    }
    
    
    public Voucher(int idVoucher, int phanTramGiam, String maVoucher, String tenVoucher, String moTa, String trangThai, Date thoiGianBatDau, Date thoiGianKetThuc, Date ngayTao, Date ngaySua, double giamToiDa) {
        this.idVoucher = idVoucher;
        this.phanTramGiam = phanTramGiam;
        this.maVoucher = maVoucher;
        this.tenVoucher = tenVoucher;
        this.moTa = moTa;
        this.trangThai = trangThai;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.giamToiDa = giamToiDa;
    }

    public int getIdVoucher() {
        return idVoucher;
    }

    public void setIdVoucher(int idVoucher) {
        this.idVoucher = idVoucher;
    }

    public int getPhanTramGiam() {
        return phanTramGiam;
    }

    public void setPhanTramGiam(int phanTramGiam) {
        this.phanTramGiam = phanTramGiam;
    }

    public String getMaVoucher() {
        return maVoucher;
    }

    public void setMaVoucher(String maVoucher) {
        this.maVoucher = maVoucher;
    }

    public String getTenVoucher() {
        return tenVoucher;
    }

    public void setTenVoucher(String tenVoucher) {
        this.tenVoucher = tenVoucher;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Date getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(Date thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public Date getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(Date thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Date ngaySua) {
        this.ngaySua = ngaySua;
    }

    public double getGiamToiDa() {
        return giamToiDa;
    }

    public void setGiamToiDa(double giamToiDa) {
        this.giamToiDa = giamToiDa;
    }

    public Object[] toDataRow() {
        return new Object[]{
            this.idVoucher, this.getMaVoucher(), this.getTenVoucher(), this.getPhanTramGiam(), this.getThoiGianBatDau(), this.getThoiGianKetThuc(), this.getGiamToiDa(), this.getMoTa(), this.getNgayTao(), this.getNgaySua(), this.getTrangThai()
        };
    }
}
