package com.trak.trak.services;

import com.trak.trak.payload.APIResponse;
import com.trak.trak.payload.AppUserDTO;
import com.trak.trak.payload.AppUserPasswordDTO;
import com.trak.trak.payload.AppUserUsernameDTO;

public interface AppUserService {

    public AppUserDTO createAppUser(AppUserDTO appUserDTO);
    public AppUserDTO getAppUser(Long appUserId);
    public AppUserDTO updateUsername(AppUserUsernameDTO appUserDTO);
    public AppUserDTO updatePassword(AppUserPasswordDTO appUserDTO);
    public APIResponse deleteAppUser(Long appUserId);
//    public HabitResponse getAllHabits(Long appUserId);
//    public HabitResponse getAllActiveHabits(Long appUserId);
//    public HabitResponse getAllInactiveHabits(Long appUserId);

}
