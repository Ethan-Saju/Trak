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

    APIResponse deleteHabit(Long appUserId, Long habitId);

}
