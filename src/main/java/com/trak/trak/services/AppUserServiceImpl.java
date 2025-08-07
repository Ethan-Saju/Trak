package com.trak.trak.services;


import com.trak.trak.exceptions.APIException;
import com.trak.trak.models.AppUser;
import com.trak.trak.payload.*;
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
    public AppUserDTO createAppUser(AppCreateUserDTO appCreateUserDTO) {

        appUserRepository.findByUsername(appCreateUserDTO.getUsername())
                .ifPresent(appUser -> {
                    throw new APIException("Username already exists");
                });

        AppUser appUser = modelMapper.map(appCreateUserDTO, AppUser.class);
        appUser = appUserRepository.save(appUser);

        return modelMapper.map(appUser, AppUserDTO.class);
    }


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
