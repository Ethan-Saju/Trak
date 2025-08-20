package com.trak.trak.repositories;

import com.trak.trak.models.HabitLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface HabitLogRepository extends JpaRepository<HabitLog, Long> {

    List<HabitLog> findAllByHabit_AppUser_AppUserIdAndDate(Long appUserId , LocalDate date);

    Optional<HabitLog> findByLogIdAndHabit_AppUser_AppUserId(Long logId, Long appUserId);

    List<HabitLog> findAllByHabit_AppUser_AppUserIdAndHabit_habitIdAndDateBetween(
            Long appUserId,
            Long habitId,
            LocalDate startDate,
            LocalDate endDate
    );

    Optional<HabitLog> findByHabit_HabitIdAndHabit_AppUser_AppUserIdAndDate(Long habitId, Long appUserId, LocalDate now);
}
