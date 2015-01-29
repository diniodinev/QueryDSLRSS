package com.musala.dao;

import com.musala.entity.DnesBgNewsEntity;

import javax.annotation.Nonnull;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Cannibal on 29.1.2015 г..
 */
public class DnesBgNewsDaoImpl extends DnesBgNewsAbstractDao<DnesBgNewsEntity, String> {

    public DnesBgNewsDaoImpl(@Nonnull EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public DnesBgNewsEntity findById(String id) {
        return entityManager.find(DnesBgNewsEntity.class, id);
    }

    @Override
    public List<DnesBgNewsEntity> findAll() {
        //TODO implement
        return null;
    }
}
