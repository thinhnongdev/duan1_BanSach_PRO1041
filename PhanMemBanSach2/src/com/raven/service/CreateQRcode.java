package com.raven.service;

import java.io.ByteArrayOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.raven.utils.DBConnect;
import java.io.File;

public class CreateQRcode {

    public static void main(String[] args) {
        try {
            Connection conn = DBConnect.getConnection();
            String sql = "SELECT idSachChiTiet,idHinhAnh,idSach,idNhaCungCap,idTacGia,idTheLoai,idNhaXuatBan,MaSachChiTiet,DonGia,SoLuong,NgayTao,TrangThai,NgaySua,Mota FROM SachChiTiet";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                // Lấy dữ liệu từ các cột trong bảng
                int idSachChiTiet = resultSet.getInt("idSachChiTiet");
                String maSachChiTiet = resultSet.getString("MaSachChiTiet");
                int idNhaCungCap = resultSet.getInt("idNhaCungCap");

                String qrData = maSachChiTiet;

                int width = 300;
                int height = 300;
                String format = "png";
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                com.google.zxing.Writer writer = new QRCodeWriter();
                BitMatrix matrix = writer.encode(qrData, BarcodeFormat.QR_CODE, width, height, createQRCodeHints());
                MatrixToImageWriter.writeToStream(matrix, format, baos);
                byte[] qrCodeBytes = baos.toByteArray();

                String filePath = "D:\\QLDA\\duan1_BanSach_PRO1041\\duan1_BanSach_PRO1041\\QRcode\\" + maSachChiTiet + ".jpg";
                ImageIO.write(MatrixToImageWriter.toBufferedImage(matrix), format, new File(filePath));

            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static java.util.Map<EncodeHintType, Object> createQRCodeHints() {
        java.util.Map<EncodeHintType, Object> hints = new java.util.HashMap<>();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        return hints;
    }
}


