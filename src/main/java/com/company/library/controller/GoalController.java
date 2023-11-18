package com.company.library.controller;

import com.company.library.dto.ResponseDto;
import com.company.library.dto.requestDto.RequestGoalDto;
import com.company.library.dto.responseDto.ResponseGoalDto;
import com.company.library.service.GoalService;
import com.company.library.util.SimpleRequestCrud;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.company.library.dto.SimpleResponseDto.convertStatusCodeByData;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "goals")
public class GoalController implements SimpleRequestCrud<Integer, RequestGoalDto, ResponseGoalDto> {

    private final GoalService goalService;

    @PostMapping
    @Override
    public ResponseEntity<ResponseDto<ResponseGoalDto>> createEntity(@RequestBody @Valid RequestGoalDto entity) {
        return convertStatusCodeByData(this.goalService.createEntity(entity));
    }

    @GetMapping
    @Override
    public ResponseEntity<ResponseDto<ResponseGoalDto>> getEntity(@RequestParam(value = "id") Integer entityId) {
        return convertStatusCodeByData(this.goalService.getEntity(entityId));
    }

    @PutMapping
    @Override
    public ResponseEntity<ResponseDto<ResponseGoalDto>> updateEntity(@RequestParam(value = "id") Integer entityId,
                                                                     @RequestBody @Valid RequestGoalDto entity) {
        return convertStatusCodeByData(this.goalService.updateEntity(entityId, entity));
    }

    @DeleteMapping
    @Override
    public ResponseEntity<ResponseDto<ResponseGoalDto>> deleteEntity(@RequestParam(value = "id") Integer entityId) {
        return convertStatusCodeByData(this.goalService.deleteEntity(entityId));
    }
}
