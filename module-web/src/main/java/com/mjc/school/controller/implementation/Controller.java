package com.mjc.school.controller.implementation;

import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoResponse;
import com.mjc.school.service.factory.Factory;
import com.mjc.school.service.interfaces.Service;
import java.util.List;

public class Controller {
    private final Service<NewsDtoRequest, NewsDtoResponse> service;

    public Controller() {
        service = Factory.getInstance().getNewsService();
    }

    public List<NewsDtoResponse> readAll() {
        return service.readAll();
    }

    public NewsDtoResponse readById(Long newsId) {
        return service.readById(newsId);
    }

    public NewsDtoResponse create(NewsDtoRequest dtoRequest) {
        return service.create(dtoRequest);
    }

    public NewsDtoResponse update(NewsDtoRequest dtoRequest) {
        return service.update(dtoRequest);
    }

    public Boolean deleteById(Long newsId) {
        return service.deleteById(newsId);
    }
}
