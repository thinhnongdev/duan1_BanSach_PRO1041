/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.service;

import com.raven.model.NhanVien;
import com.raven.utils.DBConnect;
import java.util.*;
import java.sql.*;

public class NhanVienService {

    List<NhanVien> listNV;
    private Connection con = null;
    private PreparedStatement pre = null;
    private ResultSet rs = null;
    private String sql = null;

    public List<NhanVien> getAll() {
        listNV = new ArrayList();
        sql = "select idNhanVien, MaNhanVien, TenNhanVien,TenDangNhap,MatKhau,GioiTinh,Email,DiaChi,SDT, NgayTao, TrangThai, idChucVu from NhanVien";

        try {
            con = DBConnect.getConnection();
            pre = con.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien(
                        rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getBoolean(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getDate(10), rs.getString(11),
                        rs.getInt(12)
                );
                listNV.add(nv);
            }
            return listNV;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public int AddNV(NhanVien nv) {
        int result = 0;
        sql = "insert into NhanVien(MaNhanVien, TenNhanVien,TenDangNhap,MatKhau,GioiTinh,Email,DiaChi,SDT, NgayTao, TrangThai, idChucVu) values(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            con = DBConnect.getConnection();
            pre = con.prepareStatement(sql);
            pre.setObject(1, nv.getMaNhanVien());
            pre.setObject(2, nv.getTenNhanVien());
            pre.setObject(3, nv.getTenDangNhap());
            pre.setObject(4, nv.getMatKhau());
            pre.setObject(5, nv.isGioiTinh());
            pre.setObject(6, nv.getEmail());
            pre.setObject(7, nv.getDiaChi());
            pre.setObject(8, nv.getSDT());
            pre.setObject(9, nv.getNgayTao());
            pre.setObject(10, nv.getTrangThai());
            pre.setObject(11, nv.getIdChucVu());
            result = pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            result = 0;
        }
        return result;
    }

    public int UpdateNV(NhanVien nv, String ma) {
        int result = 0;
        sql = "update NhanVien set TenNhanVien=?,TenDangNhap=?,MatKhau=?,GioiTinh=?,Email=?,DiaChi=?,SDT=?, NgayTao=?, TrangThai=?, idChucVu=? where MaNhanVien=?";
        try {
            con = DBConnect.getConnection();
            pre = con.prepareStatement(sql);
            pre.setObject(1, nv.getTenNhanVien());
            pre.setObject(2, nv.getTenDangNhap());
            pre.setObject(3, nv.getMatKhau());
            pre.setObject(4, nv.isGioiTinh());
            pre.setObject(5, nv.getEmail());
            pre.setObject(6, nv.getDiaChi());
            pre.setObject(7, nv.getSDT());
            pre.setObject(8, nv.getNgayTao());
            pre.setObject(9, nv.getTrangThai());
            pre.setObject(10, nv.getIdChucVu());
            pre.setObject(11, ma);
            result = pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            result = 0;
        }
        return result;
    }

    public int DeleteNV(String ma) {
        int result = 0;
        sql = "update NhanVien set TrangThai=? where MaNhanVien like ?";
        try {
            con = DBConnect.getConnection();
            pre = con.prepareStatement(sql);
            pre.setObject(1, "Đã xóa");
            pre.setObject(2, ma);
            result = pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            result = 0;
        }
        return result;
    }
    public NhanVien getAtNV(int index) {
        return listNV.get(index);
    }
}
