import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PhongBan {
    private int maSNV;
    private String tenNhanVien;
    private String congViec;
    private Date ngayTuyen;
    private float luong;
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");

    public PhongBan() {
    }

    public PhongBan(int maSNV, String tenNhanVien, String congViec, String ngayTuyenStr, float luong) {
        this.maSNV = maSNV;
        this.tenNhanVien = tenNhanVien;
        this.congViec = congViec;
        this.luong = luong;
        try {
            this.ngayTuyen = DATE_FORMAT.parse(ngayTuyenStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public int getMaSNV() {
        return maSNV;
    }

    public void setMaSNV(int maSNV) {
        this.maSNV = maSNV;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getCongViec() {
        return congViec;
    }

    public void setCongViec(String congViec) {
        this.congViec = congViec;
    }

    public Date getNgayTuyen() {
        return ngayTuyen;
    }

    public void setNgayTuyen(Date ngayTuyen) {
        this.ngayTuyen = ngayTuyen;
    }

    public float getLuong() {
        return luong;
    }

    public void setLuong(float luong) {
        this.luong = luong;
    }
}

