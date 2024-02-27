package com.company.library.dto.requestDto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestPublisherDto {

    @NotBlank(message = "Publisher cannot be null or empty")
    private String publisher;
    private String location;

}
