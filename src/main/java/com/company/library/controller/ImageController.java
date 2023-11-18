package com.company.library.controller;

import com.company.library.dto.ResponseDto;
import com.company.library.dto.requestDto.RequestImageDto;
import com.company.library.dto.responseDto.ResponseImageDto;
import com.company.library.service.ImageService;
import com.company.library.util.SimpleRequestCrud;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.company.library.dto.SimpleResponseDto.convertStatusCodeByData;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "images")
public class ImageController implements SimpleRequestCrud<Integer, RequestImageDto, ResponseImageDto> {

    private final ImageService imageService;

    @PostMapping
    @Override
    public ResponseEntity<ResponseDto<ResponseImageDto>> createEntity(@RequestBody @Valid RequestImageDto entity) {
        return convertStatusCodeByData(this.imageService.createEntity(entity));
    }

    @GetMapping
    @Override
    public ResponseEntity<ResponseDto<ResponseImageDto>> getEntity(@RequestParam(value = "id") Integer entityId) {
        return convertStatusCodeByData(this.imageService.getEntity(entityId));
    }

    @PutMapping
    @Override
    public ResponseEntity<ResponseDto<ResponseImageDto>> updateEntity(@RequestParam(value = "id") Integer entityId,
                                                                     @RequestBody @Valid RequestImageDto entity) {
        return convertStatusCodeByData(this.imageService.updateEntity(entityId, entity));
    }

    @DeleteMapping
    @Override
    public ResponseEntity<ResponseDto<ResponseImageDto>> deleteEntity(@RequestParam(value = "id") Integer entityId) {
        return convertStatusCodeByData(this.imageService.deleteEntity(entityId));
    }
}
