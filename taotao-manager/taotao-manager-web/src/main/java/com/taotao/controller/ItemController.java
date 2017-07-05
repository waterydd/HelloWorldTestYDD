package com.taotao.controller;

import javax.xml.ws.RespectBinding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;

/**
 * 整合测试：直接商品查询
* @author
* @version 创建时间：2017年6月22日下午3:37:42
*/
@Controller
public class ItemController {

        @Autowired
        private ItemService itemService;
        
        @RequestMapping("/item/{itemId}")
        @ResponseBody
        public TbItem getItemById(@PathVariable Long itemId){
                TbItem tbItem = itemService.getItemById(itemId);
                return tbItem;
        }
        
        @RequestMapping("/item/list")
        @ResponseBody
        public EUDataGridResult getItemList(Integer page, Integer rows){
                EUDataGridResult result =  itemService.getItemList(page, rows);
                return result ;
        }
}
