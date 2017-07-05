package com.ydd.spring.beans.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ydd.spring.beans.annotation.controller.UserController;
import com.ydd.spring.beans.annotation.repository.UserRepository;
import com.ydd.spring.beans.annotation.service.UserService;

public class Main {
        
        public static void main(String[] args) {
                

                ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-annotation.xml");
                
                TestObject to = (TestObject) ctx.getBean("testObject");
                System.out.println(to);
                
                UserController userController = (UserController) ctx.getBean("userController");
                System.out.println(userController);
                
                UserRepository useRepository = (UserRepository) ctx.getBean("userRepository");
                System.out.println(useRepository);
                
                UserService userService = (UserService) ctx.getBean("userService");
                System.out.println(userService);
                
                
                
                
        }

}
