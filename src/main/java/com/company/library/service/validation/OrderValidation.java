package com.company.library.service.validation;

import com.company.library.dto.ErrorDto;
import com.company.library.dto.requestDto.RequestOrdersDto;
import com.company.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderValidation {

    private final UserRepository userRepository;


    public List<ErrorDto> orderValid(RequestOrdersDto dto){
        List<ErrorDto> errorDtos = new ArrayList<>();

        if(this.userRepository.findByUserIdAndDeletedAtIsNull(dto.getUserId()).isEmpty()){
            errorDtos.add(new ErrorDto("userId" , String.format("Order with %d:id is not found" , dto.getUserId())));
        }
        return errorDtos;
    }
}
