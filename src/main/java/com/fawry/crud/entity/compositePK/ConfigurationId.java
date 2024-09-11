package com.fawry.crud.entity.compositePK;

import lombok.Data;

@Data
public class ConfigurationId {

  private String category;
  private String key;

  public ConfigurationId() {}

  public ConfigurationId(String category, String key) {
    this.category = category;
    this.key = key;
  }
}
