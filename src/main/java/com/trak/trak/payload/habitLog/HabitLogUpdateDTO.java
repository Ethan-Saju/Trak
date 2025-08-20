package com.trak.trak.payload.habitLog;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.trak.trak.payload.habit.BinaryHabitCreateDTO;
import com.trak.trak.payload.habit.NumericHabitCreateDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = NumericHabitLogUpdateDTO.class, name = "numeric"),
        @JsonSubTypes.Type(value = BinaryHabitLogUpdateDTO.class, name = "binary")
})

public class HabitLogUpdateDTO {
    String note;
}
