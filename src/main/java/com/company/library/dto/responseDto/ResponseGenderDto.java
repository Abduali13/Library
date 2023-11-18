package com.company.library.dto.responseDto;

import com.company.library.entity.Gender;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseGenderDto {
    private Integer genderId;

    @NotBlank(message = "Gender Name cannot be null or empty")
    private Gender name;
    enum Genders{
        MALE,
        FEMALE
    }
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
