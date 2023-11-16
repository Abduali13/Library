package com.company.library.mapper;

import com.company.library.dto.requestDto.RequestOrdersDto;
import com.company.library.dto.responseDto.ResponseOrdersDto;
import com.company.library.entity.Orders;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public abstract class OrdersMapper {


    @Mapping(target = "orderId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "ordersBooks", ignore = true)
    @Mapping(target = "users", ignore = true)
    public abstract Orders toEntity(RequestOrdersDto dto);


    public abstract ResponseOrdersDto toDto(Orders orders);

    @Mapping(target = "orderId", ignore = true)
    @Mapping(target = "users", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, resultType = Orders.class)
    public abstract Orders updateOrders(@MappingTarget Orders orders, RequestOrdersDto dto);


}
