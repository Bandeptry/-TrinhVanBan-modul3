package model;

public class LoaiMatBang {
    private int idMatBang;
    private String nameMatBang;

    public LoaiMatBang() {
    }

    public LoaiMatBang(int idMatBang, String nameMatBang) {
        this.idMatBang = idMatBang;
        this.nameMatBang = nameMatBang;
    }

    public int getIdMatBang() {
        return idMatBang;
    }

    public void setIdMatBang(int idMatBang) {
        this.idMatBang = idMatBang;
    }

    public String getNameMatBang() {
        return nameMatBang;
    }

    public void setNameMatBang(String nameMatBang) {
        this.nameMatBang = nameMatBang;
    }
}
