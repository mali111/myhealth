package com.myhealth.wedigitalize;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

import com.myhealth.wedigitalize.medication.Medication;
import com.myhealth.wedigitalize.medication.repository.MedicationRepository;
import com.myhealth.wedigitalize.patient.DrugIntollerance;
import com.myhealth.wedigitalize.patient.Patient;
import com.myhealth.wedigitalize.patient.repository.PatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyhealthApplication extends SpringBootServletInitializer {

  @Autowired PatientRepository patientRepository;
  private static final Logger log = LoggerFactory.getLogger(MyhealthApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(MyhealthApplication.class, args);
  }

  @Bean
  CommandLineRunner runner(PatientRepository repository) {
    return args -> {
      Patient patient1 =
          new Patient(
              "max",
              "mustermann",
              "2.02.1990",
              "26",
              "male",
              "80kg",
              TRUE,
              "A+ve",
              FALSE,
              "No information",
              false,
              "Private");
      DrugIntollerance drugIntollerance = new DrugIntollerance("penicillin", "26.02.2020");
      DrugIntollerance drugIntollerance1 = new DrugIntollerance("Lactonse", "2.02.2021");

      patient1.getDrugIntollerances().add(drugIntollerance);
      patient1.getDrugIntollerances().add(drugIntollerance1);
      this.patientRepository.save(patient1);

      repository.save(
          new Patient(
              "max",
              "mustermann",
              "2.02.1990",
              "26",
              "male",
              "80kg",
              TRUE,
              "A+ve",
              FALSE,
              "No information",
              false,
              "Private"));

      repository.save(
          new Patient(
              "Rania",
              "Khawar",
              "2.02.2019",
              "2",
              "Female",
              "8kg",
              FALSE,
              "B+ve",
              FALSE,
              "I am a baby",
              false,
              "Techniker Krankenkasse"));
      repository.save(
          new Patient(
              "Rehan",
              "Khawar",
              "2.02.2018",
              "9",
              "male",
              "18kg",
              FALSE,
              "A-ve",
              FALSE,
              "Going to school",
              false,
              "AOK"));

      // fetch all Patients
      log.info("Patients found with findall();");
      for (Patient patient : repository.findAll()) {
        log.info(patient.toString());
      }
      log.info("Log ends here");
    };
  }

  @Bean
  CommandLineRunner runner2(MedicationRepository repository) {
    return args -> {
      repository.save(
          new Medication(
              0631340,
              "Ibuflam",
              "17.02.2021",
              "17.04.2021",
              TRUE,
              "Morning",
              "Ibuprofen",
              TRUE,
              "some information"));
      repository.save(
          new Medication(
              0631341,
              "Paracetamol",
              "15.01.2021",
              "12.02.2021",
              TRUE,
              "Noon",
              "Panadol",
              FALSE,
              "Whenever Needed"));
      repository.save(
          new Medication(
              0631342,
              "Aspirin",
              "11.01.2021",
              "30.01.2021",
              FALSE,
              "Night",
              "Acetylsalicylsäure",
              FALSE,
              "i am allergic to it"));

      // fetch all Patients
      log.info("Patients found with findall();");
      for (Medication medication : repository.findAll()) {
        log.info(medication.toString());
      }
      log.info("Log ends here");
    };
  }
}
