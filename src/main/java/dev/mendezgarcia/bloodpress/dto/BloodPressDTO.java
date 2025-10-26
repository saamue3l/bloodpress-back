package dev.mendezgarcia.bloodpress.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BloodPressDTO {

    private Long id;

    @NotNull(message = "Date is required")
    private LocalDateTime date;

    @NotNull(message = "Systolic is required")
    @Min(value = 70, message = "Systolic must be between 70 and 200")
    @Max(value = 200, message = "Systolic must be between 70 and 200")
    private Integer systolic;

    @NotNull(message = "Diastolic is required")
    @Min(value = 40, message = "Diastolic must be between 40 and 130")
    @Max(value = 130, message = "Diastolic must be between 40 and 130")
    private Integer diastolic;

    @NotNull(message = "Pulse is required")
    @Min(value = 40, message = "Pulse must be between 40 and 200")
    @Max(value = 200, message = "Pulse must be between 40 and 200")
    private Integer pulse;
}
