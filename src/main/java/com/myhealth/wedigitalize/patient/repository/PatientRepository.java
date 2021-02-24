package com.myhealth.wedigitalize.patient.repository;

import com.myhealth.wedigitalize.patient.Patient;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient,Long> {
  List<Patient> findByLastName(String lastName);
  Patient findById(long id);
}
