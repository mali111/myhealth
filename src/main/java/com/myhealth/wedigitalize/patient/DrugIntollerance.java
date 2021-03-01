package com.myhealth.wedigitalize.patient;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class DrugIntollerance {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String name;
  private String knownSince;

  public DrugIntollerance() {}
  ;

  public DrugIntollerance(String name, String knownSince) {
    this.name = name;
    this.knownSince = knownSince;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getKnownSince() {
    return knownSince;
  }

  public void setKnownSince(String knownSince) {
    this.knownSince = knownSince;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }
}
