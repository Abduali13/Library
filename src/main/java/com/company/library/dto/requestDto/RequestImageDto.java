package com.company.library.dto.requestDto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestImageDto {
    private String path;
    private String type;
    private String size;
    private String token;
}
