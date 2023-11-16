package com.company.library.mapper;

import com.company.library.dto.requestDto.RequestImageDto;
import com.company.library.dto.responseDto.ResponseImageDto;
import com.company.library.entity.Image;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public abstract class ImageMapper {

    @Mapping(target = "imageId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    public abstract Image toEntity(RequestImageDto dto);


    public abstract ResponseImageDto toDto(Image image);


    @Mapping(target = "imageId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, resultType = Image.class)
    public abstract Image updateImage(@MappingTarget Image image, RequestImageDto dto);



}
