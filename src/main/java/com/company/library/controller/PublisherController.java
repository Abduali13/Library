package com.company.library.controller;

import com.company.library.dto.ResponseDto;
import com.company.library.dto.requestDto.RequestPublisherDto;
import com.company.library.dto.responseDto.ResponseAuthorDto;
import com.company.library.dto.responseDto.ResponsePublisherDto;
import com.company.library.service.PublisherService;
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
@RequestMapping(value = "publishers")
public class PublisherController implements SimpleRequestCrud<Integer, RequestPublisherDto, ResponsePublisherDto> {

    private final PublisherService publisherService;

    @PostMapping
    @Override
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Publisher API Success Post Method",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ResponseAuthorDto.class),
                                    examples = @ExampleObject(value = PUBLISHER_SUCCESS)
                            )
                    ),@ApiResponse(description = "Publisher API NOT  Found Post Method",
                    responseCode = "404",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(
                                    implementation = ResponseDto.class
                            ),
                            examples = @ExampleObject(value = PUBLISHER_NOT_FOUND)
                    )
            )
            })
    @Operation(summary = "This is Publisher Post Method")
    public ResponseEntity<ResponseDto<ResponsePublisherDto>> createEntity(@RequestBody @Valid RequestPublisherDto entity) {
        return convertStatusCodeByData(this.publisherService.createEntity(entity));
    }

    @GetMapping
    @Override
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Publisher API Success Get Method",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ResponseAuthorDto.class),
                                    examples = @ExampleObject(value = PUBLISHER_SUCCESS)
                            )
                    ),@ApiResponse(description = "Publisher API NOT  Found Get Method",
                    responseCode = "404",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(
                                    implementation = ResponseDto.class
                            ),
                            examples = @ExampleObject(value = PUBLISHER_NOT_FOUND)
                    )
            )
            })
    @Operation(summary = "This is Publisher Get Method")
    public ResponseEntity<ResponseDto<ResponsePublisherDto>> getEntity(@RequestParam(value = "id") Integer entityId) {
        return convertStatusCodeByData(this.publisherService.getEntity(entityId));
    }

    @PutMapping
    @Override
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Publisher API Success Put Method",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ResponseAuthorDto.class),
                                    examples = @ExampleObject(value = PUBLISHER_SUCCESS)
                            )
                    ),@ApiResponse(description = "Publisher API NOT  Found Put Method",
                    responseCode = "404",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(
                                    implementation = ResponseDto.class
                            ),
                            examples = @ExampleObject(value = PUBLISHER_NOT_FOUND)
                    )
            )
            })
    @Operation(summary = "This is Publisher Put Method")
    public ResponseEntity<ResponseDto<ResponsePublisherDto>> updateEntity(@RequestParam(value = "id") Integer entityId,
                                                                     @RequestBody @Valid RequestPublisherDto entity) {
        return convertStatusCodeByData(this.publisherService.updateEntity(entityId, entity));
    }

    @DeleteMapping
    @Override
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Publisher API Success Delete Method",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ResponseAuthorDto.class),
                                    examples = @ExampleObject(value = PUBLISHER_SUCCESS)
                            )
                    ),@ApiResponse(description = "Publisher API NOT  Found Delete Method",
                    responseCode = "404",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(
                                    implementation = ResponseDto.class
                            ),
                            examples = @ExampleObject(value = PUBLISHER_NOT_FOUND)
                    )
            )
            })
    @Operation(summary = "This is Publisher Delete Method")
    public ResponseEntity<ResponseDto<ResponsePublisherDto>> deleteEntity(@RequestParam(value = "id") Integer entityId) {
        return convertStatusCodeByData(this.publisherService.deleteEntity(entityId));
    }
}
