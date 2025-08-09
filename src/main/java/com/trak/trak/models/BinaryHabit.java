package com.trak.trak.models;

import com.trak.trak.payload.habit.HabitCreateDTO;
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
public class BinaryHabit extends Habit {

    public BinaryHabit(Long habitId, String habitName, String description, Boolean isActive, AppUser appUser, List<HabitLog> habitLogs) {
        super(habitId, habitName, description, isActive, appUser,habitLogs);
    }
}

