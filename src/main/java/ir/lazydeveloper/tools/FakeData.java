package ir.lazydeveloper.tools;

import com.github.javafaker.Faker;
import ir.lazydeveloper.dao.CustomerRepository;
import ir.lazydeveloper.model.Customer;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

@Service
public class FakeData implements ApplicationRunner {
    private final CustomerRepository customerRepository;

    public FakeData(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Faker faker = new Faker();
        for (int i = 0; i < 100; i++) {
//            Customer customer = new Customer();
//            customer.setName(faker.name().firstName());
//            customer.setEmail(faker.internet().emailAddress());
//            customer.setAge(faker.number().numberBetween(18, 99));
//            customerRepository.saveAndFlush(customer);
        }
    }
}
