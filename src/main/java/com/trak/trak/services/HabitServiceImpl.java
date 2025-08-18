package com.trak.trak.services;

import com.trak.trak.exceptions.APIException;
import com.trak.trak.models.BinaryHabit;
import com.trak.trak.models.Habit;
import com.trak.trak.models.NumericHabit;
import com.trak.trak.payload.APIResponse;
import com.trak.trak.payload.habit.*;
import com.trak.trak.repositories.AppUserRepository;
import com.trak.trak.repositories.HabitRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitServiceImpl implements HabitService {

    HabitRepository habitRepository;
    AppUserRepository appUserRepository;
    ModelMapper modelMapper;

    @Autowired
    public HabitServiceImpl(HabitRepository habitRepository , ModelMapper modelMapper , AppUserRepository appUserRepository) {
        this.habitRepository = habitRepository;
        this.modelMapper = modelMapper;
        this.appUserRepository = appUserRepository;
    }


    @Override
    public List<HabitDTO> getHabits(Long appUserId, String type) {

        appUserRepository.findById(appUserId).orElseThrow(() -> new APIException("User not found"));

        List<Habit> habits;

        switch (type) {
            case "active" -> habits = habitRepository.findAllByAppUser_appUserIdAndIsActive(appUserId, true);
            case "inactive" -> habits = habitRepository.findAllByAppUser_appUserIdAndIsActive(appUserId, false);
            case "all" -> habits = habitRepository.findAllByAppUser_appUserId(appUserId);
            default -> throw new APIException("Invalid type");
        }

        return habits.stream().map(this::mapHabitToHabitDTO).toList();

    }

    @Override
    public HabitDTO getHabit(Long appUserId, Long habitId) {

        appUserRepository.findById(appUserId).orElseThrow(() -> new APIException("User not found"));

        Habit habit = habitRepository
                .findByHabitIdAndAppUser_appUserId(habitId, appUserId)
                .orElseThrow(() -> new APIException("Habit not found"));

        return mapHabitToHabitDTO(habit);

    }

    @Override
    public HabitDTO createHabit(Long appUserId, HabitCreateDTO habitCreateDTO) {

        appUserRepository.findById(appUserId).orElseThrow(() -> new APIException("User not found"));

        habitRepository
                .findByHabitNameAndAppUser_appUserId(habitCreateDTO.getHabitName(), appUserId)
                .ifPresent(habit -> {
                    throw new APIException("Habit name already exists");
                });

        Habit habit = mapHabitCreateDTOToHabit(habitCreateDTO);
        habit.setCurrentStreak(0);
        habit.setLongestStreak(0);
        habit.setIsActive(true);

        habit.setAppUser(appUserRepository.findById(appUserId).get());

        return mapHabitToHabitDTO(habitRepository.save(habit));

    }

    @Override
    public HabitDTO updateHabit(Long appUserId, Long habitId, HabitCreateDTO habitCreateDTO) {

        appUserRepository.findById(appUserId).orElseThrow(() -> new APIException("User not found"));

        Habit habit = habitRepository
                .findByHabitIdAndAppUser_appUserId(habitId, appUserId)
                .orElseThrow(() -> new APIException("Habit not found"));



        habitRepository
            .findByHabitNameAndAppUser_appUserId(habitCreateDTO.getHabitName(), appUserId)
            .ifPresent(existingHabit -> {
                if (! existingHabit.getHabitId().equals(habitId))
                    throw new APIException("Habit name already exists");
            });



        if (!validateHabitType(habit, habitCreateDTO))
            throw new APIException("Cannot update habit type");

        modelMapper.map(habitCreateDTO, habit);

        return mapHabitToHabitDTO(habitRepository.save(habit));
    }

    @Override
    public HabitDTO toggleHabitActivity(Long appUserId, Long habitId) {

        appUserRepository.findById(appUserId).orElseThrow(() -> new APIException("User not found"));

        Habit habit = habitRepository
                .findByHabitIdAndAppUser_appUserId(habitId, appUserId)
                .orElseThrow(() -> new APIException("Habit not found"));

        habit.setIsActive(!habit.getIsActive());

        return mapHabitToHabitDTO(habitRepository.save(habit));

    }

    @Override
    public APIResponse deleteHabit(Long appUserId, Long habitId) {

        appUserRepository.findById(appUserId).orElseThrow(() -> new APIException("User not found"));

        Habit habit = habitRepository
                .findByHabitIdAndAppUser_appUserId(habitId, appUserId)
                .orElseThrow(() -> new APIException("Habit not found"));

        habitRepository.delete(habit);

        return new APIResponse("Habit deleted successfully!", true);

    }

    private HabitDTO mapHabitToHabitDTO(Habit habit)  {

        HabitDTO habitDTO;

        if (habit instanceof NumericHabit numericHabit) {
            habitDTO = modelMapper.map(numericHabit, NumericHabitDTO.class);
            habitDTO.setType("numeric");
        } else if (habit instanceof BinaryHabit binaryHabit) {
            habitDTO = modelMapper.map(binaryHabit, BinaryHabitDTO.class);
            habitDTO.setType("binary");
        }
        else throw new APIException("Unknown habit type");

        return habitDTO;

    }

    private Habit mapHabitCreateDTOToHabit(HabitCreateDTO habitCreateDTO) {

        Habit habit;

        if (habitCreateDTO instanceof NumericHabitCreateDTO numericHabitCreateDTO) {
            habit = modelMapper.map(numericHabitCreateDTO, NumericHabit.class);
        } else if (habitCreateDTO instanceof BinaryHabitCreateDTO binaryHabitCreateDTO) {
            habit = modelMapper.map(binaryHabitCreateDTO, BinaryHabit.class);
        }
        else throw new APIException("Unknown habit type");

        return habit;

    }

    private boolean validateHabitType(Habit habit , HabitCreateDTO habitCreateDTO) {
        return (
                (habit instanceof NumericHabit numericHabit && habitCreateDTO instanceof NumericHabitCreateDTO)
                || (habit instanceof BinaryHabit binaryHabit && habitCreateDTO instanceof BinaryHabitCreateDTO)
        );

    }
}
