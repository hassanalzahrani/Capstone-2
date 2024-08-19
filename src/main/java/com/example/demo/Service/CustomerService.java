package com.example.demo.Service;

import com.example.demo.Api.ApiException;
import com.example.demo.Modell.Customer;
import com.example.demo.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer) {

        Customer c=customerRepository.save(customer);
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(int id) {
        return customerRepository.findById(id).orElseThrow(() -> new ApiException("Customer not found"));
    }

    public void deleteCustomer(int id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ApiException("Customer not found"));
        customerRepository.delete(customer);
    }

    public void updateCustomer(int id, Customer customer) {
        Customer existingCustomer = customerRepository.findById(id).orElseThrow(() -> new ApiException("Customer not found"));
        existingCustomer.setCustomerEmail(customer.getCustomerEmail());
        existingCustomer.setCustomerLocation(customer.getCustomerLocation());
        customerRepository.save(existingCustomer);
    }

    public Customer getCustomerByName(String name) {

        return customerRepository.findByCustomerName(name);
    }

    public Customer getCustomerByPhone(String phone) {
        return customerRepository.findCustomerByPhoneNumber(phone);
    }

}
