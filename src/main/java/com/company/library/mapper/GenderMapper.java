package com.company.library.mapper;

import com.company.library.dto.requestDto.RequestGenderDto;
import com.company.library.dto.responseDto.ResponseGenderDto;
import com.company.library.entity.Gender;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public abstract class GenderMapper {

    @Mapping(target = "genderId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "genders", ignore = true)
    public abstract Gender toEntity(RequestGenderDto dto);


    public abstract ResponseGenderDto toDto(Gender gender);

    @Mapping(target = "genderId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, resultType = Gender.class)
    public abstract Gender updateGender(@MappingTarget Gender gender, RequestGenderDto dto);



}
