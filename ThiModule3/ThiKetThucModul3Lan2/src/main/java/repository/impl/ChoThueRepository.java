package repository.impl;

import model.ChoThue;
import model.MatBang;
import model.TrangThai;
import repository.DBChoThue;
import repository.IChoThueRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChoThueRepository implements IChoThueRepository {
    private static final String SELECT_ALL = "SELECT \n" +
            "    ch.*, \n" +
            "    tt.ten_trang_thai,\n" +
            "    mb.matbang\n" +
            "FROM \n" +
            "    `danang`.`chothue` ch\n" +
            "JOIN \n" +
            "    `trangthai` tt ON ch.`idtrangthai` = tt.`idtrangthai`\n" +
            "JOIN \n" +
            "    `matbang` mb ON ch.`idmatbang` = mb.`idmatbang`" +
            "ORDER BY ch.`dientich` ASC; \n";
    private static final String SELECT_BY_ID = "";
    private static final String CREATE_FORM = "INSERT INTO `danang`.`chothue` (`id`, `dientich`, `tang`, `gia`, `ngaybatdau`, `ngayketthuc`, `idtrangthai`, `idmatbang`) VALUES (?, ?, ?, ?, ?, ?, ?, ?);\n";
    private static final String DELETE_CHOTHUE = "DELETE FROM `danang`.`chothue` WHERE (`id` = ?);\n";

    @Override
    public List<ChoThue> finalAllChoThue() {
        List<ChoThue> choThuetList = new ArrayList<>();
        Connection connection = DBChoThue.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                ChoThue chothue = getChoThue(rs);

                choThuetList.add(chothue);
            }
            connection.close();
        } catch (SQLException e) {
            printSQLException(e);
        }
        return choThuetList;
    }

    private static ChoThue getChoThue(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        int dienTich = rs.getInt("dientich");
        int tang = rs.getInt("tang");
        Double gia = rs.getDouble("gia");
        String ngayBatDau = rs.getString("ngaybatdau");
        String ngayKetThuc = rs.getString("ngayketthuc");
        ChoThue choThue = new ChoThue(id, dienTich, tang, gia, ngayBatDau, ngayKetThuc);

        int idTrangThai = rs.getInt("idtrangthai");
        String tenTT = rs.getString("ten_trang_thai");

        TrangThai trangThai = new TrangThai(idTrangThai,tenTT);
        choThue.setNameTrangThai(trangThai);

        int idMatBang = rs.getInt("idmatbang");
        String matBang = rs.getString("matbang");

        MatBang mb = new MatBang(idMatBang,matBang);
        choThue.setNameMatBang(mb);
        return choThue;
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
    public ChoThue finalById(int id) {
        Connection connection = DBChoThue.getConnection();
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ChoThue thue = getChoThue(rs);
                return thue;
            }
        } catch(SQLException e){
            printSQLException(e);
        }
        return null;
    }

    @Override
    public void create(ChoThue choThue) {
//        INSERT INTO `danang`.`chothue` (`id`, `dientich`, `tang`,
//        `gia`, `ngaybatdau`, `ngayketthuc`, `idtrangthai`, `idmatbang`)
//        VALUES (?, ?, ?, ?, ?, ?, ?, ?);
        Connection connection = DBChoThue.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_FORM);
            preparedStatement.setInt(1, choThue.getId());
            preparedStatement.setInt(2, choThue.getDienTich());
            preparedStatement.setInt(3, choThue.getTang());
            preparedStatement.setDouble(4, choThue.getGia());
            preparedStatement.setString(5, choThue.getNgayBatDau());
            preparedStatement.setString(6, choThue.getNgayKetThuc());
            preparedStatement.setInt(7, choThue.getNameMatBang().getIdMatBang());
            preparedStatement.setInt(8, choThue.getNameTrangThai().getIdTrangThai());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public void delete(int id) {
        Connection connection = DBChoThue.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CHOTHUE);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public List<ChoThue> seach(MatBang matBang) {
        return null;
    }

    @Override
    public List<ChoThue> seach(int tang) {
        return null;
    }

    @Override
    public List<ChoThue> seach(double gia) {
        return null;
    }
}
