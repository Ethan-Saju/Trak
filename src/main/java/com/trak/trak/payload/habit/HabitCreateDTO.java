package com.trak.trak.payload.habit;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

@Data
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = NumericHabitCreateDTO.class, name = "numeric"),
        @JsonSubTypes.Type(value = BinaryHabitCreateDTO.class, name = "binary")
})
public abstract class HabitCreateDTO {
    private String habitName;
    private String description;
}