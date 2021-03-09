package com.myhealth.wedigitalize.patient;

import com.myhealth.wedigitalize.medication.Medication;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Patient {
  @Id @GeneratedValue private long id;
  private String firstName;
  private String lastName;
  private String dob;
  private String age;
  private String gender;
  private String weight;
  private boolean OrganDonor;
  private String bloodGroup;
  private boolean pregnant;
  private boolean smoker;
  private String additionalInfo;
  private String insurance;

  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "patientDrugIntollerance_fid", referencedColumnName = "id")
  List<DrugIntollerance> drugIntollerances = new ArrayList<>();

  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "patientcontact_fid", referencedColumnName = "id")
  List<Contact> contacts = new ArrayList<>();

  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "pc-fid", referencedColumnName = "id")
  List<Vaccine> vaccines = new ArrayList<>();

  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "pa-fid", referencedColumnName = "id")
  List<Allergy> allergies = new ArrayList<>();

  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "pp-fid", referencedColumnName = "id")
  List<PreviousIllness> previousIllnesses = new ArrayList<>();

  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "pm-fid", referencedColumnName = "id")
  List<Medication> medications = new ArrayList<>();

  public Patient(
      String firstName,
      String lastName,
      String dob,
      String age,
      String gender,
      String weight,
      boolean organDonor,
      String bloodGroup,
      boolean pregnant,
      String additionalInfo,
      boolean smoker,
      String insurance) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.dob = dob;
    this.age = age;
    this.gender = gender;
    this.weight = weight;
    this.OrganDonor = organDonor;
    this.bloodGroup = bloodGroup;
    this.pregnant = pregnant;
    this.additionalInfo = additionalInfo;
    this.smoker = smoker;
    this.insurance = insurance;
  }
}
