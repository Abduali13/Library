package com.company.library.service;

import com.company.library.dto.ResponseDto;
import com.company.library.dto.requestDto.RequestGenderDto;
import com.company.library.dto.responseDto.ResponseGenderDto;
import com.company.library.service.mapper.GenderMapper;
import com.company.library.repository.GenderRepository;
import com.company.library.util.SimpleCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class GenderService implements SimpleCrud<Integer, RequestGenderDto, ResponseGenderDto> {

    private final GenderMapper genderMapper;
    private final GenderRepository genderRepository;

    @Override
    public ResponseDto<ResponseGenderDto> createEntity(RequestGenderDto dto) {
        try {
            return ResponseDto.<ResponseGenderDto>builder()
                    .success(true)
                    .message("Ok")
                    .content(this.genderMapper.toDto(this.genderRepository.save(this.genderMapper.toEntity(dto))))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<ResponseGenderDto>builder()
                    .code(-2)
                    .message(String.format("Gender while saving error! Message::%s", e.getMessage()))
                    .build();
        }
    }

    @Override
    public ResponseDto<ResponseGenderDto> getEntity(Integer entityId) {
        return this.genderRepository.findByGenderId(entityId)
                .map(gender -> ResponseDto.<ResponseGenderDto>builder()
                        .success(true)
                        .message("Ok")
                        .content(this.genderMapper.toDto(gender))
                        .build())
                .orElse(ResponseDto.<ResponseGenderDto>builder()
                        .message(String.format("Gender with %d:id is not found", entityId))
                        .build());

    }

    @Override
    public ResponseDto<ResponseGenderDto> updateEntity(Integer entityId, RequestGenderDto dto) {
        try {

            return this.genderRepository.findByGenderId(entityId)
                    .map(gender -> ResponseDto.<ResponseGenderDto>builder()
                            .success(true)
                            .message("Ok")
                            .content(this.genderMapper.toDto(this.genderRepository.save(this.genderMapper.updateGender(gender, dto))))
                            .build())
                    .orElse(ResponseDto.<ResponseGenderDto>builder()
                            .message(String.format("Gender with %d:id is not found", entityId))
                            .build());
        } catch (Exception e) {
            return ResponseDto.<ResponseGenderDto>builder()
                    .code(-2)
                    .message(String.format("Gender while saving error! Message::%s", e.getMessage()))
                    .build();
        }
    }

    @Override
    public ResponseDto<ResponseGenderDto> deleteEntity(Integer entityId) {
        try {

            return this.genderRepository.findByGenderId(entityId)
                    .map(gender -> {
                        gender.setDeletedAt(LocalDateTime.now());
                        return ResponseDto.<ResponseGenderDto>builder()
                                .success(true)
                                .message("Ok")
                                .content(this.genderMapper.toDto(this.genderRepository.save(gender)))
                                .build();
                    })
                    .orElse(ResponseDto.<ResponseGenderDto>builder()
                            .message(String.format("Gender with %d:id is not found", entityId))
                            .build());
        } catch (Exception e) {
            return ResponseDto.<ResponseGenderDto>builder()
                    .code(-2)
                    .message(String.format("Gender while saving error! Message::%s", e.getMessage()))
                    .build();
        }
    }
}
