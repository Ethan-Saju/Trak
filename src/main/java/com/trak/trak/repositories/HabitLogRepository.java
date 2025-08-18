package com.trak.trak.repositories;

import com.trak.trak.models.HabitLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface HabitLogRepository extends JpaRepository<HabitLog, Long> {

    List<HabitLog> findAllByAppUser_appUserId(Long appUserId);

    Optional<HabitLog> findByLogIdAndAppUser_appUserId(Long logId, Long appUserId);

    List<HabitLog> findAllByAppUser_appUserIdAndHabit_habitIdAndLogDateBetween(
            Long appUserId,
            Long habitId,
            LocalDate startDate,
            LocalDate endDate
    );
}
