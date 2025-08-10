package com.trak.trak.payload.habit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class HabitDTO {
    private String type;
    private Long id;
    private String habitName;
    private String description;
    private Integer currentStreak;
    private Integer longestStreak;
    private Boolean isActive;
}
