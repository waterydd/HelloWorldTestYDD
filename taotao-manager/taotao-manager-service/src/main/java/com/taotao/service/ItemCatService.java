package com.taotao.service;

import java.util.List;

import com.taotao.common.pojo.EUTreeNode;

/**
* @author:YDD
* @date创建时间：2017年6月22日下午9:34:24
*/
public interface ItemCatService {

        List<EUTreeNode>  getCatList(long parentId);
}
