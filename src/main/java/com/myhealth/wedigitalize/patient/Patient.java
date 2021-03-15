package com.myhealth.wedigitalize.patient;

import com.myhealth.wedigitalize.medication.Medication;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
  private String email;
  private String password;
  private String reTypePassword;
  private boolean OrganDonor;
  private String bloodGroup;
  private boolean pregnant;
  private boolean smoker;
  private String additionalInfo;

  @Enumerated(EnumType.STRING)
  private Gender gender;

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
      String email,
      Gender gender,
      String reTypePassword,
      boolean organDonor,
      String bloodGroup,
      boolean pregnant,
      String additionalInfo,
      boolean smoker,
      String password) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.dob = dob;
    this.email = email;
    this.gender = gender;
    this.reTypePassword = reTypePassword;
    this.OrganDonor = organDonor;
    this.bloodGroup = bloodGroup;
    this.pregnant = pregnant;
    this.additionalInfo = additionalInfo;
    this.smoker = smoker;
    this.password = password;
  }
}
