package com.trak.trak.payload.habit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class HabitDTO {
    private Long id;
    private String habitName;
    private String description;
    private Boolean isActive;
}
