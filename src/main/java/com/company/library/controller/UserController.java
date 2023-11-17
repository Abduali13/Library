package com.company.library.controller;

import com.company.library.dto.ResponseDto;
import com.company.library.dto.requestDto.RequestUserDto;
import com.company.library.dto.responseDto.ResponseUserDto;
import com.company.library.service.UserService;
import com.company.library.util.SimpleRequestCrud;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.company.library.dto.SimpleResponseDto.convertStatusCodeByData;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "user")
public class UserController implements SimpleRequestCrud<Integer, RequestUserDto, ResponseUserDto> {
    private final UserService userService;

    @Override
    public ResponseEntity<ResponseDto<ResponseUserDto>> createEntity(@RequestBody @Valid RequestUserDto entity) {
        return convertStatusCodeByData(this.userService.createEntity(entity));
    }

    @Override
    public ResponseEntity<ResponseDto<ResponseUserDto>> getEntity(@RequestParam(value = "id") Integer entityId) {
        return convertStatusCodeByData(this.userService.getEntity(entityId));
    }

    @Override
    public ResponseEntity<ResponseDto<ResponseUserDto>> updateEntity(@RequestParam(value = "id") Integer entityId,
                                                                     @RequestBody @Valid RequestUserDto entity) {
        return convertStatusCodeByData(this.userService.updateEntity(entityId, entity));
    }

    @Override
    public ResponseEntity<ResponseDto<ResponseUserDto>> deleteEntity(@RequestParam(value = "id") Integer entityId) {
        return convertStatusCodeByData(this.userService.deleteEntity(entityId));
    }
}