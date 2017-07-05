package com.ydd.spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args){
		/*
		//1、创建 HelloWorld 的一个对象
		HelloWorld helloworld = new HelloWorld();
		//2、为 name 属性赋值 
		helloworld.setName("yangdandan");
		*/
		
		
		//以上2步可以交给 spring 完成
		//(1)创建 Spring 的 IOC 容器对象
		// ApplicationContext：代表 IOC 容器
		// ClassPathXmlApplicationContext：是 ApplicationContext 接口的实现类，该实现类从类路径下来加载配置文件
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//（2）从 IOC 容器中获取 Bean 实例
	   //利用 id 定位到 IOC 容器中的 bean
		HelloWorld helloworld = (HelloWorld)ctx.getBean("helloworld2");
		//3、（3）调用 hello 方法
		helloworld.hello();
		
		Car car =(Car) ctx.getBean("car");
		System.out.println(car);
		
		Car car2 =(Car) ctx.getBean("car2");
		System.out.println(car2);
		
		Person ydd = (Person) ctx.getBean("person2");
		System.out.println(ydd);
	}

}
