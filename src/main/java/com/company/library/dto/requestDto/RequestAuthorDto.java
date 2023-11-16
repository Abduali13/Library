package com.company.library.dto.requestDto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestAuthorDto {

    @NotBlank(message = "AuthorFirstName cannot be null or empty")
    private String authorFirstName;

    @NotBlank(message = "AuthorLastName cannot be null or empty")
    private String authorLastName;

    private Integer authorAge;
}
