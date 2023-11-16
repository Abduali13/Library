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
    private Gender name;
    enum Gender{
        MALE,
        FEMALE
    }
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
