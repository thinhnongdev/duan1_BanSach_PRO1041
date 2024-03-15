/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.service;

import com.raven.model.model_hoadon;
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
public class serviec_hoadon {
     private List<model_hoadon> listSV;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    //tập kết quả truy vấn
    private String sql = null;
    
    
        public List<model_hoadon> getAll() {
        listSV = new ArrayList<>();
        sql = "  select idHoaDon,idKhachHang,idNhanVien,idVoucher,idThanhToan,MaHoaDon,TongTien,GhiChu,NgayTao,TrangThai from HoaDon";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
       
            while (rs.next()) {
              
                model_hoadon sv = new model_hoadon(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
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
        
        
             
          public List<model_hoadon> searchSP(String masp) {
        listSV = new ArrayList<>();
        try {
            sql = "  select idHoaDon,idKhachHang,idNhanVien,idVoucher,idThanhToan,MaHoaDon,TongTien,GhiChu,NgayTao,TrangThai from HoaDon WHERE MaHoaDon LIKE ?";
            con = DBConnect.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(1, "%" + masp + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                  model_hoadon sv = new model_hoadon(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
                listSV.add(sv);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return listSV;
    }
        
        
        
         public model_hoadon getAt(int index){
        return listSV.get(index);
    }
}
