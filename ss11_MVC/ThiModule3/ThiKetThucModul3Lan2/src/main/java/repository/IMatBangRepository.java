package repository;

import model.MatBang;

import java.util.List;

public interface IMatBangRepository {
    List<MatBang> finalAllMatBang();
    MatBang finalById(int id);
}
