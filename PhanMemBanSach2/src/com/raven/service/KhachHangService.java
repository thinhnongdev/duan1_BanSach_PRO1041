/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.service;

import com.raven.model.KhachHang;
import com.raven.utils.DBConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KhachHangService {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = "";
    List<KhachHang> list;

    public List<KhachHang> getAll() {
        list = new ArrayList<>();
        try {
            sql = "select MaKhachHang,TenKhachHang,SDT,DiaChi from KhachHang";
            con = DBConnect.getConnection();
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(4), rs.getString(3), null, null, null);
                list.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }

    public int themKH(KhachHang kh) {
        int result = 0;
        try {
            sql = "insert into KhachHang(MaKhachHang,TenKhachHang,SDT,DiaChi,NgayTao,TrangThai) values(?,?,?,?,?,?)";
            con = DBConnect.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(1, kh.getMaKH());
            ps.setObject(2, kh.getTenKH());
            ps.setObject(3, kh.getSDT());
            ps.setObject(4, kh.getDiaChi());
            ps.setObject(5, kh.getNgayTao());
            ps.setObject(6, kh.getTrangThai());
            result = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            result = 0;
        }
        return result;
    }

    public List<KhachHang> TimKhachHang(String thongtintimkiem) {
        list = new ArrayList<>();
        try {
            sql = "select MaKhachHang,TenKhachHang,SDT,DiaChi from KhachHang where TenKhachHang like '%'+?+'%' or SDT like '%'+?+'%'";
            con = DBConnect.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(1, thongtintimkiem);
            ps.setObject(2, thongtintimkiem);
            rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), null, null, null);
                list.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }

    public List<KhachHang> TimKhachHangTheoMa(String thongtintimkiem) {
        list = new ArrayList<>();
        try {
            sql = "select MaKhachHang,TenKhachHang,SDT,DiaChi from KhachHang where MaKhachHang = ?";
            con = DBConnect.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(1, thongtintimkiem);
            rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), null, null, null);
                list.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }
}
