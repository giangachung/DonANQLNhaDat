/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TienVN.org.com.dao;

import TienVN.org.com.model.ChoSoHuu;
import TienVN.org.com.model.YeuCauKhachHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Laptop Thang Long
 */
public class YeuCauKhachHangDAO {
    public int add(YeuCauKhachHang a) {
        Connection cn =null;
        PreparedStatement check  =null;

        PreparedStatement pst  =null;
        try {

            String check1= "SELECT * FROM yeucaukh WHERE maphieu=?";
            cn = ConnectionDB.conn();
            PreparedStatement p = cn.prepareStatement(check1);
            p.setInt(1, a.getMaPhieu());
            ResultSet resultSet = p.executeQuery();
            if (resultSet.next()) {
                return 0;
            } else {
                try {
                    String sql1 = "INSERT INTO yeucaukh(yeucau, dientich, huongdat, khanang, lienhe) VALUES(?,?,?,?,?)";
                    pst = cn.prepareStatement(sql1, PreparedStatement.RETURN_GENERATED_KEYS);
                    //pst = cn.prepareStatement(sql1);

                   // pst.setString(1, String.valueOf(a.getMaPhieu()));
                    pst.setString(1,a.getYeuCau());
                    pst.setInt(2,a.getDienTich());
                    pst.setString(3,a.getHuongDat());
                    pst.setString(4,a.getKhaNang());
                    pst.setString(5,a.getLienHe());
                    
                     int affectedRows = pst.executeUpdate();
                    if (affectedRows > 0) {
                        ResultSet generatedKeys = pst.getGeneratedKeys();
                        if (generatedKeys.next()) {
                            int maphieu = generatedKeys.getInt(1);
                            System.out.println("Thêm tài khoản thành công. ID mới: " + maphieu);
                            return 1; // Trả về 1 để biểu thị thêm thành công
                        }
                    }
                }catch(Exception e) {
                    e.printStackTrace();
                }
            }

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pst.close();
            }catch(Exception e) {

            }
        }
        return -1;
    }
    
    public int delete(YeuCauKhachHang a) {
        PreparedStatement pst = null;
        Connection cn = null;
        try {
            String sql = "DELETE FROM yeucaukh WHERE maphieu=?";

            cn = ConnectionDB.conn();
            pst = cn.prepareStatement(sql);

            pst.setString(1, String.valueOf(a.getMaPhieu()));
            if (pst.executeUpdate() > 0) {
                return 1;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
