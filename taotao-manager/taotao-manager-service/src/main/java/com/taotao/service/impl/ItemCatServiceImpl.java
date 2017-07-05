package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.service.ItemCatService;

/**
 * 商品分类管理
* @author:YDD
* @date创建时间：2017年6月22日下午9:37:04
*/
@Service
public class ItemCatServiceImpl implements ItemCatService {

        @Autowired
        private TbItemCatMapper itemCatMapper;
        @Override
        public List<EUTreeNode> getCatList(long parentId) {
                // TODO Auto-generated method stub
                //创建查询条件
                TbItemCatExample example = new TbItemCatExample();
                com.taotao.pojo.TbItemCatExample.Criteria criteria = example.createCriteria();
                criteria.andParentIdEqualTo(parentId);
                //根据条件查询
                List<TbItemCat>  list = itemCatMapper.selectByExample(example);
                List<EUTreeNode> resultList = new ArrayList<>();
                for (TbItemCat tbItemCat : list ) {
                        EUTreeNode node = new EUTreeNode();
                        node.setId(tbItemCat.getId());
                        node.setText(tbItemCat.getName());
                        node.setState(tbItemCat.getIsParent()?"closed":"open");
                        resultList.add(node);
                }
                //返回结果
                return resultList;
        }

}
