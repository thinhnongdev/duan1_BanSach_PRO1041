/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.service;

import com.raven.model.SanPhamCT;
import com.raven.utils.DBConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class SanPhamCTservice {

    private Connection con = null;
    private CallableStatement cs = null;
    private ResultSet rs = null;
    private String sql = "";
    List<SanPhamCT> list;

    public List<SanPhamCT> getAll(String masach) {
        list = new ArrayList<>();
        try {
            sql = "{call SelectAllSachCT(?)}";
            con = DBConnect.getConnection();
            cs = con.prepareCall(sql);
            cs.setObject(1, masach);
            rs = cs.executeQuery();
            while (rs.next()) {
                SanPhamCT spct = new SanPhamCT(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getDouble(9), rs.getInt(10), rs.getDate(11), rs.getString(12), rs.getDate(13));
                list.add(spct);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }
}
