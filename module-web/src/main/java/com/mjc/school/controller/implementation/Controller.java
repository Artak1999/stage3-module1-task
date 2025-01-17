package com.mjc.school.controller.implementation;

import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoResponse;
import com.mjc.school.service.factory.Factory;
import com.mjc.school.service.interfaces.Service;
import java.util.List;

public class Controller {
    private final Service<NewsDtoRequest, NewsDtoResponse> newsService;

    public Controller() {
        newsService = Factory.getInstance().getNewsService();
    }

    public List<NewsDtoResponse> readAll() {
        return newsService.readAll();
    }

    public NewsDtoResponse readById(Long newsId) {
        return newsService.readById(newsId);
    }

    public NewsDtoResponse create(NewsDtoRequest dtoRequest) {
        return newsService.create(dtoRequest);
    }

    public NewsDtoResponse update(NewsDtoRequest dtoRequest) {
        return newsService.update(dtoRequest);
    }

    public Boolean deleteById(Long newsId) {
        return newsService.deleteById(newsId);
    }
}
