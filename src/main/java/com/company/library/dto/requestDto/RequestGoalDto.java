package com.company.library.dto.requestDto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestGoalDto {
    private String language;
    private String name;
}
