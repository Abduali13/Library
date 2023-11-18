package com.company.library.controller;

import com.company.library.dto.ResponseDto;
import com.company.library.dto.requestDto.RequestImageDto;
import com.company.library.dto.responseDto.ResponseAuthorDto;
import com.company.library.dto.responseDto.ResponseImageDto;
import com.company.library.service.ImageService;
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
@RequestMapping(value = "images")
public class ImageController implements SimpleRequestCrud<Integer, RequestImageDto, ResponseImageDto> {

    private final ImageService imageService;

    @PostMapping
    @Override
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Image API Success POST Method",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ResponseAuthorDto.class),
                                    examples = @ExampleObject(value = IMAGE_SUCCESS)
                            )
                    ),@ApiResponse(description = "Image API NOT  Found Post Method",
                    responseCode = "404",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(
                                    implementation = ResponseDto.class
                            ),
                            examples = @ExampleObject(value = IMAGE_NOT_FOUND)
                    )
            )
            })
    @Operation(summary = "This is Image Post Method")
    public ResponseEntity<ResponseDto<ResponseImageDto>> createEntity(@RequestBody @Valid RequestImageDto entity) {
        return convertStatusCodeByData(this.imageService.createEntity(entity));
    }

    @GetMapping
    @Override
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Image API Success Get Method",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ResponseAuthorDto.class),
                                    examples = @ExampleObject(value = IMAGE_SUCCESS)
                            )
                    ),@ApiResponse(description = "Image API NOT  Found Get Method",
                    responseCode = "404",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(
                                    implementation = ResponseDto.class
                            ),
                            examples = @ExampleObject(value = IMAGE_NOT_FOUND)
                    )
            )
            })
    @Operation(summary = "This is Image Get Method")
    public ResponseEntity<ResponseDto<ResponseImageDto>> getEntity(@RequestParam(value = "id") Integer entityId) {
        return convertStatusCodeByData(this.imageService.getEntity(entityId));
    }

    @PutMapping
    @Override
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Image API Success PUT Method",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ResponseAuthorDto.class),
                                    examples = @ExampleObject(value = IMAGE_SUCCESS)
                            )
                    ),@ApiResponse(description = "Image API NOT  Found Put Method",
                    responseCode = "404",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(
                                    implementation = ResponseDto.class
                            ),
                            examples = @ExampleObject(value = IMAGE_NOT_FOUND)
                    )
            )
            })
    @Operation(summary = "This is Image PUT Method")
    public ResponseEntity<ResponseDto<ResponseImageDto>> updateEntity(@RequestParam(value = "id") Integer entityId,
                                                                     @RequestBody @Valid RequestImageDto entity) {
        return convertStatusCodeByData(this.imageService.updateEntity(entityId, entity));
    }

    @DeleteMapping
    @Override
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Image API Success Delete Method",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ResponseAuthorDto.class),
                                    examples = @ExampleObject(value = IMAGE_SUCCESS)
                            )
                    ),@ApiResponse(description = "Image API NOT  Found Delete Method",
                    responseCode = "404",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(
                                    implementation = ResponseDto.class
                            ),
                            examples = @ExampleObject(value = IMAGE_NOT_FOUND)
                    )
            )
            })
    @Operation(summary = "This is Image Delete Method")
    public ResponseEntity<ResponseDto<ResponseImageDto>> deleteEntity(@RequestParam(value = "id") Integer entityId) {
        return convertStatusCodeByData(this.imageService.deleteEntity(entityId));
    }
}
