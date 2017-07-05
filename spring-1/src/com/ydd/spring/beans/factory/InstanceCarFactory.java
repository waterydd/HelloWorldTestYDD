package com.ydd.spring.beans.factory;
/**
 *ʵ������������ʵ�������ķ�����������Ҫ�������������ٵ��ù�����ʵ������������ bean ��ʵ��
 * 
 */
import java.util.HashMap;
import java.util.Map;

public class InstanceCarFactory {

        private Map<String ,Car> cars = new HashMap<>();
        
        public InstanceCarFactory(){
                cars.put("audi", new Car("audi",300000));
                cars.put("ford", new Car("ford",400000));
        }
        public Car getCar(String brand){
                return cars.get(brand);
        }
       
}
