package com.trak.trak.services;


import com.trak.trak.payload.habitLog.HabitLogDTO;
import com.trak.trak.payload.habitLog.HabitLogUpdateDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitLogServiceImpl implements HabitLogService {

    @Override
    public List<HabitLogDTO> getHabitLogs(Long appUserId) {
        return List.of();
    }

    @Override
    public HabitLogDTO updateHabitLog(Long appUserId, Long logId, HabitLogUpdateDTO HabitLogUpdateDTO) {
        return null;
    }

    @Override
    public List<HabitLogDTO> getHabitLogsByDate(Long appUserId, Long habitId, String startDate, String endDate) {
        return List.of();
    }
}
