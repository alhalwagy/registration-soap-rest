package com.fawry.crud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "BK_REGISTRATION")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BKRegistration {


    @Id
    @Column(
            name = "ID",
            unique = true,
            nullable = false,
            scale = 0
    )
    @GeneratedValue(
            generator = "BK_REGISTRATION_SEQ",
            strategy = GenerationType.SEQUENCE
    )
    @SequenceGenerator(
            name = "BK_REGISTRATION_SEQ",
            sequenceName = "EBPP_CORE.BK_RG_ENTITLS_SEQ",  // Use the exact sequence name from your database
            allocationSize = 1  // Ensure the allocation size matches the sequence increment
    )
    Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CUSTOMER_ID")
   Customer customer;

    @Column(name = "STATUS_ID")
    Long statusId;

    @Column(name = "SENDER_ID")
    Long sender_id ;

    @Column(name = "BANK_BRANCH_ID")
    Long bankBranchId;

    @Column(name = "PREFERRED_APP_LANG_ID")
    Long preferredAppLangId;


    @Column(name = "PREFERRED_NOTIFICATION_LANG_ID")
    Long preferredNotificationLangId;

    @Column(name = "DEFAULT_SOF")
    private String defaultSof;

    @Column(name = "DEACTIVATION_DATE")
    private LocalDateTime deactivationDate;

    @Column(name = "DEACTIVATION_REASON")
    private String deactivationReason;

    @Column(name = "REGISTERATION_DATE")
    private LocalDateTime registrationDate;

    @Column(name = "CREATION_DATE")
    private LocalDateTime creationDate;


    @Column(name = "LAST_MODIFICATION_DATE")
    private LocalDateTime lastModificationDate;

    @Column(name = "CIF")
    private String cif;

    @Column(name = "TRX_MAX_AMOUNT")
    private Double trxMaxAmount;

    @Column(name = "LAST_LOGIN_DATE")
    private LocalDateTime lastLoginDate;

    @Column(name = "IS_LOGEDON")
    private Character isLogedOn;


    @Column(name = "IS_AUTO_ARCHIVE_ENABLE")
    private Character isAutoArchiveEnable;

    @Column(name = "AUTO_ARCHIVE_PERIOD")
    private String autoArchivePeriod;

    @Column(name = "USER_CATEGORY_ID")
    private Long userCategoryId;

    @Column(name = "CREDIT_CARD_ENABLED")
    private Character creditCardEnabled;

    @Column(name = "LOGIN_USERNAME")
    private String loginUsername;

    @Column(name = "ACTIVATION_CODE")
    private String activationCode;

    @Column(name = "PMT_ATTEMPT_FLAG")
    private Character pmtAttemptFlag;

    @Column(name = "ACTIVATION_DATE")
    private LocalDateTime activationDate;

    @Column(name = "REGISTRATION_EMAIL")
    private String registrationEmail;

    @Column(name = "REGISTRATION_MOBILE")
    private String registrationMobile;


    @Column(name = "DASHBOARD_VIEWING_TYPE_ID")
    private Long dashboardViewingTypeId;

    @Column(name = "CUSTOMER_IP")
    private String customerIp;

    @Column(name = "CSP_CHANNEL_ID")
    private String cspChannelId;

    @Column(name = "KYC_LEVEL_ID")
    private Long kycLevelId;

    @Column(name = "JOB_TITLE")
    private String jobTitle;

    @Column(name = "MONTHLY_SALARY")
    private Double monthlySalary;

    @Column(name = "MEMO")
    private String memo;

    @Column(name = "HAS_BANK_ACCOUNT")
    private Character hasBankAccount;

    @Column(name = "COMPANY_NAME")
    private String companyName;

    @Column(name = "IS_SELF_REG")
    private Character isSelfReg;

    @Column(name = "REG_VER_METHOD")
    private String regVerMethod;

    @Column(name = "CUSTOMER_VALIDATION_STATUS")
    private Long customerValidationStatus;

    @Column(name = "EXT_TRANSFER_ENABLED")
    private Boolean extTransferEnabled;

}
