package service;

import model.Customer;

import java.util.List;

public interface IServiceCutomer {
    void findAll();

    void save(Customer customer);

    void findById(int id);

    void update(int id, Customer customer);

    void remove(int id);
}
