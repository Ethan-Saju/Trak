package com.trak.trak.services;

import com.trak.trak.payload.APIResponse;
import com.trak.trak.payload.habit.HabitCreateDTO;
import com.trak.trak.payload.habit.HabitDTO;

import java.util.List;

public interface HabitService {

    List<HabitDTO> getHabits(Long appUserId,String type);

    HabitDTO getHabit(Long appUserId, Long habitId);

    HabitDTO createHabit(Long appUserId, HabitCreateDTO habitCreateDTO);

    HabitDTO updateHabit(Long appUserId, Long habitId, HabitCreateDTO habitCreateDTO);

    HabitDTO toggleHabitActivity(Long appUserId, Long habitId);
    //to complete- > if they toggle from active to inactive we need to delete habit log for the day
    //if they toggle from inactive to active we need to create habit log for the day

    APIResponse deleteHabit(Long appUserId, Long habitId);


}
