package com.fawry.crud.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity(name = "CUSTOMERS")
@Data
public class Customer { // Replace with your entity class name

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", nullable = false)
  private Long id;

  @Column(name = "CUSTOMER_TYPE_ID", nullable = false)
  private Long customerTypeId;

  @Column(name = "NATIONALITY_ID", nullable = false)
  private Long nationalityId;

  @Column(name = "CFN", length = 32)
  private String cfn;

  @Column(name = "NAME_PRIMARY_LANG", length = 200)
  private String namePrimaryLang;

  @Column(name = "NAME_SECONDARY_LANG", length = 200)
  private String nameSecondaryLang;

  @Column(name = "CREATION_DATE", nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private LocalDateTime creationDate;

  @Column(name = "LAST_MODIFICATION_DATE", nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private LocalDateTime lastModificationDate;

  @Column(name = "LAST_NAME_PRIMARY_LANG", length = 200)
  private String lastNamePrimaryLang;

  @Column(name = "LAST_NAME_SECONDARY_LANG", length = 200)
  private String lastNameSecondaryLang;

  @Column(name = "BIRTH_DATE")
  @Temporal(TemporalType.TIMESTAMP)
  private LocalDateTime birthDate;

  @Column(name = "IS_TRUSTED_REG", length = 1)
  private String isTrustedReg;

  @Column(name = "GENDER", length = 1)
  private String gender;

  @Column(name = "MARTIAL_STATUS")
  private Long maritalStatus;

  @Column(name = "MIDDLE_NAME", length = 200)
  private String middleName;

  @Column(name = "MOTHER_FIRST_NAME", length = 200)
  private String motherFirstName;

  @Column(name = "MOTHER_MIDDLE_NAME", length = 200)
  private String motherMiddleName;

  @Column(name = "MOTHER_LAST_NAME", length = 200)
  private String motherLastName;

  @Column(name = "OTHER_NATIONALITY_ID")
  private Long otherNationalityId;

  @Column(name = "BIRTH_PLACE_CITY", length = 50)
  private String birthPlaceCity;

  @Column(name = "BIRTH_PLACE_COUNTRY", length = 50)
  private String birthPlaceCountry;

  @Column(name = "BUSINESS_DOMAIN", length = 128)
  private String businessDomain;
}
