package com.trak.trak.payload.habit;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class NumericHabitDTO extends HabitDTO {
    private Double target;
}