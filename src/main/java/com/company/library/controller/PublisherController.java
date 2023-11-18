package com.company.library.controller;

import com.company.library.dto.ResponseDto;
import com.company.library.dto.requestDto.RequestPublisherDto;
import com.company.library.dto.responseDto.ResponsePublisherDto;
import com.company.library.service.PublisherService;
import com.company.library.util.SimpleRequestCrud;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.company.library.dto.SimpleResponseDto.convertStatusCodeByData;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "publishers")
public class PublisherController implements SimpleRequestCrud<Integer, RequestPublisherDto, ResponsePublisherDto> {

    private final PublisherService publisherService;

    @PostMapping
    @Override
    public ResponseEntity<ResponseDto<ResponsePublisherDto>> createEntity(@RequestBody @Valid RequestPublisherDto entity) {
        return convertStatusCodeByData(this.publisherService.createEntity(entity));
    }

    @GetMapping
    @Override
    public ResponseEntity<ResponseDto<ResponsePublisherDto>> getEntity(@RequestParam(value = "id") Integer entityId) {
        return convertStatusCodeByData(this.publisherService.getEntity(entityId));
    }

    @PutMapping
    @Override
    public ResponseEntity<ResponseDto<ResponsePublisherDto>> updateEntity(@RequestParam(value = "id") Integer entityId,
                                                                     @RequestBody @Valid RequestPublisherDto entity) {
        return convertStatusCodeByData(this.publisherService.updateEntity(entityId, entity));
    }

    @DeleteMapping
    @Override
    public ResponseEntity<ResponseDto<ResponsePublisherDto>> deleteEntity(@RequestParam(value = "id") Integer entityId) {
        return convertStatusCodeByData(this.publisherService.deleteEntity(entityId));
    }
}
