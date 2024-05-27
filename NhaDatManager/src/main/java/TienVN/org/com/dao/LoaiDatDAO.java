package TienVN.org.com.dao;

import TienVN.org.com.model.ChoSoHuu;
import TienVN.org.com.model.LoaiDat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoaiDatDAO {
    public int add(LoaiDat a) {
        Connection cn = null;
        PreparedStatement check = null;

        PreparedStatement pst = null;
        try {

            String check1 = "SELECT * FROM loaidat WHERE MaLoai=?";
            cn = ConnectionDB.conn();
            PreparedStatement p = cn.prepareStatement(check1);
            p.setInt(1, a.getMaLoai());
            ResultSet resultSet = p.executeQuery();
            if (resultSet.next()) {
                return 0;
            } else {
                try {
                    String sql1 = "INSERT INTO loaidat VALUES (?,?)";
                    pst = cn.prepareStatement(sql1);

                    pst.setString(1, String.valueOf(a.getMaLoai()));
                    pst.setString(2, a.getTenLoai());


                    if (pst.executeUpdate() > 0) {
                        System.out.println("add thanh cong");
                        return 1;
                    }
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

    public int delete(LoaiDat a) {
        PreparedStatement pst = null;
        Connection cn = null;
        try {
            String sql = "DELETE FROM loaidat WHERE MaLoai=?";


            cn = ConnectionDB.conn();
            pst = cn.prepareStatement(sql);

            pst.setString(1, String.valueOf(a.getMaLoai()));
            if (pst.executeUpdate() > 0) {
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int update(LoaiDat a) {
        PreparedStatement pst = null;
        Connection cn = null;
        try {
            String sql = "UPDATE loaidat  SET TenLoai = ? WHERE MaLoai=?";

            cn = ConnectionDB.conn();
            pst = cn.prepareStatement(sql);

            pst.setString(1, a.getTenLoai());
            pst.setString(1, String.valueOf(a.getMaLoai()));

            if (pst.executeUpdate() > 0) {
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}