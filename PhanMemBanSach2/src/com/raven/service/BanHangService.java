/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.service;

import com.raven.model.HoaDon;
import com.raven.model.HoaDonChiTiet;
import com.raven.model.ThanhToan;
import com.raven.utils.DBConnect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class BanHangService {

    private Connection con = null;
    private CallableStatement cs = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private ResultSet rs2 = null;
    private String sql = "";
    List<HoaDon> listHD = null;
    List<HoaDonChiTiet> listHDCT = null;

    public List<HoaDon> getAllHD() {
        listHD = new ArrayList<>();
        try {
            sql = "select HoaDon.MaHoaDon,HoaDon.NgayTao,NhanVien.MaNhanVien,KhachHang.MaKhachHang,ThanhToan.MaThanhToan,HoaDon.TrangThai  from HoaDon join NhanVien on NhanVien.idNhanVien=HoaDon.idNhanVien join KhachHang on KhachHang.idKhachHang=HoaDon.idKhachHang join ThanhToan on ThanhToan.idThanhToan=HoaDon.idThanhToan";
            con = DBConnect.getConnection();
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon(rs.getString(4), rs.getString(3), null, rs.getString(5), rs.getString(1), null, null, rs.getDate(2), rs.getString(6), null, 0);
                if (hd.getTrangThai().equalsIgnoreCase("Cho thanh toan")) {
                    listHD.add(hd);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return listHD;
    }

    public List<HoaDonChiTiet> getHDCT(String maHD) {
        listHDCT = new ArrayList<>();
        try {
            sql = "select HoaDon.MaHoaDon,MaHoaDonChiTiet,SachChiTiet.MaSachChiTiet,Sach.TenSach,TheLoai.TenTheLoai,TacGia.TenTacGia,HoaDonChiTiet.DonGia,HoaDonChiTiet.SoLuong,HoaDonChiTiet.DonGia*HoaDonChiTiet.SoLuong as ThanhTien,HoaDonChiTiet.TrangThai from HoaDonChiTiet join HoaDon on HoaDon.idHoaDon=HoaDonChiTiet.idHoaDon join SachChiTiet on SachChiTiet.idSachChiTiet=HoaDonChiTiet.idSachChiTiet join TheLoai on TheLoai.idTheLoai=SachChiTiet.idTheLoai join TacGia on TacGia.idTacGia=SachChiTiet.idTacGia join Sach on Sach.idSach=SachChiTiet.idSach where MaHoaDon=?";
            con = DBConnect.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(1, maHD);
            rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonChiTiet hdct = new HoaDonChiTiet(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDouble(7), rs.getInt(8), rs.getDouble(9), null, rs.getString(10), null);
                if (hdct.getTrangThai().equalsIgnoreCase("Chờ thanh toán")) {
                    listHDCT.add(hdct);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return listHDCT;
    }

    public int themTT(String maTT) {
        int result = 0;
        try {
            sql = "insert into ThanhToan(MaThanhToan,HinhThucThanhToan,TongTienThanhToan,NgayTao,TrangThai) values(?,?,?,?,?)";
            con = DBConnect.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(1, maTT);
            ps.setObject(2, null);
            ps.setObject(3, null);
            ps.setObject(4, new java.util.Date());
            ps.setObject(5, null);
            result = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            result = 0;
        }
        return result;
    }

    public int UpdateTT(String hingthuctt, double tongtien, String maTT,String trangthai) {
        int result = 0;
        try {
            sql = "update ThanhToan set HinhThucThanhToan=?,TongTienThanhToan=?,NgaySua=?,TrangThai=? where MaThanhToan=?";
            con = DBConnect.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(1, hingthuctt);
            ps.setObject(2, tongtien);
            ps.setObject(3, new java.util.Date());
            ps.setObject(4, trangthai);
            ps.setObject(5, maTT);
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
            sql = "{Call ThemHoaDon2(?,?,?,?,?,?,?)}";
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

    public int UpdateHD(String maKH, String trangThai, String maHD) {
        int result = -1;
        try {
            sql = "update HoaDon set idKhachHang=(select idKhachHang from KhachHang where MaKhachHang=?),TrangThai=? where MaHoaDon=?";
            con = DBConnect.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(1, maKH);
            ps.setObject(2, trangThai);
            ps.setObject(3, maHD);
            result = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            result = 0;
        }
        return result;
    }

    public int CongDonSPCT(int soluong, String maHDCT) {
        int result = -1;
        try {
            sql = "update HoaDonChiTiet set SoLuong=SoLuong+? where MaHoaDonChiTiet=?";
            con = DBConnect.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(1, soluong);
            ps.setObject(2, maHDCT);
            result = ps.executeUpdate();

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

    public int CapNhatSPCTChuaThanhToan(HoaDonChiTiet hdct) {
        int result = -1;
        try {
            sql = "{Call TraLaiSPCTchuaThanhToan(?,?)}";
            con = DBConnect.getConnection();
            cs = con.prepareCall(sql);
            cs.setObject(1, hdct.getSoLuong());
            cs.setObject(2, hdct.getMaSPCT());
            result = cs.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            result = 0;
        }
        return result;
    }

    public int XoaSPtrongGioHang(String maHDCT) {
        int result = -1;
        try {
            sql = "update HoaDonChiTiet set TrangThai=? where MaHoaDonChiTiet=?";
            con = DBConnect.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(1, "Đã hủy");
            ps.setObject(2, maHDCT);
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            result = 0;
        }
        return result;
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

    public int ThanhToanHD(String maHD, String maVoucher, double tongtien) {
        int result = -1;
        try {
            sql = "update HoaDon set idVoucher=(select idVoucher from Voucher where MaVoucher like ?),TongTien=?,TrangThai=? where MaHoaDon=?";
            con = DBConnect.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(1, maVoucher);
            ps.setObject(2, tongtien);
            ps.setObject(3, "Da thanh toan");
            ps.setObject(4, maHD);
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            result = 0;
        }
        return result;
    }

    public int ThanhToanHDCT(String maHDCT) {
        int result = -1;
        try {
            sql = "update HoaDonChiTiet set TrangThai=? where MaHoaDonChiTiet=?";
            con = DBConnect.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(1, "Đã thanh toán");
            ps.setObject(2, maHDCT);
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            result = 0;
        }
        return result;
    }
}
