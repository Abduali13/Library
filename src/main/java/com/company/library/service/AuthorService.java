package com.company.library.service;

import com.company.library.dto.ResponseDto;
import com.company.library.dto.requestDto.RequestAuthorDto;
import com.company.library.dto.responseDto.ResponseAuthorDto;
import com.company.library.service.mapper.AuthorMapper;
import com.company.library.repository.AuthorRepository;
import com.company.library.util.SimpleCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthorService implements SimpleCrud<Integer, RequestAuthorDto, ResponseAuthorDto> {

    private final AuthorMapper authorMapper;
    private final AuthorRepository authorRepository;

    @Override
    public ResponseDto<ResponseAuthorDto> createEntity(RequestAuthorDto dto) {
        try {

            return ResponseDto.<ResponseAuthorDto>builder()
                    .success(true)
                    .message("Ok")
                    .content(this.authorMapper.toDto(this.authorMapper.toEntity(dto)))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<ResponseAuthorDto>builder()
                    .code(-2)
                    .message(String.format("Author while saving error! Message::%s", e.getMessage()))
                    .build();
        }
    }

    @Override
    public ResponseDto<ResponseAuthorDto> getEntity(Integer entityId) {
        return this.authorRepository.findByAuthorIdAndDeletedAtIsNull(entityId)
                .map(author -> ResponseDto.<ResponseAuthorDto>builder()
                        .success(true)
                        .message("Ok")
                        .content(this.authorMapper.toDto(author))
                        .build())
                .orElse(ResponseDto.<ResponseAuthorDto>builder()
                        .message(String.format("Author with %d:id is not", entityId))
                        .build());

    }

    @Override
    public ResponseDto<ResponseAuthorDto> updateEntity(Integer entityId, RequestAuthorDto dto) {
        try {

            return this.authorRepository.findByAuthorIdAndDeletedAtIsNull(entityId)
                    .map(author -> ResponseDto.<ResponseAuthorDto>builder()
                            .success(true)
                            .message("Ok")
                            .content(this.authorMapper.toDto(this.authorRepository.save(this.authorMapper.updateAuthor(dto, author))))
                            .build())
                    .orElse(ResponseDto.<ResponseAuthorDto>builder()
                            .message(String.format("Author with %d:id is not", entityId))
                            .build());
        } catch (Exception e) {
            return ResponseDto.<ResponseAuthorDto>builder()
                    .code(-2)
                    .message(String.format("Author while updating error! Message::%s", e.getMessage()))
                    .build();
        }
    }

    @Override
    public ResponseDto<ResponseAuthorDto> deleteEntity(Integer entityId) {
        try {

            return this.authorRepository.findByAuthorIdAndDeletedAtIsNull(entityId)
                    .map(author -> {
                        author.setDeletedAt(LocalDateTime.now());
                        return ResponseDto.<ResponseAuthorDto>builder()
                                .success(true)
                                .message("Ok")
                                .content(this.authorMapper.toDto(this.authorRepository.save(author)))
                                .build();
                    })
                    .orElse(ResponseDto.<ResponseAuthorDto>builder()
                            .message(String.format("Author with %d:id is not", entityId))
                            .build());
        } catch (Exception e) {
            return ResponseDto.<ResponseAuthorDto>builder()
                    .code(-2)
                    .message(String.format("Author while deleting error! Message::%s", e.getMessage()))
                    .build();
        }
    }
}
