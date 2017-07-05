package com.ydd.spring.beans.factorybean;
/**
 * 实现 FactoryBean 接口在 Spring IOC 容器中配置 Bean
 * 
 * @author YDD
 *
 */
import org.springframework.beans.factory.FactoryBean;

//自定义的 FactoryBean 需要实现 FactoryBean 接口
public class CarFactoryBean implements FactoryBean<Car> {
        
        private String brand;
        public void setBrand(String brand) {
                this.brand = brand;
        }
        

        //返回 bean 的对象
        @Override
        public Car getObject() throws Exception {
                // TODO Auto-generated method stub
                return new Car(brand,500000);
        }

        /**
         * 返回的 bean 的类型
         */
        @Override
        public Class<?> getObjectType() {
                // TODO Auto-generated method stub
                return Car.class;
        }

        /**
         * 是否是单实例的
         */
        @Override
        public boolean isSingleton() {
                // TODO Auto-generated method stub
                return true;
        }

}
