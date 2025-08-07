package com.trak.trak.services;


import com.trak.trak.payload.APIResponse;
import com.trak.trak.payload.AppUserDTO;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl implements AppUserService {

    @Override
    public AppUserDTO createAppUser(AppUserDTO appUserDTO) {

    }

    @Override
    public AppUserDTO getAppUser(String appUserId) {
        return null;
    }

    @Override
    public AppUserDTO updateUsername(AppUserDTO appUserDTO) {
        return null;
    }

    @Override
    public APIResponse deleteAppUser(String appUserId) {
        return null;
    }


}
