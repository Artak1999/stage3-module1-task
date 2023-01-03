package com.mjc.school.service.interfaces;

import com.mjc.school.repository.model.NewsModel;
import com.mjc.school.service.dto.Request;
import com.mjc.school.service.dto.Response;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import java.util.List;

@Mapper
public interface ModelMapper {
    List<Response> modelListToDtoList(List<NewsModel> newsModelList);
    Response modelToDto(NewsModel newsModel);
    @Mappings({
            @Mapping(target = "createDate", ignore = true),
            @Mapping(target = "lastUpdatedDate", ignore = true)
    })
    NewsModel dtoToModel(Request newsModelRequest);
}
