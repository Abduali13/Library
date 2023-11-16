package com.company.library.service.validation;


import com.company.library.dto.ErrorDto;
import com.company.library.dto.requestDto.RequestBookDto;
import com.company.library.dto.responseDto.ResponseAuthorDto;
import com.company.library.dto.responseDto.ResponseBookDto;
import com.company.library.repository.AuthorRepository;
import com.company.library.repository.GoalRepository;
import com.company.library.repository.ImageRepository;
import com.company.library.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BookValidation {

    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;
    private final GoalRepository goalRepository;
    private ImageRepository imageRepository;


public List<ErrorDto> bookValid(RequestBookDto dto){
    List<ErrorDto> errorDtos = new ArrayList<>();
    if(this.authorRepository.findByAuthorIdAndDeletedAtIsNull(dto.getAuthorId()).isEmpty()){
        errorDtos.add(new ErrorDto("authorId" , String.format("book with %d:id is not found" , dto.getAuthorId())));
    }
    if(this.publisherRepository.findByPublisherIdAndDeletedAtIsNull(dto.getPublisherId()).isEmpty()){
        errorDtos.add(new ErrorDto("publisherId" , String.format("publisher with %d:id is not found" , dto.getPublisherId())));
    }
    if(this.goalRepository.findByGoalIdAndDeletedAtIsNull(dto.getGoalId()).isEmpty()){
        errorDtos.add(new ErrorDto("goalId" , String.format("goal with %d:id is not found" , dto.getGoalId())));
    }
    if(this.imageRepository.findByImageIdAndDeletedAtIsNull(dto.getImageId()).isEmpty()){
        errorDtos.add(new ErrorDto("imageId" , String.format("image with %d:id is not found" , dto.getImageId())));
    }
    return  errorDtos;
}

}
