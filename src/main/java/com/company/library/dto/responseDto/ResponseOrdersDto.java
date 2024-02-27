package com.company.library.dto.responseDto;

import com.company.library.entity.OrdersBook;
import com.company.library.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseOrdersDto {

    private Integer orderId;

    private Integer userId;

    private User users;

    private Integer total;

    private List<ResponseOrdersDto> ordersBooks;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
