package model;

public class MatBang {
    private int idMatBang;
    private String nameMatBang;

    public MatBang() {
    }

    public MatBang(int idMatBang, String nameMatBang) {
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
