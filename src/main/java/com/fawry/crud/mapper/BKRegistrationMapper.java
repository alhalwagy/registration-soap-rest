package com.fawry.crud.mapper;

import com.fawry.crud.bkregistration.CreateBKRegistrationRequest;
import com.fawry.crud.dto.BKRegistrationDTO;
import com.fawry.crud.entity.EBPPCORE.BKRegistration;
import com.fawry.crud.entity.EBPPCORE.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BKRegistrationMapper {


  @Mapping(source = "registrationDTO.creationDate", target = "creationDate")
  @Mapping(source = "registrationDTO.lastModificationDate", target = "lastModificationDate")
  @Mapping(target = "id", ignore = true)
  BKRegistration toEntity(BKRegistrationDTO registrationDTO, Customer customer);

  @Mapping(target = "sender_id",source = "createBKRegistrationRequest.senderId")
  BKRegistrationDTO toDTOFromWS (CreateBKRegistrationRequest createBKRegistrationRequest);
}
