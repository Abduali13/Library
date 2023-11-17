package com.company.library.controller;

import com.company.library.dto.ResponseDto;
import com.company.library.dto.requestDto.RequestGenderDto;
import com.company.library.dto.responseDto.ResponseGenderDto;
import com.company.library.service.GenderService;
import com.company.library.util.SimpleRequestCrud;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.company.library.dto.SimpleResponseDto.convertStatusCodeByData;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "genders")
public class GenderController implements SimpleRequestCrud<Integer, RequestGenderDto, ResponseGenderDto> {

    private final GenderService genderService;

    @PostMapping
    @Override
    public ResponseEntity<ResponseDto<ResponseGenderDto>> createEntity(@RequestBody @Valid RequestGenderDto entity) {
        return convertStatusCodeByData(this.genderService.createEntity(entity));
    }

    @GetMapping
    @Override
    public ResponseEntity<ResponseDto<ResponseGenderDto>> getEntity(@RequestParam(value = "id") Integer entityId) {
        return convertStatusCodeByData(this.genderService.getEntity(entityId));
    }

    @PutMapping
    @Override
    public ResponseEntity<ResponseDto<ResponseGenderDto>> updateEntity(@RequestParam(value = "id") Integer entityId,
                                                                     @RequestBody @Valid RequestGenderDto entity) {
        return convertStatusCodeByData(this.genderService.updateEntity(entityId, entity));
    }

    @DeleteMapping
    @Override
    public ResponseEntity<ResponseDto<ResponseGenderDto>> deleteEntity(@RequestParam(value = "id") Integer entityId) {
        return convertStatusCodeByData(this.genderService.deleteEntity(entityId));
    }
}
