package com.example.demo.Repository;


import com.example.demo.Modell.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findCustomerById(Integer id);

Customer findByCustomerName(String customerName);
Customer findCustomerByPhoneNumber(String phoneNumber);


}
