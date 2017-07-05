package com.ydd.spring.beans.generic.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.transform.impl.AddDelegateTransformer;
import org.springframework.stereotype.Service;

@Service
public class BaseService<T> {
        
        
        @Autowired
        protected BaseRepository<T> repository;
        
        public void add(){
                System.out.println("add...");
                System.out.println(repository);
                
        }

}
