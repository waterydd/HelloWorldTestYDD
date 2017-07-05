package com.ydd.spring.beans.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * ��̬����������ֱ�ӵ���ĳһ����ľ�̬�����Ϳ��Է��� Bean ��ʵ��
 * 
 * @author YDD
 *
 */
public class StaticCarFactory {

        private static Map<String, Car> cars = new HashMap<>();
        
        static{
                cars.put("Audi", new Car("Audi", 300000));
                cars.put("Ford", new Car("Ford", 400000));
        }
        
        //��̬��������
        public static  Car getCar(String brand) {
                
                return cars.get(brand);

        }

}
