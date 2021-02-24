package com.myhealth.wedigitalize.medication;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Medication {
  @Id
  private long pznNumber;
  private String medicationName;
  private String startDate;
  private String endDate;
  private boolean activate;
  // Morgen, Mittag, Abend
  private String dosage;
  //wirkstoff
  private String activeIngredient;
  private boolean prescriptionRequired;
  private String notes;

  public Medication(long pznNumber, String medicationName, String startDate, String endDate,
      boolean activate, String dosage, String activeIngredient, boolean prescriptionRequired,
      String notes) {
    this.pznNumber = pznNumber;
    this.medicationName = medicationName;
    this.startDate = startDate;
    this.endDate = endDate;
    this.activate = activate;
    this.dosage = dosage;
    this.activeIngredient = activeIngredient;
    this.prescriptionRequired = prescriptionRequired;
    this.notes = notes;
  }
  public Medication(){}
}
