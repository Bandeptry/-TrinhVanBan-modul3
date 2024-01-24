package repository.impl;

import model.MatBang;
import model.TrangThai;
import repository.DBChoThue;
import repository.ITrangThaiRepoditory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrangThaiRepoditory implements ITrangThaiRepoditory {
    private static final String SELECT_TRANGTHAI = "SELECT * FROM danang.trangthai;";
    private static final String FIND_TRANGTHAI_BY_ID = "SELECT * FROM danang.trangthai\n" +
            "where (idtrangthai = ?)";

    @Override
    public List<TrangThai> finalAllTrangThai() {
        List<TrangThai> trangThais = new ArrayList<>();
        Connection connection = DBChoThue.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TRANGTHAI);
            System.out.println("finalAll(): "+ preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            TrangThai trangThai = null;
            while (resultSet.next()){
                int id = resultSet.getInt("idtrangthai");
                String name = resultSet.getString("ten_trang_thai");
                trangThai = new TrangThai(id,name);
                trangThais.add(trangThai);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trangThais;
    }

    @Override
    public TrangThai finalById(int id) {
        TrangThai trangThai = null;
        try {
            Connection connection = DBChoThue.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_TRANGTHAI_BY_ID);
            System.out.println("finalById "+ preparedStatement);
            preparedStatement.setInt(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int idMB = resultSet.getInt("idtrangthai");
                String name = resultSet.getString("ten_trang_thai");

                trangThai = new TrangThai(idMB,name);
                return trangThai;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trangThai;
    }
}
