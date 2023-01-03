package com.mjc.school.service;

import com.mjc.school.repository.NewsModel;
import com.mjc.school.repository.Repository;
import com.mjc.school.repository.RepositoryFactory;
import com.mjc.school.service.exceptions.NotFoundException;
import com.mjc.school.service.interfaces.ModelMapper;
import com.mjc.school.service.interfaces.Service;
import org.mapstruct.factory.Mappers;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import static com.mjc.school.service.Validate.getNewsValidator;
import static com.mjc.school.service.exceptions.ServiceErrorException.NEWS_ID_DOES_NOT_EXIST;

public class NewsService implements Service<Request, Response> {
    private final Repository<NewsModel> newsRepository;
    private final Validate newsValidator;
    private ModelMapper mapper = Mappers.getMapper(ModelMapper.class);

    public NewsService() {
        this.newsRepository = RepositoryFactory.getInstance().getNewsRepository();
        newsValidator = getNewsValidator();
    }

    @Override
    public List<Response> readAll() {
        return mapper.modelListToDtoList(newsRepository.readAll());
    }

    @Override
    public Response readById(Long newsId) {
        newsValidator.validateNewsId(newsId);
        if (newsRepository.isExistById(newsId)) {
            NewsModel newsModel = newsRepository.readById(newsId);
            return mapper.modelToDto(newsModel);
        } else {
            throw new NotFoundException(String.format(String.valueOf(NEWS_ID_DOES_NOT_EXIST.getMessage()), newsId));
        }
    }

    @Override
    public Response create(Request dtoRequest) {
        newsValidator.validateNewsDto(dtoRequest);
        NewsModel model = mapper.dtoToModel(dtoRequest);
        LocalDateTime date = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        model.setCreateDate(date);
        model.setLastUpdatedDate(date);
        NewsModel newsModel = newsRepository.create(model);
        return mapper.modelToDto(newsModel);
    }

    @Override
    public Response update(Request dtoRequest) {
        newsValidator.validateNewsId(dtoRequest.id());
        newsValidator.validateNewsDto(dtoRequest);
        if (newsRepository.isExistById(dtoRequest.id())) {
            NewsModel model = mapper.dtoToModel(dtoRequest);
            LocalDateTime date = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
            model.setLastUpdatedDate(date);
            NewsModel newsModel = newsRepository.update(model);
            return mapper.modelToDto(newsModel);
        } else {
            throw new NotFoundException(String.format(NEWS_ID_DOES_NOT_EXIST.getMessage(), dtoRequest.id()));
        }
    }

    @Override
    public Boolean deleteById(Long newsId) {
        newsValidator.validateNewsId(newsId);
        if (newsRepository.isExistById(newsId)) {
            return newsRepository.deleteById(newsId);
        } else {
            throw new NotFoundException(String.format(NEWS_ID_DOES_NOT_EXIST.getMessage(), newsId));
        }
    }
}