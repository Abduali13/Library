package com.company.library.dto.requestDto;

import com.company.library.entity.Gender;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestGenderDto {
    private Gender name;
    enum Genders{
        MALE,
        FEMALE
    }
}
