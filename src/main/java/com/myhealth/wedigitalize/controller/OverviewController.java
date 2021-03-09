package com.myhealth.wedigitalize.controller;

import com.myhealth.wedigitalize.medication.repository.MedicationRepository;
import com.myhealth.wedigitalize.patient.Patient;
import com.myhealth.wedigitalize.patient.repository.AllergyRepository;
import com.myhealth.wedigitalize.patient.repository.ContactRepository;
import com.myhealth.wedigitalize.patient.repository.DrugIntolleranceRepository;
import com.myhealth.wedigitalize.patient.repository.PatientRepository;
import com.myhealth.wedigitalize.patient.repository.PreviousIllnessesRepository;
import com.myhealth.wedigitalize.patient.repository.VaccineRepository;
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
  @Autowired ContactRepository contactRepository;
  @Autowired VaccineRepository vaccineRepository;
  @Autowired AllergyRepository allergyRepository;
  @Autowired PreviousIllnessesRepository previousIllnessesRepository;

  @GetMapping("overview")
  public String showAll(
      Map<String, Object> model,
      Model drugInt,
      Model contact,
      Model vaccine,
      Model allergy,
      Model previousIllness,
      Model medication) {
    // General Patient Data
    Patient patient = patientRepository.findById(1);
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
    // contacts list
    contact.addAttribute("contacts", contactRepository.findAll());
    // vaccine list
    vaccine.addAttribute("vaccines", vaccineRepository.findAll());
    // Allergy List
    allergy.addAttribute("allergies", allergyRepository.findAll());
    // Pervious Illness List
    previousIllness.addAttribute("previousIllnesses", previousIllnessesRepository.findAll());
    // Medication Data

    medication.addAttribute("medications", medicationRepository.findAll());
    return "overview";
  }

  @GetMapping("firstAidOverview")
  public String firstAidOverview(
      Map<String, Object> model,
      Model drugInt,
      Model contact,
      Model vaccine,
      Model allergy,
      Model previousIllness) {
    // General Patient Data
    Patient patient = patientRepository.findById(1);
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
    // contacts list
    contact.addAttribute("contacts", contactRepository.findAll());
    // vaccine list
    vaccine.addAttribute("vaccines", vaccineRepository.findAll());
    // Allergy List
    allergy.addAttribute("allergies", allergyRepository.findAll());
    // Pervious Illness List
    previousIllness.addAttribute("previousIllnesses", previousIllnessesRepository.findAll());

    return "firstAidOverview";
  }
}
