package com.company.library.dto.requestDto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestCardDto {

    private String cardName;
    private String cardNumber;
    private Integer userId;

}
