package ru.junglejobs.service;


import ru.junglejobs.model.News;

import java.util.Date;
import java.util.List;

public interface NewsService {

    List<News> getAllNews();

    List<News> getNews(Date fromDate, Date toDate);

}
