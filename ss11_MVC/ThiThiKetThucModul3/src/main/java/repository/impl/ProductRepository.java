package repository.impl;

import model.Category;
import model.Product;
import repository.DBCategory;
import repository.IProductRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static final String DELETE_PRODUCT = "DELETE FROM `category`.`product` WHERE (`id` = ?);";
    private static final String UPDATE_PRODUCT = "UPDATE `category`.`product` SET `ten_san_pham` = ?, `gia` = ?, `so_luong` = ?, `mau_sac` = ?, `mo_ta` = ?, id_category = (SELECT id_category FROM category WHERE category = ?) WHERE (`id` = ?);\n";
    private static final String SELECT_PRODUCT_BY_NAME = "SELECT product.*, category.category\n" +
                                                        "FROM product\n" +
                                                        "INNER JOIN category ON product.id_category = category.id_category\n" +
                                                        "WHERE product.ten_san_pham LIKE ?;";
    CategoryRepository categoryRepository = new CategoryRepository();
    private static final String SELECT_BY_ID = "SELECT p.*, ct.category from category.product p \n" +
            "join category.category ct ON p.id_category = ct.id_category\n" +
            "where (p.id = ?);";
    private static final String SELECT_ALL = "SELECT p.*, ct.category from category.product p join category.category ct ON p.id_category = ct.id_category;";
    private static final String CREATE_FORM = "INSERT INTO `category`.`product` (`id`, `ten_san_pham`, `gia`, `so_luong`, `mau_sac`, `mo_ta`, `id_category`) VALUES (?, ?, ?, ?, ?, ?, ?);\n";

    @Override
    public List<Product> finalAllProduct() {
        List<Product> productList = new ArrayList<>();
        Connection connection = DBCategory.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                Product product = getProduct(rs);

                 productList.add(product);
            }
            connection.close();
//            return productList;
        } catch (SQLException e) {
            printSQLException(e);
        }
        return productList;
    }

    private static Product getProduct(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String ten = rs.getString("ten_san_pham");
        Double gia = rs.getDouble("gia");
        int soLuong = rs.getInt("so_luong");
        String mauSac = rs.getString("mau_sac");
        String moTa = rs.getString("mo_ta");
        Product product = new Product(id, ten, gia, soLuong, mauSac, moTa);

        int idCate = rs.getInt("id_category");
        String tenCate = rs.getString("category");
//                Category category = categoryRepository.finalById(idCate);
        Category category = new Category(idCate,tenCate);
        product.setCategory(category);
        return product;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }

    }

    @Override
    public Product finalById(int id) {
        Connection connection = DBCategory.getConnection();
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idP = rs.getInt("id");
                String ten = rs.getString("ten_san_pham");
                Double gia = rs.getDouble("gia");
                int soLuong = rs.getInt("so_luong");
                String mauSac = rs.getString("mau_sac");
                String moTa = rs.getString("mo_ta");
                Product products = new Product(idP, ten, gia, soLuong, mauSac, moTa);

                int idCate = rs.getInt("id_category");
                String tenCategory = rs.getString("category");
                Category category = new Category(idCate,tenCategory);
                products.setCategory(category);
                return products;
            }
        } catch(SQLException e){
            printSQLException(e);
        }
        return null;
    }
    @Override
    public void create(Product product) {
//        INSERT INTO `category`.`product` (`id`, `ten_san_pham`, `gia`, `so_luong`, `mau_sac`, `mo_ta`, `id_category`)
//        VALUES (?, ?, ?, ?, ?, ?, ?);
        Connection connection = DBCategory.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_FORM);
            preparedStatement.setInt(1, product.getId());
            preparedStatement.setString(2, product.getTenSanPham());
            preparedStatement.setDouble(3, product.getGia());
            preparedStatement.setInt(4, product.getSoLuong());
            preparedStatement.setString(5, product.getMauSac());
            preparedStatement.setString(6, product.getMoTa());
            preparedStatement.setInt(7, product.getCategory().getIdCate());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public void delete(int id) {
        Connection connection = DBCategory.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public void update(int id, Product product) {
        //        UPDATE `category`.`product` SET `ten_san_pham` = ?, `gia` = ?, `so_luong` = ?,
//        `mau_sac` = ?, `mo_ta` = ?, `id_category` = ? WHERE (`id` = ?);
        Connection connection = DBCategory.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT);
            preparedStatement.setString(1, product.getTenSanPham());
            preparedStatement.setDouble(2, product.getGia());
            preparedStatement.setInt(3, product.getSoLuong());
            preparedStatement.setString(4, product.getMauSac());
            preparedStatement.setString(5, product.getMoTa());
            preparedStatement.setString(6, product.getCategory().getCategory());
            preparedStatement.setInt(7, id);

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public List<Product> seach(String name) {
        List<Product> productList = new ArrayList<>();
        Connection connection = DBCategory.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_PRODUCT_BY_NAME);
            statement.setString(1,"%" + name + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String ten = rs.getString("ten_san_pham");
                Double gia = rs.getDouble("gia");
                int soLuong = rs.getInt("so_luong");
                String mauSac = rs.getString("mau_sac");
                String moTa = rs.getString("mo_ta");
                Product products = new Product(id, ten, gia, soLuong, mauSac, moTa);

                int idCate = rs.getInt("id_category");
                String tenCategory = rs.getString("category");
                Category category = new Category(idCate,tenCategory);
                products.setCategory(category);
                productList.add(products);
            }
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }
}
