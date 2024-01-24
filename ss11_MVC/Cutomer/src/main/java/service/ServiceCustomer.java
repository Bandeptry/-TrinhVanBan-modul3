package service;

import model.Customer;
import repository.IRepositoryCustomer;
import repository.RepositoryCustomer;

public class ServiceCustomer implements IServiceCutomer{
    IRepositoryCustomer repositoryCustomer = new RepositoryCustomer();
    @Override
    public void findAll() {
        repositoryCustomer.findAll();
    }

    @Override
    public void save(Customer customer) {
        repositoryCustomer.save(customer);
    }

    @Override
    public void findById(int id) {
        repositoryCustomer.findById(id);
    }

    @Override
    public void update(int id, Customer customer) {
        repositoryCustomer.update(id, customer);
    }

    @Override
    public void remove(int id) {
        repositoryCustomer.remove(id);
    }
}
