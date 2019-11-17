package com.elio.edu.login.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private int customerNo;
    private String dialCode;
    private String mdn;
    private String email;
    private String profileName;
    private String profileImageUrl;
    private String customerType;
    private String accountPassword;
    private int passwordFailCount;
    private String languageCode;
    private String lastJoinDate;
    private String lastRequestDate;
    private String lastPaymentDate;
    private String lastCloseDate;
    private String customerStatus;
    private String closeType;
    private String closeDesc;
    private String blockYn;

}
