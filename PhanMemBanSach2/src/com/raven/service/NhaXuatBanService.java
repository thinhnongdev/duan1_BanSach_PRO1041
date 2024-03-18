/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.service;

import com.raven.model.NhaCungCap;
import com.raven.model.NhaXuatBan;
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
public class NhaXuatBanService {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = "";
    List<NhaXuatBan> list;

    public List<NhaXuatBan> getAllNhaXuatBan() {
        list = new ArrayList<>();
        try {
            sql = "select * from NhaXuatBan";
            con = DBConnect.getConnection();
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                NhaXuatBan nxb = new NhaXuatBan(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getString(7), rs.getDate(8));
                list.add(nxb);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }

    public int AddNhaXuatBan(NhaXuatBan nxb) {
        int result = -1;
        try {
            sql = "insert into NhaXuatBan(MaNhaXuatBan,TenNhaXuatBan,DiaChi,SDT,NgayTao,TrangThai,NgaySua) values(?,?,?,?,?,?,?)";
            con = DBConnect.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(1, nxb.getManhaxuatban());
            ps.setObject(2, nxb.getTennhaxuatban());
            ps.setObject(3, nxb.getDiachi());
            ps.setObject(4, nxb.getSdt());
            ps.setObject(5, nxb.getNgaytao());
            ps.setObject(6, nxb.getTrangthai());
            ps.setObject(7, nxb.getNgaysua());
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            result = 0;
        }
        return result;
    }

    public int SuaNhaXuatBan(NhaXuatBan nxb, String ma) {
        int result = -1;
        try {
            sql = "update NhaXuatBan set TenNhaXuatBan=?,DiaChi=?,SDT=?,TrangThai=?,NgaySua=? where MaNhaXuatBan=?";
            con = DBConnect.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(6, ma);
            ps.setObject(1, nxb.getTennhaxuatban());
            ps.setObject(2, nxb.getDiachi());
            ps.setObject(3, nxb.getSdt());
            ps.setObject(4, nxb.getTrangthai());
            ps.setObject(5, nxb.getNgaysua());
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            result = 0;
        }
        return result;
    }

    public NhaXuatBan getAt(int index) {
        return list.get(index);
    }
}
