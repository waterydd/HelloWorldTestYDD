package com.ydd.spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args){
		/*
		//1������ HelloWorld ��һ������
		HelloWorld helloworld = new HelloWorld();
		//2��Ϊ name ���Ը�ֵ 
		helloworld.setName("yangdandan");
		*/
		
		
		//����2�����Խ��� spring ���
		//(1)���� Spring �� IOC ��������
		// ApplicationContext������ IOC ����
		// ClassPathXmlApplicationContext���� ApplicationContext �ӿڵ�ʵ���࣬��ʵ�������·���������������ļ�
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//��2���� IOC �����л�ȡ Bean ʵ��
	   //���� id ��λ�� IOC �����е� bean
		HelloWorld helloworld = (HelloWorld)ctx.getBean("helloworld2");
		//3����3������ hello ����
		helloworld.hello();
		
		Car car =(Car) ctx.getBean("car");
		System.out.println(car);
		
		Car car2 =(Car) ctx.getBean("car2");
		System.out.println(car2);
		
		Person ydd = (Person) ctx.getBean("person2");
		System.out.println(ydd);
	}

}
