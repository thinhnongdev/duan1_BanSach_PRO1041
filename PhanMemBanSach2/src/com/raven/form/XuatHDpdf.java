/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.raven.form;

import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import static com.itextpdf.kernel.pdf.PdfName.BaseFont;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.raven.service.QLHoaDonService;
import com.raven.utils.GetMaSanPham;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XuatHDpdf {

    public static void main(String[] args) throws FileNotFoundException {
        // Tạo đối tượng tài liệu
        QLHoaDonService qlservice = new QLHoaDonService();
        String path = "Hoadon.pdf";
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfdocument = new PdfDocument(pdfWriter);
        pdfdocument.setDefaultPageSize(PageSize.A4);
        Document document = new Document(pdfdocument);
        float threecol = 190f;
        float twocol = 280f;
        float twocol150 = twocol + 150f;
        float twocolumWidth[] = {twocol150, twocol};
        float fullwidth[] = {threecol * 3};
        float collWidth[] = {150, 250, 150, 250};
        float iteminfoColWidth[] = {140, 140, 140, 140};
        float totalAmount[] = {500, 150, 200};
        float columfooter[] = {450, 450};
        Table table = new Table(twocolumWidth);

        //header 
        long millis = System.currentTimeMillis();
        java.util.Date datenow = new java.util.Date(millis);
        table.addCell(new Cell().add(new Paragraph("Hoa don").setBold().setFontSize(30f)).setBorder(Border.NO_BORDER));
        Table nestedtable = new Table(new float[]{twocol / 2, twocol / 2});
        nestedtable.addCell(new Cell().add(new Paragraph("Ma hoa don:").setBold()).setBorder(Border.NO_BORDER));
        nestedtable.addCell(new Cell().add(new Paragraph(qlservice.TimThongtincthd(GetMaSanPham.maHDpdf).getMaHoaDon())).setBorder(Border.NO_BORDER));
        nestedtable.addCell(new Cell().add(new Paragraph("Ngay lap:").setBold()).setBorder(Border.NO_BORDER));
        nestedtable.addCell(new Cell().add(new Paragraph(String.valueOf(datenow))).setBorder(Border.NO_BORDER));
        table.addCell(new Cell().add(nestedtable).setBorder(Border.NO_BORDER));
        //line phân cách
        Border bd = new SolidBorder(1f / 2f);
        Table divider = new Table(fullwidth);
        divider.setBorder(bd);
        //body.khachhang

        Table customerInfoTable = new Table(collWidth);
        customerInfoTable.addCell(new Cell(0, 4).add(new Paragraph("Thong tin khach hang")).setBold().setBorder(Border.NO_BORDER));
        customerInfoTable.addCell(new Cell().add(new Paragraph("Ten khach hang:")).setBorder(Border.NO_BORDER));
        customerInfoTable.addCell(new Cell().add(new Paragraph(qlservice.TimThongtincthd(GetMaSanPham.maHDpdf).getTenKH())).setBorder(Border.NO_BORDER));
        customerInfoTable.addCell(new Cell().add(new Paragraph("So dien thoai:")).setBorder(Border.NO_BORDER));
        customerInfoTable.addCell(new Cell().add(new Paragraph(qlservice.TimThongtincthd(GetMaSanPham.maHDpdf).getSDT())).setBorder(Border.NO_BORDER));
        customerInfoTable.addCell(new Cell().add(new Paragraph("Dia chi:")).setBorder(Border.NO_BORDER));
        customerInfoTable.addCell(new Cell().add(new Paragraph(qlservice.TimThongtincthd(GetMaSanPham.maHDpdf).getDiaChi())).setBorder(Border.NO_BORDER));
        customerInfoTable.addCell(new Cell().add(new Paragraph("Ngay thanh toan:")).setBorder(Border.NO_BORDER));
        customerInfoTable.addCell(new Cell().add(new Paragraph(qlservice.TimThongtincthd(GetMaSanPham.maHDpdf).getNgayThanhToan().toString())).setBorder(Border.NO_BORDER));
        //body.sanpham
        Table itemInfoTable = new Table(iteminfoColWidth);
        itemInfoTable.addCell(new Cell().add(new Paragraph("San pham")).setTextAlignment(TextAlignment.CENTER).setBackgroundColor(new DeviceRgb(Color.BLACK)).setFontColor(new DeviceRgb(Color.WHITE)));
        itemInfoTable.addCell(new Cell().add(new Paragraph("So luong")).setTextAlignment(TextAlignment.CENTER).setBackgroundColor(new DeviceRgb(Color.BLACK)).setFontColor(new DeviceRgb(Color.WHITE)));
        itemInfoTable.addCell(new Cell().add(new Paragraph("Don gia")).setTextAlignment(TextAlignment.CENTER).setBackgroundColor(new DeviceRgb(Color.BLACK)).setFontColor(new DeviceRgb(Color.WHITE)));
        itemInfoTable.addCell(new Cell().add(new Paragraph("Thanh tien")).setTextAlignment(TextAlignment.CENTER).setBackgroundColor(new DeviceRgb(Color.BLACK)).setFontColor(new DeviceRgb(Color.WHITE)));

        for (int i = 0; i < qlservice.getSPCT(GetMaSanPham.maHDpdf).size(); i++) {
            itemInfoTable.addCell(new Cell().add(new Paragraph(qlservice.getSPCT(GetMaSanPham.maHDpdf).get(i).getTensach())).setTextAlignment(TextAlignment.CENTER));
            itemInfoTable.addCell(new Cell().add(new Paragraph(String.valueOf(qlservice.getSPCT(GetMaSanPham.maHDpdf).get(i).getSoluong()))).setTextAlignment(TextAlignment.CENTER));
            itemInfoTable.addCell(new Cell().add(new Paragraph(String.valueOf(qlservice.getSPCT(GetMaSanPham.maHDpdf).get(i).getDongia()))).setTextAlignment(TextAlignment.CENTER));
            itemInfoTable.addCell(new Cell().add(new Paragraph(String.valueOf(qlservice.getSPCT(GetMaSanPham.maHDpdf).get(i).getDongia() * qlservice.getSPCT(GetMaSanPham.maHDpdf).get(i).getSoluong()))).setTextAlignment(TextAlignment.CENTER));
        }

        Table totalAmountTable = new Table(totalAmount);
        totalAmountTable.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
        totalAmountTable.addCell(new Cell().add(new Paragraph("Tong tien hang :")).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
        totalAmountTable.addCell(new Cell().add(new Paragraph(String.valueOf(qlservice.TimThongtincthd(GetMaSanPham.maHDpdf).getTongtien()))).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.CENTER));
        totalAmountTable.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
        totalAmountTable.addCell(new Cell().add(new Paragraph("Giam gia :")).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
        totalAmountTable.addCell(new Cell().add(new Paragraph(String.valueOf(qlservice.TimThongtincthd(GetMaSanPham.maHDpdf).getPhanTramGiam() + "%"))).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.CENTER));
        totalAmountTable.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
        totalAmountTable.addCell(new Cell().add(new Paragraph("Thanh toan :")).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
        totalAmountTable.addCell(new Cell().add(new Paragraph(String.valueOf(qlservice.TimThongtincthd(GetMaSanPham.maHDpdf).getTongtientt()))).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.CENTER));

        //footer
        Table footer = new Table(columfooter);
        footer.addCell(new Cell().add(new Paragraph("Cam on và hen gap lai quy khach!")).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.CENTER));
        footer.addCell(new Cell().add(new Paragraph("BOOK DEPOT")).setFontSize(20f).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.CENTER));
        footer.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
        footer.addCell(new Cell().add(new Paragraph("Dc: Toa nha FPT Polytechnic, P. Trinh Van Bo, Xuan Phuong, Nam Tu Liem, Ha Noi")).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.CENTER));

        document.add(table);
        document.add(divider);
        document.add(new Paragraph("\n"));
        document.add(customerInfoTable);
        document.add(new Paragraph("\n"));
        document.add(itemInfoTable);
        document.add(totalAmountTable);
        document.add(new Paragraph("\n"));
        document.add(divider);
        document.add(new Paragraph("\n"));
        document.add(footer);
        document.close();

        String pathhoadon = "D:\\QLDA\\duan1_BanSach_PRO1041\\duan1_BanSach_PRO1041\\HoaDonPDF\\";
        File file = new File(path);
        try {
            Desktop.getDesktop().open(file);

        } catch (IOException ex) {
            Logger.getLogger(XuatHDpdf.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
