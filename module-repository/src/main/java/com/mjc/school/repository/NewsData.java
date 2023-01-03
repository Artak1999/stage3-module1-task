package com.mjc.school.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static com.mjc.school.repository.Utils.getRandomContentByFilePath;
import static com.mjc.school.repository.Utils.getRandomDate;

public class NewsData {
    private final static String CONTENT_FILE_NAME = "content";
    private final static String NEWS_FILE_NAME = "news";
    private static NewsData newsData;
    private List<NewsModel> newsList;

    private NewsData(List<AuthorModel> authorModelList) {
        init(authorModelList);
    }

    public static NewsData getNewsData(List<AuthorModel> authorModelList) {
        if (newsData == null) {
            newsData = new NewsData(authorModelList);
        }
        return newsData;
    }

    private void init(List<AuthorModel> authorModelList) {
        newsList = new ArrayList<>();
        Random random = new Random();
        for (long i = 1; i <= 20; i++) {
            LocalDateTime date = getRandomDate();
            newsList.add(new NewsModel(i, getRandomContentByFilePath(NEWS_FILE_NAME),
                            getRandomContentByFilePath(CONTENT_FILE_NAME), date, date,
                            authorModelList.get(random.nextInt(authorModelList.size())).getId())
            );
        }
    }

    public List<NewsModel> getNewsList() {
        return newsList;
    }
}
