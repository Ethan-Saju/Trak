package com.trak.trak.payload.habitLog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BinaryHabitLogDTO extends HabitLogDTO {

    private Boolean complete;
}
