package ru.junglejobs.dao;

import ru.junglejobs.model.News;

import java.util.Date;
import java.util.List;

public interface NewsDao {

    List<News> findAll();

    List<News> getNews(Date fromDate, Date toDate);

}
