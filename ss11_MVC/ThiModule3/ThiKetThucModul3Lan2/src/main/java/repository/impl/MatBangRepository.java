package repository.impl;

import model.MatBang;
import repository.DBChoThue;
import repository.IMatBangRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MatBangRepository implements IMatBangRepository {
    private static final String SELECT_MATBANG = "SELECT * FROM danang.matbang;";
    private static final String FIND_MATBANG_BY_ID = "SELECT * FROM danang.matbang\n" +
            "where (idmatbang = ?)";

    @Override
    public List<MatBang> finalAllMatBang() {
        List<MatBang> matBangs = new ArrayList<>();
        Connection connection = DBChoThue.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MATBANG);
            System.out.println("finalAllMatBang(): "+ preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            MatBang matBang = null;
            while (resultSet.next()){
                int id = resultSet.getInt("idmatbang");
                String name = resultSet.getString("matbang");
                matBang = new MatBang(id,name);
                matBangs.add(matBang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return matBangs;
    }

    @Override
    public MatBang finalById(int id) {
        MatBang matBang = null;
        try {
            Connection connection = DBChoThue.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_MATBANG_BY_ID);
            System.out.println("finalById "+ preparedStatement);
            preparedStatement.setInt(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int idMB = resultSet.getInt("idmatbang");
                String name = resultSet.getString("matbang");

                matBang = new MatBang(idMB,name);
                return matBang;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return matBang;
    }
}
