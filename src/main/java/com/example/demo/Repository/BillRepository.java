package com.example.demo.Repository;

import com.example.demo.Modell.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {



Bill findBillByBillId(Integer billId);
}
