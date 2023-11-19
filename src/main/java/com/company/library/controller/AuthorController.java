package com.company.library.controller;

import com.company.library.dto.ResponseDto;
import com.company.library.dto.requestDto.RequestAuthorDto;
import com.company.library.dto.responseDto.ResponseAuthorDto;
import com.company.library.service.AuthorService;
import com.company.library.util.SimpleRequestCrud;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.company.library.dto.SimpleResponseDto.convertStatusCodeByData;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "authors")
public class AuthorController implements SimpleRequestCrud<Integer, RequestAuthorDto, ResponseAuthorDto> {

    private final AuthorService authorService;

    @PostMapping
    @Override
    public ResponseEntity<ResponseDto<ResponseAuthorDto>> createEntity(@RequestBody @Valid RequestAuthorDto entity) {
        return convertStatusCodeByData(this.authorService.createEntity(entity));
    }

    @GetMapping
    @Override
    public ResponseEntity<ResponseDto<ResponseAuthorDto>> getEntity(@RequestParam(value = "id") Integer entityId) {
        return convertStatusCodeByData(this.authorService.getEntity(entityId));
    }

    @PutMapping
    @Override
    public ResponseEntity<ResponseDto<ResponseAuthorDto>> updateEntity(@RequestParam(value = "id") Integer entityId,
                                                                     @RequestBody @Valid RequestAuthorDto entity) {
        return convertStatusCodeByData(this.authorService.updateEntity(entityId, entity));
    }

    @DeleteMapping
    @Override
    public ResponseEntity<ResponseDto<ResponseAuthorDto>> deleteEntity(@RequestParam(value = "id") Integer entityId) {
        return convertStatusCodeByData(this.authorService.deleteEntity(entityId));
    }
}
