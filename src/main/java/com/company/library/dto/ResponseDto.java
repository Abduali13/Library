package com.company.library.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto<T> {
    private boolean success;

    private int code;

    private String message;

    private T content;

    private List<ErrorDto> errorList;
}
