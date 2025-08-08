package com.trak.trak.payload.AppUser;

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
