package com.company.library.service;

import com.company.library.dto.ResponseDto;
import com.company.library.dto.requestDto.RequestOrdersBookDto;
import com.company.library.dto.responseDto.ResponseOrdersBookDto;
import com.company.library.repository.OrdersBookRepository;
import com.company.library.service.mapper.OrdersBookMapper;
import com.company.library.util.SimpleCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OrdersBookService implements SimpleCrud<Integer, RequestOrdersBookDto, ResponseOrdersBookDto> {

    private final OrdersBookMapper ordersBookMapper;
    private final OrdersBookRepository ordersBookRepository;

    @Override
    public ResponseDto<ResponseOrdersBookDto> createEntity(RequestOrdersBookDto dto) {
        try {
            return ResponseDto.<ResponseOrdersBookDto>builder()
                    .success(true)
                    .message("OK")
                    .content(this.ordersBookMapper.toDto(this.ordersBookRepository.save(this.ordersBookMapper.toEntity(dto))))

                    .build();
        } catch (Exception e) {
            return ResponseDto.<ResponseOrdersBookDto>builder()
                    .code(-2)
                    .message(String.format("OrdersBook while saving error! Message ::%s", e.getMessage()))
                    .build();
        }
    }

    @Override
    public ResponseDto<ResponseOrdersBookDto> getEntity(Integer entityId) {
        return this.ordersBookRepository.findByOrdersBookIdAndDeletedAtIsNull(entityId)
                .map(ordersBook -> ResponseDto.<ResponseOrdersBookDto>builder()
                        .success(true)
                        .message("OK")
                        .content(this.ordersBookMapper.toDto(ordersBook))
                        .build())
                .orElse(ResponseDto.<ResponseOrdersBookDto>builder()
                        .message(String.format("OrdersBok with %d: id is not found", entityId))
                        .build());
    }

    @Override
    public ResponseDto<ResponseOrdersBookDto> updateEntity(Integer entityId, RequestOrdersBookDto entity) {
        try {
            return this.ordersBookRepository.findByOrdersBookIdAndDeletedAtIsNull(entityId)
                    .map(ordersBook -> ResponseDto.<ResponseOrdersBookDto>builder()
                            .success(true)
                            .message("OK")
                            .content(this.ordersBookMapper.toDto(this.ordersBookRepository.save(this.ordersBookMapper.updateOrdersBook(ordersBook))))
                            .build())
                    .orElse(ResponseDto.<ResponseOrdersBookDto>builder()
                            .message(String.format("OrdersBok with %d: id is not found", entityId))
                            .build());
        } catch (Exception e) {
            return ResponseDto.<ResponseOrdersBookDto>builder()
                    .code(-2)
                    .message(String.format("OrdersBook while saving error! Message ::%s", e.getMessage()))
                    .build();
        }
    }

    @Override
    public ResponseDto<ResponseOrdersBookDto> deleteEntity(Integer entityId) {
        try {
            return this.ordersBookRepository.findByOrdersBookIdAndDeletedAtIsNull(entityId)
                    .map(ordersBook -> {
                        ordersBook.setDeletedAt(LocalDateTime.now());
                       return ResponseDto.<ResponseOrdersBookDto>builder()
                                .success(true)
                                .message("OK")
                                .content(this.ordersBookMapper.toDto(this.ordersBookRepository.save(ordersBook)))
                                .build();
                    })
                    .orElse(ResponseDto.<ResponseOrdersBookDto>builder()
                            .message(String.format("OrdersBok with %d: id is not found", entityId))
                            .build());
        } catch (Exception e) {
            return ResponseDto.<ResponseOrdersBookDto>builder()
                    .code(-2)
                    .message(String.format("OrdersBook while saving error! Message ::%s", e.getMessage()))
                    .build();
        }
    }
}
