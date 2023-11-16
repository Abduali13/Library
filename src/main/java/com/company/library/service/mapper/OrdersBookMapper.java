package com.company.library.service.mapper;

import com.company.library.dto.requestDto.RequestBookDto;
import com.company.library.dto.responseDto.ResponseBookDto;
import com.company.library.entity.OrdersBook;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public abstract class OrdersBookMapper {

    @Mapping(target = "ordersBookId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "books", ignore = true)
    public abstract OrdersBook toEntity(RequestBookDto dto);

    public abstract ResponseBookDto toDto(OrdersBook ordersBook);

    @Mapping(target = "ordersBookId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, resultType = OrdersBook.class)
    public abstract OrdersBook updateOrdersBook(@MappingTarget OrdersBook ordersBook, ResponseBookDto dto);

}
