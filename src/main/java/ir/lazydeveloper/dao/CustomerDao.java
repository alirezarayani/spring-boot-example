package ir.lazydeveloper.dao;

import ir.lazydeveloper.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDao {

    List<Customer> selectAllCustomers();
    Optional<Customer> selectCustomerByIs(Integer id);

    void insertCustomer(Customer customer);

    boolean existsPersonWithEmail(String email);

    boolean existPersonWithId(Integer customerId);

    void deleteCustomerById(Integer customerId);

    void updateCustomer(Customer update);
}
