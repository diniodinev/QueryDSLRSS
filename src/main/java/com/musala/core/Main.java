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


import com.musala.entity.AbstractArticle;
import com.musala.entity.Customer;
import com.musala.entity.DnesBgNews;
import com.musala.services.EmploeeService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {

        //GEt custoemr from the DB
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("thePersistenceUnit");
        EntityManager theManager = factory.createEntityManager();

//        EmploeeService em = new EmploeeService();
//        em.setEntityManager(theManager);
//        List<Customer> list = em.getCustomer("Ivanov");
//        for(Customer c:list){
//            System.out.println(c.getFirstName()+ " "+ c.getLastName());
//        }

//        Customer customer1 = new Customer();
//        customer1.setFirstName("Ivan");
//        customer1.setLastName("Ivanov");
//
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("thePersistenceUnit");
//        EntityManager theManager = factory.createEntityManager();
//        theManager.getTransaction().begin();
//
//
//        theManager.persist(customer1);
//        theManager.getTransaction().commit();

        //Create DnesBGNews fro testing the DB
        AbstractArticle abstractArticle = new AbstractArticle();

        DnesBgNews dnesBgNews = new DnesBgNews();
        dnesBgNews.setTitle("Title");
        dnesBgNews.setAuthorName("Dinio");
        dnesBgNews.setDescription("Описание");
        dnesBgNews.setAbstractArticle(abstractArticle);
        dnesBgNews.setNewsContent("Content of the text .Ала бала-------- текст.");
        dnesBgNews.setNewsId(112);
        dnesBgNews.setPublicationDate(Calendar.getInstance().getTime());

        theManager.getTransaction().begin();
        theManager.persist(dnesBgNews);
        theManager.getTransaction().commit();


    }

}

