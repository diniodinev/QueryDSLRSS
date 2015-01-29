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


import com.musala.dao.DnesBgDaoImpl;
import com.musala.dao.ProcessDnesBgHtmlPage;
import com.musala.entity.DnesBgNewsEntity;
import com.musala.services.EmploeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws SQLException, IOException {

        final String URL = "jdbc:mysql://localhost:3306/dnesdb";
        //GEt custoemr from the DB
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("thePersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        EmploeeService em = new EmploeeService();
        em.setEntityManager(entityManager);

        Connection conn = null;
        conn = DriverManager.getConnection(URL, "root", "root");


//
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("thePersistenceUnit");
//        EntityManager theManager = factory.createEntityManager();
//        theManager.getTransaction().begin();
//
//
//        theManager.persist(customer1);
//        theManager.getTransaction().commit();

        //Create DnesBGNews fro testing the DB

//        DnesBgNewsEntity dnesBgNews = new DnesBgNewsEntity();
//        dnesBgNews.setTitle("Title");
//        dnesBgNews.setDescription("Описание");
//        dnesBgNews.setNewsContent("Content of the text .Чирипаха.");
//        dnesBgNews.setPublicationDate(Calendar.getInstance().getTime());
////
//        theManager.getTransaction().begin();
//        theManager.persist(dnesBgNews);
//
//        theManager.getTransaction().commit();





        String tagName = "#article_text";
        String titleTag = "h1.title";
        String descriptionTag = "div.descr";
        DnesBgDaoImpl dnesBgDao = new DnesBgDaoImpl();
        for (int i = 252723; i >= 1000; i--) {
            try {

                DnesBgNewsEntity dnesBgNewsEntity = new DnesBgNewsEntity();
                dnesBgNewsEntity.setPublicationDate(Calendar.getInstance().getTime());

                String url = "http://www.dnes.bg/world/2015/01/25/page." + i;
                ProcessDnesBgHtmlPage processDnesBgHtmlPage = new ProcessDnesBgHtmlPage(url);

                //String url = "http://www.dnes.bg/world/2015/01/25/lavrov-prizova-es-za-natisk-vyrhu-kiev.252390";


                String text = processDnesBgHtmlPage.extractInformationByTag(tagName);

                if (text != null) {
                    dnesBgNewsEntity.setNewsContent(text);
                }


                dnesBgNewsEntity.setTitle(processDnesBgHtmlPage.extractInformationByTag(titleTag));


                dnesBgNewsEntity.setDescription(processDnesBgHtmlPage.extractInformationByTag(descriptionTag));

                dnesBgNewsEntity.setNewsUrl(url);

                dnesBgNewsEntity.setAuthor(processDnesBgHtmlPage.extractAuthor());

                dnesBgDao.insert(dnesBgNewsEntity, entityManager);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } catch (Throwable e) {
                System.out.println("Error" + i);
            }
        }
    }

}

