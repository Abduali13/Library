package com.company.library.dto.responseDto;

import com.company.library.entity.Book;
import com.company.library.entity.Orders;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseOrdersBookDto {

    private Integer ordersBookId;

    private Integer bookId;

    private Integer orderId;

    private Orders orders;

    private List<ResponseOrdersBookDto> books;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
