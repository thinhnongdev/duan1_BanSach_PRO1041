/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.service;

import com.raven.model.HinhAnh;
import com.raven.utils.DBConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class HinhAnhService {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = "";
    List<HinhAnh> list;

    public List<HinhAnh> getAllHinhAnh() {
        list = new ArrayList<>();
        try {
            sql = "select * from HinhAnh";
            con = DBConnect.getConnection();
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                HinhAnh anh = new HinhAnh(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6), rs.getDate(7));
                list.add(anh);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }

    public String timduongdananh(String ten) {
        list = new ArrayList<>();
        try {
            sql = "select * from HinhAnh where Ten like ?";
            con = DBConnect.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(1, ten);
            rs = ps.executeQuery();
            while (rs.next()) {
                HinhAnh anh = new HinhAnh(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6), rs.getDate(7));
                list.add(anh);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return list.get(0).getDuongdananh();
    }

    public int ThemThuocTinhAnh(HinhAnh ha) {
        int result = -1;
        try {
            sql = "insert into HinhAnh(MaHinhAnh,Ten,DuongDanAnh,NgayTao) values (?,?,?,?)";
            con = DBConnect.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(1, ha.getMahinhanh());
            ps.setObject(2, ha.getTenhinhanh());
            ps.setObject(3, ha.getDuongdananh());
            ps.setObject(4, ha.getNgaytao());
            result = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            result = -1;
        }
        return result;
    }

    public int SuaThuocTinhAnh(HinhAnh ha, String ma) {
        int result = -1;
        try {
            sql = "update HinhAnh set Ten=?,DuongDanAnh=?,NgaySua=? where MaHinhAnh=?";
            con = DBConnect.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(4, ma);
            ps.setObject(1, ha.getTenhinhanh());
            ps.setObject(2, ha.getDuongdananh());
            ps.setObject(3, ha.getNgaysua());
            result = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            result = -1;
        }
        return result;
    }

    public HinhAnh getAt(int index) {
        return list.get(index);
    }
}
