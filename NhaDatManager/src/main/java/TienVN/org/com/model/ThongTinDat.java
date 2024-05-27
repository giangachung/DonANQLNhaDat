package TienVN.org.com.model;

import java.awt.Image;
import java.io.Serializable;

public class ThongTinDat implements Serializable {

    private int SoThua;

    private float DienTich;

    private int maLoai;
    private String GiapRanh;
    private String soDo;
    private Float giaBan;
    private String nhanVienBan;
    private String sDT, moTa;
    private String anh;
    

    public ThongTinDat() {
    }

    public ThongTinDat(int soThua) {
        SoThua = soThua;
    }

    public ThongTinDat(int soThua, float dienTich, int maLoai, String giapRanh, String soDo,
                                float giaban, String nhanvienban, String sdt, String mota) {
        SoThua = soThua;
        DienTich = dienTich;
        this.maLoai = maLoai;
        GiapRanh = giapRanh;
        this.soDo = soDo;
        giaBan = giaban;
        nhanVienBan = nhanvienban;
        sDT = sdt;
        moTa = mota;  
       
    }
 public ThongTinDat(int soThua, float dienTich, int maLoai, String giapRanh, String soDo) {
        SoThua = soThua;
        DienTich = dienTich;
        this.maLoai = maLoai;
        GiapRanh = giapRanh;
        this.soDo = soDo;
 }
    public int getSoThua() {
        return SoThua;
    }

    public void setSoThua(int soThua) {
        SoThua = soThua;
    }

    public float getDienTich() {
        return DienTich;
    }

    public void setDienTich(float dienTich) {
        DienTich = dienTich;
    }

    public int getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(int maLoai) {
        this.maLoai = maLoai;
    }

    public String getGiapRanh() {
        return GiapRanh;
    }

    public void setGiapRanh(String giapRanh) {
        GiapRanh = giapRanh;
    }

    public String getSoDo() {
        return soDo;
    }

    public void setSoDo(String soDo) {
        this.soDo = soDo;
    }

    public Float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Float giaBan) {
        this.giaBan = giaBan;
    }

    public String getNhanVienBan() {
        return nhanVienBan;
    }

    public void setNhanVienBan(String nhanVienBan) {
        this.nhanVienBan = nhanVienBan;
    }

    public String getsDT() {
        return sDT;
    }

    public void setsDT(String sDT) {
        this.sDT = sDT;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }
    
    
    @Override
    public String toString() {
        return "ThongTinDat{" +
                "SoThua=" + SoThua +
                ", DienTich=" + DienTich +
                ", maLoai=" + maLoai +
                ", GiapRanh='" + GiapRanh + '\'' +
                ", soDo='" + soDo + 
                "giaBan"+giaBan+
                "nhanVienBan"+nhanVienBan+
                "SDT"+sDT+
                "moTa"+moTa+
                "anh"+anh+'\'' +
                
                '}';
    }
}


