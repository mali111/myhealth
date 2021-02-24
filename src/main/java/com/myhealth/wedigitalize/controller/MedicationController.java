package com.myhealth.wedigitalize.controller;

import com.myhealth.wedigitalize.medication.Medication;
import com.myhealth.wedigitalize.medication.repository.MedicationRepository;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MedicationController {
  @Autowired
  MedicationRepository medicationRepository;
@GetMapping("medication")
  public String getMedication(Map<String ,Object> model){
  Medication medication = medicationRepository.findByPznNumber(0631340);

  model.put("medicationName",medication.getMedicationName().toString());
  model.put("medicationPZN",medication.getPznNumber());
  model.put("medicationDosage",medication.getDosage().toString());
  model.put("medicationStartDate",medication.getStartDate().toString());
  model.put("medicationEndDate",medication.getEndDate().toString());
  model.put("medicationActiveIngredient",medication.getActiveIngredient().toString());
  model.put("medicationNotes",medication.getNotes().toString());
  model.put("medicationActive",medication.isActivate());
  model.put("medicationPrescriptionRequired",medication.isPrescriptionRequired());
  return "medication";
  }
}
