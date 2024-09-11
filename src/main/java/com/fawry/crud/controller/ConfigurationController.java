package com.fawry.crud.controller;

import com.fawry.crud.entity.Configuration;
import com.fawry.crud.service.ConfigurationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/configurations")
@RequiredArgsConstructor
public class ConfigurationController {
  private final ConfigurationService configurationService;

  @GetMapping("/by-key")
  public Configuration getConfigurationByKey(@RequestParam("key") String key) {
    return configurationService.findByKey(key);
  }

  @GetMapping("/")
  public List<Configuration> getConfiguration() {
    return configurationService.findAllConfig();
  }
}
