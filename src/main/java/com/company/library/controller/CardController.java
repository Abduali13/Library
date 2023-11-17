package com.company.library.controller;

import com.company.library.dto.ResponseDto;
import com.company.library.dto.requestDto.RequestCardDto;
import com.company.library.dto.responseDto.ResponseCardDto;
import com.company.library.service.CardService;
import com.company.library.util.SimpleRequestCrud;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.company.library.dto.SimpleResponseDto.convertStatusCodeByData;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "cards")
public class CardController implements SimpleRequestCrud<Integer, RequestCardDto, ResponseCardDto> {

    private final CardService cardService;

    @PostMapping
    @Override
    public ResponseEntity<ResponseDto<ResponseCardDto>> createEntity(@RequestBody @Valid RequestCardDto entity) {
        return convertStatusCodeByData(this.cardService.createEntity(entity));
    }

    @GetMapping
    @Override
    public ResponseEntity<ResponseDto<ResponseCardDto>> getEntity(@RequestParam(value = "id") Integer entityId) {
        return convertStatusCodeByData(this.cardService.getEntity(entityId));
    }

    @PutMapping
    @Override
    public ResponseEntity<ResponseDto<ResponseCardDto>> updateEntity(@RequestParam(value = "id") Integer entityId,
                                                                     @RequestBody @Valid RequestCardDto entity) {
        return convertStatusCodeByData(this.cardService.updateEntity(entityId, entity));
    }

    @DeleteMapping
    @Override
    public ResponseEntity<ResponseDto<ResponseCardDto>> deleteEntity(@RequestParam(value = "id") Integer entityId) {
        return convertStatusCodeByData(this.cardService.deleteEntity(entityId));
    }
}
