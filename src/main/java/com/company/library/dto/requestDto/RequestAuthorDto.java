package com.company.library.dto.requestDto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestAuthorDto {
    private String authorFirstName;
    private String authorLastName;
    private Integer authorAge;
}
