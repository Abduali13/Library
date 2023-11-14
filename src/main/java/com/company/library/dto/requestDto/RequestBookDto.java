package com.company.library.dto.requestDto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestBookDto {
    private String bookName;
    private Float price;
    private Integer page;
    private LocalDate published;
    private Float amount;
}
