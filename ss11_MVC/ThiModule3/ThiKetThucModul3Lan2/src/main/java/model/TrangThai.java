package model;

public class TrangThai {
    private int idTrangThai;
    private String nameTrangThai;

    public TrangThai() {
    }

    public TrangThai(int idTrangThai, String nameTrangThai) {
        this.idTrangThai = idTrangThai;
        this.nameTrangThai = nameTrangThai;
    }

    public int getIdTrangThai() {
        return idTrangThai;
    }

    public void setIdTrangThai(int idTrangThai) {
        this.idTrangThai = idTrangThai;
    }

    public String getNameTrangThai() {
        return nameTrangThai;
    }

    public void setNameTrangThai(String nameTrangThai) {
        this.nameTrangThai = nameTrangThai;
    }
}
