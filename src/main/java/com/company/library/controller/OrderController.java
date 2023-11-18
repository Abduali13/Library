package com.company.library.controller;


import com.company.library.dto.ResponseDto;
import com.company.library.dto.requestDto.RequestOrdersDto;
import com.company.library.dto.responseDto.ResponseAuthorDto;
import com.company.library.dto.responseDto.ResponseOrdersDto;
import com.company.library.service.OrdersService;
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
@RequestMapping("/orders")
public class OrderController implements SimpleRequestCrud<Integer, RequestOrdersDto, ResponseOrdersDto> {

    private final OrdersService orderService;

    @PostMapping
    @Override
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Orders API Success POST Method",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ResponseAuthorDto.class),
                                    examples = @ExampleObject(value = ORDERS_SUCCESS)
                            )
                    ),@ApiResponse(description = "Orders API NOT  Found Post Method",
                    responseCode = "404",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(
                                    implementation = ResponseDto.class
                            ),
                            examples = @ExampleObject(value = ORDERS_NOT_FOUND)
                    )
            )
            })
    @Operation(summary = "This is Orders Post Method")
    public ResponseEntity<ResponseDto<ResponseOrdersDto>> createEntity(@RequestBody @Valid RequestOrdersDto entity) {
        return convertStatusCodeByData(this.orderService.createEntity(entity));
    }

    @GetMapping
    @Override
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Orders API Success Get Method",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ResponseAuthorDto.class),
                                    examples = @ExampleObject(value = ORDERS_SUCCESS)
                            )
                    ),@ApiResponse(description = "Orders API NOT  Found Get Method",
                    responseCode = "404",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(
                                    implementation = ResponseDto.class
                            ),
                            examples = @ExampleObject(value = ORDERS_NOT_FOUND)
                    )
            )
            })
    @Operation(summary = "This is Orders Get Method")
    public ResponseEntity<ResponseDto<ResponseOrdersDto>> getEntity(@RequestParam(value = "id") Integer entityId) {
        return convertStatusCodeByData(this.orderService.getEntity(entityId));
    }

    @PutMapping
    @Override
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Orders API Success Put Method",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ResponseAuthorDto.class),
                                    examples = @ExampleObject(value = ORDERS_SUCCESS)
                            )
                    ),@ApiResponse(description = "Orders API NOT  Found Put Method",
                    responseCode = "404",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(
                                    implementation = ResponseDto.class
                            ),
                            examples = @ExampleObject(value = ORDERS_NOT_FOUND)
                    )
            )
            })
    @Operation(summary = "This is Orders Put Method")
    public ResponseEntity<ResponseDto<ResponseOrdersDto>> updateEntity(@RequestParam(value = "id") Integer entityId,
                                                                       @RequestBody @Valid RequestOrdersDto dto) {
        return convertStatusCodeByData(this.orderService.updateEntity(entityId, dto));
    }

    @DeleteMapping
    @Override
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Orders API Success Delete Method",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ResponseAuthorDto.class),
                                    examples = @ExampleObject(value = ORDERS_SUCCESS)
                            )
                    ),@ApiResponse(description = "Orders API NOT  Found Delete Method",
                    responseCode = "404",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(
                                    implementation = ResponseDto.class
                            ),
                            examples = @ExampleObject(value = ORDERS_NOT_FOUND)
                    )
            )
            })
    @Operation(summary = "This is Orders Delete Method")
    public ResponseEntity<ResponseDto<ResponseOrdersDto>> deleteEntity(@RequestParam(value = "id") Integer entityId) {
        return convertStatusCodeByData(this.orderService.deleteEntity(entityId));
    }
}
