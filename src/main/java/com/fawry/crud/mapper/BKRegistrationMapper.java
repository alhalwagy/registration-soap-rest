package com.fawry.crud.mapper;

import com.fawry.crud.dto.BKRegistrationDTO;
import com.fawry.crud.entity.BKRegistration;
import com.fawry.crud.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BKRegistrationMapper {

    @Mapping(target = "customer", source = "customer")
    @Mapping(source = "registrationDTO.creationDate", target = "creationDate")
    @Mapping(source = "registrationDTO.lastModificationDate", target = "lastModificationDate")
    @Mapping(target = "id", ignore = true)
    BKRegistration toEntity(BKRegistrationDTO registrationDTO, Customer customer);
}