package com.trak.trak.services;


import com.trak.trak.exceptions.APIException;
import com.trak.trak.models.*;
import com.trak.trak.payload.habitLog.*;
import com.trak.trak.repositories.AppUserRepository;
import com.trak.trak.repositories.HabitLogRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class HabitLogServiceImpl implements HabitLogService {

    AppUserRepository appUserRepository;
    ModelMapper modelMapper;
    HabitLogRepository habitLogRepository;

    @Autowired
    public HabitLogServiceImpl(AppUserRepository appUserRepository , ModelMapper modelMapper , HabitLogRepository habitLogRepository) {
        this.appUserRepository = appUserRepository;
        this.modelMapper = modelMapper;
        this.habitLogRepository = habitLogRepository;
    }

    @Override
    public List<HabitLogDTO> getHabitLogs(Long appUserId) {

        appUserRepository.findById(appUserId).orElseThrow(() -> new APIException("User not found"));

        List<HabitLog> habitLogs = habitLogRepository.findAllByHabit_AppUser_AppUserIdAndDate(appUserId, LocalDate.now());

        return habitLogs.stream().map(this::mapHabitLogToHabitLogDTO).toList();
    }



    @Override
    public HabitLogDTO updateHabitLog(Long appUserId, Long logId, HabitLogUpdateDTO habitLogUpdateDTO) {
        appUserRepository.findById(appUserId)
                .orElseThrow(() -> new APIException("User not found"));

        HabitLog habitLog = habitLogRepository
                .findByLogIdAndHabit_AppUser_AppUserId(logId, appUserId)
                .orElseThrow(() -> new APIException("Habit log not found"));

        habitLog.setNote(habitLogUpdateDTO.getNote());

        if (habitLogUpdateDTO instanceof BinaryHabitLogUpdateDTO binaryHabitLogUpdateDTO
                && habitLog instanceof BinaryHabitLog binaryHabitLog) {
            binaryHabitLog.setComplete(binaryHabitLogUpdateDTO.getComplete());
        } else if (habitLogUpdateDTO instanceof NumericHabitLogUpdateDTO numericHabitLogUpdateDTO
                && habitLog instanceof NumericHabitLog numericHabitLog) {
            numericHabitLog.setProgress(numericHabitLogUpdateDTO.getProgress());
        } else {
            throw new APIException("HabitLog type and DTO type mismatch");
        }

        return mapHabitLogToHabitLogDTO(habitLogRepository.save(habitLog));
    }


    @Override
    public List<HabitLogDTO> getHabitLogsByDate(Long appUserId, Long habitId, LocalDate startDate, LocalDate endDate) {

        appUserRepository.findById(appUserId).orElseThrow(() -> new APIException("User not found"));

        List<HabitLog> habitLogs = habitLogRepository.findAllByHabit_AppUser_AppUserIdAndHabit_habitIdAndDateBetween(appUserId, habitId,startDate, endDate);


        return habitLogs.stream().map(this::mapHabitLogToHabitLogDTO).toList();
    }

    private HabitLogDTO mapHabitLogToHabitLogDTO(HabitLog habitLog) {

        HabitLogDTO habitLogDTO;

        if (habitLog instanceof BinaryHabitLog binaryHabitLog) {
            habitLogDTO = modelMapper.map(binaryHabitLog, BinaryHabitLogDTO.class);
            habitLogDTO.setType("binary");
        } else {

            habitLogDTO = modelMapper.map(habitLog, NumericHabitLogDTO.class);
            habitLogDTO.setType("numeric");
        }

        return habitLogDTO;

    }

}
