package com.trak.trak.repositories;

import com.trak.trak.models.Habit;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface HabitRepository extends JpaRepository<Habit, Long> {
    List<Habit> findAllByAppUser_appUserIdAndIsActive(Long appUserId, boolean b);

    List<Habit> findAllByAppUser_appUserId(Long appUserAppUserId);

    Optional<Habit> findByHabitIdAndAppUser_appUserId(Long habitId, Long appUserAppUserId1);

    Optional<Habit> findByHabitNameAndAppUser_appUserId(String habitName, Long appUserAppUserId);
}
