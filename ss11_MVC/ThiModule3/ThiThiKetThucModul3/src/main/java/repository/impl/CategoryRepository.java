package repository.impl;

import model.Category;
import model.Product;
import repository.DBCategory;
import repository.ICategoryRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository implements ICategoryRepository {
    private static final String SELECT_CATEGORY = "SELECT * FROM category.category;";
    private static final String FIND_CATEGORY_BY_ID = " SELECT * FROM category.category\n" +
                                                        "where (id_category = ?); ";

    @Override
    public List<Category> finalAllCategory() {
        List<Category> categories = new ArrayList<>();
        Connection connection = DBCategory.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CATEGORY);
            System.out.println("finalAllCategory(): "+ preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            Category category = null;
            while (resultSet.next()){
                int id = resultSet.getInt("id_category");
                String name = resultSet.getString("category");
                category = new Category(id,name);
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public Category finalById(int id) {
        Category category = null;
        try {
            Connection connection = DBCategory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_CATEGORY_BY_ID);
            System.out.println("finalAllCategory(): "+ preparedStatement);
            preparedStatement.setInt(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int idCategory = resultSet.getInt("id_category");
                String name = resultSet.getString("category");

                category = new Category(idCategory,name);
                return category;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }
}
