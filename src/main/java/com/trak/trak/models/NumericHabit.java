package com.trak.trak.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NumericHabit extends Habit {
    private Double target;

    public NumericHabit(Long habitId, String habitName, String description, Boolean isActive, Integer currentStreak, Integer longestStreak, AppUser appUser, Double target, List<HabitLog> habitLogs) {
        super(habitId, habitName, description, isActive,currentStreak, longestStreak, appUser,habitLogs);
        this.target = target;
    }
}
