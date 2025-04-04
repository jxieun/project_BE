
package com.baseballweb.auth.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class SignupRequest {
    private String email;
    private String password;
    //private String nickname;
}
