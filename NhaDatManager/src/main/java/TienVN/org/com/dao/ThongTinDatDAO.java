package TienVN.org.com.dao;

//import TienVN.org.com.model.NguoiDung;
import TienVN.org.com.model.ThongTinDat;
import java.io.File;
import java.io.FileInputStream;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;

public class ThongTinDatDAO {

    
    public int add(ThongTinDat a) {
        Connection cn = null;
        PreparedStatement check = null;


        PreparedStatement pst = null;
        try {

            String check1 = "SELECT * FROM thongtindat WHERE SoThua=?";
            cn = ConnectionDB.conn();
            PreparedStatement p = cn.prepareStatement(check1);
            p.setInt(1, a.getSoThua());
            ResultSet resultSet = p.executeQuery();
            if (resultSet.next()) {
                return 0;
            } else {
                try {
                    String sql1 = "INSERT INTO thongtindat VALUES (?,?,?,?,?,?,?,?,?)";
                    pst = cn.prepareStatement(sql1);

                    pst.setString(1, String.valueOf(a.getSoThua()));
                    pst.setFloat(2, a.getDienTich());
                    pst.setString(3, String.valueOf(a.getMaLoai()));
                    pst.setString(4, a.getGiapRanh());
                    pst.setString(5, a.getSoDo());
                    pst.setFloat(6, a.getGiaBan());
                    pst.setString(7, a.getNhanVienBan());
                    pst.setString(8, a.getsDT());
                    pst.setString(9, a.getMoTa());
                    //pst.setString(10,a.getAnh());

                    int rowsAffected = pst.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Thêm thành công");
                        return 1;
                    }
//                    File imageFile = new File(a.getAnh());
//                    FileInputStream inputStream = new FileInputStream(imageFile);
//                    pst.setBinaryStream(10, inputStream, (int) imageFile.length());
//                    
//                    pst.executeUpdate();
//                    if (pst.executeUpdate() > 0) {
//                        System.out.println("add thanh cong");
//                        return 1;
//                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pst.close();
            } catch (Exception e) {

            }
        }


        return -1;
    }

    public int delete(ThongTinDat a) {
        PreparedStatement pst = null;
        Connection cn = null;
        try {
            String sql = "DELETE FROM thongtindat WHERE SoThua=?";


            cn = ConnectionDB.conn();
            pst = cn.prepareStatement(sql);

            pst.setString(1, String.valueOf(a.getSoThua()));
            if (pst.executeUpdate() > 0) {
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int update(ThongTinDat a) {
        PreparedStatement pst = null;
        Connection cn = null;
        try {
            String sql = "UPDATE thongtindat  SET DienTich = ?, MaLoai = ?, GiapRanh = ?, SoDo = ? WHERE SoThua=?";

            cn = ConnectionDB.conn();
            pst = cn.prepareStatement(sql);

            pst.setFloat(1, a.getDienTich());
            pst.setString(2, String.valueOf(a.getMaLoai()));
           
            pst.setString(3, a.getGiapRanh());
            pst.setString(4, a.getSoDo());
            pst.setString(5, String.valueOf(a.getSoThua()));

            if (pst.executeUpdate() > 0) {
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

}