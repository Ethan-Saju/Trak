package com.trak.trak.services;

import com.trak.trak.payload.habitLog.HabitLogDTO;

import java.util.List;

public interface HabitLogService {

    //return habit logs for the day
    //at 12 pm create habit log for all active habits
    //if they add new active habit , create habit log for it and return that too
    List<HabitLogDTO> getHabitLogs(Long appUserId);


    //updates note and completed/progress
    //HabitLogDTO updateHabitLog(Long appUserId, Long logId, updateHabitLogDTO updateHabitLogDTO);
}
