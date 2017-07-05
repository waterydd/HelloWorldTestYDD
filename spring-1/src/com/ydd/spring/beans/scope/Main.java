package com.ydd.spring.beans.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.SystemEnvironmentPropertySource;

import com.ydd.spring.beans.autowire.Address;
import com.ydd.spring.beans.autowire.Car;
import com.ydd.spring.beans.autowire.Person;

public class Main {
        
        public static void main(String[] args){
                
                ApplicationContext ctx=new ClassPathXmlApplicationContext("beans-scope.xml");
              
                Car car = (Car) ctx.getBean("car");
                Car car2 = (Car) ctx.getBean("car");
                System.out.println(car == car2);

        }
}
