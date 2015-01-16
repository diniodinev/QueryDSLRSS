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


import com.musala.entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        Customer customer1 = new Customer();
        customer1.setFirstName("Ivan");
        customer1.setLastName("Ivanov");

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("thePersistenceUnit");
        EntityManager theManager = factory.createEntityManager();
        theManager.getTransaction().begin();


        theManager.persist(customer1);
        theManager.getTransaction().commit();

    }

}

