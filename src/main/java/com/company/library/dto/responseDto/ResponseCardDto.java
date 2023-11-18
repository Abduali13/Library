package com.company.library.dto.responseDto;

import com.company.library.entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseCardDto {
    private Integer cardId;

    @NotBlank(message = "Card Name cannot be null or empty")
    private String cardName;

    @NotNull(message = "Card Number cannot be null or empty")
    private String cardNumber;

    private Integer userId;

    private User users;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
