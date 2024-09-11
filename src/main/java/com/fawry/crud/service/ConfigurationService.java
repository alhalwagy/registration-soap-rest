package com.fawry.crud.service;

import com.fawry.crud.entity.Configuration;
import com.fawry.crud.exception.customExceptions.ResourceNotFoundException;

import java.util.List;

public interface ConfigurationService {

  List<Configuration> findAllConfig();

  Configuration findByKey(String key) throws ResourceNotFoundException;
}
