package com.trak.trak.services;

import com.trak.trak.payload.APIResponse;
import com.trak.trak.payload.AppUserDTO;

public interface AppUserService {

    public AppUserDTO createAppUser(AppUserDTO appUserDTO);
    public AppUserDTO getAppUser(String appUserId);
    public AppUserDTO updateUsername(AppUserDTO appUserDTO);
    public APIResponse deleteAppUser(String appUserId);
//    public HabitResponse getAllHabits(String appUserId);
//    public HabitResponse getAllActiveHabits(String appUserId);
//    public HabitResponse getAllInactiveHabits(String appUserId);

}
