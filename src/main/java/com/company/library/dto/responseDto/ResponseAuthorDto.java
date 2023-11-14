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

    @NotBlank(message = "AuthorFirstName cannot be null or empty")
    private String authorFirstName;

    @NotBlank(message = "AuthorLastName cannot be null or empty")
    private String authorLastName;

    private Integer authorAge;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
