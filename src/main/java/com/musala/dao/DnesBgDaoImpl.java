package com.musala.dao;

import com.musala.entity.BaseKeyEntity;
import com.mysema.query.sql.MySQLTemplates;
import com.mysema.query.sql.RelationalPath;
import com.mysema.query.sql.SQLTemplates;
import com.mysema.query.sql.dml.SQLDeleteClause;
import com.mysema.query.sql.dml.SQLUpdateClause;

import javax.persistence.EntityManager;
import java.sql.Connection;

/**
 * Created by Cannibal on 25.1.2015 г..
 */
public class DnesBgDaoImpl {

    private static final SQLTemplates dialect = new MySQLTemplates();

    public void insert(BaseKeyEntity objectToPersist, EntityManager entityManager) {
        entityManager.getTransaction().begin();
        entityManager.persist(objectToPersist);
        entityManager.getTransaction().commit();
    }

    SQLDeleteClause delete(Connection conn, RelationalPath path) {
        return new SQLDeleteClause(
                conn, dialect, path);
    }

//    SQLQuery from(Connection conn, RelationalPath path) {
//        SQLQueryImpl query = new SQLQueryImpl(conn, dialect,path);
//        query.from(from);
//        return query;
//    }


    SQLUpdateClause update(Connection conn, RelationalPath path) {
        return new SQLUpdateClause(conn, dialect, path);
    }
}
