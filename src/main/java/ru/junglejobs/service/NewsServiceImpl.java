package ru.junglejobs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.junglejobs.dao.NewsDao;
import ru.junglejobs.model.News;

import java.util.Date;
import java.util.List;

@Service("newsService")
@Transactional
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDao newsDao;

    public List<News> getAllNews() {
        return newsDao.findAll();
    }

    public List<News> getNews(Date fromDate, Date toDate) {
        return newsDao.getNews(fromDate, toDate);
    }
}
