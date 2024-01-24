package service;

import model.Category;
import model.Product;

import java.util.List;

public interface ICategoryService {
    List<Category> finalAllCategory();
    Category finalById(int id);
}
