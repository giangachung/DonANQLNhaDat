package TienVN.org.com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
public ConnectionDB(){}
    public static Connection conn() {
        String url = "jdbc:mysql://localhost:3306/qlnhadat?useUnicode=true&characterEncoding=UTF-8";
        String user = "root";
        String password = "";
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                // Kết nối thành công
                //System.out.println("Connect successful !!");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }


}