package com.company.library.service.mapper;

import com.company.library.dto.requestDto.RequestGoalDto;
import com.company.library.dto.responseDto.ResponseGoalDto;
import com.company.library.entity.Goal;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public abstract class GoalMapper {

    @Mapping(target = "goalId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "book", ignore = true)

    public abstract Goal toEntity(RequestGoalDto dto);


    public abstract ResponseGoalDto toDto(Goal goal);


    @Mapping(target = "goalId", ignore = true)
    @Mapping(target = "book", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, resultType = Goal.class)
    public abstract Goal updateGoal(@MappingTarget Goal goal, RequestGoalDto dto);



}
