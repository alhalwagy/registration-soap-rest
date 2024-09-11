package com.fawry.crud.controller;

import com.fawry.crud.dto.BKRegistrationDTO;
import com.fawry.crud.entity.BKRegistration;
import com.fawry.crud.service.BKRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bk-registrations")
@RequiredArgsConstructor
public class BKRegistrationController {

  private final BKRegistrationService bkRegistrationService;

  @GetMapping("/")
  public List<BKRegistration> getBKRegistration(
      @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
    return bkRegistrationService.findAll(page, size);
  }

  @GetMapping("{id}")
  public BKRegistration getBKRegistration(@PathVariable Long id) {
    return bkRegistrationService.findById(id);
  }

  @PostMapping("/")
  public BKRegistration createBKRegistration(@RequestBody BKRegistrationDTO bkRegistration) {
    return bkRegistrationService.createBkRegistration(bkRegistration);
  }

  @DeleteMapping("{id}")
  public void deleteBKRegistration(@PathVariable Long id) {
    bkRegistrationService.deleteById(id);
  }

  @PutMapping("{id}")
  public BKRegistration updateBKRegistration(
      @PathVariable Long id, @RequestBody BKRegistrationDTO bkRegistration) {
    return bkRegistrationService.updateById(id, bkRegistration);
  }

  @PostMapping("/creaty-by-config")
  public BKRegistration createBKRegistrationByConfig(
      @RequestParam("key") String key, @RequestBody BKRegistrationDTO bkRegistrationDTO) {

    return bkRegistrationService.createBkRegistrationByConfig(key, bkRegistrationDTO);
  }
}
