package com.taotao.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.tools.javac.util.List;
import com.taotao.common.pojo.EUTreeNode;
import com.taotao.pojo.TbItemCat;
import com.taotao.service.ItemCatService;

/**
 * 商品分类管理controller
 * 
 * @author:YDD
 * @date创建时间：2017年6月27日下午9:04:16
 */
@Controller
@RequestMapping("/item/cat")

public class ItemCatController {

        @Autowired
        private ItemCatService itemCatService;

        @RequestMapping("/list")
        @ResponseBody
        // 如果id为null是使用默认值，也就是parentid为0的分类列表
        public List<EUTreeNode> getCatList(@RequestParam(value = "id", defaultValue = "0") long parentId) {
                List<EUTreeNode> catList = (List<EUTreeNode>) itemCatService.getCatList(parentId);
                return catList;
        }

}