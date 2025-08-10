package com.trak.trak.payload.appUser;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppCreateUserDTO {
    private String username;
    private String password;
}
