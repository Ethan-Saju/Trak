package com.trak.trak.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NumericHabitLog extends HabitLog {
    private Double progress;

    public NumericHabitLog(Long id, LocalDate date, String note , NumericHabit numericHabit, Double progress) {
        super(id, date , note , numericHabit);
        this.progress = progress;
    }
}
