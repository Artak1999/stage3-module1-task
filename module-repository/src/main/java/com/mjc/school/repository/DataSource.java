package com.mjc.school.repository;

import java.util.List;
import static com.mjc.school.repository.AuthorData.getAuthorData;
import static com.mjc.school.repository.NewsData.getNewsData;

public class DataSource {
    private final List<NewsModel> news;

    private DataSource() {
        List<AuthorModel> authorList = getAuthorData().getAuthorList();
        news = getNewsData(authorList).getNewsList();
    }

    private static class LazyDataSource {
        static final DataSource INSTANCE = new DataSource();
    }

    public static DataSource getInstance() {
        return LazyDataSource.INSTANCE;
    }

    public List<NewsModel> getNews() {
        return news;
    }
}
