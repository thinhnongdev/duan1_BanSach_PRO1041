package com.raven.service;

import com.raven.model.SanPham;
import com.raven.model.Voucher;
import com.raven.utils.DBConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VoucherService {

    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private Connection con = null;
    private String sql = "";
    private ArrayList<Voucher> listVoucher;
    private List<Voucher> list;

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

    public List<Voucher> getAll() {
        list = new ArrayList<>();
        try {
            sql = "select MaVoucher,TenVoucher,PhanTramGiam,GiamToiDa,TrangThai from Voucher";
            con = DBConnect.getConnection();
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Voucher vc = new Voucher(rs.getString(1), rs.getString(2), rs.getInt(3), null, null, rs.getDouble(4), null, null, rs.getString(5), null);
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

//    public Voucher getVoucher(String id) {
//        sql = "select idVoucher,MaVoucher,TenVoucher,PhanTramGiam,ThoiGianBatDau,ThoiGianKetThuc,GiamToiDa,MoTa,NgayTao,TrangThai,NgaySua from Voucher where MaVoucher like ?";
//        try {
//            con = DBConnect.getConnection();
//            PreparedStatement ps = con.prepareCall(sql);
//            ps.setString(1, id);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                Voucher voucher = new Voucher();
//                voucher.setMaVoucher(rs.getString(1));
//                voucher.setTenVoucher(rs.getString(2));
//                voucher.setPhanTramGiam(rs.getInt(3));
//                voucher.setThoiGianBatDau(rs.getDate(4));
//                voucher.setThoiGianKetThuc(rs.getDate(5));
//                voucher.setGiamToiDa(rs.getDouble(6));
//                voucher.setMoTa(rs.getString(7));
//                voucher.setNgayTao(rs.getDate(8));
//                voucher.setTrangThai(rs.getString(9));
//                voucher.setNgaySua(rs.getDate(10));
//
//                return voucher;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public Voucher getVoucherByPhanTram(int phantram) {
//        sql = "select idVoucher,MaVoucher,TenVoucher,PhanTramGiam,ThoiGianBatDau,ThoiGianKetThuc,GiamToiDa,MoTa,NgayTao,TrangThai,NgaySua from Voucher where PhanTramGiam = ? ";
//        try {
//            con = DBConnect.getConnection();
//            PreparedStatement ps = con.prepareCall(sql);
//            ps.setInt(1, phantram);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                Voucher voucher = new Voucher();
//                voucher.setMaVoucher(rs.getString(1));
//                voucher.setTenVoucher(rs.getString(2));
//                voucher.setPhanTramGiam(rs.getInt(3));
//                voucher.setThoiGianBatDau(rs.getDate(4));
//                voucher.setThoiGianKetThuc(rs.getDate(5));
//                voucher.setGiamToiDa(rs.getDouble(6));
//                voucher.setMoTa(rs.getString(7));
//                voucher.setNgayTao(rs.getDate(8));
//                voucher.setTrangThai(rs.getString(9));
//                voucher.setNgaySua(rs.getDate(10));
//                return voucher;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
    public int addVoucher(Voucher voucher) {
        sql = "insert into Voucher values(?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, voucher.getMaVoucher());
            ps.setString(2, voucher.getTenVoucher());
            ps.setInt(3, voucher.getPhanTramGiam());

            long date = voucher.getThoiGianBatDau().getTime();
            long date2 = voucher.getThoiGianKetThuc().getTime();
            long date3 = voucher.getNgayTao().getTime();
            long date4 = voucher.getNgaySua().getTime();

            ps.setDate(4, new Date(date));
            ps.setDate(5, new Date(date2));

            ps.setDouble(6, voucher.getGiamToiDa());
            ps.setString(7, voucher.getMoTa());

            ps.setDate(8, new Date(date3));
            ps.setString(9, voucher.getTrangThai());
            ps.setDate(10, new Date(date4));

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int updateVoucher(String ma, Voucher vc) {
        sql = "UPDATE Voucher SET MaVoucher = ?, TenVoucher = ?, PhanTramGiam = ?, ThoiGianBatDau = ?, ThoiGianKetThuc = ?, GiamToiDa = ?, MoTa = ?, NgayTao = ?, TrangThai = ?, NgaySua = ? WHERE MaVoucher like ?";
        try {
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, vc.getMaVoucher());
            ps.setString(2, vc.getTenVoucher());
            ps.setInt(3, vc.getPhanTramGiam());

            long date = vc.getThoiGianBatDau().getTime();
            long date2 = vc.getThoiGianKetThuc().getTime();
            long date3 = vc.getNgayTao().getTime();
            long date4 = vc.getNgaySua().getTime();

            ps.setDate(4, new Date(date));
            ps.setDate(5, new Date(date2));
            ps.setDouble(6, vc.getGiamToiDa());
            ps.setString(7, vc.getMoTa());
            ps.setDate(8, new Date(date3));
            ps.setString(9, vc.getTrangThai());
            ps.setDate(10, new Date(date4));

            ps.setString(11, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int deleteVoucher(String ma) {
        int result = 0;
        sql = "update Voucher set TrangThai=? where MaVoucher like ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(1, "Đã xóa");
            ps.setObject(2, ma);
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            result = 0;
        }
        return result;
    }

    public Voucher Loc(int phanTram, String trangThai, Date thoiGianBatDau, Date thoiGianKetThuc) {
        sql = "select * from voucher where MaVoucher like ? And TrangThai like ? And ThoiGianBatDau like ? And ThoiGianKetThuc like ?";
        try {
            con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareCall(sql);
            ps.setInt(1, phanTram);
            ps.setString(2, trangThai);
            ps.setDate(3, new java.sql.Date(thoiGianBatDau.getTime()));
            ps.setDate(4, new java.sql.Date(thoiGianKetThuc.getTime()));
            rs = ps.executeQuery();
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

    public Voucher getAt(int index) {
        if (index >= 0) {
            return listVoucher.get(index);
        }
        return null;
    }
}
