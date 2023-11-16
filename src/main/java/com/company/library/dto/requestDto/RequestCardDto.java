package com.company.library.dto.requestDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestCardDto {
    @NotBlank(message = "Card Name cannot be null or empty")
    private String cardName;

    @NotNull(message = "Card Number cannot be null or empty")
    private String cardNumber;

    private Integer userId;
}
