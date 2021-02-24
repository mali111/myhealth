package com.myhealth.wedigitalize.controller;

import com.myhealth.wedigitalize.patient.Patient;
import com.myhealth.wedigitalize.patient.repository.PatientRepository;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OverviewController {
 @Autowired
 PatientRepository patientRepository;

@GetMapping("overview")
public String getOverview(Map<String ,Object> model) {
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
  return "overview";
  }
}
