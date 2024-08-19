package com.example.demo.Repository;


import com.example.demo.Modell.JobReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobReservationRepository extends JpaRepository<JobReservation, Integer> {

        JobReservation findJobReservationById(Integer id);

        List<JobReservation> findByPackageType(String packageType);

        List<JobReservation> findByJobType(String jobType);

        List<JobReservation> findJobReservationByJobTitle(String jobTitle);


}
