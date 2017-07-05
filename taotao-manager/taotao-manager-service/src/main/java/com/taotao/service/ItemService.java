package com.taotao.service;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.pojo.TbItem;

/**
 * 整合测试：直接商品查询
 * @author YDD
 *
 */
public interface ItemService {

        TbItem getItemById(long itemId);
        EUDataGridResult getItemList(int page, int rows);
}
