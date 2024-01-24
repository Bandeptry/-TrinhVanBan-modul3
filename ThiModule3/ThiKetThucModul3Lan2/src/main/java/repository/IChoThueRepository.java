package repository;

import model.ChoThue;
import model.MatBang;

import java.util.List;

public interface IChoThueRepository {
    List<ChoThue> finalAllChoThue();
    ChoThue finalById(int id);
    void create(ChoThue product);
    void delete(int id);
    List<ChoThue> seach(MatBang matBang);
    List<ChoThue> seach(int tang);
    List<ChoThue> seach(double gia);
}
