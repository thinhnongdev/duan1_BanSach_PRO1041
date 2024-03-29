/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.raven.form;

import com.raven.model.HinhAnh;
import com.raven.model.SanPhamCT;
import com.raven.service.SanPhamCTservice;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Admin
 */
public class demodiaalog extends javax.swing.JDialog {

    /**
     * Creates new form demodiaalog
     */
    SanPhamCTservice spctService = new SanPhamCTservice();
    List<SanPhamCT> listimportExcel = null;

    public demodiaalog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        tblChiTietspExcel = new javax.swing.JTable();
        btnImportExcel = new javax.swing.JButton();
        btnSaveExcel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblChiTietspExcel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Sách", "Tên Sách", "Tên Tác Giả", "Tên Thể Loại", "Tên Nhà Cung Cấp", "Tên ảnh", "Tên Nhà Xuất Bản", "Đơn Giá", "Số Lượng", "Mô tả", "Trạng thái"
            }
        ));
        tblChiTietspExcel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChiTietspExcelMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblChiTietspExcel);

        btnImportExcel.setText("Import (Excel)");
        btnImportExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportExcelActionPerformed(evt);
            }
        });

        btnSaveExcel.setText("Save");
        btnSaveExcel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveExcelMouseClicked(evt);
            }
        });
        btnSaveExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnImportExcel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSaveExcel)
                        .addGap(46, 46, 46))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSaveExcel, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(btnImportExcel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblChiTietspExcelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChiTietspExcelMouseClicked
        // TODO add your handling code here:
//        indexSPCT = tblChiTietSP.getSelectedRow();
//        if (indexSPCT >= 0) {
//            String ma = tblChiTietSP.getValueAt(indexSPCT, 1).toString();
//            System.out.println(ma);
//            setFormCTSP(spctService.getSPCT(ma));
//        }
    }//GEN-LAST:event_tblChiTietspExcelMouseClicked

    private void btnImportExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportExcelActionPerformed
        // TODO add your handling code here:
        FileInputStream excelFIS = null;
        BufferedInputStream excelBIS = null;
        XSSFWorkbook excelImportWorkBook = null;
        listimportExcel = new ArrayList<>();
        DefaultTableModel model = (DefaultTableModel) tblChiTietspExcel.getModel();
        model.setRowCount(0);
        String duongdanFileExcel = "D:\\FPT-POLY\\Duan1";
        JFileChooser excelFileChooserImport = new JFileChooser(duongdanFileExcel);
        int excelchooser = excelFileChooserImport.showOpenDialog(null);

        if (excelchooser == JFileChooser.APPROVE_OPTION) {
            try {
                File excelFile = excelFileChooserImport.getSelectedFile();
                excelFIS = new FileInputStream(excelFile);
                excelBIS = new BufferedInputStream(excelFIS);
                excelImportWorkBook = new XSSFWorkbook(excelBIS);
                XSSFSheet excelSheet = excelImportWorkBook.getSheetAt(0);

                for (int i = 1; i < excelSheet.getLastRowNum(); i++) {
                    XSSFRow excelRow = excelSheet.getRow(i);

                    XSSFCell cell2 = excelRow.getCell(1);
                    XSSFCell cell3 = excelRow.getCell(2);
                    XSSFCell cell4 = excelRow.getCell(3);
                    XSSFCell cell5 = excelRow.getCell(4);
                    XSSFCell cell6 = excelRow.getCell(5);
                    XSSFCell cell7 = excelRow.getCell(6);
                    XSSFCell cell8 = excelRow.getCell(7);
                    XSSFCell cell9 = excelRow.getCell(8);
                    XSSFCell cell10 = excelRow.getCell(9);
                    XSSFCell cell11 = excelRow.getCell(10);
                    XSSFCell cell12 = excelRow.getCell(11);
                    double soluongformat = cell10.getNumericCellValue();
                    int soluong = (int) soluongformat;
                    String maSPCT = "SCT" + new Random().nextInt(10000);
                    for (SanPhamCT sp : spctService.getAll2()) {
                        if (sp.getMasachchitiet().equalsIgnoreCase(maSPCT)) {
                            maSPCT = "SCT" + new Random().nextInt(10000);
                        }
                    }
                    model.addRow(new Object[]{i, cell2, cell3, cell4, cell5, cell6, cell7, cell8, cell9, cell10, cell11, cell12});
                    SanPhamCT sp = new SanPhamCT(cell2.toString(), maSPCT, cell3.toString(), cell4.toString(), cell5.toString(), cell6.toString(), cell7.toString(), cell8.toString(), Double.parseDouble(cell9.toString()), soluong, new java.util.Date(), cell12.toString(), null, cell11.toString());
                    listimportExcel.add(sp);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnImportExcelActionPerformed

    private void btnSaveExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveExcelActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnSaveExcelActionPerformed

    private void btnSaveExcelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveExcelMouseClicked
        // TODO add your handling code here:
        if (tblChiTietspExcel.getRowCount() > 0) {

            for (int i = 0; i < listimportExcel.size(); i++) {
                spctService.ThemSPCT(listimportExcel.get(i));

                System.out.println(listimportExcel.get(i).getMasach());
                System.out.println(listimportExcel.get(i).getMasachchitiet());
                System.out.println(listimportExcel.get(i).getTensach());
                System.out.println(listimportExcel.get(i).getTentacgia());
                System.out.println(listimportExcel.get(i).getTentheloai());
                System.out.println(listimportExcel.get(i).getTennhacungcap());
                System.out.println(listimportExcel.get(i).getTenanh());
                System.out.println(listimportExcel.get(i).getTennhaxuatban());
                System.out.println(listimportExcel.get(i).getDongia());
                System.out.println(listimportExcel.get(i).getSoluong());
                System.out.println(listimportExcel.get(i).getNgaytao());
                System.out.println(listimportExcel.get(i).getTrangthai());
                System.out.println(listimportExcel.get(i).getNgaysua());
                System.out.println(listimportExcel.get(i).getMota());

            }
        }

        JOptionPane.showMessageDialog(this, "Import file thành công");
        this.dispose();
    }//GEN-LAST:event_btnSaveExcelMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(demodiaalog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(demodiaalog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(demodiaalog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(demodiaalog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                demodiaalog dialog = new demodiaalog(new javax.swing.JFrame(), true);
                dialog.addWindowFocusListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImportExcel;
    private javax.swing.JButton btnSaveExcel;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblChiTietspExcel;
    // End of variables declaration//GEN-END:variables
}
