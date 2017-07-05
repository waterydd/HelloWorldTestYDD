package com.ydd.spring.beans.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.SystemEnvironmentPropertySource;

public class Main {
        
        public static void main(String[] args){
                
                ApplicationContext ctx=new ClassPathXmlApplicationContext("beans-autowire.xml");
              
               Person person = (Person) ctx.getBean("person2");
                System.out.println(person);
                
        }
}
