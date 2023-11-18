package com.company.library.controller;


import com.company.library.dto.ResponseDto;
import com.company.library.dto.requestDto.RequestOrdersBookDto;
import com.company.library.dto.responseDto.ResponseAuthorDto;
import com.company.library.dto.responseDto.ResponseOrdersBookDto;
import com.company.library.service.OrdersBookService;
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
@RequestMapping(value = "orderBook")
public class OrderedBookController implements SimpleRequestCrud<Integer, RequestOrdersBookDto, ResponseOrdersBookDto> {

    private final OrdersBookService ordersBookService;

    @PostMapping
    @Override
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "OrdersBook API Success POST Method",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ResponseAuthorDto.class),
                                    examples = @ExampleObject(value = ORDERS_BOOK_SUCCESS)
                            )
                    ),@ApiResponse(description = "OrdersBook API NOT  Found Post Method",
                    responseCode = "404",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(
                                    implementation = ResponseDto.class
                            ),
                            examples = @ExampleObject(value = ORDERS_BOOK_NOT_FOUND)
                    )
            )
            })
    @Operation(summary = "This is OrdersBook Post Method")
    public ResponseEntity<ResponseDto<ResponseOrdersBookDto>> createEntity(@RequestBody @Valid RequestOrdersBookDto entity) {
        return convertStatusCodeByData(this.ordersBookService.createEntity(entity));
    }

    @Override
    @GetMapping
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "OrdersBook API Success Get Method",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ResponseAuthorDto.class),
                                    examples = @ExampleObject(value = ORDERS_BOOK_SUCCESS)
                            )
                    ),@ApiResponse(description = "OrdersBook API NOT  Found Get Method",
                    responseCode = "404",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(
                                    implementation = ResponseDto.class
                            ),
                            examples = @ExampleObject(value = ORDERS_BOOK_NOT_FOUND)
                    )
            )
            })
    @Operation(summary = "This is OrdersBook Get Method")
    public ResponseEntity<ResponseDto<ResponseOrdersBookDto>> getEntity(@RequestParam(value = "id") Integer entityId) {
        return convertStatusCodeByData(this.ordersBookService.getEntity(entityId));
    }

    @Override
    @PutMapping
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "OrdersBook API Success Put Method",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ResponseAuthorDto.class),
                                    examples = @ExampleObject(value = ORDERS_BOOK_SUCCESS)
                            )
                    ),@ApiResponse(description = "OrdersBook API NOT  Found Put Method",
                    responseCode = "404",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(
                                    implementation = ResponseDto.class
                            ),
                            examples = @ExampleObject(value = ORDERS_BOOK_NOT_FOUND)
                    )
            )
            })
    @Operation(summary = "This is OrdersBook Put Method")
    public ResponseEntity<ResponseDto<ResponseOrdersBookDto>> updateEntity(@RequestParam(value = "id") Integer entityId,
                                                                           @RequestBody @Valid RequestOrdersBookDto entity) {
        return convertStatusCodeByData(this.ordersBookService.updateEntity(entityId, entity));
    }

    @Override
    @DeleteMapping
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "OrdersBook API Success Delete Method",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ResponseAuthorDto.class),
                                    examples = @ExampleObject(value = ORDERS_BOOK_SUCCESS)
                            )
                    ),@ApiResponse(description = "OrdersBook API NOT  Found Delete Method",
                    responseCode = "404",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(
                                    implementation = ResponseDto.class
                            ),
                            examples = @ExampleObject(value = ORDERS_BOOK_NOT_FOUND)
                    )
            )
            })
    @Operation(summary = "This is OrdersBook Delete Method")
    public ResponseEntity<ResponseDto<ResponseOrdersBookDto>> deleteEntity(@RequestParam(value = "id") Integer entityId) {
        return convertStatusCodeByData(this.ordersBookService.deleteEntity(entityId));
    }
}
