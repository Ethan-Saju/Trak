package com.trak.trak;


import com.trak.trak.config.AppConfig;
import com.trak.trak.models.AppUser;
import com.trak.trak.models.BinaryHabit;
import com.trak.trak.models.NumericHabit;
import com.trak.trak.repositories.AppUserRepository;
import com.trak.trak.repositories.HabitRepository;
import com.trak.trak.services.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DataInit {

    private final AppUserRepository appUserRepository;
    private final HabitRepository habitRepository;

    @Autowired
    public DataInit(AppUserRepository appUserRepository, HabitRepository habitRepository) {
        this.appUserRepository = appUserRepository;
        this.habitRepository = habitRepository;
    }

    @Bean
    public CommandLineRunner dataInitializer(AppUserRepository appUserRepository, HabitRepository habitRepository) {
        return args -> {
            // Save users first
            appUserRepository.saveAll(List.of(
                    new AppUser(null, "user1", "password1", new ArrayList<>()),
                    new AppUser(null, "user2", "password2", new ArrayList<>()),
                    new AppUser(null, "user3", "password3", new ArrayList<>())
            ));

            // Save habits in one shot, fetching users inline
            habitRepository.saveAll(List.of(
                    // User 1 habits
                    new NumericHabit(null, "Daily Steps", "Walk a certain number of steps", true, 0, 0, appUserRepository.findById(1L).get(), 10000.0, new ArrayList<>()),
                    new NumericHabit(null, "Push-ups", "Do push-ups daily", false, 0, 0, appUserRepository.findById(1L).get(), 50.0, new ArrayList<>()),
                    new BinaryHabit(null, "Read a Book", "Read at least once a day", true, 0, 0, appUserRepository.findById(1L).get(), new ArrayList<>()),
                    new BinaryHabit(null, "No Sugar", "Avoid sugar all day", true, 0, 0, appUserRepository.findById(1L).get(), new ArrayList<>()),

                    // User 2 habits
                    new NumericHabit(null, "Cycling Distance", "Cycle a certain distance", true, 0, 0, appUserRepository.findById(2L).get(), 15.0, new ArrayList<>()),
                    new NumericHabit(null, "Squats", "Do squats daily", false, 0, 0, appUserRepository.findById(2L).get(), 40.0, new ArrayList<>()),
                    new BinaryHabit(null, "Meditate", "Meditate once a day", false, 0, 0, appUserRepository.findById(2L).get(), new ArrayList<>()),
                    new BinaryHabit(null, "No Caffeine", "Avoid caffeine all day", true, 0, 0, appUserRepository.findById(2L).get(), new ArrayList<>()),

                    // User 3 habits
                    new NumericHabit(null, "Swimming Laps", "Swim a certain number of laps", false, 0, 0, appUserRepository.findById(3L).get(), 20.0, new ArrayList<>()),
                    new NumericHabit(null, "Plank Time", "Hold a plank for minutes", true, 0, 0, appUserRepository.findById(3L).get(), 5.0, new ArrayList<>()),
                    new BinaryHabit(null, "Write Journal", "Write in journal daily", true, 0, 0, appUserRepository.findById(3L).get(), new ArrayList<>()),
                    new BinaryHabit(null, "No Social Media", "Avoid social media all day", false, 0, 0, appUserRepository.findById(3L).get(), new ArrayList<>())
            ));



        };
    }


}



