package ru.junglejobs.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import ru.junglejobs.model.News;

import java.util.Date;
import java.util.List;

@Repository("newsDao")
public class NewsDaoImpl extends AbstractDao<Long, News> implements NewsDao {

    @SuppressWarnings("unchecked")
    public List<News> findAll() {
        Criteria criteria = createEntityCriteria();
        return (List<News>) criteria.list();
    }

    @SuppressWarnings("unchecked")
    public List<News> getNews(Date fromDate, Date toDate) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.gt("date", fromDate));
        criteria.add(Restrictions.lt("date", toDate));
        criteria.addOrder(Order.desc("date"));//последние новости - вперед
//        criteria.add(Restrictions.between("date",fromDate, toDate));
        return (List<News>) criteria.list();
    }
}
