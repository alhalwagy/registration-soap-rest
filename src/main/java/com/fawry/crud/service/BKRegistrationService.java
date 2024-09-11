package com.fawry.crud.service;

import com.fawry.crud.dto.BKRegistrationDTO;
import com.fawry.crud.entity.BKRegistration;
import com.fawry.crud.exception.customExceptions.ResourceNotFoundException;

import java.util.List;

public interface BKRegistrationService {

  List<BKRegistration> findAll(int page, int size);

  BKRegistration findById(Long id) throws ResourceNotFoundException;

  BKRegistration createBkRegistration(BKRegistrationDTO bkRegistrationDTO);

  void deleteById(Long id);

  BKRegistration updateById(Long id, BKRegistrationDTO bkRegistrationDTO)
      throws ResourceNotFoundException;

  BKRegistration createBkRegistrationByConfig(String key, BKRegistrationDTO bkRegistrationDTO)
      throws ResourceNotFoundException;
}
