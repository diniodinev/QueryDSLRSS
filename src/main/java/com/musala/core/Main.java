package com.musala.core; 
 /*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
  * Created by dinyo.dinev on 2015.
 */


import com.musala.entity.AbstractBaseEntity;
import com.musala.entity.Customer;
import com.musala.entity.DnesBgNews;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Calendar;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        //GEt custoemr from the DB
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("thePersistenceUnit");
        EntityManager theManager = factory.createEntityManager();

        Customer customer1 = new Customer();
        customer1.setFirstName("Ivan");
        customer1.setLastName("Иванов");

        theManager.getTransaction().begin();
        theManager.persist(customer1);

        theManager.getTransaction().commit();

//        EmploeeService em = new EmploeeService();
//        em.setEntityManager(theManager);


//
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("thePersistenceUnit");
//        EntityManager theManager = factory.createEntityManager();
//        theManager.getTransaction().begin();
//
//
//        theManager.persist(customer1);
//        theManager.getTransaction().commit();

        //Create DnesBGNews fro testing the DB
        AbstractBaseEntity abstractBaseEntity = new AbstractBaseEntity();


        DnesBgNews dnesBgNews = new DnesBgNews();
        dnesBgNews.setTitle("Title");
        dnesBgNews.setAuthorName("Xelian");
        dnesBgNews.setDescription("Описание");
        dnesBgNews.setAbstractBaseEntity(abstractBaseEntity);
        dnesBgNews.setNewsContent("Content of the text .Чирипаха.");
        dnesBgNews.setNewsId(112);
        dnesBgNews.setPublicationDate(Calendar.getInstance().getTime());

        theManager.getTransaction().begin();
        theManager.persist(dnesBgNews);
        theManager.persist(dnesBgNews);
        theManager.persist(dnesBgNews);
        theManager.getTransaction().commit();

    }

}

