/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.service;

import com.raven.model.SanPham;
import com.raven.utils.DBConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class SanPhamService {

    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private Connection con = null;
    private String sql = "";
    private List<SanPham> list;

    public List<SanPham> getAll() {
        list = new ArrayList<>();
        try {
            sql = "select * from Sach";
            con = DBConnect.getConnection();
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getDate(6));
                list.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }

    public int addSP(SanPham sp) {
        int result = 0;
        try {
            sql = "insert into Sach(MaSach,TenSach,NgayTao,TrangThai) values(?,?,?,?)";
            con = DBConnect.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(1, sp.getMaSach());
            ps.setObject(2, sp.getTenSach());
            ps.setObject(3, sp.getNgayTao());
            ps.setObject(4, "Đang hoạt động");
            result = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            result = 0;
        }
        return result;
    }

    public int updateSP(SanPham sp,String ma) {
        int result = 0;
        try {
            sql = "UPDATE Sach SET TenSach=?,NgaySua=? WHERE MaSach=?";
            con = DBConnect.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(1, sp.getTenSach());
            ps.setObject(2, sp.getNgaySua());
            ps.setObject(3, ma);
            result = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            result = 0;
        }
        return result;
    }

    public List<SanPham> searchSP(String masp) {
        list = new ArrayList<>();
        try {
            sql = "select * from Sach WHERE TenSach LIKE ?";
            con = DBConnect.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(1, "%" + masp + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getDate(6));
                list.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }

    public SanPham getAtSP(int index) {
        return list.get(index);
    }
}
