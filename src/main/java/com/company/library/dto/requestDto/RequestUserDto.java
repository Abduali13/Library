package com.company.library.dto.requestDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestUserDto {
    @NotBlank(message = "First Name cannot be null or empty")
    private String firstName;

    @NotBlank(message = "Last Name cannot be null or empty")
    private String lastName;

    @Email(message = "Email not valid")
    @NotBlank(message = "Email cannot be null or empty")
    private String email;

    private Integer genderId;

    @NotNull(message = "Phone cannot be null or empty")
    private String phone;

    @NotBlank(message = "Password cannot be null or empty")
    private String password;
    private Integer cardId;
    private LocalDate birthDate;
}
