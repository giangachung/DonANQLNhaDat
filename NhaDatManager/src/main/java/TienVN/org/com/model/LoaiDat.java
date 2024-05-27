package TienVN.org.com.model;

public class LoaiDat {

    private int MaLoai;

    private String tenLoai;


    public LoaiDat() {
    }

    public LoaiDat(int maLoai) {
        MaLoai = maLoai;
    }

    public LoaiDat(int maLoai, String tenLoai) {
        MaLoai = maLoai;
        this.tenLoai = tenLoai;
    }

    public int getMaLoai() {
        return MaLoai;
    }

    public void setMaLoai(int maLoai) {
        MaLoai = maLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }


    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    @Override
    public String toString() {
        return "LoaiDat{" +
                "MaLoai=" + MaLoai +
                ", tenLoai='" + tenLoai + '\'' +
                '}';
    }
}
