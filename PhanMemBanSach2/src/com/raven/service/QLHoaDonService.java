/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.service;

import com.raven.model.HoaDonChiTiet;
import com.raven.model.QLhoaDon;
import com.raven.model.SanPhamCT;
import com.raven.utils.DBConnect;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class QLHoaDonService {

    private Connection con = null;
    private CallableStatement cs = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private ResultSet rs2 = null;
    private String sql = "";
    List<QLhoaDon> listQLHD = null;
    List<SanPhamCT> listspct = null;

    public List<QLhoaDon> getAllQLHD() {
        listQLHD = new ArrayList<>();
        try {
            sql = "select MaHoaDon,HoaDon.NgayTao,ThanhToan.NgaySua,ThanhToan.TongTienThanhToan,NhanVien.MaNhanVien,KhachHang.TenKhachHang,HoaDon.TrangThai from HoaDon join ThanhToan on ThanhToan.idThanhToan=HoaDon.idThanhToan join NhanVien on NhanVien.idNhanVien=HoaDon.idNhanVien join KhachHang on KhachHang.idKhachHang =HoaDon.idKhachHang";
            con = DBConnect.getConnection();
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                QLhoaDon hd = new QLhoaDon(rs.getString(1), rs.getDate(2), rs.getDate(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7), null, null, null, 0, null, null);
                listQLHD.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return listQLHD;
    }

    public List<QLhoaDon> TimHD(String maHD) {
        listQLHD = new ArrayList<>();
        try {
            sql = "select MaHoaDon,HoaDon.NgayTao,ThanhToan.NgaySua,ThanhToan.TongTienThanhToan,NhanVien.MaNhanVien,KhachHang.TenKhachHang,HoaDon.TrangThai from HoaDon join ThanhToan on ThanhToan.idThanhToan=HoaDon.idThanhToan join NhanVien on NhanVien.idNhanVien=HoaDon.idNhanVien join KhachHang on KhachHang.idKhachHang =HoaDon.idKhachHang where HoaDon.MaHoaDon like '%'+?+'%'";
            con = DBConnect.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(1, maHD);
            rs = ps.executeQuery();
            while (rs.next()) {
                QLhoaDon hd = new QLhoaDon(rs.getString(1), rs.getDate(2), rs.getDate(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7), null, null, null, 0, null, null);
                listQLHD.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return listQLHD;
    }

    public QLhoaDon TimThongtincthd(String maHD) {
        listQLHD = new ArrayList<>();
        try {
            sql = "select MaHoaDon,HoaDon.NgayTao,ThanhToan.NgaySua,ThanhToan.TongTienThanhToan,NhanVien.MaNhanVien,KhachHang.TenKhachHang,HoaDon.TrangThai,NhanVien.TenNhanVien,KhachHang.DiaChi,KhachHang.SDT,Voucher.PhanTramGiam,ThanhToan.HinhThucThanhToan,HoaDon.TongTien from HoaDon join ThanhToan on ThanhToan.idThanhToan=HoaDon.idThanhToan join NhanVien on NhanVien.idNhanVien=HoaDon.idNhanVien join KhachHang on KhachHang.idKhachHang =HoaDon.idKhachHang join Voucher on Voucher.idVoucher=HoaDon.idVoucher where HoaDon.MaHoaDon like ?";
            con = DBConnect.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(1, maHD);
            rs = ps.executeQuery();
            while (rs.next()) {
                QLhoaDon hd = new QLhoaDon(rs.getString(1), rs.getDate(2), rs.getDate(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getShort(11), rs.getString(12), rs.getDouble(13));
                listQLHD.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return listQLHD.get(0);
    }

    public List<SanPhamCT> getSPCT(String maHoaDon) {
        listspct = new ArrayList<>();
        try {
            sql = "select SachChiTiet.MaSachChiTiet,Sach.TenSach,TheLoai.TenTheLoai,TacGia.TenTacGia,NhaXuatBan.TenNhaXuatBan,HoaDonChiTiet.DonGia,HoaDonChiTiet.SoLuong,HoaDonChiTiet.TrangThai from HoaDonChiTiet join HoaDon on HoaDon.idHoaDon=HoaDonChiTiet.idHoaDon join SachChiTiet on HoaDonChiTiet.idSachChiTiet=SachChiTiet.idSachChiTiet join HinhAnh on SachChiTiet.idHinhAnh=HinhAnh.idHinhAnh join NhaCungCap on SachChiTiet.idNhaCungCap=NhaCungCap.idNhaCungCap join NhaXuatBan on SachChiTiet.idNhaXuatBan=NhaXuatBan.idNhaXuatBan join TacGia on SachChiTiet.idTacGia=TacGia.idTacGia join TheLoai on SachChiTiet.idTheLoai=TheLoai.idTheLoai join Sach on Sach.idSach=SachChiTiet.idSach where MaHoaDon=?";
            con = DBConnect.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(1, maHoaDon);
            rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamCT sp = new SanPhamCT(null, rs.getString(1), rs.getString(2), rs.getString(4), rs.getString(3), null, null, rs.getString(5), rs.getDouble(6), rs.getInt(7), null, rs.getString(8), null, null);
                if (sp.getTrangthai().equalsIgnoreCase("Đã thanh toán") || sp.getTrangthai().equalsIgnoreCase("Chờ thanh toán")) {
                    listspct.add(sp);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return listspct;
    }

    public int XoaHoaDon(String maHD) {
        int result = -1;
        try {
            sql = "update HoaDon set TrangThai=? where MaHoaDon=?";
            con = DBConnect.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(1, "Da huy");
            ps.setObject(2, maHD);
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            result = 0;
        }
        return result;
    }

    public List<QLhoaDon> LocTheoTruongDacTrung(String trangthai, String hinhthucTT) {
        listQLHD = new ArrayList<>();
        try {
            sql = "select MaHoaDon,HoaDon.NgayTao,ThanhToan.NgaySua,ThanhToan.TongTienThanhToan,NhanVien.MaNhanVien,KhachHang.TenKhachHang,HoaDon.TrangThai from HoaDon join ThanhToan on ThanhToan.idThanhToan=HoaDon.idThanhToan join NhanVien on NhanVien.idNhanVien=HoaDon.idNhanVien join KhachHang on KhachHang.idKhachHang =HoaDon.idKhachHang where HoaDon.TrangThai like '%'+?+'%' and ThanhToan.HinhThucThanhToan like '%'+?+'%'";
            con = DBConnect.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(1, trangthai);
            ps.setObject(2, hinhthucTT);
            rs = ps.executeQuery();
            while (rs.next()) {
                QLhoaDon hd = new QLhoaDon(rs.getString(1), rs.getDate(2), rs.getDate(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7), null, null, null, 0, null, null);
                listQLHD.add(hd);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return listQLHD;
    }
}
