package com.musala.services; 
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
import com.musala.entity.QCustomer;
import com.mysema.query.jpa.impl.JPAQuery;

import java.util.List;

public class EmploeeService extends AbstractService {
    public List<Customer> getCustomer(String lastName) {
        QCustomer qCustomer = QCustomer.customer;
        JPAQuery jpaQuery = from(qCustomer).where(qCustomer.lastName.eq(lastName));
        return jpaQuery.list(qCustomer);
    }
}
