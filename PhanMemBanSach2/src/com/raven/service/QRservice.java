package com.raven.service;

import com.raven.model.SanPhamCT;
import com.raven.utils.DBConnect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QRservice {

    private Connection con = null;
    private CallableStatement cs = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = "";
    List<SanPhamCT> list;
    
     public List<SanPhamCT> getAllQR(String qrData) {
        list = new ArrayList<>();
        try {
            sql = "{call getSPCTtheoQR(?)}";
            con = DBConnect.getConnection();
            cs = con.prepareCall(sql);
            cs.setObject(1, qrData);
            rs = cs.executeQuery();
            
            while (rs.next()) {
                SanPhamCT spct = new SanPhamCT(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getDouble(9), rs.getInt(10), rs.getDate(11), rs.getString(12), rs.getDate(13), rs.getString(14));
                list.add(spct);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }
     
}
