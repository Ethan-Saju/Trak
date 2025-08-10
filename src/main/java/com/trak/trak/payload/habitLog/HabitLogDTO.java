package com.trak.trak.payload.habitLog;

import com.trak.trak.models.Habit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class HabitLogDTO {

    private Long logId;

    private LocalDate habitDate;

    private String note;

    private Boolean completed;

    private Habit habit;
}
