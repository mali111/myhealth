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

  public Contact(
      String firstname, String lastName, String telephone, String email, String address) {
    this.firstName = firstname;
    this.lastName = lastName;
    this.telephone = telephone;
    this.email = email;
    this.address = address;
  }
}
