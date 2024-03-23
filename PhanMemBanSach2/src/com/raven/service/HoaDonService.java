/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.service;

/**
 *
 * @author Admin
 */
import com.raven.model.HoaDon;
import com.raven.model.HoaDonChiTiet;
import com.raven.model.ThanhToan;
import com.raven.utils.DBConnect;
import java.sql.*;

public class HoaDonService {

    private Connection con = null;
    private CallableStatement cs = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = "";

    public int themTT(ThanhToan tt) {
        int result = 0;
        try {
            sql = "insert into ThanhToan(MaThanhToan,HinhThucThanhToan,TongTienThanhToan,NgayTao,TrangThai) values(?,?,?,?,?)";
            con = DBConnect.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(1, tt.getMaThanhToan());
            ps.setObject(2, tt.getHinhThucThanhToan());
            ps.setObject(3, tt.getTongTienThanhToan());
            ps.setObject(4, tt.getNgayTao());
            ps.setObject(5, tt.getTrangThai());
            result = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            result = 0;
        }
        return result;
    }

    public int themHD(HoaDon hd) {
        int result = -1;
        try {
            sql = "{Call ThemHoaDon(?,?,?,?,?,?,?)}";
            con = DBConnect.getConnection();
            cs = con.prepareCall(sql);
            cs.setObject(1, hd.getMaHoaDon());
            cs.setObject(2, hd.getMaKhachHang());
            cs.setObject(3, hd.getMaNhanVien());
            cs.setObject(4, hd.getMaVoucher());
            cs.setObject(5, hd.getTongTien());
            cs.setObject(6, hd.getTrangThai());
            cs.setObject(7, hd.getNgayTao());
            result = cs.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            result = 0;
        }
        return result;
    }

    public int themHDCT(HoaDonChiTiet hdct) {
        int result = -1;
        try {
            sql = "{Call themHoaDonCT(?,?,?,?,?,?,?)}";
            con = DBConnect.getConnection();
            cs = con.prepareCall(sql);
            cs.setObject(1, hdct.getMaHoaDon());
            cs.setObject(2, hdct.getMaSPCT());
            cs.setObject(3, hdct.getMaHoaDonCT());
            cs.setObject(4, hdct.getDonGia());
            cs.setObject(5, hdct.getSoLuong());
            cs.setObject(6, hdct.getNgayTao());
            cs.setObject(7, hdct.getTrangThai());
            result = cs.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            result = 0;
        }
        return result;
    }
}

