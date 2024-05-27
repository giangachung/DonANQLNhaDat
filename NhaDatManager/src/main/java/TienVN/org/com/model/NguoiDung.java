package TienVN.org.com.model;

import java.io.Serializable;

public class NguoiDung implements Serializable {

    private int id;
    private String tenNguiDung;
    private String password;
    private int role;
    private String sdt;

    public NguoiDung() {
        this.role=0;
    }
    
    public NguoiDung(int id) {
        this.id = id;
    }

    public NguoiDung(String tenNguiDung, String password, int role, String sdt) {
        //this.id = id;
        this.tenNguiDung = tenNguiDung;
        this.password = password;
        this.role = role;
        this.sdt = sdt;
    }
    public NguoiDung(int id, String tenNguiDung, String password, int role, String sdt) {
        this.id = id;
        this.tenNguiDung = tenNguiDung;
        this.password = password;
        this.role = role;
        this.sdt = sdt;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenNguiDung() {
        return tenNguiDung;
    }

    public void setTenNguiDung(String tenNguiDung) {
        this.tenNguiDung = tenNguiDung;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    
}
