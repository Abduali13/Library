package com.company.library.dto.requestDto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestPublisherDto {
    private String publisher;
    private String location;
}
