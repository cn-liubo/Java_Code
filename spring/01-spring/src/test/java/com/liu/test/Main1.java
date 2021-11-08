package com.liu.test;

import com.liu.config.Config;
import com.liu.entity.LBFactoryBean;
import com.liu.entity.Person;
import com.liu.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main1 {

    @Test
    public void test1() {
        User user = new User();

    }

    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        User user1 = (User) context.getBean("user");

        User user2 = context.getBean("user", User.class);
        System.out.println(user1 == user2);
    }

    @Test
    public void test3() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        User user1 = (User) context.getBean("user");

        User user2 = context.getBean("user", User.class);
        System.out.println(user1 == user2);
    }

    @Test
    public void test4() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
        beanDefinition.setBeanClass(User.class);

        context.registerBeanDefinition("user", beanDefinition);
//        context.refresh();

        User user1 = (User) context.getBean("user");

        User user2 = context.getBean("user", User.class);
        System.out.println(user1 == user2);
    }

    @Test
    public void test5() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
        beanDefinition.setBeanClass(LBFactoryBean.class);// 2个bean对象  &user:LBFactoryBean类型的对象， user:person

        context.registerBeanDefinition("user", beanDefinition);
//        context.refresh();

        LBFactoryBean lbFactoryBean = context.getBean("&user", LBFactoryBean.class);
        System.out.println(lbFactoryBean);

        Person person = context.getBean("user", Person.class);
        System.out.println(person);
    }
}
