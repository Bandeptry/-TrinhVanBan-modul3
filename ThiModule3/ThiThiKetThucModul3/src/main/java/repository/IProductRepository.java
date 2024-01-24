package repository;

import model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> finalAllProduct();
    Product finalById(int id);
    void create(Product product);
    void delete(int id);
    void update(int id, Product product);
    List<Product> seach(String name);
}
