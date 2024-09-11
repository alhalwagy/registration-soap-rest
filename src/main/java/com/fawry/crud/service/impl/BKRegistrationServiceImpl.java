package com.fawry.crud.service.impl;

import com.fawry.crud.dto.BKRegistrationDTO;
import com.fawry.crud.entity.BKRegistration;
import com.fawry.crud.entity.Configuration;
import com.fawry.crud.entity.Customer;
import com.fawry.crud.exception.customExceptions.ResourceNotFoundException;
import com.fawry.crud.mapper.BKRegistrationMapper;
import com.fawry.crud.repository.BKRegistrationRepository;

import com.fawry.crud.repository.ConfigurationRepository;
import com.fawry.crud.repository.CustomerRepository;
import com.fawry.crud.service.BKRegistrationService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BKRegistrationServiceImpl implements BKRegistrationService {

  private final BKRegistrationRepository bkRegistrationRepository;
  private final CustomerRepository customerRepository;
  private final BKRegistrationMapper bkRegistrationMapper;
  private final ConfigurationRepository configurationRepository;

  public List<BKRegistration> findAll(int page, int size) {

    return bkRegistrationRepository.findAll(page, size);
  }

  public BKRegistration findById(Long id) {
    return getById(id)
        .orElseThrow(
            () -> new ResourceNotFoundException("BKRegistration Not Found With id: " + id));
  }

  private Optional<BKRegistration> getById(Long id) {
    return bkRegistrationRepository
            .findById(id);
  }

  public BKRegistration createBkRegistration(BKRegistrationDTO bkRegistrationDTO) {
    System.out.println(bkRegistrationDTO);
    Customer customer =
        customerRepository
            .findById(bkRegistrationDTO.getCustomerId())
            .orElseThrow(() -> new RuntimeException("Customer not found"));

    BKRegistration bkRegistration = bkRegistrationMapper.toEntity(bkRegistrationDTO, customer);
    System.out.println(bkRegistration);
    return bkRegistrationRepository.save(bkRegistration);
  }

  public void deleteById(Long id) {
    bkRegistrationRepository.deleteById(id);
  }

  public BKRegistration updateById(Long id, BKRegistrationDTO bkRegistrationDTO) {
    BKRegistration bkRegistration =
        bkRegistrationRepository
            .findById(id)
            .orElseThrow(
                () -> new ResourceNotFoundException("BKRegistration Not Found With id: " + id));
//
//    bkRegistration.setCompanyName(bkRegistrationDTO.getCompanyName());
//    bkRegistration.setJobTitle(bkRegistrationDTO.getJobTitle());

    return bkRegistrationRepository.save(bkRegistration);
  }

  public BKRegistration createBkRegistrationByConfig(
      String key, BKRegistrationDTO bkRegistrationDTO) {

    Configuration configuration =
        configurationRepository
            .findByKey(key)
            .orElseThrow(() -> new ResourceNotFoundException("Configuration Not Found"));

    if (configuration.getKey().equals("gateway.switch.webservice.url")) {
      Customer customer =
          customerRepository
              .findById(bkRegistrationDTO.getCustomerId())
              .orElseThrow(() -> new RuntimeException("Customer not found"));

      BKRegistration bkRegistration = bkRegistrationMapper.toEntity(bkRegistrationDTO, customer);
      return bkRegistrationRepository.save(bkRegistration);
    }

    throw new ResourceNotFoundException("Configuration Key Not Equal to Gateway Switch Webservice URL: "+"gateway.switch.webservice.url");
  }
}
