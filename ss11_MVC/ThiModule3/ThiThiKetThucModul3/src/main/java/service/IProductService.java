package service;

import model.Product;

import java.util.List;

public interface IProductService {
    List<Product> finalAllProduct();
    Product finalById(int id);
    void create(Product product);
    void delete(int id);
    void update(int id, Product product);
    List<Product> seach(String name);
}
