package TienVN.org.com.model;

import java.io.Serializable;
import java.time.LocalDate;

public class ChoSoHuu implements Serializable {
    private int MahuSoHuu;
    private String TenChuSoHuu;
    private int SoThua;
    private LocalDate  NgaySoHuu;

    public ChoSoHuu() {
    }

    public ChoSoHuu(int mahuSoHuu) {
        MahuSoHuu = mahuSoHuu;
    }

    public ChoSoHuu(int MahuSoHuu, String TenChuSoHuu, int SoThua, LocalDate NgaySoHuu) {
        this.MahuSoHuu = MahuSoHuu;
        this.TenChuSoHuu = TenChuSoHuu;
        this.SoThua = SoThua;
        this.NgaySoHuu = NgaySoHuu;
    }

//    
//    public ChoSoHuu(int mahuSoHuu, String tenChuSoHuu, int soThua) {
//        MahuSoHuu = mahuSoHuu;
//        TenChuSoHuu = tenChuSoHuu;
//        SoThua = soThua;
//    }

    public int getMahuSoHuu() {
        return MahuSoHuu;
    }

    public void setMahuSoHuu(int mahuSoHuu) {
        MahuSoHuu = mahuSoHuu;
    }

    public String getTenChuSoHuu() {
        return TenChuSoHuu;
    }

    public void setTenChuSoHuu(String tenChuSoHuu) {
        TenChuSoHuu = tenChuSoHuu;
    }

    public int getSoThua() {
        return SoThua;
    }

    public void setSoThua(int soThua) {
        SoThua = soThua;
    }

    public LocalDate getNgaySoHuu() {
        return NgaySoHuu;
    }

    public void setNgaySoHuu(LocalDate NgaySoHuu) {
        this.NgaySoHuu = NgaySoHuu;
    }

    
    @Override
    public String toString() {
        return "ChoSoHuu{" +
                "MahuSoHuu=" + MahuSoHuu +
                ", TenChuSoHuu='" + TenChuSoHuu + '\'' +
                ", SoThua=" + SoThua +
                ", NgaySoHuu = " + NgaySoHuu +
                '}';
    }
}
