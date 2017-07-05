package com.taotao.controller;

import org.apache.ibatis.builder.annotation.MapperAnnotationBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.tools.javac.util.List;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;

/**
* @author
* @date创建时间：2017年6月22日下午5:12:46
*/
public class TestPageHelper {

        @Test
        public  void testPageHelper(){
                //创建一个spring容器
                ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
                //从spring容器中获得Mapper的代理对象
                TbItemMapper mapper = ctx.getBean(TbItemMapper.class);
                //执行查询，并分页
                TbItemExample example = new TbItemExample();
                //分页处理
                PageHelper.startPage(1, 10);
               java.util.List<TbItem> List = mapper.selectByExample(example);
               //取商品列表
               for (TbItem tbItem : List) {
               System.out.println(tbItem.getTitle());
               }
                //取分页信息
               PageInfo<TbItem> pageInfo = new PageInfo<>(List);
               long total = pageInfo.getTotal();
               System.out.println("共有商品："+total);
        }
}
