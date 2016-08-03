package ru.junglejobs.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.junglejobs.model.News;
import ru.junglejobs.service.NewsService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @RequestMapping("/")
    public String welcome() {//Welcome page, non-rest
        return "Welcome to news api";
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<News> getAllNews() {
        return newsService.getAllNews();
    }


    //    http://localhost:8080/news/get/2010-01-01/2020-02-02
    //    http://localhost:8080/news/get/2010-01-01/2016-07-31
    @RequestMapping(value = "/get/{from}/{to}", method = {RequestMethod.POST, RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<News> getNews(@PathVariable("from") final String from, @PathVariable("to") final String to) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date dateF = null;
        Date dateT;
        try {
            dateF = format.parse(from);
            dateT = format.parse(to);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }

        return newsService.getNews(dateF, dateT);
    }

}
