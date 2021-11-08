package com.liu.entity;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class LBFactoryBean implements FactoryBean {

    Person person = new Person();

    @Override
    public Object getObject() throws Exception {
        return person;
    }

    @Override
    public Class<?> getObjectType() {
        return Person.class;
    }
}
