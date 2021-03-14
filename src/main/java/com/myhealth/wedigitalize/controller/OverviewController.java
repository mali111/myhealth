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
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    model.put("age", patient.getEmail().toString());
    model.put("gender", patient.getGender().toString());
    model.put("bloodGroup", patient.getBloodGroup().toString());
    model.put("weight", patient.getReTypePassword().toString());
    model.put("organDonor", patient.isOrganDonor());
    model.put("pregnant", patient.isPregnant());
    model.put("smoker", patient.isSmoker());
    model.put("insurance", patient.getPassword());
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
    model.put("age", patient.getEmail().toString());
    model.put("gender", patient.getGender().toString());
    model.put("bloodGroup", patient.getBloodGroup().toString());
    model.put("weight", patient.getReTypePassword().toString());
    model.put("organDonor", patient.isOrganDonor());
    model.put("pregnant", patient.isPregnant());
    model.put("smoker", patient.isSmoker());
    model.put("insurance", patient.getPassword());
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

  @RequestMapping(value = "/registration", method = RequestMethod.POST)
  public String submit(
      @Valid @ModelAttribute("patient") Patient patient, BindingResult result, ModelMap model) {
    if (result.hasErrors()) {
      return "error";
    }
    model.addAttribute("firstname", patient.getFirstName());
    model.addAttribute("lastname", patient.getLastName());
    model.addAttribute("dob", patient.getDob().toString());

    model.addAttribute("email", patient.getEmail().toString());
    model.addAttribute("password", patient.getPassword());
    model.addAttribute("reTypePassword", patient.getReTypePassword().toString());

    model.addAttribute("gender", patient.getGender().toString());
    model.addAttribute("bloodGroup", patient.getBloodGroup().toString());
    model.addAttribute("organDonor", patient.isOrganDonor());

    model.addAttribute("pregnant", patient.isPregnant());
    model.addAttribute("smoker", patient.isSmoker());
    model.addAttribute("additionalInfo", patient.getAdditionalInfo());
    patientRepository.save(patient);
    return "registration";
  }

  @RequestMapping(value = "/registration", method = RequestMethod.GET)
  public String showPatient(Model model) {
    model.addAttribute("patient", new Patient());
    return "registration";
  }
}
