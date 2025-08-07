package com.trak.trak.services;

import com.trak.trak.payload.*;

public interface AppUserService {

    public AppUserDTO createAppUser(AppCreateUserDTO appUserDTO);
    public AppUserDTO getAppUser(Long appUserId);
    public AppUserDTO updateUsername(AppUserUsernameDTO appUserDTO);
    public AppUserDTO updatePassword(AppUserPasswordDTO appUserDTO);
    public APIResponse deleteAppUser(Long appUserId);
//    public HabitResponse getAllHabits(Long appUserId);
//    public HabitResponse getAllActiveHabits(Long appUserId);
//    public HabitResponse getAllInactiveHabits(Long appUserId);

}
