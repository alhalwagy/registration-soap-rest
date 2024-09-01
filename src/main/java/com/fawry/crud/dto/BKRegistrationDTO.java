package com.fawry.crud.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BKRegistrationDTO {

    private Long customerId;
    private Long statusId;
    private Long sender_id;
    private Long bankBranchId;
    private Long preferredAppLangId;
    private Long preferredNotificationLangId;
    private String defaultSof;
    private LocalDateTime deactivationDate;
    private String deactivationReason;
    private LocalDateTime registrationDate;
    private LocalDateTime creationDate;
    private LocalDateTime lastModificationDate;
    private String cif;
    private Double trxMaxAmount;
    private LocalDateTime lastLoginDate;
    private Character isLogedOn;
    private Character isAutoArchiveEnable;
    private String autoArchivePeriod;
    private Long userCategoryId;
    private Character creditCardEnabled;
    private String loginUsername;
    private String activationCode;
    private Character pmtAttemptFlag;
    private LocalDateTime activationDate;
    private String registrationEmail;
    private String registrationMobile;
    private Long dashboardViewingTypeId;
    private String customerIp;
    private String cspChannelId;
    private Long kycLevelId;
    private String jobTitle;
    private Double monthlySalary;
    private String memo;
    private Character hasBankAccount;
    private String companyName;
    private Character isSelfReg;
    private String regVerMethod;
    private Long customerValidationStatus;
    private Boolean extTransferEnabled;

    }