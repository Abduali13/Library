package com.company.library.service;

import com.company.library.dto.ResponseDto;
import com.company.library.dto.requestDto.RequestImageDto;
import com.company.library.dto.responseDto.ResponseImageDto;
import com.company.library.service.mapper.ImageMapper;
import com.company.library.repository.ImageRepository;
import com.company.library.util.SimpleCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ImageService implements SimpleCrud<Integer, RequestImageDto, ResponseImageDto> {
    private final ImageMapper imageMapper;
    private final ImageRepository imageRepository;

    @Override
    public ResponseDto<ResponseImageDto> createEntity(RequestImageDto dto) {
        try {

            return ResponseDto.<ResponseImageDto>builder()
                    .success(true)
                    .message("Ok")
                    .content(this.imageMapper.toDto(this.imageRepository.save(this.imageMapper.toEntity(dto))))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<ResponseImageDto>builder()
                    .code(-2)
                    .message(String.format("Image while saving error! Message :: %s", e.getMessage()))
                    .build();
        }
    }

    @Override
    public ResponseDto<ResponseImageDto> getEntity(Integer entityId) {
        return this.imageRepository.findByImageIdAndDeletedAtIsNull(entityId)
                .map(image -> ResponseDto.<ResponseImageDto>builder()
                        .success(true)
                        .message("Ok")
                        .content(this.imageMapper.toDto(image))
                        .build())
                .orElse(ResponseDto.<ResponseImageDto>builder()
                        .message(String.format("Image with %d:id is not found!", entityId))
                        .build());
    }

    @Override
    public ResponseDto<ResponseImageDto> updateEntity(Integer entityId, RequestImageDto dto) {
        try {

            return this.imageRepository.findByImageIdAndDeletedAtIsNull(entityId)
                    .map(image -> ResponseDto.<ResponseImageDto>builder()
                            .success(true)
                            .message("Ok")
                            .content(this.imageMapper.toDto(this.imageRepository.save(this.imageMapper.updateImage(image, dto))))
                            .build())
                    .orElse(ResponseDto.<ResponseImageDto>builder()
                            .message(String.format("Image with %d:id is not found!", entityId))
                            .build());
        } catch (Exception e) {
            return ResponseDto.<ResponseImageDto>builder()
                    .code(-2)
                    .message(String.format("Image while updating error! Message :: %s", e.getMessage()))
                    .build();
        }
    }

    @Override
    public ResponseDto<ResponseImageDto> deleteEntity(Integer entityId) {
        try {

            return this.imageRepository.findByImageIdAndDeletedAtIsNull(entityId)
                    .map(image -> {
                        image.setDeletedAt(LocalDateTime.now());
                        return ResponseDto.<ResponseImageDto>builder()
                                .success(true)
                                .message("Ok")
                                .content(this.imageMapper.toDto(this.imageRepository.save(image)))
                                .build();
                    })
                    .orElse(ResponseDto.<ResponseImageDto>builder()
                            .message(String.format("Image with %d:id is not found!", entityId))
                            .build());
        } catch (Exception e) {
            return ResponseDto.<ResponseImageDto>builder()
                    .code(-2)
                    .message(String.format("Image while deleting error! Message :: %s", e.getMessage()))
                    .build();
        }
    }
}
