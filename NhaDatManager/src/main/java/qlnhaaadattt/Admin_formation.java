/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package qlnhaaadattt;

import TienVN.org.com.dao.ConnectionDB;
import TienVN.org.com.model.ChoSoHuu;
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
 * @author PC
 */
public class Admin_formation extends javax.swing.JFrame {

    /**
     * Creates new form Admin_formation
     */
    DefaultTableModel model;
    ArrayList<ChoSoHuu> qlchusohuu = new ArrayList<>();
    private int row;
    public Admin_formation() {
        initComponents();
        ShowProfile();
    }
    
    public void ShowProfile() {
        String[] arr = {
            "STT","Ten Chủ", "Số Thửa", "Diện Tích","Giá bán(triệu đồng) ", "Người bán", "Ngày sở hữu"
        };
        model = new DefaultTableModel(arr, 0);

        Connection conn = ConnectionDB.conn();
        String sql = "SELECT chusohuu.TenChuSoHuu, thongtindat.SoThua, thongtindat.DienTich, thongtindat.GiaBan, thongtindat.NhanVienBan, chusohuu.NgaySoHuu\n" +
                        "FROM chusohuu\n" +
                        "RIGHT JOIN thongtindat ON chusohuu.SoThua = thongtindat.SoThua\n" +
                        "WHERE MONTH(chusohuu.NgaySoHuu) = MONTH(CURDATE())\n" +
                        "AND YEAR(chusohuu.NgaySoHuu) = YEAR(CURDATE())";
        Statement st = null;
        double totalSalePrice = 0;
        try {
            st = (Statement) conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            int STT = 0;
            while (rs.next()) {
                Vector<String> vc = new Vector<>();
                STT++;
                vc.add(String.valueOf(STT));
                if(rs.getString(1) != null){
                    vc.add(rs.getString(1));
                    vc.add(rs.getString(2));
                    vc.add(rs.getString(3));      
                    vc.add(rs.getString(4));
                    vc.add(rs.getString(5));
                    vc.add(rs.getString(6));
                    double salePrice = Double.parseDouble(rs.getString(4));
                    totalSalePrice += salePrice;
                    
                }    
                model.addRow(vc);
            }
            tbl_thongtin.setModel(model);
            
            Vector<String> totalRow = new Vector<>();
            totalRow.add(""); 
            totalRow.add(""); 
            totalRow.add("");
            totalRow.add("Tổng giá bán:"); // Label for total sale price
            totalRow.add(String.valueOf(totalSalePrice)); // Display the total sale price
            totalRow.add("(triệu đồng)");
            model.addRow(totalRow);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void ShowProfileSearch() {
    String tenSearch1 = txtTim.getText();
    String tenSearch2 = txtTim1.getText();
    if (tenSearch1.length() == 0  && tenSearch2.length()==0  ) {
        ShowProfile();
    } else {
        String[] arr = {
            "STT", "Ten Chủ", "Số Thửa", "Diện Tích", "Giá bán(triệu đồng) ", "Người bán", "Ngày sở hữu"
        };
        model = new DefaultTableModel(arr, 0);

        Connection conn = ConnectionDB.conn();
        String sql = "SELECT chusohuu.TenChuSoHuu, thongtindat.SoThua, thongtindat.DienTich, thongtindat.GiaBan, thongtindat.NhanVienBan, chusohuu.NgaySoHuu "
            + "FROM chusohuu "
            + "RIGHT JOIN thongtindat ON chusohuu.SoThua = thongtindat.SoThua "
            + "WHERE chusohuu.NgaySoHuu >= '" + tenSearch1 + "' and chusohuu.NgaySoHuu <= '" + tenSearch2 + "'";
        Statement st = null;
        double totalSalePrice = 0;
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            int STT = 0;
            while (rs.next()) {
                Vector<String> vc = new Vector<>();
                STT++;
                vc.add(String.valueOf(STT));
                if (rs.getString(1) != null) {
                    vc.add(rs.getString(1));
                    vc.add(rs.getString(2));
                    vc.add(rs.getString(3));
                    vc.add(rs.getString(4));
                    vc.add(rs.getString(5));
                    vc.add(rs.getString(6));
                    double salePrice = Double.parseDouble(rs.getString(4));
                    totalSalePrice += salePrice;
                }
                model.addRow(vc);
            }
            tbl_thongtin.setModel(model);

            Vector<String> totalRow = new Vector<>();
            totalRow.add("");
            totalRow.add("");
            totalRow.add("");
            totalRow.add("Tổng giá bán:"); // Label for total sale price
            totalRow.add(String.valueOf(totalSalePrice)); // Display the total sale price
            totalRow.add("(triệu đồng)");
            model.addRow(totalRow);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
        tableHachToan = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        lblHoachToan = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_thongtin = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        txtTim = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnTim = new javax.swing.JButton();
        txtTim1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        tableHachToan.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tableHachToan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã giao dịch", "Loại giao dịch", "Nhân viên", "Ngày giao dịch", "Số tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableHachToan.setEnabled(false);
        jScrollPane1.setViewportView(tableHachToan);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setForeground(new java.awt.Color(102, 102, 102));

        lblHoachToan.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblHoachToan.setForeground(new java.awt.Color(255, 255, 255));
        lblHoachToan.setText("Thống kê");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(284, 284, 284)
                .addComponent(lblHoachToan)
                .addContainerGap(376, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHoachToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbl_thongtin.setBackground(new java.awt.Color(204, 204, 255));
        tbl_thongtin.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tbl_thongtin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Tên Chủ", "Số Thửa", "Diện Tích", "Tiền Thuế", "Tình Trạng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_thongtin.setEnabled(false);
        jScrollPane2.setViewportView(tbl_thongtin);

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setText("Đóng");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Doanh thu từ :");

        btnTim.setBackground(new java.awt.Color(51, 255, 255));
        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        jLabel2.setText("đến");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtTim1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnTim)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(29, 29, 29))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(txtTim1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTim)
                            .addComponent(jLabel2))))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
        ShowProfileSearch();
    }//GEN-LAST:event_btnTimActionPerformed

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
            java.util.logging.Logger.getLogger(Admin_formation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_formation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_formation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_formation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_formation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTim;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblHoachToan;
    private javax.swing.JTable tableHachToan;
    private javax.swing.JTable tbl_thongtin;
    private javax.swing.JTextField txtTim;
    private javax.swing.JTextField txtTim1;
    // End of variables declaration//GEN-END:variables
}
