package TienVN.org.com.dao;

import TienVN.org.com.model.ChoSoHuu;
import TienVN.org.com.model.NguoiDung;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChuSoHuuDAO {
    public int add(ChoSoHuu a) {
        Connection cn =null;
        PreparedStatement check  =null;

        PreparedStatement pst  =null;
        try {

            String check1= "SELECT * FROM chusohuu WHERE MaChuSoHuu=?";
            cn = ConnectionDB.conn();
            PreparedStatement p = cn.prepareStatement(check1);
            p.setInt(1, a.getMahuSoHuu());
            ResultSet resultSet = p.executeQuery();
            if (resultSet.next()) {
                return 0;
            } else {
                try {
                    String sql1 = "INSERT INTO chusohuu VALUES (?,?,?,?)";
                   // pst = cn.prepareStatement(sql1);
                   pst = cn.prepareStatement(sql1, PreparedStatement.RETURN_GENERATED_KEYS);
                    pst.setString(1, String.valueOf(a.getMahuSoHuu()));
                    pst.setString(2,a.getTenChuSoHuu());
                    pst.setInt(3,a.getSoThua());
                    pst.setString(4, a.getNgaySoHuu().toString());

                    if (pst.executeUpdate() > 0) {
                        System.out.println("add thanh cong");
                        return 1;
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
    public int delete(ChoSoHuu a) {
        PreparedStatement pst = null;
        Connection cn = null;
        try {
            String sql = "DELETE FROM chusohuu WHERE MaChuSoHuu=?";


            cn = ConnectionDB.conn();
            pst = cn.prepareStatement(sql);

            pst.setString(1, String.valueOf(a.getMahuSoHuu()));
            if (pst.executeUpdate() > 0) {
                return 1;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    public int update(ChoSoHuu a) {
    PreparedStatement pst = null;
    Connection cn = null;
    try {
        String sql = "UPDATE chusohuu SET TenChuSoHuu=?, SoThua=?, NgaySoHuu=? WHERE MaChuSoHuu=?";

        cn = ConnectionDB.conn();
        pst = cn.prepareStatement(sql);

        pst.setString(1, a.getTenChuSoHuu());
        pst.setInt(2, a.getSoThua());
        pst.setObject(3, a.getNgaySoHuu());
        pst.setInt(4, a.getMahuSoHuu());

        if (pst.executeUpdate() > 0) {
            return 1;
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return -1;
}
    public int findByName(ChoSoHuu a){
        
        
        PreparedStatement pst = null;
        Connection cn = null;
        try {
            String sql = "SElECT * FROM chusohuu WHERE TenChuSoHuu=?";


            cn = ConnectionDB.conn();
            pst = cn.prepareStatement(sql);

            pst.setString(1, String.valueOf(a.getTenChuSoHuu()));
            if (pst.executeUpdate() > 0) {
                return 1;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return -1;
        
        
    }
}
