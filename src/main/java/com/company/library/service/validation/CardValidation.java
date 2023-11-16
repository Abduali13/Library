package com.company.library.service.validation;

import com.company.library.dto.ErrorDto;
import com.company.library.dto.requestDto.RequestCardDto;
import com.company.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CardValidation {
    private final UserRepository userRepository;

    public List<ErrorDto> cardValid(RequestCardDto dto){
        List<ErrorDto> errorDtos = new ArrayList<>();

        if(this.userRepository.findByUserIdAndDeletedAtIsNull(dto.getUserId()).isEmpty()){
            errorDtos.add(new ErrorDto("userId" , String.format("Card with %d:id is not found" , dto.getUserId())));
        }
        return errorDtos;
    }
}
