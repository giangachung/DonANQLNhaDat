package TienVN.org.com.dao;

import TienVN.org.com.model.NguoiDung;
import TienVN.org.com.model.YeuCauKhachHang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NguoiDungDAO {

    
    public int add(NguoiDung a) {
        Connection cn = null;
        PreparedStatement check = null;
        PreparedStatement pst = null;
        try {
            String check1 = "SELECT * FROM nguoidung WHERE id=?";
            cn = ConnectionDB.conn();
            PreparedStatement p = cn.prepareStatement(check1);
            p.setInt(1, a.getId());
            ResultSet resultSet = p.executeQuery();
            if (resultSet.next()) {
                return 0;
            } else {
                try {
                    String sql1 = "INSERT INTO nguoidung(TenND, Password, role, sdt) VALUES (?, ?, ?, ?)";
                    pst = cn.prepareStatement(sql1, PreparedStatement.RETURN_GENERATED_KEYS);
                    pst.setString(1, a.getTenNguiDung());
                    pst.setString(2, a.getPassword());
                    pst.setInt(3, a.getRole());
                    pst.setString(4, a.getSdt());

                    int affectedRows = pst.executeUpdate();
                    if (affectedRows > 0) {
                        // Lấy giá trị ID tự động tăng của bản ghi mới được thêm vào
                        ResultSet generatedKeys = pst.getGeneratedKeys();
                        if (generatedKeys.next()) {
                            int id = generatedKeys.getInt(1);
                            System.out.println("Thêm tài khoản thành công. ID mới: " + id);
                            return 1; // Trả về 1 để biểu thị thêm thành công
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Đóng các kết nối và tài nguyên
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (cn != null) {
                try {
                    cn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return -1; // Trả về -1 để biểu thị thêm thất bại
    }
    
    public int delete(NguoiDung a) {
        PreparedStatement pst = null;
        Connection cn = null;
        try {
            String sql = "DELETE FROM nguoidung WHERE Id=?";


            cn = ConnectionDB.conn();
            pst = cn.prepareStatement(sql);

            pst.setString(1, String.valueOf(a.getId()));
            if (pst.executeUpdate() > 0) {
                return 1;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    public int update(NguoiDung a) {
        PreparedStatement pst = null;
        Connection cn = null;
        try {
            String sql = "UPDATE nguoidung  SET TenND = ?, Password = ?, role = ? , sdt =? WHERE id=?";

            cn = ConnectionDB.conn();
            //pst = cn.prepareStatement(sql);
            pst = cn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            pst.setString(1, a.getTenNguiDung());
            pst.setString(2, a.getPassword());
            pst.setInt(3, a.getRole());
            pst.setString(4, a.getSdt());
            //pst.setInt(5, a.getId());
            pst.setString(5, String.valueOf(a.getId()));
            
            
            if (pst.executeUpdate() > 0) {
                return 1;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return -1;
    }


    public int tao(NguoiDung a) {
        Connection cn =null;
        PreparedStatement check  =null;

        PreparedStatement pst  =null;
        try {

            String check1= "SELECT * FROM nguoidung WHERE id=?";
            cn = ConnectionDB.conn();
            PreparedStatement p = cn.prepareStatement(check1);
            p.setInt(1, a.getId());
            ResultSet resultSet = p.executeQuery();
            if (resultSet.next()) {
                return 0;
            } else {
                try {
                    String sql1 = "INSERT INTO nguoidung(TenND, Password, role, sdt) VALUES(?,?,?,?)";
                    pst = cn.prepareStatement(sql1, PreparedStatement.RETURN_GENERATED_KEYS);
                    //pst = cn.prepareStatement(sql1);

                   // pst.setString(1, String.valueOf(a.getMaPhieu()));
                    pst.setString(1,a.getTenNguiDung());
                    pst.setString(2,a.getPassword());
                    pst.setInt(3,a.getRole());
                    pst.setString(4,a.getSdt());
                    
                    
                     int affectedRows = pst.executeUpdate();
                    if (affectedRows > 0) {
                        ResultSet generatedKeys = pst.getGeneratedKeys();
                        if (generatedKeys.next()) {
                            int id = generatedKeys.getInt(1);
                            System.out.println("Thêm tài khoản thành công. ID mới: " + id);
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
}

