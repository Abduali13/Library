package com.company.library.dto.requestDto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestImageDto {

    @NotBlank(message = "Path cannot be null or empty")
    private String path;
    private String type;
    private String size;
    private String token;

}
