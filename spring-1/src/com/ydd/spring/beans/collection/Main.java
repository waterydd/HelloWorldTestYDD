package com.ydd.spring.beans.collection;

import java.applet.AppletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ydd.spring.beans.Car;

public class Main {

    public static void main(String[] args){
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        Person person = (Person) ctx.getBean("person5");
        System.out.println(person);
        
        NewPerson newperson = (NewPerson) ctx.getBean("newperson2");
        System.out.println(newperson);
        
        DataSource datasource = (DataSource) ctx.getBean("datasource");
        System.out.println(datasource);
    }
}
