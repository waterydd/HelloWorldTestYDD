package com.ydd.spring.beans.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * 静态工厂方法：直接调用某一个类的静态方法就可以返回 Bean 的实例
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
        
        //静态工厂方法
        public static  Car getCar(String brand) {
                
                return cars.get(brand);

        }

}
