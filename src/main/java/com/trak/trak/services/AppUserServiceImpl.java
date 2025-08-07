package com.trak.trak.services;


import com.trak.trak.exceptions.APIException;
import com.trak.trak.payload.APIResponse;
import com.trak.trak.payload.AppUserDTO;
import com.trak.trak.payload.AppUserUsernameDTO;
import com.trak.trak.repositories.AppUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl implements AppUserService {

    AppUserRepository appUserRepository;
    ModelMapper modelMapper;

    @Autowired
    public AppUserServiceImpl(AppUserRepository appUserRepository, ModelMapper modelMapper) {
        this.appUserRepository = appUserRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public AppUserDTO createAppUser(AppUserDTO appUserDTO) {

        appUserRepository.findByUsername((appUserDTO.getUsername())
                .ifPresent(appUser -> {
                    throw new APIException("Username already exists");
                });



    @Override
    public AppUserDTO getAppUser(Long appUserId) {

        return null;
    }

    @Override
    public AppUserDTO updateUsername(AppUserUsernameDTO appUserDTO) {
        return null;
    }

    @Override
    public AppUserDTO updatePassword(AppUserPasswordDTO appUserDTO) {
        return null;
    }

    @Override
    public APIResponse deleteAppUser(Long appUserId) {
        return null;
    }


}
