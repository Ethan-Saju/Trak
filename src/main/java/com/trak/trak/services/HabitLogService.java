package com.trak.trak.services;

import com.trak.trak.payload.habitLog.HabitLogDTO;
import com.trak.trak.payload.habitLog.HabitLogUpdateDTO;

import java.util.List;

public interface HabitLogService {

    //return habit logs for the day
    //at 12 pm create habit log for all active habits
    //if they add new active habit , create habit log for it


    List<HabitLogDTO> getHabitLogs(Long appUserId);


    //updates note and completed/progress
    HabitLogDTO updateHabitLog(Long appUserId, Long logId, HabitLogUpdateDTO HabitLogUpdateDTO);


    //show logs for a custom time period  ,last week , last moth ,or year
    //with pagination
    //with info completed/total
    //make custom response that also mentioned that info
    List<HabitLogDTO> getHabitLogsByDate(Long appUserId, Long habitId, String startDate, String endDate);






}
