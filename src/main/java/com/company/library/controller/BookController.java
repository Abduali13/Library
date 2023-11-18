package com.company.library.controller;

import com.company.library.dto.ResponseDto;
import com.company.library.dto.requestDto.RequestBookDto;
import com.company.library.dto.responseDto.ResponseBookDto;
import com.company.library.service.BookService;
import com.company.library.util.SimpleRequestCrud;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.company.library.dto.SimpleResponseDto.convertStatusCodeByData;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "books")
public class BookController implements SimpleRequestCrud<Integer, RequestBookDto, ResponseBookDto> {

    private final BookService bookService;

    @PostMapping
    @Override
    public ResponseEntity<ResponseDto<ResponseBookDto>> createEntity(@RequestBody @Valid RequestBookDto entity) {
        return convertStatusCodeByData(this.bookService.createEntity(entity));
    }

    @GetMapping
    @Override
    public ResponseEntity<ResponseDto<ResponseBookDto>> getEntity(@RequestParam(value = "id") Integer entityId) {
        return convertStatusCodeByData(this.bookService.getEntity(entityId));
    }

    @PutMapping
    @Override
    public ResponseEntity<ResponseDto<ResponseBookDto>> updateEntity(@RequestParam(value = "id") Integer entityId,
                                                                     @RequestBody @Valid RequestBookDto entity) {
        return convertStatusCodeByData(this.bookService.updateEntity(entityId, entity));
    }

    @DeleteMapping
    @Override
    public ResponseEntity<ResponseDto<ResponseBookDto>> deleteEntity(@RequestParam(value = "id") Integer entityId) {
        return convertStatusCodeByData(this.bookService.deleteEntity(entityId));
    }
}
