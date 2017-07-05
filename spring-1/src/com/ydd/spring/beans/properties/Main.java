package com.ydd.spring.beans.properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.SystemEnvironmentPropertySource;

import com.ydd.spring.beans.autowire.Address;
import com.ydd.spring.beans.autowire.Car;
import com.ydd.spring.beans.autowire.Person;
import com.ydd.spring.beans.collection.DataSource;

import java.sql.SQLException;

import javax.sql.*;

public class Main {
        
        public static void main(String[] args) throws SQLException {
                
                ApplicationContext ctx=new ClassPathXmlApplicationContext("beans-properties.xml");
              
                DataSource datasource = (DataSource) ctx.getBean("datasource");
//                System.out.println( datasource.getConnection());


        }
}
