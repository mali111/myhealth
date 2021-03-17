package com.myhealth.wedigitalize.patient;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String firstName;
  private String lastName;
  private String telephone;
  private String email;
  private String address;
  private String address2;
  private String city;
  private String state;
  private String zip;
  private String country;

  public Contact(
      String firstName,
      String lastName,
      String telephone,
      String email,
      String address,
      String address2,
      String city,
      String state,
      String zip,
      String country) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.telephone = telephone;
    this.email = email;
    this.address = address;
    this.address2 = address2;
    this.city = city;
    this.state = state;
    this.zip = zip;
    this.country = country;
  }
}
