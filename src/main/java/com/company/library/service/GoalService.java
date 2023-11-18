package com.company.library.service;

import com.company.library.dto.ResponseDto;
import com.company.library.dto.requestDto.RequestGoalDto;
import com.company.library.dto.responseDto.ResponseGoalDto;
import com.company.library.service.mapper.GoalMapper;
import com.company.library.repository.GoalRepository;
import com.company.library.util.SimpleCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class GoalService implements SimpleCrud<Integer, RequestGoalDto, ResponseGoalDto> {
    private final GoalMapper goalMapper;
    private final GoalRepository goalRepository;

    @Override
    public ResponseDto<ResponseGoalDto> createEntity(RequestGoalDto dto) {
        try {

            return ResponseDto.<ResponseGoalDto>builder()
                    .success(true)
                    .message("Ok")
                    .content(this.goalMapper.toDto(this.goalRepository.save(this.goalMapper.toEntity(dto))))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<ResponseGoalDto>builder()
                    .code(-2)
                    .message(String.format("Goal while saving error :: %s", e.getMessage()))
                    .build();
        }
    }

    @Override
    public ResponseDto<ResponseGoalDto> getEntity(Integer entityId) {
        return this.goalRepository.findByGoalIdAndDeletedAtIsNull(entityId)
                .map(goal -> ResponseDto.<ResponseGoalDto>builder()
                        .success(true)
                        .message("OK")
                        .content(this.goalMapper.toDto(goal))
                        .build())
                .orElse(ResponseDto.<ResponseGoalDto>builder()
                        .message(String.format("Goal with %d:id is not found", entityId))
                        .build());
    }

    @Override
    public ResponseDto<ResponseGoalDto> updateEntity(Integer entityId, RequestGoalDto dto) {
        try {

            return this.goalRepository.findByGoalIdAndDeletedAtIsNull(entityId)
                    .map(goal -> ResponseDto.<ResponseGoalDto>builder()
                            .success(true)
                            .message("OK")
                            .content(this.goalMapper.toDto(this.goalRepository.save(this.goalMapper.updateGoal(goal, dto))))
                            .build())
                    .orElse(ResponseDto.<ResponseGoalDto>builder()
                            .message(String.format("Goal with %d:id is not found", entityId))
                            .build());
        } catch (Exception e) {
            return ResponseDto.<ResponseGoalDto>builder()
                    .code(-2)
                    .message(String.format("Goal while updating error :: %s", e.getMessage()))
                    .build();
        }
    }

    @Override
    public ResponseDto<ResponseGoalDto> deleteEntity(Integer entityId) {
        try {

            return this.goalRepository.findByGoalIdAndDeletedAtIsNull(entityId)
                    .map(goal -> {
                        goal.setDeletedAt(LocalDateTime.now());
                        return ResponseDto.<ResponseGoalDto>builder()
                                .success(true)
                                .message("OK")
                                .content(this.goalMapper.toDto(this.goalRepository.save(goal)))
                                .build();
                    })
                    .orElse(ResponseDto.<ResponseGoalDto>builder()
                            .message(String.format("Goal with %d:id is not found", entityId))
                            .build());
        } catch (Exception e) {
            return ResponseDto.<ResponseGoalDto>builder()
                    .code(-2)
                    .message(String.format("Goal while deleting error :: %s", e.getMessage()))
                    .build();
        }
    }
}
