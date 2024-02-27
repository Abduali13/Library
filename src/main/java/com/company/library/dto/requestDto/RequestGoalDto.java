package com.company.library.dto.requestDto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestGoalDto {

    @NotBlank(message = "Language cannot be null or empty")
    private String language;
    private String name;

}
