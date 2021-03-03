package com.myhealth.wedigitalize.controller;

import com.myhealth.wedigitalize.patient.Patient;
import com.myhealth.wedigitalize.patient.repository.PatientRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class patientController {
  @Autowired PatientRepository patientRepository;

  @GetMapping("all-patients")
  public Iterable<Patient> getAllPatients() {
    Iterable<Patient> allPatients = new ArrayList<>();

    allPatients = patientRepository.findAll();
    return allPatients;
  }
}
