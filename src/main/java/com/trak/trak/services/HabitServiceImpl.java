package com.trak.trak.services;

import com.trak.trak.payload.APIResponse;
import com.trak.trak.payload.habit.HabitCreateDTO;
import com.trak.trak.payload.habit.HabitDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitServiceImpl implements HabitService {
    @Override
    public List<HabitDTO> getHabits(Long appUserId, String type) {
        return null;
    }

    @Override
    public HabitDTO getHabit(Long appUserId, Long habitId) {
        return null;
    }

    @Override
    public HabitDTO createHabit(Long appUserId, HabitCreateDTO habitCreateDTO) {
        return null;
    }

    @Override
    public HabitDTO updateHabit(Long appUserId, Long habitId, HabitCreateDTO habitCreateDTO) {
        return null;
    }

    @Override
    public APIResponse deleteHabit(Long appUserId, Long habitId) {
        return null;
    }
}
