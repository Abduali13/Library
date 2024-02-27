package com.company.library.dto.responseDto;

import com.company.library.entity.*;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseBookDto {

    private Integer bookId;

    private String bookName;

    private Integer authorId;
    private Integer goalId;
    private Integer imageId;
    private Integer publisherId;

    private Float price;
    private Integer page;
    private LocalDate published;
    private Float amount;

    private Author author;
    private Publisher publisher;
    private Image image;
    private List<Goal> goals;
    private OrdersBook ordersBooks;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
