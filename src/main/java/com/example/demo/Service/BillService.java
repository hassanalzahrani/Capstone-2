package com.example.demo.Service;

import com.example.demo.Api.ApiException;
import com.example.demo.Modell.Bill;
import com.example.demo.Repository.BillRepository;
import com.example.demo.Repository.CraftsmanRepository;
import com.example.demo.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BillService {
    private final BillRepository billRepository;

    public Bill saveBill(Bill bill) {
        return billRepository.save(bill);
    }

    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    public Bill getBillById(int id) {
        return billRepository.findBillByBillId(id);
    }

    public void deleteBill(int id) {

        Bill bill = billRepository.findBillByBillId(id);
        if (bill == null) {
            throw new ApiException("Bill does not exist");
        }
        billRepository.delete(bill);
    }

    public void updateBill(int id, Bill bill) {

        Bill existingBill = billRepository.findBillByBillId(id);
        if (existingBill == null) {
            throw new ApiException("Bill does not exist");
        }
        existingBill.setCost(bill.getCost());
        existingBill.setDiscount(bill.getDiscount());
        existingBill.setPaymentType(bill.getPaymentType());
        billRepository.save(existingBill);
    }



    private final CraftsmanRepository craftsmanRepository;
    private final CustomerRepository customerRepository;


}
