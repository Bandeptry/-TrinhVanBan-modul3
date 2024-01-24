package model;

public class Category {
    private int idCate;
    private String category;

    public Category() {
    }

    public Category(int idCate, String category) {
        this.idCate = idCate;
        this.category = category;
    }

    public int getIdCate() {
        return idCate;
    }

    public void setIdCate(int idCate) {
        this.idCate = idCate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
