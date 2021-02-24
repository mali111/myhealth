package com.myhealth.wedigitalize.medication.repository;

import com.myhealth.wedigitalize.medication.Medication;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface MedicationRepository extends CrudRepository<Medication, Long> {
List<Medication>findByMedicationName(String medicationName);
Medication findByPznNumber(long pznNumber);
}
