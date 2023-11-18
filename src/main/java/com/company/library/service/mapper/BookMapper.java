package com.company.library.service.mapper;

import com.company.library.dto.requestDto.RequestBookDto;
import com.company.library.dto.responseDto.ResponseBookDto;
import com.company.library.entity.Book;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public abstract class BookMapper {

    @Mapping(target = "bookId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "goals", ignore = true)

    public abstract Book toEntity(RequestBookDto dto);

    public abstract ResponseBookDto toDto(Book book);


    @Mapping(target = "bookId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, resultType = Book.class)
    public abstract Book updateBook(@MappingTarget Book book, RequestBookDto dto);


}
