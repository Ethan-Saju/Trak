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
@AllArgsConstructor
@NoArgsConstructor
public class BinaryHabitLog extends HabitLog {

    private boolean complete;

    public BinaryHabitLog(Long id, LocalDate date, String note , BinaryHabit binaryHabit, boolean complete) {
        super(id, date , note , binaryHabit);
        this.complete = complete;
    }
}
