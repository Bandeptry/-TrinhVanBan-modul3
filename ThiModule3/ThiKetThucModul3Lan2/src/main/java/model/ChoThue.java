package model;

public class ChoThue {
    private int id;
    private int idTrangThai;
    private TrangThai nameTrangThai;
    private MatBang nameMatBang;
    private int idMatBang;
    private int dienTich;
    private int tang;
    private double gia;

    private String ngayBatDau;
    private String ngayKetThuc;



    public ChoThue() {
    }

    public ChoThue(int id, int dienTich, int tang, double gia, String ngayBatDau, String ngayKetThuc) {
        this.id = id;
        this.dienTich = dienTich;
        this.tang = tang;
        this.gia = gia;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTrangThai() {
        return idTrangThai;
    }

    public void setIdTrangThai(int idTrangThai) {
        this.idTrangThai = idTrangThai;
    }

    public int getIdMatBang() {
        return idMatBang;
    }

    public void setIdMatBang(int idMatBang) {
        this.idMatBang = idMatBang;
    }

    public int getDienTich() {
        return dienTich;
    }

    public void setDienTich(int dienTich) {
        this.dienTich = dienTich;
    }

    public int getTang() {
        return tang;
    }

    public void setTang(int tang) {
        this.tang = tang;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public TrangThai getNameTrangThai() {
        return nameTrangThai;
    }

    public void setNameTrangThai(TrangThai nameTrangThai) {
        this.nameTrangThai = nameTrangThai;
    }

    public MatBang getNameMatBang() {
        return nameMatBang;
    }

    public void setNameMatBang(MatBang nameMatBang) {
        this.nameMatBang = nameMatBang;
    }
}
