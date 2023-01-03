package com.mjc.school.repository;

public class RepositoryFactory {
    private static RepositoryFactory instance;
    private final Repository<NewsModel> newsRepository;

    private RepositoryFactory() {
        newsRepository = new NewsRepository();
    }

    public static RepositoryFactory getInstance() {
        if (instance == null) {
            instance = new RepositoryFactory();
        }
        return instance;
    }

    public Repository<NewsModel> getNewsRepository() {
        return newsRepository;
    }
}
