package com.myhealth.wedigitalize.patient;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;
@Data
@Entity
public class Patient {
  @Id
  @GeneratedValue
  private long id;
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
//  private List allergies;
  //public Disease diseases;
  // public Contact emergencyContact;

  public Patient(String firstName, String lastName, String dob, String age,
      String gender, String weight, boolean organDonor, String bloodGroup, boolean pregnant,
      String additionalInfo,boolean smoker, String insurance) {
    this.id = id;
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

  public Patient(){}
}
