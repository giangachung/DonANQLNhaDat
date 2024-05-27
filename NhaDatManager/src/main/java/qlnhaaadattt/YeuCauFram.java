/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package qlnhaaadattt;

import TienVN.org.com.dao.ConnectionDB;
import TienVN.org.com.dao.NguoiDungDAO;
import TienVN.org.com.dao.YeuCauKhachHangDAO;
import TienVN.org.com.model.NguoiDung;
import TienVN.org.com.model.ThongTinDat;
import TienVN.org.com.model.YeuCauKhachHang;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Laptop Thang Long
 */
public class YeuCauFram extends javax.swing.JFrame {

 
    DefaultTableModel model;
     ArrayList<YeuCauKhachHang> yeucau = new ArrayList<>();
     private int row;
    public YeuCauFram() {
        initComponents();
        ShowProfile();
    }
    public void ShowProfile() {
        String[] arr = {
                "mã phiếu", "yêu cầu khách hàng", "diện tích mong muốn", "hướng đất","khả năng túi tiền", "sdt liên hệ"
        };
        model = new DefaultTableModel(arr, 0);


        Connection conn =ConnectionDB.conn();
        String sql = "SELECT * FROM yeucaukh";
        Statement st = null;
        try {
            st = (Statement) conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            //int STT = 0;
            while(rs.next()) {
               // STT++;
                Vector<String> vc = new Vector<>();
                
                //vc.add(String.valueOf(STT));
                vc.add(rs.getString(1));
                vc.add(rs.getString(2));
                vc.add(rs.getString(3));
                vc.add(rs.getString(4));
                 vc.add(rs.getString(5));
                vc.add(rs.getString(6));
                 
                       
            YeuCauKhachHang s =new YeuCauKhachHang();
            s.setMaPhieu(rs.getInt("maphieu"));
            s.setYeuCau(rs.getString("yeucau"));
            s.setDienTich(rs.getInt("dientich"));
            s.setHuongDat(rs.getString("huongdat"));
            s.setKhaNang(rs.getString("khanang"));
            s.setLienHe(rs.getString("lienhe"));
            //qldat.add(s);
            
                model.addRow(vc);
            }
            tbl_yeucau.setModel(model);
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }
    public void Del(YeuCauKhachHang x){
        yeucau.remove(row);
        ShowProfile();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lblHoachToan = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_yeucau = new javax.swing.JTable();
        txtMaPhieu = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setForeground(new java.awt.Color(102, 102, 102));

        lblHoachToan.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblHoachToan.setForeground(new java.awt.Color(255, 255, 255));
        lblHoachToan.setText("Thông tin yêu cầu của khách hàng");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(284, 284, 284)
                .addComponent(lblHoachToan)
                .addContainerGap(159, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHoachToan, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
        );

        jButton7.setBackground(new java.awt.Color(255, 51, 51));
        jButton7.setText("Đóng");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Mã phiếu");
        jLabel1.setDoubleBuffered(true);
        jLabel1.setFocusCycleRoot(true);
        jLabel1.setFocusTraversalPolicyProvider(true);

        tbl_yeucau.setBackground(new java.awt.Color(204, 204, 255));
        tbl_yeucau.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "mã phiếu", "Yêu cầu khách hàng", "Diện tích mong muốn", "Hướng đất", "Khả năng túi tiền", "thông tin liên hệ", "tuenr"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Float.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_yeucau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_yeucauMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_yeucauMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_yeucau);
        if (tbl_yeucau.getColumnModel().getColumnCount() > 0) {
            tbl_yeucau.getColumnModel().getColumn(0).setHeaderValue("mã phiếu");
            tbl_yeucau.getColumnModel().getColumn(1).setHeaderValue("Yêu cầu khách hàng");
            tbl_yeucau.getColumnModel().getColumn(2).setHeaderValue("Diện tích mong muốn");
            tbl_yeucau.getColumnModel().getColumn(3).setHeaderValue("Hướng đất");
            tbl_yeucau.getColumnModel().getColumn(4).setHeaderValue("Khả năng túi tiền");
            tbl_yeucau.getColumnModel().getColumn(5).setHeaderValue("thông tin liên hệ");
            tbl_yeucau.getColumnModel().getColumn(6).setHeaderValue("tuenr");
        }

        txtMaPhieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaPhieuActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(102, 102, 255));
        jButton1.setText("Xóa");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtMaPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton7)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton7)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtMaPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void txtMaPhieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaPhieuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaPhieuActionPerformed

    private void tbl_yeucauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_yeucauMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_yeucauMouseClicked

    private void tbl_yeucauMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_yeucauMousePressed
        // TODO add your handling code here:
        row = tbl_yeucau.getSelectedRow();
        String maphieu = tbl_yeucau.getModel().getValueAt(row, 0).toString();
        
        txtMaPhieu.setText(maphieu);
    }//GEN-LAST:event_tbl_yeucauMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int option = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa không?", "Xóa", JOptionPane.YES_NO_OPTION);
        
        if (option == JOptionPane.YES_OPTION) {
            // Thực hiện xóa
             YeuCauKhachHangDAO dao = new YeuCauKhachHangDAO();
                 String maphieu = txtMaPhieu.getText();
      

        YeuCauKhachHang x = new YeuCauKhachHang(Integer.parseInt(maphieu));
        JOptionPane jOptionPane1 = new JOptionPane();
        if (dao.delete(x) == -1) {
           Del(x);
            JOptionPane.showMessageDialog(rootPane, "xoa thanh cong!!");
            jOptionPane1.showMessageDialog(null, "Xóa hồ sơ thất bại!", "Error", JOptionPane.INFORMATION_MESSAGE);
        } else {
            jOptionPane1.showMessageDialog(null, "Xóa hồ sơ thành công!", "Success", JOptionPane.INFORMATION_MESSAGE);
        }

        ShowProfile();
            System.out.println("Đã xóa!");
        } else {
            // Hủy xóa
            System.out.println("Đã hủy xóa!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(YeuCauFram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(YeuCauFram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(YeuCauFram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(YeuCauFram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new YeuCauFram().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHoachToan;
    private javax.swing.JTable tbl_yeucau;
    private javax.swing.JTextField txtMaPhieu;
    // End of variables declaration//GEN-END:variables
}
