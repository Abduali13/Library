package com.company.library.controller;


import com.company.library.dto.ResponseDto;
import com.company.library.dto.requestDto.RequestOrdersDto;
import com.company.library.dto.responseDto.ResponseOrdersDto;
import com.company.library.service.OrdersService;
import com.company.library.util.SimpleRequestCrud;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.company.library.dto.SimpleResponseDto.convertStatusCodeByData;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController implements SimpleRequestCrud<Integer, RequestOrdersDto, ResponseOrdersDto> {

    private final OrdersService orderService;

    @PostMapping
    @Override
    public ResponseEntity<ResponseDto<ResponseOrdersDto>> createEntity(@RequestBody @Valid RequestOrdersDto entity) {
        return convertStatusCodeByData(this.orderService.createEntity(entity));
    }

    @GetMapping
    @Override
    public ResponseEntity<ResponseDto<ResponseOrdersDto>> getEntity(@RequestParam(value = "id") Integer entityId) {
        return convertStatusCodeByData(this.orderService.getEntity(entityId));
    }

    @PutMapping
    @Override
    public ResponseEntity<ResponseDto<ResponseOrdersDto>> updateEntity(@RequestParam(value = "id") Integer entityId,
                                                                       @RequestBody @Valid RequestOrdersDto dto) {
        return convertStatusCodeByData(this.orderService.updateEntity(entityId, dto));
    }

    @DeleteMapping
    @Override
    public ResponseEntity<ResponseDto<ResponseOrdersDto>> deleteEntity(@RequestParam(value = "id") Integer entityId) {
        return convertStatusCodeByData(this.orderService.deleteEntity(entityId));
    }
}
