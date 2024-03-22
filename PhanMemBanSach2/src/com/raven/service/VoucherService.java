/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.service;

import com.raven.model.voucher;
import com.raven.utils.DBConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class VoucherService {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = "";
    List<voucher> list;

    public List<voucher> getAll() {
        list = new ArrayList<>();
        try {
            sql = "select MaVoucher,TenVoucher,PhanTramGiam,GiamToiDa,TrangThai from Voucher";
            con = DBConnect.getConnection();
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                voucher vc = new voucher(rs.getString(1), rs.getString(2), rs.getInt(3), null, null, rs.getDouble(4), null, null, rs.getString(5), null);
                if (vc.getTrangThai().equalsIgnoreCase("Hoạt động")) {
                    list.add(vc);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }
}
