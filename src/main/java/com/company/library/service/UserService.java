package com.company.library.service;

import com.company.library.dto.ResponseDto;
import com.company.library.dto.requestDto.RequestUserDto;
import com.company.library.dto.responseDto.ResponseUserDto;
import com.company.library.service.mapper.UserMapper;
import com.company.library.repository.UserRepository;
import com.company.library.util.SimpleCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService implements SimpleCrud<Integer, RequestUserDto, ResponseUserDto> {

    private final UserMapper userMapper;
    private final UserRepository userRepository;


    @Override
    public ResponseDto<ResponseUserDto> createEntity(RequestUserDto dto) {
        try {
            return ResponseDto.<ResponseUserDto>builder()
                    .success(true)
                    .message("OK")
                    .content(this.userMapper.toDto(this.userRepository.save(this.userMapper.toEntity(dto))))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<ResponseUserDto>builder()
                    .message(String.format("User while saving error! Message ::%s", e.getMessage()))
                    .build();
        }
    }

    @Override
    public ResponseDto<ResponseUserDto> getEntity(Integer entityId) {
        return this.userRepository.findByUserIdAndDeletedAtIsNull(entityId)
                .map(user -> ResponseDto.<ResponseUserDto>builder()
                        .success(true)
                        .message("Ok")
                        .content(this.userMapper.toDto(user))
                        .build())
                .orElse(ResponseDto.<ResponseUserDto>builder()
                        .message(String.format("User with %d: id is not found", entityId))
                        .build());

    }

    @Override
    public ResponseDto<ResponseUserDto> updateEntity(Integer entityId, RequestUserDto dto) {
        try {

            return this.userRepository.findByUserIdAndDeletedAtIsNull(entityId)
                    .map(user -> ResponseDto.<ResponseUserDto>builder()
                            .success(true)
                            .message("Ok")
                            .content(this.userMapper.toDto(this.userRepository.save(this.userMapper.updateUser(dto, user))))
                            .build())
                    .orElse(ResponseDto.<ResponseUserDto>builder()
                            .message(String.format("User with %d: id is not found", entityId))
                            .build());

        } catch (Exception e) {
            return ResponseDto.<ResponseUserDto>builder()
                    .message(String.format("User while updating error! Message ::%s", e.getMessage()))
                    .build();
        }
    }

    @Override
    public ResponseDto<ResponseUserDto> deleteEntity(Integer entityId) {
        try {
            return this.userRepository.findByUserIdAndDeletedAtIsNull(entityId)
                    .map(user -> {
                        user.setDeletedAt(LocalDateTime.now());
                        return ResponseDto.<ResponseUserDto>builder()
                                .success(true)
                                .message("Ok")
                                .content(this.userMapper.toDto(this.userRepository.save(user)))
                                .build();
                    })
                    .orElse(ResponseDto.<ResponseUserDto>builder()
                            .message(String.format("User with %d: id is not found", entityId))
                            .build());

        } catch (Exception e) {
            return ResponseDto.<ResponseUserDto>builder()
                    .message(String.format("User while deleting error! Message ::%s", e.getMessage()))
                    .build();
        }
    }
}
