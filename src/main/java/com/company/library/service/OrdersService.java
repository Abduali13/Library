package com.company.library.service;

import com.company.library.dto.ErrorDto;
import com.company.library.dto.ResponseDto;
import com.company.library.dto.requestDto.RequestOrdersDto;
import com.company.library.dto.responseDto.ResponseOrdersDto;
import com.company.library.service.mapper.OrdersMapper;
import com.company.library.repository.OrdersRepository;
import com.company.library.service.validation.OrderValidation;
import com.company.library.util.SimpleCrud;
import jdk.dynalink.linker.LinkerServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdersService implements SimpleCrud<Integer, RequestOrdersDto, ResponseOrdersDto> {
    private final OrdersMapper ordersMapper;
    private final OrdersRepository ordersRepository;
    private final OrderValidation orderValidation;

    @Override
    public ResponseDto<ResponseOrdersDto> createEntity(RequestOrdersDto dto) {
        List<ErrorDto> valid = this.orderValidation.orderValid(dto);
        if(!valid.isEmpty()){
            return ResponseDto.<ResponseOrdersDto>builder()
                    .code(-3)
                    .message("Validation Error")
                    .errorList(valid)
                    .build();
        }
        try {

            return ResponseDto.<ResponseOrdersDto>builder()
                    .success(true)
                    .message("Ok")
                    .content(this.ordersMapper.toDto(this.ordersRepository.save(this.ordersMapper.toEntity(dto))))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<ResponseOrdersDto>builder()
                    .code(-2)
                    .message(String.format("Order while saving error! Message:: %s", e.getMessage()))
                    .build();
        }
    }

    @Override
    public ResponseDto<ResponseOrdersDto> getEntity(Integer entityId) {
        return this.ordersRepository.findByOrderIdAndDeletedAtIsNull(entityId)
                .map(orders -> ResponseDto.<ResponseOrdersDto>builder()
                        .success(true)
                        .message("Ok")
                        .content(this.ordersMapper.toDto(orders))
                        .build())
                .orElse(ResponseDto.<ResponseOrdersDto>builder()
                        .message(String.format("Orders with %d:id is not found!", entityId))
                        .build());
    }

    @Override
    public ResponseDto<ResponseOrdersDto> updateEntity(Integer entityId, RequestOrdersDto dto) {
        try {

            return this.ordersRepository.findByOrderIdAndDeletedAtIsNull(entityId)
                    .map(orders -> ResponseDto.<ResponseOrdersDto>builder()
                            .success(true)
                            .message("Ok")
                            .content(this.ordersMapper.toDto(this.ordersRepository.save(this.ordersMapper.updateOrders(orders, dto))))
                            .build())
                    .orElse(ResponseDto.<ResponseOrdersDto>builder()
                            .message(String.format("Orders with %d:id is not found!", entityId))
                            .build());
        } catch (Exception e) {
            return ResponseDto.<ResponseOrdersDto>builder()
                    .code(-2)
                    .message(String.format("Order while updating error! Message :: %s", e.getMessage()))
                    .build();
        }
    }

    @Override
    public ResponseDto<ResponseOrdersDto> deleteEntity(Integer entityId) {
        try {

            return this.ordersRepository.findByOrderIdAndDeletedAtIsNull(entityId)
                    .map(orders -> {
                        orders.setDeletedAt(LocalDateTime.now());
                        return ResponseDto.<ResponseOrdersDto>builder()
                                .success(true)
                                .message("Ok")
                                .content(this.ordersMapper.toDto(orders))
                                .build();
                    })
                    .orElse(ResponseDto.<ResponseOrdersDto>builder()
                            .message(String.format("Orders with %d:id is not found!", entityId))
                            .build());
        } catch (Exception e) {
            return ResponseDto.<ResponseOrdersDto>builder()
                    .code(-2)
                    .message(String.format("Order while deleting error! Message :: %s", e.getMessage()))
                    .build();
        }
    }
}
