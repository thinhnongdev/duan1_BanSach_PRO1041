package com.raven.service;

import com.raven.model.SanPham;
import com.raven.model.Voucher;
import com.raven.utils.DBConnect;
import java.sql.*;
import java.util.ArrayList;

public class VoucherService {

    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private Connection con = null;
    private String sql = "";
    private ArrayList<Voucher> listVoucher;

    public ArrayList<Voucher> getAllVoucher() {
        listVoucher = new ArrayList<>();
        sql = "select idVoucher,MaVoucher,TenVoucher,PhanTramGiam,ThoiGianBatDau,ThoiGianKetThuc,GiamToiDa,MoTa,NgayTao,TrangThai,NgaySua from Voucher";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Voucher vc = new Voucher(rs.getInt(1), rs.getInt(4), rs.getString(2), rs.getString(3), rs.getString(8), rs.getString(10), rs.getDate(5), rs.getDate(6), rs.getDate(9), rs.getDate(11), rs.getDouble(7));
                listVoucher.add(vc);
            }
            return listVoucher;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Voucher getVoucher(String id) {
        sql = "select idVoucher,MaVoucher,TenVoucher,PhanTramGiam,ThoiGianBatDau,ThoiGianKetThuc,GiamToiDa,MoTa,NgayTao,TrangThai,NgaySua from Voucher where MaVoucher = ?";
        try {
            con = DBConnect.getConnection();
            PreparedStatement stmt = con.prepareCall(sql);
            stmt.setString(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Voucher voucher = new Voucher();
                voucher.setMaVoucher(rs.getString(1));
                voucher.setTenVoucher(rs.getString(2));
                voucher.setPhanTramGiam(rs.getInt(3));
                voucher.setThoiGianBatDau(rs.getDate(4));
                voucher.setThoiGianKetThuc(rs.getDate(5));
                voucher.setGiamToiDa(rs.getDouble(6));
                voucher.setMoTa(rs.getString(7));
                voucher.setNgayTao(rs.getDate(8));
                voucher.setTrangThai(rs.getString(9));
                voucher.setNgaySua(rs.getDate(10));

                return voucher;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Voucher getVoucherByPhanTram(int phantram) {
        sql = "select idVoucher,MaVoucher,TenVoucher,PhanTramGiam,ThoiGianBatDau,ThoiGianKetThuc,GiamToiDa,MoTa,NgayTao,TrangThai,NgaySua from Voucher where PhanTramGiam = ? ";
        try {
            con = DBConnect.getConnection();
            PreparedStatement stmt = con.prepareCall(sql);
            stmt.setInt(1, phantram);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Voucher voucher = new Voucher();
                voucher.setMaVoucher(rs.getString(1));
                voucher.setTenVoucher(rs.getString(2));
                voucher.setPhanTramGiam(rs.getInt(3));
                voucher.setThoiGianBatDau(rs.getDate(4));
                voucher.setThoiGianKetThuc(rs.getDate(5));
                voucher.setGiamToiDa(rs.getDouble(6));
                voucher.setMoTa(rs.getString(7));
                voucher.setNgayTao(rs.getDate(8));
                voucher.setTrangThai(rs.getString(9));
                voucher.setNgaySua(rs.getDate(10));
                return voucher;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int addVoucher(Voucher voucher) {
        sql = "insert into Voucher values(?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = con.prepareCall(sql);
            stmt.setString(1, voucher.getMaVoucher());
            stmt.setString(2, voucher.getTenVoucher());
            stmt.setInt(3, voucher.getPhanTramGiam());
            long date = voucher.getThoiGianBatDau().getTime();

            stmt.setDate(4, new Date(date));
            stmt.setDate(5, new Date(date));

            stmt.setDouble(6, voucher.getGiamToiDa());
            stmt.setString(7, voucher.getMoTa());

            stmt.setDate(8, new Date(date));
            stmt.setString(9, voucher.getMoTa());
            stmt.setDate(10, new Date(date));

            return stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int updateVoucher(String ma, Voucher vc) {
        sql = "update Voucher set PhanTramGiam = ?, ThoiGianBatDau = ?,ThoiGianKetThuc=?,GiamToiDa = ?,MoTa=? where MaVoucher = ?";
        try {
            PreparedStatement stmt = con.prepareCall(sql);
            stmt.setInt(1, vc.getPhanTramGiam());

            long date = vc.getThoiGianBatDau().getTime();

            stmt.setDate(2, new Date(date));
            stmt.setDate(3, new Date(date));
            stmt.setDouble(6, vc.getGiamToiDa());
            stmt.setString(7, vc.getMoTa());
            return stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    
    public Voucher getAt(int index) {
        if (index >= 0) {
            return listVoucher.get(index);
        }
        return null;
    }
}
