/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.raven.form;

import com.raven.model.SanPhamCT;
import com.raven.service.SanPhamCTservice;
import com.raven.service.SanPhamService;
import com.raven.utils.GetMaSanPham;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class SanPhamCTform extends javax.swing.JFrame {

    /**
     * Creates new form SanPhamCTform
     */
    DefaultTableModel model = new DefaultTableModel();
    SanPhamCTservice service = new SanPhamCTservice();
    SanPhamService spsv = new SanPhamService();
    
    public SanPhamCTform() {
        initComponents();
        setLocationRelativeTo(null);
        if (GetMaSanPham.indexSP >= 0) {
            fillTable(service.getAll(GetMaSanPham.maSanPham));
        }
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }
    
    void fillTable(List<SanPhamCT> list) {
        model = (DefaultTableModel) tblSachCT.getModel();
        model.setRowCount(0);
        for (SanPhamCT sp : list) {
            Object[] row = new Object[]{sp.getMasach(), sp.getMasachchitiet(), sp.getTensach(), sp.getTentacgia(), sp.getTentheloai(), sp.getTennhacungcap(), sp.getTenanh(), sp.getTennhaxuatban(), sp.getDongia(), sp.getSoluong(), sp.getNgaytao(), sp.getTrangthai(), sp.getNgaysua()};
            model.addRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblSachCT = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblSachCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Sách", "Mã Sách Chi Tiết", "Tên Sách", "Tên Tác Giả", "Tên Thể Loại", "Tên Nhà Cung Cấp", "Tên ảnh", "Tên Nhà Xuất Bản", "Đơn Giá", "Số Lượng", "Ngày Tạo", "Trạng Thái", "Ngày Sửa"
            }
        ));
        jScrollPane1.setViewportView(tblSachCT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1080, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(SanPhamCTform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SanPhamCTform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SanPhamCTform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SanPhamCTform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SanPhamCTform().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSachCT;
    // End of variables declaration//GEN-END:variables
}
