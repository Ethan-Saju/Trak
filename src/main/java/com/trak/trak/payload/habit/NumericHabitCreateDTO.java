package com.trak.trak.payload.habit;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class NumericHabitCreateDTO extends HabitCreateDTO {

    private Double target;
}
