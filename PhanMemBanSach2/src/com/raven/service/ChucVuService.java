/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.service;

import com.raven.model.ChucVu;
import com.raven.model.NhanVien;
import com.raven.utils.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

/**
 *
 * @author Admin
 */
public class ChucVuService {

    List<ChucVu> listCV;
    private Connection con = null;
    private PreparedStatement pre = null;
    private ResultSet rs = null;
    private String sql = null;

    public List<ChucVu> getAll() {
        listCV = new ArrayList();
        sql = "select * from ChucVu";
        try {
            con = DBConnect.getConnection();
            pre = con.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                ChucVu cv = new ChucVu(
                        rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(5), rs.getDate(4), rs.getDate(6)
                );
                listCV.add(cv);
            }
            return listCV;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int AddCV(ChucVu cv) {
        int result = 0;
        sql = "insert into ChucVu(MaChucVu, TenChucVu, NgayTao, TrangThai, NgaySua) values(?,?,?,?,?)";
        try {
            con = DBConnect.getConnection();
            pre = con.prepareStatement(sql);
            pre.setObject(1, cv.getMaChucVu());
            pre.setObject(2, cv.getTenChucVu());
            pre.setObject(3, cv.getNgayTaoCV());
            pre.setObject(4, cv.getTrangThaiCV());
            pre.setObject(5, cv.getNgaySuaCV());
            result = pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            result = 0;
        }
        return result;
    }

    public int UpdateCV(ChucVu cv, String ma1) {
        int result = 0;
        sql = "update ChucVu set TenChucVu =?, NgayTao=?, TrangThai=?, NgaySua=? where MaChucVu = ?";
        try {
            con = DBConnect.getConnection();
            pre = con.prepareStatement(sql);
            pre.setObject(1, cv.getTenChucVu());
            pre.setObject(2, cv.getNgayTaoCV());
            pre.setObject(3, cv.getTrangThaiCV());
            pre.setObject(4, cv.getNgaySuaCV());
            pre.setObject(5, ma1);
            result = pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            result = 0;
        }
        return result;
    }

    public ChucVu getAtCV(int index) {
        return listCV.get(index);
    }
}
