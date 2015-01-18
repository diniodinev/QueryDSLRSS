package com.musala.services;

import com.musala.entity.Customer;
import com.musala.entity.QCustomer;
import com.musala.entity.QDnesBgNews;
import com.mysema.query.jpa.impl.JPAQuery;

import java.util.List;

/**
 * Created by Cannibal on 18.1.2015 г..
 */
public class DnesBgService extends AbstractService {
    public boolean exist(final long newsId) {
        QDnesBgNews dnesBgNews = QDnesBgNews.dnesBgNews;
        JPAQuery jpaQuery = from(dnesBgNews).where(dnesBgNews.newsId.eq(newsId));
        return jpaQuery.list(dnesBgNews).size() > 0;
    }
    public void addNews(){
//        SQLTemplates dialect;
//        QDnesBgNews dnesBgNews = QDnesBgNews.dnesBgNews;
//        new SQLInsertClause(conn, dialect, dnesBgNews)
//                .columns(survey.id, dnesBgNews.name)
//                .values(3, "Hello").execute();
    }
}
