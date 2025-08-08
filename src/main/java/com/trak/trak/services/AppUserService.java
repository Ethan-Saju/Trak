package com.trak.trak.services;

import com.trak.trak.payload.*;
import com.trak.trak.payload.AppUser.AppCreateUserDTO;
import com.trak.trak.payload.AppUser.AppUserDTO;
import com.trak.trak.payload.AppUser.AppUserPasswordDTO;
import com.trak.trak.payload.AppUser.AppUserUsernameDTO;

public interface AppUserService {

    public AppUserDTO createAppUser(AppCreateUserDTO appUserDTO);
    public AppUserDTO getAppUser(Long appUserId);
    public AppUserDTO updateUsername(AppUserUsernameDTO appUserDTO, Long appUserId);
    public AppUserDTO updatePassword(AppUserPasswordDTO appUserDTO, Long appUserId);
    public APIResponse deleteAppUser(Long appUserId);
//    public HabitResponse getAllHabits(Long appUserId);
//    public HabitResponse getAllActiveHabits(Long appUserId);
//    public HabitResponse getAllInactiveHabits(Long appUserId);

}
