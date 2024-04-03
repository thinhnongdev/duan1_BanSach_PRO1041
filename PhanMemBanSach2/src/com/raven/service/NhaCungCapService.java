/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.service;

import com.raven.model.NhaCungCap;
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
public class NhaCungCapService {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = "";
    List<NhaCungCap> list;

    public List<NhaCungCap> getAllNhaCungCap() {
        list = new ArrayList<>();
        try {
            sql = "select * from NhaCungCap";
            con = DBConnect.getConnection();
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                NhaCungCap ncc = new NhaCungCap(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getString(7), rs.getDate(8));
                list.add(ncc);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }

    public int AddNhaCungCap(NhaCungCap ncc) {
        int result = -1;
        try {
            sql = "insert into NhaCungCap(MaNhaCungCap,TenNhaCungCap,DiaChi,SDT,NgayTao,TrangThai,NgaySua) values(?,?,?,?,?,?,?)";
            con = DBConnect.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(1, ncc.getManhacungcap());
            ps.setObject(2, ncc.getTennhacungcap());
            ps.setObject(3, ncc.getDiachi());
            ps.setObject(4, ncc.getSdt());
            ps.setObject(5, ncc.getNgaytao());
            ps.setObject(6, ncc.getTrangthai());
            ps.setObject(7, ncc.getNgaysua());
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            result = 0;
        }
        return result;
    }

    public int SuaNhaCungCap(NhaCungCap ncc, String ma) {
        int result = -1;
        try {
            sql = "update NhaCungCap set TenNhaCungCap=?,DiaChi=?,SDT=?,TrangThai=?,NgaySua=? where MaNhaCungCap=?";
            con = DBConnect.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(6, ma);
            ps.setObject(1, ncc.getTennhacungcap());
            ps.setObject(2, ncc.getDiachi());
            ps.setObject(3, ncc.getSdt());
            ps.setObject(4, ncc.getTrangthai());
            ps.setObject(5, ncc.getNgaysua());
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            result = 0;
        }
        return result;
    }

    public NhaCungCap getAt(int index) {
        return list.get(index);
    }
}
