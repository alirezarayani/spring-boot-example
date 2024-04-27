package ir.lazydeveloper.controller;

import ir.lazydeveloper.model.Customer;
import ir.lazydeveloper.model.CustomerRegistrationRequest;
import ir.lazydeveloper.model.CustomerUpdateRequest;
import ir.lazydeveloper.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllStudents() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getByIdd(@PathVariable int id) {
        return customerService.getCustomer(id);
    }

    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrationRequest request) {
        customerService.add(request);
    }

    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer customerId) {
        customerService.deleteCustomerById(customerId);
    }

    @PutMapping("{customerId}")
    public void deleteCustomer(@RequestBody CustomerUpdateRequest customerUpdateRequest,@PathVariable("customerId") Integer customerId) {
        customerService.updateCustomer(customerUpdateRequest,customerId);
    }

}

