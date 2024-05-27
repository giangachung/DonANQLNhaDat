/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TienVN.org.com.model;

//import java.awt.TexturePaintContext;
import java.io.Serializable;

/**
 *
 * @author Laptop Thang Long
 */
public class YeuCauKhachHang implements Serializable {
    private int maPhieu;
    private String yeuCau, huongDat, khaNang, lienHe;
    private int dienTich;
    
    public YeuCauKhachHang(){
        
    }
    public YeuCauKhachHang(int mp){
        maPhieu = mp;
   }


    public YeuCauKhachHang(int maphieu, String yeucau,int dt, String hd,String khanang, String lienhe) {
        maPhieu = maphieu;
        yeuCau = yeucau;
        dienTich = dt;
        huongDat = hd;
        khaNang = khanang;
        lienHe = lienhe;
    }
    
    public YeuCauKhachHang(String yeucau,int dt, String hd,String khanang, String lienhe) {
        yeuCau = yeucau;
        dienTich = dt;
        huongDat = hd;
        khaNang = khanang;
        lienHe = lienhe;
    }

    public int getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(int maPhieu) {
        this.maPhieu = maPhieu;
    }

    public String getYeuCau() {
        return yeuCau;
    }

    public void setYeuCau(String yeuCau) {
        this.yeuCau = yeuCau;
    }

    public String getHuongDat() {
        return huongDat;
    }

    public void setHuongDat(String huongDat) {
        this.huongDat = huongDat;
    }

    public String getKhaNang() {
        return khaNang;
    }

    public void setKhaNang(String khaNang) {
        this.khaNang = khaNang;
    }

    public String getLienHe() {
        return lienHe;
    }

    public void setLienHe(String lienHe) {
        this.lienHe = lienHe;
    }

    public int getDienTich() {
        return dienTich;
    }

    public void setDienTich(int dienTich) {
        this.dienTich = dienTich;
    }
    
    

    @Override
    public String toString()
    {
        return "YeuCauKhachHang{" +
                "MaPhieu=" +maPhieu+
                ",YeuCau='"+ yeuCau+
                ",DienTich'" +dienTich+ '\''+
                "HuongDat="+ huongDat+ 
                "KhaNangTuiTien=" +khaNang+
                "lienhe = " +lienHe+
                '}';
    }
}
