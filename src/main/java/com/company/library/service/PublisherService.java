package com.company.library.service;

import com.company.library.dto.ResponseDto;
import com.company.library.dto.requestDto.RequestPublisherDto;
import com.company.library.dto.responseDto.ResponsePublisherDto;
import com.company.library.service.mapper.PublisherMapper;
import com.company.library.repository.PublisherRepository;
import com.company.library.util.SimpleCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PublisherService implements SimpleCrud<Integer, RequestPublisherDto, ResponsePublisherDto> {
    private final PublisherMapper publisherMapper;
    private final PublisherRepository publisherRepository;

    @Override
    public ResponseDto<ResponsePublisherDto> createEntity(RequestPublisherDto dto) {
        try {

            return ResponseDto.<ResponsePublisherDto>builder()
                    .success(true)
                    .message("OK")
                    .content(this.publisherMapper.toDto(this.publisherRepository.save(this.publisherMapper.toEntity(dto))))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<ResponsePublisherDto>builder()
                    .code(-2)
                    .message(String.format("Publisher while saving error! Message ::%s", e.getMessage()))
                    .build();
        }
    }

    @Override
    public ResponseDto<ResponsePublisherDto> getEntity(Integer entityId) {
        return this.publisherRepository.findByPublisherIdAndDeletedAtIsNull(entityId)
                .map(publisher -> ResponseDto.<ResponsePublisherDto>builder()
                        .success(true)
                        .message("OK")
                        .content(this.publisherMapper.toDto(publisher))
                        .build())
                .orElse(ResponseDto.<ResponsePublisherDto>builder()
                        .message(String.format("Publisher with %d::id is not found", entityId))
                        .build());
    }

    @Override
    public ResponseDto<ResponsePublisherDto> updateEntity(Integer entityId, RequestPublisherDto dto) {
        try {

            return this.publisherRepository.findByPublisherIdAndDeletedAtIsNull(entityId)
                    .map(publisher -> ResponseDto.<ResponsePublisherDto>builder()
                            .success(true)
                            .message("OK")
                            .content(this.publisherMapper.toDto(this.publisherRepository.save(this.publisherMapper.updatePublisher(publisher, dto))))
                            .build())
                    .orElse(ResponseDto.<ResponsePublisherDto>builder()
                            .message(String.format("Publisher with %d::id is not found", entityId))
                            .build());
        } catch (Exception e) {
            return ResponseDto.<ResponsePublisherDto>builder()
                    .code(-2)
                    .message(String.format("Publisher while updating error! Message ::%s", e.getMessage()))
                    .build();
        }
    }

    @Override
    public ResponseDto<ResponsePublisherDto> deleteEntity(Integer entityId) {
        try {

            return this.publisherRepository.findByPublisherIdAndDeletedAtIsNull(entityId)
                    .map(publisher -> {
                        publisher.setDeletedAt(LocalDateTime.now());
                        return ResponseDto.<ResponsePublisherDto>builder()
                                .success(true)
                                .message("OK")
                                .content(this.publisherMapper.toDto(this.publisherRepository.save(publisher)))
                                .build();
                    })
                    .orElse(ResponseDto.<ResponsePublisherDto>builder()
                            .message(String.format("Publisher with %d::id is not found", entityId))
                            .build());
        } catch (Exception e) {
            return ResponseDto.<ResponsePublisherDto>builder()
                    .code(-2)
                    .message(String.format("Publisher while deleting error! Message ::%s", e.getMessage()))
                    .build();
        }
    }
}
