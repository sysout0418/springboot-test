package com.elio.edu.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "TB_CUSTOMER")
public class UserEntity {

    @Id
    @Column(name = "CUSTOMER_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customerNo;

    @Column(name = "DIAL_CODE")
    private String dialCode;

    @Column(name = "MDN")
    private String mdn;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PROFILE_NAME")
    private String profileName;

    @Column(name = "PROFILE_IMAGE_URL")
    private String profileImageUrl;

    @Column(name = "CUSTOMER_TYPE")
    private String customerType;

    @Column(name = "ACCOUNT_PASSWORD")
    private String accountPassword;

    @Column(name = "PASSWORD_FAIL_COUNT")
    private int passwordFailCount;

    @Column(name = "LANGUAGE_CODE")
    private String languageCode;

    @Column(name = "LAST_JOIN_DATE")
    private LocalDateTime lastJoinDate;

    @Column(name = "LAST_REQUEST_DATE")
    private LocalDateTime lastRequestDate;

    @Column(name = "LAST_PAYMENT_DATE")
    private LocalDateTime lastPaymentDate;

    @Column(name = "LAST_CLOSE_DATE")
    private LocalDateTime lastCloseDate;

    @Column(name = "CUSTOMER_STATUS")
    private String customerStatus;

    @Column(name = "CLOSE_TYPE")
    private String closeType;

    @Column(name = "CLOSE_DESC")
    private String closeDesc;

    @Column(name = "BLOCK_YN")
    private String blockYn;

    @Column(name = "DELETE_YN")
    private String deleteYn;

    @Column(name = "INSERTED_ID")
    private String insertedId;

    @Column(name = "INSERTED_DATE")
    private LocalDateTime insertedDate;

    @Column(name = "UPDATED_ID")
    private String updatedId;

    @Column(name = "UPDATED_DATE")
    private LocalDateTime updatedDate;

    @Column(name = "UPDATED_DESC")
    private String updatedDesc;

    public UserEntity() {}

}
