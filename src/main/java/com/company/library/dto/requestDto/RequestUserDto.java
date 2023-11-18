package com.company.library.dto.requestDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    private String username;
    private Integer genderId;
    private String phone;
    private String password;
    private Integer cardId;
    private LocalDate birthDate;
}
