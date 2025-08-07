package com.trak.trak.controllers;


import com.trak.trak.payload.APIResponse;
import com.trak.trak.payload.AppUserDTO;
import com.trak.trak.payload.AppUserUsernameDTO;
import com.trak.trak.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/users")
public class AppUserController {

    private final AppUserService appUserService;

    @Autowired
    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }


    @PostMapping("/")
    public ResponseEntity<AppUserDTO> createUser(@RequestBody AppUserDTO appUserDTO) {
        return new ResponseEntity<>(appUserService.createAppUser(appUserDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{appUserId}")
    public ResponseEntity<AppUserDTO> getUser(@PathVariable Long appUserId) {
        return new ResponseEntity<>(appUserService.getAppUser(appUserId), HttpStatus.OK);
    }

    @DeleteMapping("/{appUserId}")
    public ResponseEntity<APIResponse> deleteUser(@PathVariable Long appUserId) {
        return new ResponseEntity<>(appUserService.deleteAppUser(appUserId), HttpStatus.OK);
    }

    @PatchMapping("/updateUsername")
    public ResponseEntity<AppUserDTO> updateUsername(@RequestBody AppUserUsernameDTO appUserUsernameDTO) {
        return new ResponseEntity<>(appUserService.updateUsername(appUserUsernameDTO), HttpStatus.OK);
    }
}
