/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.form;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import javax.imageio.ImageIO;

public class NewClass {

    public static void main(String[] args) {
        String text = "Hello, world!"; // Nội dung của mã QR
        int width = 300; // Chiều rộng của mã QR
        int height = 300; // Chiều cao của mã QR

        // Tạo mã QR và chuyển đổi thành hình ảnh
        try {
            byte[] qrImageData = generateQRCodeImage(text, width, height);

            // Tạo ImageIcon từ dữ liệu hình ảnh
            ImageIcon qrImageIcon = new ImageIcon(qrImageData);

            // Tạo JLabel để hiển thị mã QR
            JLabel lblQRCode = new JLabel(qrImageIcon);

            // Tạo JFrame và thêm JLabel vào
            JFrame frame = new JFrame();
            frame.getContentPane().add(lblQRCode);
            frame.setSize(width, height);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }
    }

    public static byte[] generateQRCodeImage(String text, int width, int height) throws WriterException, IOException {
        // Tạo mã QR từ văn bản và kích thước được chỉ định
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        Map<EncodeHintType, String> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height, hints);

        // Chuyển đổi BitMatrix thành hình ảnh PNG
        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);

        // Đọc hình ảnh PNG và chuyển đổi thành hình ảnh JPG
        BufferedImage pngImage = ImageIO.read(new ByteArrayInputStream(pngOutputStream.toByteArray()));
        ByteArrayOutputStream jpgOutputStream = new ByteArrayOutputStream();
        ImageIO.write(pngImage, "JPG", jpgOutputStream);

        // Trả về dữ liệu của hình ảnh JPG
        return jpgOutputStream.toByteArray();
    }
}

