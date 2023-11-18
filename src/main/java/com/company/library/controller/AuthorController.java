package com.company.library.controller;

import com.company.library.dto.ResponseDto;
import com.company.library.dto.requestDto.RequestAuthorDto;
import com.company.library.dto.responseDto.ResponseAuthorDto;
import com.company.library.service.AuthorService;
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

import static com.company.library.constans.SwaggerConstants.AUTHOR_NOT_FOUND;
import static com.company.library.constans.SwaggerConstants.AUTHOR_SUCCESS;
import static com.company.library.dto.SimpleResponseDto.convertStatusCodeByData;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "authors")
public class AuthorController implements SimpleRequestCrud<Integer, RequestAuthorDto, ResponseAuthorDto> {

    private final AuthorService authorService;

    @PostMapping
    @Override
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Author API Success POST Method",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ResponseAuthorDto.class),
                            examples = @ExampleObject(value = AUTHOR_SUCCESS)
                    )
                    ),@ApiResponse(description = "Author API NOT  Found Post Method",
                    responseCode = "404",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(
                                    implementation = ResponseDto.class
                            ),
                            examples = @ExampleObject(value = AUTHOR_NOT_FOUND)
                    )
            )
            })
    @Operation(summary = "This is author Post Method")
    public ResponseEntity<ResponseDto<ResponseAuthorDto>> createEntity(@RequestBody @Valid RequestAuthorDto entity) {
        return convertStatusCodeByData(this.authorService.createEntity(entity));
    }

    @GetMapping
    @Override
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Author API Success Get Method",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ResponseAuthorDto.class),
                                    examples = @ExampleObject(value = AUTHOR_SUCCESS)
                            )
                    ),@ApiResponse(description = "Author API NOT  Found Get Method",
                    responseCode = "404",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(
                                    implementation = ResponseDto.class
                            ),
                            examples = @ExampleObject(value = AUTHOR_NOT_FOUND)
                    )
            )
            })
    @Operation(summary = "This is author Get Method")
    public ResponseEntity<ResponseDto<ResponseAuthorDto>> getEntity(@RequestParam(value = "id") Integer entityId) {
        return convertStatusCodeByData(this.authorService.getEntity(entityId));
    }

    @PutMapping
    @Override
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Author API Success Put Method",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ResponseAuthorDto.class),
                                    examples = @ExampleObject(value = AUTHOR_SUCCESS)
                            )
                    ),@ApiResponse(description = "Author API NOT  Found Put Method",
                    responseCode = "404",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(
                                    implementation = ResponseDto.class
                            ),
                            examples = @ExampleObject(value = AUTHOR_NOT_FOUND)
                    )
            )
            })
    @Operation(summary = "This is author Put Method")
    public ResponseEntity<ResponseDto<ResponseAuthorDto>> updateEntity(@RequestParam(value = "id") Integer entityId,
                                                                     @RequestBody @Valid RequestAuthorDto entity) {
        return convertStatusCodeByData(this.authorService.updateEntity(entityId, entity));
    }

    @DeleteMapping
    @Override
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Author API Success Delete Method",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ResponseAuthorDto.class),
                                    examples = @ExampleObject(value = AUTHOR_SUCCESS)
                            )
                    ),@ApiResponse(description = "Author API NOT  Found Delete Method",
                    responseCode = "404",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(
                                    implementation = ResponseDto.class
                            ),
                            examples = @ExampleObject(value = AUTHOR_NOT_FOUND)
                    )
            )
            })
    @Operation(summary = "This is author Delete Method")
    public ResponseEntity<ResponseDto<ResponseAuthorDto>> deleteEntity(@RequestParam(value = "id") Integer entityId) {
        return convertStatusCodeByData(this.authorService.deleteEntity(entityId));
    }
}
