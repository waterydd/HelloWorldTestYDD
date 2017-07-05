package com.taotao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;
/**
 * 整合测试：直接商品查询
 * 商品管理Service
 * @author YDD
 *
 */

@Service
public class ItemServiceImpl implements ItemService {

        @Autowired
        private TbItemMapper itemMapper;
        
        
        @Override
        public TbItem getItemById(long itemId) {
                // TODO Auto-generated method stub
                TbItem item = itemMapper.selectByPrimaryKey(itemId);
                
                if (item != null ){
                        return item;
                }
                return null ;
        }
        /**
         * 商品列表查询
         */
        
        @Override
        public EUDataGridResult getItemList(int page, int rows) {
                //查询商品列表
                TbItemExample example = new TbItemExample();
                //分页处理
                PageHelper.startPage(page, rows);
                java.util.List<TbItem> list =itemMapper.selectByExample(example);
                //创建一个返回值对象
                EUDataGridResult result = new  EUDataGridResult();
                result.setRows(list);
                //取记录总条数
                PageInfo<TbItem> pageInfo = new PageInfo<>(list);                  
                result.setTotal(pageInfo.getTotal());
                return result;
        }

}
