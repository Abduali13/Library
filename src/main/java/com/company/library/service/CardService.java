package com.company.library.service;

import com.company.library.dto.ResponseDto;
import com.company.library.dto.requestDto.RequestCardDto;
import com.company.library.dto.responseDto.ResponseCardDto;
import com.company.library.service.mapper.CardMapper;
import com.company.library.repository.CardRepository;
import com.company.library.util.SimpleCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor

public class CardService implements SimpleCrud<Integer, RequestCardDto, ResponseCardDto> {
    private final CardMapper cardMapper;
    private final CardRepository cardRepository;

    @Override
    public ResponseDto<ResponseCardDto> createEntity(RequestCardDto dto) {
        try {
            return ResponseDto.<ResponseCardDto>builder()
                    .success(true)
                    .message("Ok")
                    .content(this.cardMapper.toDto(this.cardRepository.save(this.cardMapper.toEntity(dto))))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<ResponseCardDto>builder()
                    .code(-2)
                    .message(String.format("Card while saving error! Message ::%s", e.getMessage()))
                    .build();
        }
    }

    @Override
    public ResponseDto<ResponseCardDto> getEntity(Integer entityId) {
        return this.cardRepository.findByCardIdAndDeletedAtIsNull(entityId)
                .map(card -> ResponseDto.<ResponseCardDto>builder()
                        .success(true)
                        .message("Ok")
                        .content(this.cardMapper.toDto(card))
                        .build())
                .orElse(ResponseDto.<ResponseCardDto>builder()
                        .message(String.format("Card with %d:id is not found", entityId))
                        .build());

    }

    @Override
    public ResponseDto<ResponseCardDto> updateEntity(Integer entityId, RequestCardDto dto) {
        try {
            return this.cardRepository.findByCardIdAndDeletedAtIsNull(entityId)
                    .map(card -> ResponseDto.<ResponseCardDto>builder()
                            .success(true)
                            .message("Ok")
                            .content(this.cardMapper.toDto(this.cardRepository.save(this.cardMapper.updateCard(dto, card))))
                            .build())
                    .orElse(ResponseDto.<ResponseCardDto>builder()
                            .message(String.format("Card with %d:id is not found", entityId))
                            .build());
        } catch (Exception e) {
            return ResponseDto.<ResponseCardDto>builder()
                    .code(-2)
                    .message(String.format("Card while updating error! Message ::%s", e.getMessage()))
                    .build();
        }
    }

    @Override
    public ResponseDto<ResponseCardDto> deleteEntity(Integer entityId) {
        try {

            return this.cardRepository.findByCardIdAndDeletedAtIsNull(entityId)
                    .map(card -> {
                        card.setDeletedAt(LocalDateTime.now());
                        return ResponseDto.<ResponseCardDto>builder()
                                .success(true)
                                .message("Ok")
                                .content(this.cardMapper.toDto(this.cardRepository.save(card)))
                                .build();
                    })
                    .orElse(ResponseDto.<ResponseCardDto>builder()
                            .message(String.format("Card with %d:id is not found", entityId))
                            .build());
        } catch (Exception e) {
            return ResponseDto.<ResponseCardDto>builder()
                    .code(-2)
                    .message(String.format("Card while deleting error! Message ::%s", e.getMessage()))
                    .build();
        }
    }
}
