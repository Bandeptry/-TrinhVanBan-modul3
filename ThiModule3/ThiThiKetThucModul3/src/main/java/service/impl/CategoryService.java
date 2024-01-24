package service.impl;

import model.Category;
import model.Product;
import repository.ICategoryRepository;
import repository.impl.CategoryRepository;
import service.ICategoryService;

import java.util.List;

public class CategoryService implements ICategoryService {
    ICategoryRepository iCategoryRepository =new CategoryRepository();
    @Override
    public List<Category> finalAllCategory() {
        return iCategoryRepository.finalAllCategory();
    }

    @Override
    public Category finalById(int id) {
        return iCategoryRepository.finalById(id);
    }
}
