package com.company.library.service.validation;

import com.company.library.dto.ErrorDto;
import com.company.library.dto.requestDto.RequestOrdersBookDto;
import com.company.library.repository.BooksRepository;
import com.company.library.repository.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class OrdersBookValidation {
    private final BooksRepository booksRepository;
    private final OrdersRepository ordersRepository;

    public List<ErrorDto> ordersBookValid(RequestOrdersBookDto dto){
        List<ErrorDto> errorDtos = new ArrayList<>();
        if(this.booksRepository.findByBookId(dto.getBookId()).isEmpty()){
            errorDtos.add(new ErrorDto("bookId" , String.format("OrdersBook with %d:id is not found" , dto.getBookId())));
        }
        if(this.ordersRepository.findByOrderIdAndDeletedAtIsNull(dto.getOrderId()).isEmpty()){
            errorDtos.add(new ErrorDto("orderId" , String.format("OrdersBook with %d:id is not found" , dto.getOrderId())));
        }

        return errorDtos;

    }

}
