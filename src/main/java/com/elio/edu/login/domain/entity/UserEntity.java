package com.elio.edu.login.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "TB_CUSTOMER")
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long customerNo;

    @Column(length = 2, nullable = true)
    private String dialCode;

    @Column(length = 20, nullable = false)
    private String mdn;

    @Column(length = 200, nullable = true)
    private String email;

    @Column(length = 100, nullable = true)
    private String profileName;

    @Column(length = 500, nullable = true)
    private String profileImageUrl;

    @Column(length = 2, nullable = true)
    private String customerType;

    @Column(length = 200, nullable = true)
    private String accountPassword;

    @Column
    private int passwordFailCount;

    @Column(length = 2, nullable = true)
    private String languageCode;

    @Column
    private LocalDateTime lastJoinDate;

    @Column
    private LocalDateTime lastRequestDate;

    @Column
    private LocalDateTime lastPaymentDate;

    @Column
    private LocalDateTime lastCloseDate;

    @Column(length = 2, nullable = true)
    private String customerStatus;

    @Column(length = 2, nullable = true)
    private String closeType;

    @Column(length = 1000, nullable = true)
    private String closeDesc;

    @Column(length = 1, nullable = true)
    private String blockYn;

    @Column(length = 1, nullable = true)
    private String deleteYn;

    @Column(length = 20, nullable = true)
    private String insertedId;

    @Column
    private LocalDateTime insertedDate;

    @Column(length = 20, nullable = true)
    private String updatedId;

    @Column
    private LocalDateTime updatedDate;

    @Column(length = 1000, nullable = true)
    private String updatedDesc;

    @Builder
    public UserEntity(Long customerNo,
                      String dialCode,
                      String mdn,
                      String email,
                      String profileName,
                      String profileImageUrl,
                      String customerType,
                      String accountPassword,
                      int passwordFailCount,
                      String languageCode,
                      LocalDateTime lastJoinDate,
                      LocalDateTime lastRequestDate,
                      LocalDateTime lastPaymentDate,
                      LocalDateTime lastCloseDate,
                      String customerStatus,
                      String closeType,
                      String closeDesc,
                      String blockYn,
                      String deleteYn,
                      String insertedId,
                      LocalDateTime insertedDate,
                      String updatedId,
                      LocalDateTime updatedDate,
                      String updatedDesc) {
        this.customerNo = customerNo;
        this.dialCode = dialCode;
        this.mdn = mdn;
        this.email = email;
        this.profileName = profileName;
        this.profileImageUrl = profileImageUrl;
        this.customerType = customerType;
        this.accountPassword = accountPassword;
        this.passwordFailCount = passwordFailCount;
        this.languageCode = languageCode;
        this.lastJoinDate = lastJoinDate;
        this.lastRequestDate = lastRequestDate;
        this.lastPaymentDate = lastPaymentDate;
        this.lastCloseDate = lastCloseDate;
        this.customerStatus = customerStatus;
        this.closeType = closeType;
        this.closeDesc = closeDesc;
        this.blockYn = blockYn;
        this.deleteYn = deleteYn;
        this.insertedId = insertedId;
        this.insertedDate = insertedDate;
        this.updatedId = updatedId;
        this.updatedDate = updatedDate;
        this.updatedDesc = updatedDesc;
    }

}
