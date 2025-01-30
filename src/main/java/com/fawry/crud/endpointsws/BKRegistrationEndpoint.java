package com.fawry.crud.endpointsws;

import com.fawry.crud.bkregistration.*;
import com.fawry.crud.dto.BKRegistrationDTO;
import com.fawry.crud.entity.EBPPCORE.BKRegistration;
import com.fawry.crud.mapper.BKRegistrationMapper;
import com.fawry.crud.service.BKRegistrationService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
@RequiredArgsConstructor
public class BKRegistrationEndpoint {

  private static final String NAMESPACE_URI = "http://fawry.com/crud/bkregistration";
  private final BKRegistrationService bkRegistrationService;
  private final HttpServletResponse httpServletResponse;
  private final BKRegistrationMapper bkRegistrationMapper;

  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetRegistrationByIdRequest")
  @ResponsePayload
  public GetRegistrationByIdResponse getRegistrationById(
      @RequestPayload GetRegistrationByIdRequest request) {
    GetRegistrationByIdResponse response = new GetRegistrationByIdResponse();

    BKRegistration bkRegistration = bkRegistrationService.findById(request.getId());
    BKRegistrationResRead bkRegistrationResRead = new BKRegistrationResRead();
    bkRegistrationResRead.setId(bkRegistration.getId());
    bkRegistrationResRead.setRegistrationEmail(bkRegistration.getRegistrationEmail());
    bkRegistrationResRead.setSenderId(bkRegistration.getSender_id());
    response.setBKRegistrationResRead(bkRegistrationResRead);
    return response;
  }

  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetRegistrationsRequest")
  @ResponsePayload
  public GetRegistrationsResponse getRegistrations(
      @RequestPayload GetRegistrationsRequest request) {
    GetRegistrationsResponse response = new GetRegistrationsResponse();
    List<BKRegistration> registrations =
        bkRegistrationService.findAll(request.getPage(), request.getSize());

    List<BKRegistrationResRead> registrationsResRead =
        registrations.stream()
            .filter(bkRegistration -> bkRegistration.getStatusId() != 5)
            .map(
                bkRegistration -> {
                  BKRegistrationResRead bkRegistrationResRead = new BKRegistrationResRead();
                  bkRegistrationResRead.setId(bkRegistration.getId());
                  bkRegistrationResRead.setRegistrationEmail(bkRegistration.getRegistrationEmail());
                  bkRegistrationResRead.setSenderId(bkRegistration.getSender_id());
                  return bkRegistrationResRead;
                })
            .toList();

    response.setBKRegistrationResRead(registrationsResRead);

    return response;
  }

  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "DeleteByIdRequest")
  @ResponsePayload
  public DeleteByIdResponse deleteRegistration(@RequestPayload DeleteByIdRequest request) {

    DeleteByIdResponse response = new DeleteByIdResponse();

    BKRegistration bkRegistration = bkRegistrationService.findById(request.getId());

    bkRegistration.setStatusId(5L);
    response.setMessage("Successfully deleted registration");
    response.setStatus("204 ");
    return response;
  }

  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CreateBKRegistrationRequest")
  @ResponsePayload
  public CreateRegistrationResponse createBKRegistration(
      @RequestPayload CreateBKRegistrationRequest request) {

    System.out.println("yessssssssssssssssssssssssss");

    BKRegistrationResRead bkRegistrationResRead = new BKRegistrationResRead();

    BKRegistrationDTO bkRegistration = bkRegistrationMapper.toDTOFromWS(request);

    BKRegistration newBK = bkRegistrationService.createBkRegistration(bkRegistration);

    bkRegistrationResRead.setId(newBK.getId());
    bkRegistrationResRead.setRegistrationEmail(newBK.getRegistrationEmail());
    bkRegistrationResRead.setSenderId(newBK.getSender_id());

    CreateRegistrationResponse createRegistrationResponse = new CreateRegistrationResponse();
    createRegistrationResponse.setBKRegistrationResRead(bkRegistrationResRead);

    return createRegistrationResponse;
  }

  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "UpdateBKRegistrationRequest")
  @ResponsePayload
  public UpdateRegistrationResponse updateBKRegistration(
      @RequestPayload UpdateBKRegistrationRequest request) {
    UpdateRegistrationResponse response = new UpdateRegistrationResponse();

    BKRegistrationDTO bkRegistrationDTO =
        BKRegistrationDTO.builder()
            .companyName(request.getCompanyName())
            .jobTitle(request.getJobTitle())
            .build();

    BKRegistration bkRegistration =
        bkRegistrationService.updateById(request.getId(), bkRegistrationDTO);

    BKRegistrationResReadUpdate bkRegistrationResRead = new BKRegistrationResReadUpdate();
    bkRegistrationResRead.setId(bkRegistration.getId());
    bkRegistrationResRead.setRegistrationEmail(bkRegistration.getRegistrationEmail());
    bkRegistrationResRead.setSenderId(bkRegistration.getSender_id());
    bkRegistrationResRead.setStatusId(bkRegistration.getStatusId());
    bkRegistrationResRead.setCompanyName(bkRegistration.getCompanyName());
    bkRegistrationResRead.setJobTitle(bkRegistration.getJobTitle());

    response.setBKRegistrationResReadUpdate(bkRegistrationResRead);
    return response;
  }
}
