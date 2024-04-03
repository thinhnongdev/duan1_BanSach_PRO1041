/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.service;

import com.raven.model.TacGia;
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
public class TacGiaService {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = "";
    List<TacGia> list;

    public List<TacGia> getAllTacGia() {
        list = new ArrayList<>();
        try {
            sql = "select * from TacGia";
            con = DBConnect.getConnection();
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                TacGia tg = new TacGia(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getDate(6));
                list.add(tg);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }

    public int AddTacGia(TacGia tg) {
        int result = -1;
        try {
            sql = "insert into TacGia(MaTacGia,TenTacGia,NgayTao,TrangThai,NgaySua) values(?,?,?,?,?)";
            con = DBConnect.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(1, tg.getMatacgia());
            ps.setObject(2, tg.getTentacgia());
            ps.setObject(3, tg.getNgaytao());
            ps.setObject(4, tg.getTrangthai());
            ps.setObject(5, tg.getNgaysua());
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            result = 0;
        }
        return result;
    }

    public int SuaTacGia(TacGia tg, String ma) {
        int result = -1;
        try {
            sql = "update TacGia set TenTacGia=?,TrangThai=?,NgaySua=? where MaTacGia=?";
            con = DBConnect.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(4, ma);
            ps.setObject(1, tg.getTentacgia());
            ps.setObject(2, tg.getTrangthai());
            ps.setObject(3, tg.getNgaysua());
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            result = 0;
        }
        return result;
    }

    public TacGia getAt(int index) {
        return list.get(index);
    }
}
