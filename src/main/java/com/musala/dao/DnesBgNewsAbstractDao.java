package com.musala.dao;

import javax.annotation.Nonnull;
import javax.persistence.EntityManager;

/**
 * Created by Cannibal on 29.1.2015 г..
 */
public abstract class DnesBgNewsAbstractDao<E, Key> implements CruDao<E, Key> {
    protected EntityManager entityManager;

    public DnesBgNewsAbstractDao(@Nonnull EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void persist(E entity) {
        entityManager.persist(entity);

    }

    @Override
    public void remove(E entity) {
        entityManager.remove(entity);
    }
}
