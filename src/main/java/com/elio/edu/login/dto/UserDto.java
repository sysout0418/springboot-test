package com.elio.edu.login.dto;

import com.elio.edu.login.domain.entity.UserEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDto {

    private long customerNo;
    private String dialCode;
    private String mdn;
    private String email;
    private String profileName;
    private String profileImageUrl;
    private String customerType;
    private String accountPassword;
    private int passwordFailCount;
    private String languageCode;
    private LocalDateTime lastJoinDate;
    private LocalDateTime lastRequestDate;
    private LocalDateTime lastPaymentDate;
    private LocalDateTime lastCloseDate;
    private String customerStatus;
    private String closeType;
    private String closeDesc;
    private String blockYn;
    private String deleteYn;
    private String insertedId;
    private LocalDateTime insertedDate;
    private String updatedId;
    private LocalDateTime updatedDate;
    private String updatedDesc;

    public UserEntity toEntity() {
        return UserEntity.builder()
                .customerNo(customerNo)
                .dialCode(dialCode)
                .mdn(mdn)
                .email(email)
                .profileName(profileName)
                .profileImageUrl(profileImageUrl)
                .customerType(customerType)
                .accountPassword(accountPassword)
                .passwordFailCount(passwordFailCount)
                .languageCode(languageCode)
                .lastJoinDate(lastJoinDate)
                .lastRequestDate(lastRequestDate)
                .lastPaymentDate(lastPaymentDate)
                .lastCloseDate(lastCloseDate)
                .customerStatus(customerStatus)
                .closeType(closeType)
                .closeDesc(closeDesc)
                .blockYn(blockYn)
                .deleteYn(deleteYn)
                .insertedId(insertedId)
                .insertedDate(insertedDate)
                .updatedId(updatedId)
                .updatedDate(updatedDate)
                .updatedDesc(updatedDesc)
                .build();
    }

    @Builder
    public UserDto(Long customerNo,
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
