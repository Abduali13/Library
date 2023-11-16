package com.company.library.service;

import com.company.library.dto.ErrorDto;
import com.company.library.dto.ResponseDto;
import com.company.library.dto.requestDto.RequestBookDto;
import com.company.library.dto.responseDto.ResponseBookDto;
import com.company.library.service.mapper.BookMapper;
import com.company.library.repository.BooksRepository;
import com.company.library.service.validation.BookValidation;
import com.company.library.util.SimpleCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor

public class BookService implements SimpleCrud<Integer, RequestBookDto, ResponseBookDto> {
    private final BookMapper bookMapper;
    private final BooksRepository booksRepository;
    private final BookValidation bookValidation;

    @Override
    public ResponseDto<ResponseBookDto> createEntity(RequestBookDto dto) {
        List<ErrorDto> valid = this.bookValidation.bookValid(dto);
        if(!valid.isEmpty()){
            return ResponseDto.<ResponseBookDto>builder()
                    .code(-3)
                    .message("Validation Error")
                    .errorList(valid)
                    .build();
        }
        try {
            return ResponseDto.<ResponseBookDto>builder()
                    .success(true)
                    .message("Ok")
                    .content(this.bookMapper.toDto(this.booksRepository.save(this.bookMapper.toEntity(dto))))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<ResponseBookDto>builder()
                    .code(-2)
                    .message(String.format("Book while saving error! Message::%s", e.getMessage()))
                    .build();
        }
    }

    @Override
    public ResponseDto<ResponseBookDto> getEntity(Integer entityId) {
        return this.booksRepository.findByBookId(entityId)
                .map(book -> ResponseDto.<ResponseBookDto>builder()
                        .success(true)
                        .message("Ok")
                        .content(this.bookMapper.toDto(book))
                        .build())
                .orElse(ResponseDto.<ResponseBookDto>builder()
                        .message(String.format("Book with %d:id is not found", entityId))
                        .build());

    }

    @Override
    public ResponseDto<ResponseBookDto> updateEntity(Integer entityId, RequestBookDto dto) {
        try {

            return this.booksRepository.findByBookId(entityId)
                    .map(book -> ResponseDto.<ResponseBookDto>builder()
                            .success(true)
                            .message("Ok")
                            .content(this.bookMapper.toDto(this.booksRepository.save(this.bookMapper.updateBook(book, dto))))
                            .build())
                    .orElse(ResponseDto.<ResponseBookDto>builder()
                            .message(String.format("Book with %d:id is not found", entityId))
                            .build());
        } catch (Exception e) {
            return ResponseDto.<ResponseBookDto>builder()
                    .code(-2)
                    .message(String.format("Book while updating error! Message::%s", e.getMessage()))
                    .build();
        }
    }

    @Override
    public ResponseDto<ResponseBookDto> deleteEntity(Integer entityId) {
        try {
            return this.booksRepository.findByBookId(entityId)
                    .map(book -> {
                        book.setDeletedAt(LocalDateTime.now());
                        return ResponseDto.<ResponseBookDto>builder()
                                .success(true)
                                .message("Ok")
                                .content(this.bookMapper.toDto(this.booksRepository.save(book)))
                                .build();
                    })
                    .orElse(ResponseDto.<ResponseBookDto>builder()
                            .message(String.format("Book with %d:id is not found", entityId))
                            .build());
        } catch (Exception e) {
            return ResponseDto.<ResponseBookDto>builder()
                    .code(-2)
                    .message(String.format("Book while deleting error! Message::%s", e.getMessage()))
                    .build();
        }
    }
}
