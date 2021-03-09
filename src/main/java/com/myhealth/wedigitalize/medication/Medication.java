package com.myhealth.wedigitalize.medication;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medication {
  @Id private long pznNumber;
  private String medicationName;
  private String startDate;
  private String endDate;
  private boolean activate;
  // Morgen, Mittag, Abend
  private String dosage;
  // wirkstoff
  private String activeIngredient;
  private boolean prescriptionRequired;
  private String notes;
}
