/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.model;

import java.util.Date;
import java.text.SimpleDateFormat;

public class ChucVu {

    private Integer idChucVu;
    private String MaChucVu;
    private String TenChucVu;
    private String TrangThaiCV;
    private Date NgayTaoCV;
    private Date NgaySuaCV;

    public ChucVu() {
    }

    public ChucVu(Integer idChucVu, String MaChucVu, String TenChucVu, String TrangThaiCV, Date NgayTaoCV, Date NgaySuaCV) {
        this.idChucVu = idChucVu;
        this.MaChucVu = MaChucVu;
        this.TenChucVu = TenChucVu;
        this.TrangThaiCV = TrangThaiCV;
        this.NgayTaoCV = NgayTaoCV;
        this.NgaySuaCV = NgaySuaCV;
    }

    public ChucVu(String MaChucVu, String TenChucVu, String TrangThaiCV, Date NgayTaoCV, Date NgaySuaCV) {
        this.MaChucVu = MaChucVu;
        this.TenChucVu = TenChucVu;
        this.TrangThaiCV = TrangThaiCV;
        this.NgayTaoCV = NgayTaoCV;
        this.NgaySuaCV = NgaySuaCV;
    }

    public Integer getIdChucVu() {
        return idChucVu;
    }

    public void setIdChucVu(Integer idChucVu) {
        this.idChucVu = idChucVu;
    }

    public String getMaChucVu() {
        return MaChucVu;
    }

    public void setMaChucVu(String MaChucVu) {
        this.MaChucVu = MaChucVu;
    }

    public String getTenChucVu() {
        return TenChucVu;
    }

    public void setTenChucVu(String TenChucVu) {
        this.TenChucVu = TenChucVu;
    }

    public String getTrangThaiCV() {
        return TrangThaiCV;
    }

    public void setTrangThaiCV(String TrangThaiCV) {
        this.TrangThaiCV = TrangThaiCV;
    }

    public Date getNgayTaoCV() {
        return NgayTaoCV;
    }

    public void setNgayTaoCV(Date NgayTaoCV) {
        this.NgayTaoCV = NgayTaoCV;
    }

    public Date getNgaySuaCV() {
        return NgaySuaCV;
    }

    public void setNgaySuaCV(Date NgaySuaCV) {
        this.NgaySuaCV = NgaySuaCV;
    }

    public Object[] DataRow1() {
        return new Object[]{
            this.idChucVu, this.getMaChucVu(), this.getTenChucVu(), this.getNgayTaoCV(), this.getTrangThaiCV(), this.getNgaySuaCV()
        };
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return "ChucVu{" + "idChucVu=" + idChucVu + ", MaChucVu=" + MaChucVu + ", TenChucVu=" + TenChucVu + ", NgayTaoCV=" + NgayTaoCV + ", TrangThaiCV=" + TrangThaiCV + ", NgaySuaCV=" + NgaySuaCV + '}';
    }

}
