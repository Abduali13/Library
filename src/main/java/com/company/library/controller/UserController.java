package com.company.library.controller;

import com.company.library.dto.ResponseDto;
import com.company.library.dto.requestDto.RequestUserDto;
import com.company.library.dto.responseDto.ResponseAuthorDto;
import com.company.library.dto.responseDto.ResponseUserDto;
import com.company.library.service.UserService;
import com.company.library.util.SimpleRequestCrud;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.company.library.constans.SwaggerConstants.*;
import static com.company.library.dto.SimpleResponseDto.convertStatusCodeByData;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "users")
public class UserController implements SimpleRequestCrud<Integer, RequestUserDto, ResponseUserDto> {
    private final UserService userService;

    @PostMapping
    @Override
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "User API Success Post Method",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ResponseAuthorDto.class),
                                    examples = @ExampleObject(value = USER_SUCCESS)
                            )
                    ),@ApiResponse(description = "User API NOT  Found Post Method",
                    responseCode = "404",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(
                                    implementation = ResponseDto.class
                            ),
                            examples = @ExampleObject(value = USER_NOT_FOUND)
                    )
            )
            })
    @Operation(summary = "This is User Post Method")
    public ResponseEntity<ResponseDto<ResponseUserDto>> createEntity(@RequestBody @Valid RequestUserDto entity) {
        return convertStatusCodeByData(this.userService.createEntity(entity));
    }

    @GetMapping
    @Override
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "User API Success Get Method",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ResponseAuthorDto.class),
                                    examples = @ExampleObject(value = USER_SUCCESS)
                            )
                    ),@ApiResponse(description = "User API NOT  Found Get Method",
                    responseCode = "404",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(
                                    implementation = ResponseDto.class
                            ),
                            examples = @ExampleObject(value = USER_NOT_FOUND)
                    )
            )
            })
    @Operation(summary = "This is User Get Method")
    public ResponseEntity<ResponseDto<ResponseUserDto>> getEntity(@RequestParam(value = "id") Integer entityId) {
        return convertStatusCodeByData(this.userService.getEntity(entityId));
    }

    @PutMapping
    @Override
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "User API Success Put Method",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ResponseAuthorDto.class),
                                    examples = @ExampleObject(value = USER_SUCCESS)
                            )
                    ),@ApiResponse(description = "User API NOT  Found Put Method",
                    responseCode = "404",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(
                                    implementation = ResponseDto.class
                            ),
                            examples = @ExampleObject(value = USER_NOT_FOUND)
                    )
            )
            })
    @Operation(summary = "This is User Put Method")
    public ResponseEntity<ResponseDto<ResponseUserDto>> updateEntity(@RequestParam(value = "id") Integer entityId,
                                                                     @RequestBody @Valid RequestUserDto entity) {
        return convertStatusCodeByData(this.userService.updateEntity(entityId, entity));
    }

    @DeleteMapping
    @Override
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "User API Success Delete Method",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ResponseAuthorDto.class),
                                    examples = @ExampleObject(value = USER_SUCCESS)
                            )
                    ),@ApiResponse(description = "User API NOT  Found Delete Method",
                    responseCode = "404",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(
                                    implementation = ResponseDto.class
                            ),
                            examples = @ExampleObject(value = USER_NOT_FOUND)
                    )
            )
            })
    @Operation(summary = "This is User Delete Method")
    public ResponseEntity<ResponseDto<ResponseUserDto>> deleteEntity(@RequestParam(value = "id") Integer entityId) {
        return convertStatusCodeByData(this.userService.deleteEntity(entityId));
    }
}