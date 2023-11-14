package com.company.library.dto.requestDto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestUserDto {
    private String firstName;
    private String lastName;
    private String email;
    private Integer genderId;
    private String phone;
    private String password;
    private Integer cardId;
    private LocalDate birthDate;
}
