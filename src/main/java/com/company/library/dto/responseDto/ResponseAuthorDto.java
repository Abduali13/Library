package com.company.library.dto.responseDto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseAuthorDto {

    private Integer authorId;
    private String authorFirstName;
    private String authorLastName;

    private Integer authorAge;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
