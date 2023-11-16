package com.company.library.mapper;

import com.company.library.dto.requestDto.RequestUserDto;
import com.company.library.dto.responseDto.ResponseUserDto;
import com.company.library.entity.User;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring", imports = Collectors.class)
public abstract class UserMapper {

    @Lazy
    @Autowired
    protected CardMapper cardMapper;

    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "cards", ignore = true)
    @Mapping(target = "orders", ignore = true)
    @Mapping(target = "gender", ignore = true)
    public abstract User toEntity(RequestUserDto dto);

    @Mapping(target = "cards", ignore = true)
    public abstract ResponseUserDto toDto(User user);

    /*@Mapping(target = "cards", expression = "java(user.getCards().stream().map(" +
            "this.cardMapper::toDto).collect(Collectors.toSet()))")
    public abstract ResponseUserDto toDtoWithCard(User user); */


    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, resultType = User.class)
    public abstract User updateUser(RequestUserDto dto, @MappingTarget User user);


}
