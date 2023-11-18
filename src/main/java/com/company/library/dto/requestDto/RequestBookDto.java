package com.company.library.dto.requestDto;

import com.company.library.entity.Image;
import com.company.library.entity.Publisher;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestBookDto {
    @NotBlank(message = "Book Name cannot be null or empty")
    private String bookName;

    private Float price;
    private Integer page;
    private LocalDate published;
    private Float amount;

    private Integer publisherId;
    private Integer imageId;
    private Integer authorId;
    private Integer goalId;
}
