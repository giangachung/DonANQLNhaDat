/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package qlnhaaadattt;

import TienVN.org.com.dao.ChuSoHuuDAO;
import TienVN.org.com.dao.ConnectionDB;
import TienVN.org.com.dao.NguoiDungDAO;
import TienVN.org.com.dao.ThongTinDatDAO;
import TienVN.org.com.model.ChoSoHuu;
import TienVN.org.com.model.NguoiDung;
import TienVN.org.com.model.ThongTinDat;
import java.awt.GridLayout;
import java.awt.Label;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
//import java.util.Set;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class DatManagerrr extends javax.swing.JFrame {

    /**
     * Creates new form DatManagerrr
     */
    DefaultTableModel model;
     ArrayList<ThongTinDat> qldat = new ArrayList<>();
     private int row;
    public DatManagerrr() {
        initComponents();
        ShowProfile();
    }

    public void ShowProfile() {
        String[] arr = {
                "số thửa", "diện tích", "mã loại", "địa chỉ","sổ đỏ", "giá bán", "nhanvienban","sdt","mô tả"
        };
        model = new DefaultTableModel(arr, 0);


        Connection conn =ConnectionDB.conn();
        String sql = "SELECT * FROM thongtindat";
        Statement st = null;
        try {
            st = (Statement) conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                Vector<String> vc = new Vector<>();
                vc.add(rs.getString(1));
                vc.add(rs.getString(2));
                vc.add(rs.getString(3));
                vc.add(rs.getString(4));
                 vc.add(rs.getString(5));
                 vc.add(rs.getString(6));
                 vc.add(rs.getString(7));
                 vc.add(rs.getString(8));
                 vc.add(rs.getString(9));
                       
                ThongTinDat a=new ThongTinDat();
            a.setSoThua(rs.getInt("sothua"));
            a.setDienTich(rs.getFloat("dientich"));
            a.setMaLoai(rs.getInt("maloai"));
            a.setGiapRanh(rs.getString("giapranh"));
            a.setSoDo(rs.getString("sodo"));
            a.setGiaBan(rs.getFloat("giaban"));
            a.setNhanVienBan(rs.getString("nhanvienban"));
            a.setsDT(rs.getString("sdt"));
            a.setMoTa(rs.getString("mota"));
                
            qldat.add(a);

                model.addRow(vc);
            }
            tblDat.setModel(model);
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }
    public void ShowProfileSearch() {
        String dienTich=txtSearch.getText();
        if(dienTich.length()==0){
           ShowProfile();
        }else{
            String[] arr = {
                "số thửa", "diện tích", "mã loại", "địa chỉ","sổ đỏ","giá bán", "nhân viên ban","sdt","Mô tả"
        };
        model = new DefaultTableModel(arr, 0);


        Connection conn =ConnectionDB.conn();
        String sql = "SELECT * FROM thongtindat where dientich = " +Float.parseFloat(dienTich);
        Statement st = null;
        try {
            st = (Statement) conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                Vector<String> vc = new Vector<>();
                vc.add(rs.getString(1));
                vc.add(rs.getString(2));
                vc.add(rs.getString(3));
                vc.add(rs.getString(4));
                vc.add(rs.getString(5));
                vc.add(rs.getString(6));
                vc.add(rs.getString(7));
                vc.add(rs.getString(8));
                vc.add(rs.getString(9));

                model.addRow(vc);
            }
            tblDat.setModel(model);
             if(tblDat.getRowCount()==0){
              JOptionPane.showMessageDialog(rootPane, "khong tim thay!!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        }
       
    }
    public void AddDat(ThongTinDat x){
         qldat.add(x);
         ShowProfile();
     }
    public void UpdateDat(ThongTinDat x){
        qldat.remove(row);
        qldat.add(x);
        ShowProfile();
    }
     public void Del(ThongTinDat x){
        qldat.remove(row);
        ShowProfile();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbbDat = new javax.swing.JComboBox<>();
        txtDienTich = new javax.swing.JTextField();
        txtSoThua = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDat = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtGiapRanh = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        cbbSoDo = new javax.swing.JComboBox<>();
        btChitiet = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("                                         Quản Lý Đất");
        jLabel1.setOpaque(true);

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 2, 14)); // NOI18N
        jLabel7.setText("Sổ đỏ");

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 2, 14)); // NOI18N
        jLabel6.setText("Giáp ranh");

        cbbDat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "dat tho cu", "dat ruong", "dat thanh thi" }));

        txtSoThua.setEditable(false);
        txtSoThua.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 2, 14)); // NOI18N
        jLabel4.setText("Diện tích");

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 2, 14)); // NOI18N
        jLabel3.setText("Loại đất");

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 2, 14)); // NOI18N
        jLabel2.setText("Số thửa");

        tblDat.setBackground(new java.awt.Color(204, 204, 255));
        tblDat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "So thua", "Dien tich", "Ma dat", "giap ranh", "so do"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Float.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblDat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblDatMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblDat);

        jButton1.setBackground(new java.awt.Color(255, 255, 0));
        jButton1.setText("Thêm");
        jButton1.setOpaque(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 255, 51));
        jButton2.setText("Sửa");
        jButton2.setOpaque(true);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 0, 0));
        jButton3.setText("Thoát");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 51, 51));
        jButton5.setText("Xóa");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 2, 18)); // NOI18N
        jLabel5.setText("Chức năng chính: ");

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 2, 14)); // NOI18N
        jLabel8.setText("Tìm theo diện tích");

        jButton4.setBackground(new java.awt.Color(51, 255, 255));
        jButton4.setText("Tìm");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        cbbSoDo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "da co", "chua co" }));
        cbbSoDo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbSoDoActionPerformed(evt);
            }
        });

        btChitiet.setBackground(new java.awt.Color(204, 255, 204));
        btChitiet.setText("Chi tiết");
        btChitiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btChitietActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(24, 24, 24)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2))
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbbDat, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtSoThua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                        .addComponent(txtDienTich, javax.swing.GroupLayout.Alignment.TRAILING)))
                                .addGap(72, 72, 72)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(28, 28, 28)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbbSoDo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtGiapRanh, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(34, 34, 34)
                        .addComponent(jButton2)
                        .addGap(39, 39, 39)
                        .addComponent(jButton5)
                        .addGap(71, 71, 71)
                        .addComponent(btChitiet)
                        .addGap(115, 115, 115)
                        .addComponent(jButton3)
                        .addContainerGap(190, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSoThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtGiapRanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDienTich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(cbbSoDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbbDat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton5)
                    .addComponent(jButton3)
                    .addComponent(btChitiet))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jButton4))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
              AddDatFram themPT = new AddDatFram(this,
                rootPaneCheckingEnabled);
          themPT.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        String soThua = txtSoThua.getText();
        String dienTich = txtDienTich.getText();
        String tenDat  = cbbDat.getSelectedItem().toString();
        String giapRanh = txtGiapRanh.getText();
        String soDo = cbbSoDo.getSelectedItem().toString();
       

        int maDat;
        if(tenDat.equals("dat tho cu")){
            maDat=01;
        }else if(tenDat.equals("dat ruong")){
            maDat=02;
        }else {
            maDat=03;
        }


        if (soThua.equals("") || dienTich.equals("") || tenDat.equals("")
                || giapRanh.equals("") ||  soDo.equals("")) {
            Label lbErr = new Label();
            lbErr.setText("*Khong duoc de trong");
        } else {
            ThongTinDatDAO dao = new ThongTinDatDAO();
            ThongTinDat x = new ThongTinDat(Integer.parseInt(soThua) 
                    ,Float.parseFloat(dienTich) , maDat,giapRanh,soDo);
//
            if (dao.update(x) == 1) {
                
                  UpdateDat(x);
                JOptionPane a = new JOptionPane("Sua thanh cong");
                JOptionPane.showMessageDialog(rootPane, "sua thanh cong!!");
        
               // jOptionPane1.showMessageDialog(null, "Sửa hồ sơ thành công!", "Success", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane a = new JOptionPane("Sua ho so that bai");
               // jOptionPane1.showMessageDialog(null, "Sua hồ sơ thất bại!", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        ShowProfile();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tblDatMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDatMousePressed
        // TODO add your handling code here:
          row = tblDat.getSelectedRow();
        String soThua = tblDat.getModel().getValueAt(row, 0).toString();
        String dienTich = tblDat.getModel().getValueAt(row, 1).toString();
        String maDat = tblDat.getModel().getValueAt(row, 2).toString();
        String giapRanh = tblDat.getModel().getValueAt(row, 3).toString();
        String soDo = tblDat.getModel().getValueAt(row, 4).toString();
        
        txtSoThua.setText(soThua);
        txtDienTich.setText(dienTich);
        txtGiapRanh.setText(giapRanh);
        cbbSoDo.setSelectedItem(soDo);
    }//GEN-LAST:event_tblDatMousePressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
           int option = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa không?", "Xóa", JOptionPane.YES_NO_OPTION);
        
        if (option == JOptionPane.YES_OPTION) {
            // Thực hiện xóa
             ThongTinDatDAO dao = new ThongTinDatDAO();
                 String soThua = txtSoThua.getText();
      

        ThongTinDat x = new ThongTinDat(Integer.parseInt(soThua));
        JOptionPane jOptionPane1 = new JOptionPane();
        if (dao.delete(x) == -1) {
            Del(x);
             txtSoThua.setText("");
        txtDienTich.setText("");
        txtGiapRanh.setText("");
      //  cbbSoDo.setSelectedItem(soDo);
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
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:  
        ShowProfileSearch();
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void cbbSoDoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbSoDoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbSoDoActionPerformed

    private void btChitietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btChitietActionPerformed
        // TODO add your handling code here:
          row = tblDat.getSelectedRow();
        String soThua = tblDat.getModel().getValueAt(row, 0).toString();
        String dienTich = tblDat.getModel().getValueAt(row, 1).toString();
        String maDat = tblDat.getModel().getValueAt(row, 2).toString();
        String giapRanh = tblDat.getModel().getValueAt(row, 3).toString();
        String soDo = tblDat.getModel().getValueAt(row, 4).toString();
        String giaBan = tblDat.getModel().getValueAt(row, 5).toString();
         String nhanVienBan = tblDat.getModel().getValueAt(row, 6).toString();
          String sDT = tblDat.getModel().getValueAt(row, 7).toString();
           String moTa = tblDat.getModel().getValueAt(row, 8).toString();
//        int maLoaiDat;
//        if(maDat.equals("1")){
//           cbbDat.setName("dat tho cu");
//        }else if(maDat.equals("2")){
//           cbbDat.setName("dat ruong");
//        }else{
//           cbbDat.setName("dat thanh thi");
//        }
        ShowDat newForm = new ShowDat();
        newForm.displayInformation(soThua, dienTich,maDat, giapRanh, soDo, giaBan, nhanVienBan,sDT, moTa);
        newForm.setVisible(true);
     
    }//GEN-LAST:event_btChitietActionPerformed

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
            java.util.logging.Logger.getLogger(DatManagerrr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DatManagerrr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DatManagerrr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DatManagerrr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DatManagerrr().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btChitiet;
    private javax.swing.JComboBox<String> cbbDat;
    private javax.swing.JComboBox<String> cbbSoDo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDat;
    private javax.swing.JTextField txtDienTich;
    private javax.swing.JTextField txtGiapRanh;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSoThua;
    // End of variables declaration//GEN-END:variables
}