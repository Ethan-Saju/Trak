package com.trak.trak.controllers;


import com.trak.trak.payload.*;
import com.trak.trak.payload.AppUser.AppCreateUserDTO;
import com.trak.trak.payload.AppUser.AppUserDTO;
import com.trak.trak.payload.AppUser.AppUserPasswordDTO;
import com.trak.trak.payload.AppUser.AppUserUsernameDTO;
import com.trak.trak.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class AppUserController {

    private final AppUserService appUserService;

    @Autowired
    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }


    @PostMapping("/")
    public ResponseEntity<AppUserDTO> createUser(@RequestBody AppCreateUserDTO appCreateUserDTO) {
        return new ResponseEntity<>(appUserService.createAppUser(appCreateUserDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{appUserId}")
    public ResponseEntity<AppUserDTO> getUser(@PathVariable Long appUserId) {
        return new ResponseEntity<>(appUserService.getAppUser(appUserId), HttpStatus.OK);
    }

    @DeleteMapping("/{appUserId}")
    public ResponseEntity<APIResponse> deleteUser(@PathVariable Long appUserId) {
        return new ResponseEntity<>(appUserService.deleteAppUser(appUserId), HttpStatus.OK);
    }

    @PatchMapping("/updateUsername/{appUserId}")
    public ResponseEntity<AppUserDTO> updateUsername(@RequestBody AppUserUsernameDTO appUserUsernameDTO, @PathVariable Long appUserId) {
        return new ResponseEntity<>(appUserService.updateUsername(appUserUsernameDTO, appUserId), HttpStatus.OK);
    }

    @PatchMapping("/updatePassword/{appUserId}")
    public ResponseEntity<AppUserDTO> updatePassword(@RequestBody AppUserPasswordDTO appUserPasswordDTO, @PathVariable Long appUserId) {
        return new ResponseEntity<>(appUserService.updatePassword(appUserPasswordDTO, appUserId), HttpStatus.OK);
    }
}
