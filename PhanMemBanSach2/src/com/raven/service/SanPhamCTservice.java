/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.service;

import com.raven.model.HinhAnh;
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
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = "";
    List<SanPhamCT> list;
    List<SanPhamCT> list2;

    public List<SanPhamCT> getAll(String masach) {
        list = new ArrayList<>();
        try {
            sql = "{call getSPCTtheoMaSach(?)}";
            con = DBConnect.getConnection();
            cs = con.prepareCall(sql);
            cs.setObject(1, masach);
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

    public List<SanPhamCT> getAll2() {
        list = new ArrayList<>();
        try {
            sql = "{call SelectAllSachCT}";
            con = DBConnect.getConnection();
            cs = con.prepareCall(sql);
            rs = cs.executeQuery();
            while (rs.next()) {
                SanPhamCT spct = new SanPhamCT(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getDouble(9), rs.getInt(10), rs.getDate(11), rs.getString(12), rs.getDate(13), rs.getString(14));
                if (spct.getTrangthai().equalsIgnoreCase("Hoạt động")) {
                    list.add(spct);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }

    public SanPhamCT getSPCT(String maCTSP) {
        list2 = new ArrayList<>();
        try {
            sql = "{call getSPCTtheoMaSachCT(?)}";
            con = DBConnect.getConnection();
            cs = con.prepareCall(sql);
            cs.setObject(1, maCTSP);
            rs = cs.executeQuery();
            while (rs.next()) {
                SanPhamCT spct = new SanPhamCT(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getDouble(9), rs.getInt(10), rs.getDate(11), rs.getString(12), rs.getDate(13), rs.getString(14));
                if (spct.getTrangthai().equalsIgnoreCase("Hoạt động")) {
                    list2.add(spct);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return list2.get(0);
    }

    public List<SanPhamCT> TimKiemCTSP(String thongtintim) {
        list = new ArrayList<>();
        try {
            sql = "{call TimKiemCTSP(?)}";
            con = DBConnect.getConnection();
            cs = con.prepareCall(sql);
            cs.setObject(1, "%" + thongtintim + "%");
            rs = cs.executeQuery();
            while (rs.next()) {
                SanPhamCT spct = new SanPhamCT(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getDouble(9), rs.getInt(10), rs.getDate(11), rs.getString(12), rs.getDate(13), rs.getString(14));
                if (spct.getTrangthai().equalsIgnoreCase("Hoạt động")) {
                    list.add(spct);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }

    public List<SanPhamCT> LocSanPhamCT(String loai, String NXB, String tacgia) {
        list = new ArrayList<>();
        try {
            sql = "{Call LocSanPhamCT(?,?,?)}";
            con = DBConnect.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(1, loai);
            ps.setObject(2, NXB);
            ps.setObject(3, tacgia);
            rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamCT spct = new SanPhamCT(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getDouble(9), rs.getInt(10), rs.getDate(11), rs.getString(12), rs.getDate(13), rs.getString(14));
                if (spct.getTrangthai().equalsIgnoreCase("Hoạt động")) {
                    list.add(spct);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }

    public int ThemSPCT(SanPhamCT sp) {
        int result = -1;
        try {
            sql = "{Call ThemSanPhamCT(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
            con = DBConnect.getConnection();
            cs = con.prepareCall(sql);
            cs.setObject(1, sp.getTenanh());
            cs.setObject(2, sp.getTensach());
            cs.setObject(3, sp.getTennhacungcap());
            cs.setObject(4, sp.getTentacgia());
            cs.setObject(5, sp.getTentheloai());
            cs.setObject(6, sp.getTennhaxuatban());
            cs.setObject(7, sp.getMasachchitiet());
            cs.setObject(8, sp.getDongia());
            cs.setInt(9, sp.getSoluong());
            cs.setObject(10, sp.getNgaytao());
            cs.setObject(11, sp.getTrangthai());
            cs.setObject(12, sp.getNgaysua());
            cs.setObject(13, sp.getMota());
            System.out.println(sp.getMasachchitiet());
            result = cs.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            result = -1;
        }
        return result;
    }

    public void ImportExcel(SanPhamCT sp) {

        int result = -1;
        try {
            sql = "{Call ThemSanPhamCT(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
            con = DBConnect.getConnection();
            cs = con.prepareCall(sql);
            cs.setObject(1, sp.getTenanh());
            cs.setObject(2, sp.getTensach());
            cs.setObject(3, sp.getTennhacungcap());
            cs.setObject(4, sp.getTentacgia());
            cs.setObject(5, sp.getTentheloai());
            cs.setObject(6, sp.getTennhaxuatban());
            cs.setObject(7, sp.getMasachchitiet());
            cs.setObject(8, sp.getDongia());
            cs.setInt(9, sp.getSoluong());
            cs.setObject(10, sp.getNgaytao());
            cs.setObject(11, sp.getTrangthai());
            cs.setObject(12, sp.getNgaysua());
            cs.setObject(13, sp.getMota());
            result = cs.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            result = -1;
        }
    }

    public int updateSPCT(SanPhamCT sp, String ma) {
        int result = -1;
        try {
            sql = "{Call SuaSanPhamCT(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
            con = DBConnect.getConnection();
            cs = con.prepareCall(sql);
            cs.setObject(1, sp.getTenanh());
            cs.setObject(2, sp.getTensach());
            cs.setObject(3, sp.getTennhacungcap());
            cs.setObject(4, sp.getTentacgia());
            cs.setObject(5, sp.getTentheloai());
            cs.setObject(6, sp.getTennhaxuatban());
            cs.setObject(7, ma);
            cs.setObject(8, sp.getDongia());
            cs.setInt(9, sp.getSoluong());
            cs.setObject(10, sp.getNgaytao());
            cs.setObject(11, sp.getTrangthai());
            cs.setObject(12, sp.getNgaysua());
            cs.setObject(13, sp.getMota());
            result = cs.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            result = -1;
        }
        return result;
    }

    public int DeleteSPCT(String maspct, String trangthai) {
        int result = 0;
        try {
            sql = "update SachChiTiet set TrangThai=? where MaSachChiTiet=?";
            con = DBConnect.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(1, trangthai);
            ps.setObject(2, maspct);
            result = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            result = 0;
        }
        return result;
    }

    public int CapNhatSoLuongSP(int soluong, String maspct) {
        int result = 0;
        try {
            sql = "update SachChiTiet set SoLuong=? where MaSachChiTiet=?";
            con = DBConnect.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(1, soluong);
            ps.setObject(2, maspct);
            result = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            result = 0;
        }
        return result;
    }

}
