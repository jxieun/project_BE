
package com.baseballweb.auth.dto.join;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class LoginRequest {
    private String email;
    private String password;
}
