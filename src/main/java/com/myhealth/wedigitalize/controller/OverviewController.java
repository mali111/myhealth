package com.myhealth.wedigitalize.controller;

import com.myhealth.wedigitalize.medication.Medication;
import com.myhealth.wedigitalize.medication.repository.MedicationRepository;
import com.myhealth.wedigitalize.patient.Patient;
import com.myhealth.wedigitalize.patient.repository.DrugIntolleranceRepository;
import com.myhealth.wedigitalize.patient.repository.PatientRepository;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OverviewController {
  @Autowired PatientRepository patientRepository;
  @Autowired MedicationRepository medicationRepository;
  @Autowired DrugIntolleranceRepository drugIntolleranceRepository;

  @GetMapping("overview")
  public String showAll(Map<String, Object> model, Model drugInt) {
    // General Patient Data
    Patient patient = patientRepository.findById(2);
    model.put("firstName", patient.getFirstName().toString());
    model.put("lastName", patient.getLastName().toString());
    model.put("dob", patient.getDob().toString());
    model.put("age", patient.getAge().toString());
    model.put("gender", patient.getGender().toString());
    model.put("bloodGroup", patient.getBloodGroup().toString());
    model.put("weight", patient.getWeight().toString());
    model.put("organDonor", patient.isOrganDonor());
    model.put("pregnant", patient.isPregnant());
    model.put("smoker", patient.isSmoker());
    model.put("insurance", patient.getInsurance());
    model.put("additionalInfo", patient.getAdditionalInfo());
    // drug Intollerance List
    drugInt.addAttribute("drugIntollerances", drugIntolleranceRepository.findAll());
    // Medication Data
    Medication medication = medicationRepository.findByPznNumber(0631340);
    model.put("medicationName", medication.getMedicationName().toString());
    model.put("medicationPZN", medication.getPznNumber());
    model.put("medicationDosage", medication.getDosage().toString());
    model.put("medicationStartDate", medication.getStartDate().toString());
    model.put("medicationEndDate", medication.getEndDate().toString());
    model.put("medicationActiveIngredient", medication.getActiveIngredient().toString());
    model.put("medicationNotes", medication.getNotes().toString());
    model.put("medicationActive", medication.isActivate());
    model.put("medicationPrescriptionRequired", medication.isPrescriptionRequired());

    return "overview";
  }
}
