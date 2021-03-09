package com.myhealth.wedigitalize;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

import com.myhealth.wedigitalize.medication.Medication;
import com.myhealth.wedigitalize.patient.Allergy;
import com.myhealth.wedigitalize.patient.Contact;
import com.myhealth.wedigitalize.patient.DrugIntollerance;
import com.myhealth.wedigitalize.patient.Patient;
import com.myhealth.wedigitalize.patient.PreviousIllness;
import com.myhealth.wedigitalize.patient.Vaccine;
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
              "Elon",
              "Musk",
              "28.07.1971",
              "50",
              "male",
              "80kg",
              TRUE,
              "A+ve",
              FALSE,
              "No information",
              false,
              "AOK");
      DrugIntollerance drugIntollerance = new DrugIntollerance("penicillin", "26.02.2020");
      DrugIntollerance drugIntollerance1 = new DrugIntollerance("Lactose", "2.02.2021");

      patient1.getDrugIntollerances().add(drugIntollerance);
      patient1.getDrugIntollerances().add(drugIntollerance1);

      Contact contact =
          new Contact(
              "Justine",
              "Musk",
              "01526548654",
              "justinemusk@gmail.com",
              "39 Nichols Lane" + "Brooklyn, NY 11201");
      Contact contact2 =
          new Contact(
              "Talulah ",
              "Riley",
              "015265445",
              "talulahriley@hotmail.com",
              "1 Big Rock Cove Ave." + "New York, NY 10034");

      patient1.getContacts().add(contact);
      patient1.getContacts().add(contact2);

      Vaccine vaccine = new Vaccine("Corona", "15.03.2021");
      Vaccine vaccine2 = new Vaccine("Polio", "12.01.2001");
      Vaccine vaccine3 = new Vaccine("Hepatitis-B", "1.12.2005");
      patient1.getVaccines().add(vaccine);
      patient1.getVaccines().add(vaccine2);
      patient1.getVaccines().add(vaccine3);

      Allergy allergy = new Allergy("pollins", "10.01.2020");
      Allergy allergy1 = new Allergy("Milk", "01.01.1998");
      patient1.getAllergies().add(allergy);
      patient1.getAllergies().add(allergy1);

      PreviousIllness previousIllness = new PreviousIllness("Diabetis", "01.01.2005");
      PreviousIllness previousIllness1 = new PreviousIllness("Low Blood Pressure", "07.01.2010");
      patient1.getPreviousIllnesses().add(previousIllness);
      patient1.getPreviousIllnesses().add(previousIllness1);

      Medication medication =
          new Medication(
              0631340,
              "Ibuflam",
              "17.02.2021",
              "17.04.2021",
              TRUE,
              "Morning",
              "Ibuprofen",
              TRUE,
              "icreases my BP");
      Medication medication1 =
          new Medication(
              0532340,
              "Aspirin",
              "17.01.2020",
              "Continue",
              TRUE,
              "Night",
              "Acetylsalicylsäure ",
              TRUE,
              "only when needed");
      patient1.getMedications().add(medication);
      patient1.getMedications().add(medication1);

      this.patientRepository.save(patient1);

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

  /*@Bean
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
  }*/
}
