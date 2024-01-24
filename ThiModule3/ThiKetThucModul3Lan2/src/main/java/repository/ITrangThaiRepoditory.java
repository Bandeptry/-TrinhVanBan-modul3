package repository;

import model.TrangThai;

import java.util.List;

public interface ITrangThaiRepoditory {
    List<TrangThai> finalAllTrangThai();
    TrangThai finalById(int id);
}
