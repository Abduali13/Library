package com.company.library.controller;

import com.company.library.dto.ResponseDto;
import com.company.library.dto.requestDto.RequestBookDto;
import com.company.library.dto.responseDto.ResponseAuthorDto;
import com.company.library.dto.responseDto.ResponseBookDto;
import com.company.library.service.BookService;
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
@RequestMapping(value = "books")
public class BookController implements SimpleRequestCrud<Integer, RequestBookDto, ResponseBookDto> {

    private final BookService bookService;

    @PostMapping
    @Override
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Book API Success POST Method",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ResponseAuthorDto.class),
                                    examples = @ExampleObject(value = BOOK_SUCCESS)
                            )
                    ),@ApiResponse(description = "Book API NOT  Found Post Method",
                    responseCode = "404",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(
                                    implementation = ResponseDto.class
                            ),
                            examples = @ExampleObject(value = BOOK_NOT_FOUND)
                    )
            )
            })
    @Operation(summary = "This is book Post Method")
    public ResponseEntity<ResponseDto<ResponseBookDto>> createEntity(@RequestBody @Valid RequestBookDto entity) {
        return convertStatusCodeByData(this.bookService.createEntity(entity));
    }

    @GetMapping
    @Override
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Book API Success Get Method",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ResponseAuthorDto.class),
                                    examples = @ExampleObject(value = BOOK_SUCCESS)
                            )
                    ),@ApiResponse(description = "Book API NOT  Found Get Method",
                    responseCode = "404",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(
                                    implementation = ResponseDto.class
                            ),
                            examples = @ExampleObject(value = BOOK_NOT_FOUND)
                    )
            )
            })
    @Operation(summary = "This is book Get Method")
    public ResponseEntity<ResponseDto<ResponseBookDto>> getEntity(@RequestParam(value = "id") Integer entityId) {
        return convertStatusCodeByData(this.bookService.getEntity(entityId));
    }

    @PutMapping
    @Override
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Book API Success Put Method",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ResponseAuthorDto.class),
                                    examples = @ExampleObject(value = BOOK_SUCCESS)
                            )
                    ),@ApiResponse(description = "Book API NOT  Found Put Method",
                    responseCode = "404",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(
                                    implementation = ResponseDto.class
                            ),
                            examples = @ExampleObject(value = BOOK_NOT_FOUND)
                    )
            )
            })
    @Operation(summary = "This is book Put Method")
    public ResponseEntity<ResponseDto<ResponseBookDto>> updateEntity(@RequestParam(value = "id") Integer entityId,
                                                                     @RequestBody @Valid RequestBookDto entity) {
        return convertStatusCodeByData(this.bookService.updateEntity(entityId, entity));
    }

    @DeleteMapping
    @Override
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Book API Success Delete Method",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ResponseAuthorDto.class),
                                    examples = @ExampleObject(value = BOOK_SUCCESS)
                            )
                    ),@ApiResponse(description = "Book API NOT  Found Delete Method",
                    responseCode = "404",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(
                                    implementation = ResponseDto.class
                            ),
                            examples = @ExampleObject(value = BOOK_NOT_FOUND)
                    )
            )
            })
    @Operation(summary = "This is book Delete Method")
    public ResponseEntity<ResponseDto<ResponseBookDto>> deleteEntity(@RequestParam(value = "id") Integer entityId) {
        return convertStatusCodeByData(this.bookService.deleteEntity(entityId));
    }
}
