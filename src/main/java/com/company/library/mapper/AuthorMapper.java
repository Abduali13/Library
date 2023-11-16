package com.company.library.mapper;

import com.company.library.dto.requestDto.RequestAuthorDto;
import com.company.library.dto.responseDto.ResponseAuthorDto;
import com.company.library.entity.Author;
import org.mapstruct.*;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring", imports = Collectors.class)
public abstract class AuthorMapper {

    @Mapping(target = "authorId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    public abstract Author toEntity(RequestAuthorDto dto);

    public abstract ResponseAuthorDto toDto(Author author);

    @Mapping(target = "authorId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, resultType = Author.class)
    public abstract Author updateAuthor(RequestAuthorDto dto, @MappingTarget Author author);


}
