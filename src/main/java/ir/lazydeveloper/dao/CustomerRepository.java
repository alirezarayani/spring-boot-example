package ir.lazydeveloper.dao;

import ir.lazydeveloper.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    boolean existsCustomerByEmail(String email);

    boolean existsCustomerById(Integer id);
}
