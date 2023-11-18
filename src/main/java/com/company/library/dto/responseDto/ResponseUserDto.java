package com.company.library.dto.responseDto;

import com.company.library.entity.Gender;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(value = "password",allowSetters = true)
public class ResponseUserDto {
    private Integer userId;

    @NotBlank(message = "First Name cannot be null or empty")
    private String firstName;

    @NotBlank(message = "Last Name cannot be null or empty")
    private String lastName;

     private String username;

    private Integer genderId;
    @NotNull(message = "Phone cannot be null or empty")
    private String phone;

    @NotBlank(message = "Password cannot be null or empty")
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
