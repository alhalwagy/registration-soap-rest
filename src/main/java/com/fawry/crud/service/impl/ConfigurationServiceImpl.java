package com.fawry.crud.service.impl;

import com.fawry.crud.entity.Configuration;
import com.fawry.crud.exception.customExceptions.ResourceNotFoundException;
import com.fawry.crud.repository.ConfigurationRepository;
import com.fawry.crud.service.ConfigurationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConfigurationServiceImpl implements ConfigurationService {

  private final ConfigurationRepository configurationRepository;

  public List<Configuration> findAllConfig() {
    return configurationRepository.findAll();
  }

  public Configuration findByKey(String key) {
    return configurationRepository
        .findByKey(key)
        .orElseThrow(() -> new ResourceNotFoundException("Key not found"));

  }

}
