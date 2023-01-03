package com.mjc.school.controller;

import com.mjc.school.service.Factory;
import com.mjc.school.service.Request;
import com.mjc.school.service.Response;
import com.mjc.school.service.interfaces.Service;
import java.util.List;

public class Controller {
    private final Service<Request, Response> service;

    public Controller() {
        service = Factory.getInstance().getNewsService();
    }

    public List<Response> readAll() {
        return service.readAll();
    }

    public Response readById(Long newsId) {
        return service.readById(newsId);
    }

    public Response create(Request dtoRequest) {
        return service.create(dtoRequest);
    }

    public Response update(Request dtoRequest) {
        return service.update(dtoRequest);
    }

    public Boolean deleteById(Long newsId) {
        return service.deleteById(newsId);
    }
}
