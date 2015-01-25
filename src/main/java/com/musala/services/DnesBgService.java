package com.musala.services;

import com.musala.entity.QDnesBgNews;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.sql.MySQLTemplates;
import com.mysema.query.sql.RelationalPath;
import com.mysema.query.sql.SQLTemplates;
import com.mysema.query.sql.dml.SQLInsertClause;

import java.sql.Connection;

/**
 * Created by Cannibal on 18.1.2015 г..
 */
public class DnesBgService extends AbstractService {
    public boolean exist(final long newsId) {
        QDnesBgNews dnesBgNews = QDnesBgNews.dnesBgNews;
        JPAQuery jpaQuery = from(dnesBgNews).where(dnesBgNews.newsId.eq(newsId));
        return jpaQuery.list(dnesBgNews).size() > 0;
    }


}
