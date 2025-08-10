package com.trak.trak.services;


import com.trak.trak.exceptions.APIException;
import com.trak.trak.models.AppUser;
import com.trak.trak.payload.*;
import com.trak.trak.payload.appUser.AppCreateUserDTO;
import com.trak.trak.payload.appUser.AppUserDTO;
import com.trak.trak.payload.appUser.AppUserPasswordDTO;
import com.trak.trak.payload.appUser.AppUserUsernameDTO;
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
        appUserRepository.findById(appUserId)
                .orElseThrow(() -> new APIException("User not found"));

        AppUser appUser = appUserRepository.findById(appUserId).get();
        return modelMapper.map(appUser, AppUserDTO.class);
    }

    @Override
    public AppUserDTO updateUsername(AppUserUsernameDTO appUserDTO, Long appUserId) {
        AppUser appUser = appUserRepository.findById(appUserId)
                .orElseThrow(() -> new APIException("User not found"));

        appUserRepository.findByUsername(appUserDTO.getUsername())
                .ifPresent(user -> {
                    if (!user.getAppUserId().equals(appUserId))
                        throw new APIException("Username already exists");
                });

        appUser.setUsername(appUserDTO.getUsername());

        return modelMapper.map(appUserRepository.save(appUser), AppUserDTO.class);
    }

    @Override
    public AppUserDTO updatePassword(AppUserPasswordDTO appUserDTO, Long appUserId) {
        AppUser appUser = appUserRepository.findById(appUserId)
                .orElseThrow(() -> new APIException("User not found"));

        appUser.setPassword(appUserDTO.getPassword());

        return modelMapper.map(appUserRepository.save(appUser), AppUserDTO.class);
    }

    @Override
    public APIResponse deleteAppUser(Long appUserId) {
        AppUser appUser = appUserRepository.findById(appUserId)
                .orElseThrow(() -> new APIException("User not found"));

        appUserRepository.delete(appUser);

        return new APIResponse("User deleted successfully!", true);
    }
}
