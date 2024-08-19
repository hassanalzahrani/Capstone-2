package com.example.demo.Service;

import com.example.demo.Api.ApiException;
import com.example.demo.Modell.Bill;
import com.example.demo.Modell.Craftsman;
import com.example.demo.Modell.Customer;
import com.example.demo.Modell.JobReservation;
import com.example.demo.Repository.BillRepository;
import com.example.demo.Repository.CraftsmanRepository;
import com.example.demo.Repository.CustomerRepository;
import com.example.demo.Repository.JobReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JobReservationService {
    private final JobReservationRepository jobReservationRepository;
private final CustomerRepository customerRepository;
private final BillRepository billRepository;
private final CraftsmanRepository craftsmanRepository;

////===========================================================================================
    public JobReservation saveJobReservation(JobReservation jobReservation) {

        int total = 1;
        Craftsman c = craftsmanRepository.findCraftsmanById(jobReservation.getCraftsManId());
        Customer custemor = customerRepository.findCustomerById(jobReservation.getCustomerId());
        if (c == null) {
            throw new ApiException("Craftsman not found");
        }
        if (custemor == null) {
            throw new ApiException("Customer not found");
        }
        if (jobReservation.getPackageType().equalsIgnoreCase("yearly")) {
            total = jobReservation.getJobCost();
            if (jobReservation.getPackageType().equalsIgnoreCase("one time")) {
                total = jobReservation.getJobCost() * 12;
            }
        }

        if (jobReservation.getPackageType().equalsIgnoreCase("one time")) {
            total = jobReservation.getJobCost();
        }

        Bill bill = new Bill();
        bill.setCraftsmanId(c.getId());
        bill.setCustomerId(c.getId());
        bill.setCost(bill.getCost() + total);
        bill.setBillId(bill.getBillId());

        return jobReservationRepository.save(jobReservation);
    }

    ///=================================================================================================

    public List<JobReservation> getAllJobReservations() {
        return jobReservationRepository.findAll();
    }

    public JobReservation getJobReservationById(int id) {
        return jobReservationRepository.findById(id).orElseThrow(() -> new ApiException("JobReservation not found"));
    }

    public void deleteJobReservation(int id) {
        JobReservation jobReservation = jobReservationRepository.findById(id).orElseThrow(() -> new ApiException("JobReservation not found"));
        jobReservationRepository.delete(jobReservation);
    }

    public void updateJobReservation(int id, JobReservation jobReservation) {
        JobReservation existingJobReservation = jobReservationRepository.findById(id).orElseThrow(() -> new ApiException("JobReservation not found"));
        existingJobReservation.setJobTitle(jobReservation.getJobTitle());
        existingJobReservation.setJobType(jobReservation.getJobType());
        existingJobReservation.setJobCost(jobReservation.getJobCost());
        existingJobReservation.setJobDescription(jobReservation.getJobDescription());
        existingJobReservation.setPackageType(jobReservation.getPackageType());
        jobReservationRepository.save(existingJobReservation);
    }


    public List<JobReservation> getJobReservationsByType(String jopType) {
        return jobReservationRepository.findByJobType(jopType);
    }


    public List<JobReservation> getAllJobReservationsByJopTitle(String jopTitle){

        List<JobReservation> jobReservations =jobReservationRepository.findJobReservationByJobTitle(jopTitle);
        if(jobReservations == null){
            throw new ApiException("job title not found");

        }
        return jobReservations;

    }

}
