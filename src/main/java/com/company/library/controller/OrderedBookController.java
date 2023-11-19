package com.company.library.controller;


import com.company.library.dto.ResponseDto;
import com.company.library.dto.requestDto.RequestOrdersBookDto;
import com.company.library.dto.responseDto.ResponseOrdersBookDto;
import com.company.library.service.OrdersBookService;
import com.company.library.util.SimpleRequestCrud;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.company.library.dto.SimpleResponseDto.convertStatusCodeByData;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "orderBook")
public class OrderedBookController implements SimpleRequestCrud<Integer, RequestOrdersBookDto, ResponseOrdersBookDto> {

    private final OrdersBookService ordersBookService;

    @PostMapping
    @Override
    public ResponseEntity<ResponseDto<ResponseOrdersBookDto>> createEntity(@RequestBody @Valid RequestOrdersBookDto entity) {
        return convertStatusCodeByData(this.ordersBookService.createEntity(entity));
    }

    @Override
    public ResponseEntity<ResponseDto<ResponseOrdersBookDto>> getEntity(@RequestParam(value = "id") Integer entityId) {
        return convertStatusCodeByData(this.ordersBookService.getEntity(entityId));
    }

    @Override
    public ResponseEntity<ResponseDto<ResponseOrdersBookDto>> updateEntity(@RequestParam(value = "id") Integer entityId,
                                                                           @RequestBody @Valid RequestOrdersBookDto entity) {
        return convertStatusCodeByData(this.ordersBookService.updateEntity(entityId, entity));
    }

    @Override
    public ResponseEntity<ResponseDto<ResponseOrdersBookDto>> deleteEntity(@RequestParam(value = "id") Integer entityId) {
        return convertStatusCodeByData(this.ordersBookService.deleteEntity(entityId));
    }
}
