package com.musala.dao;

import java.util.List;

/**
 * Created by Cannibal on 29.1.2015 г..
 */
public interface CruDao<E, Key> {
    public void persist(E entity);

    public void remove(E entity);

    public E findById(Key id);

    public List<E> findAll();
}
