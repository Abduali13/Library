package com.company.library.service.mapper;

import com.company.library.dto.requestDto.RequestPublisherDto;
import com.company.library.dto.responseDto.ResponsePublisherDto;
import com.company.library.entity.Publisher;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public abstract class PublisherMapper {

    @Mapping(target = "publisherId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    public abstract Publisher toEntity(RequestPublisherDto dto);


    public abstract ResponsePublisherDto toDto(Publisher publisher);


    @Mapping(target = "publisherId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, resultType = Publisher.class)
    public abstract Publisher updatePublisher(@MappingTarget Publisher publisher, RequestPublisherDto dto);


}
