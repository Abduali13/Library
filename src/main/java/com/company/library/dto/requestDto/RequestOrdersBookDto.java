package com.company.library.dto.requestDto;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestOrdersBookDto {

    private Integer bookId;

    private Integer orderId;
}
