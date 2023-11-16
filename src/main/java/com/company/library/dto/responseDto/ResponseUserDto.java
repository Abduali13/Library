package com.company.library.dto.responseDto;

import com.company.library.entity.Card;
import com.company.library.entity.Gender;
import com.company.library.entity.Orders;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseUserDto {
    private Integer userId;

    private String firstName;

    private String lastName;

    private String email;

    private Integer genderId;

    private String phone;

    private String password;
    private Integer cardId;
    private LocalDate birthDate;

    private Gender gender;

    private Set<ResponseCardDto> cards;

    private List<ResponseOrdersDto> orders;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
