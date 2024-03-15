/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.service;

import com.raven.model.model_hoadonct;
import com.raven.utils.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class serviev_hoadonct {
  private List<model_hoadonct> listSV;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    //tập kết quả truy vấn
    private String sql = null;
    
    
        public List<model_hoadonct> getAll() {
        listSV = new ArrayList<>();
        sql = "  select idHoaDonChiTiet,idHoaDon,idSachChiTiet,MaHoaDonChiTiet,DonGia,SoLuong,NgayTao,TrangThai from HoaDonChiTiet";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
       
            while (rs.next()) {
              
                model_hoadonct sv = new model_hoadonct(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getDouble(5), rs.getInt(6), rs.getString(7), rs.getString(8));
                listSV.add(sv);
                
            }
            return listSV;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
         public model_hoadonct getAt(int index){
        return listSV.get(index);
    }  
}
