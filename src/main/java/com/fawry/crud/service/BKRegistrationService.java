package com.fawry.crud.service;

import com.fawry.crud.dto.BKRegistrationDTO;
import com.fawry.crud.entity.BKRegistration;
import com.fawry.crud.entity.Customer;
import com.fawry.crud.exception.customExceptions.ResourceNotFoundException;
import com.fawry.crud.mapper.BKRegistrationMapper;
import com.fawry.crud.repository.BKRegistrationRepository;

import com.fawry.crud.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BKRegistrationService {

  private final BKRegistrationRepository bkRegistrationRepository;
  private final CustomerRepository customerRepository;
  private final BKRegistrationMapper bkRegistrationMapper;

  public List<BKRegistration> findAll(int page, int size) {

    return bkRegistrationRepository.findAll(page, size);
  }

  public BKRegistration findById(Long id) {
    return bkRegistrationRepository
        .findById(id)
        .orElseThrow(
            () -> new ResourceNotFoundException("BKRegistration Not Found With id: " + id));
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
    BKRegistration bkRegistration = bkRegistrationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("BKRegistration Not Found With id: " + id));

    bkRegistration.setCompanyName(bkRegistrationDTO.getCompanyName());
    bkRegistration.setJobTitle(bkRegistrationDTO.getJobTitle());

    return bkRegistrationRepository.save(bkRegistration);
  }
}
