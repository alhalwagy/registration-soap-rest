package com.fawry.crud.entity;

import com.fawry.crud.entity.compositePK.ConfigurationId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "CONFIGURATION", schema = "EBPP_CONFIGURATION")
@IdClass(ConfigurationId.class)
public class Configuration implements Serializable {

  @Id
  @Column(name = "CATEGORY", nullable = false)
  private String category;

  @Id
  @Column(name = "KEY", nullable = false)
  private String key;

  @Column(name = "NAME_PRIMARY_LANG")
  private String namePrimaryLang;

  @Column(name = "NAME_SECONDARY_LANG")
  private String nameSecondaryLang;
}
