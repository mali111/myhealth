package com.myhealth.wedigitalize.patient;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
  // private Vaccine vaccine;
  // private Allergy allergy;
  // public PreviousIllness previousIllness;
  // public Contact emergencyContact;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name = "patientDrugIntollerance_fid", referencedColumnName = "id")
  List<DrugIntollerance> drugIntollerances = new ArrayList<>();

  /*  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name = "patientcontact_fid", referencedColumnName = "id")
  List<Contact> contacts = new ArrayList<>();*/

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
