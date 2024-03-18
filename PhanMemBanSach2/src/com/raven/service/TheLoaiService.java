/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.service;

import com.raven.model.HinhAnh;
import com.raven.model.TheLoai;
import com.raven.utils.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class TheLoaiService {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = "";
    List<TheLoai> list;

    public List<TheLoai> getAllTheLoai() {
        list = new ArrayList<>();
        try {
            sql = "select * from TheLoai";
            con = DBConnect.getConnection();
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                TheLoai tl = new TheLoai(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getDate(6));
                list.add(tl);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }

    public int AddTheLoai(TheLoai tl) {
        int result = -1;
        try {
            sql = "insert into TheLoai(MaTheLoai,TenTheLoai,NgayTao,TrangThai,NgaySua) values(?,?,?,?,?)";
            con = DBConnect.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(1, tl.getMatheloai());
            ps.setObject(2, tl.getTentheloai());
            ps.setObject(3, tl.getNgaytao());
            ps.setObject(4, tl.getTrangthai());
            ps.setObject(5, tl.getNgaysua());
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            result = 0;
        }
        return result;
    }

    public int SuaTheLoai(TheLoai tl, String ma) {
        int result = -1;
        try {
            sql = "update TheLoai set TenTheLoai=?,TrangThai=?,NgaySua=? where MaTheLoai=?";
            con = DBConnect.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(4, ma);
            ps.setObject(1, tl.getTentheloai());
            ps.setObject(2, tl.getTrangthai());
            ps.setObject(3, tl.getNgaysua());
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            result = 0;
        }
        return result;
    }

    public TheLoai getAt(int index) {
        return list.get(index);
    }

}
