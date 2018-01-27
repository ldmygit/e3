package com.e3.service.goods.api.impl;

import com.e3.common.utils.EasyUITreeResponse;
import com.e3.service.goods.api.ItemCategoryService;
import com.e3.service.goods.mapper.ItemCategoryMapper;
import com.e3.service.goods.pojo.ItemCategory;
import com.e3.service.goods.pojo.ItemCategoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xyz on 2018/1/23.
 */
@Service("itemCategoryService")
public class ItemCategoryServiceImpl implements ItemCategoryService{

    @Autowired
    ItemCategoryMapper itemCategoryMapper;

    public List<EasyUITreeResponse> listTree(Long pid) {
        //查詢商品分类的所有数据
        ItemCategoryExample example = new ItemCategoryExample();
        ItemCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(pid);

        List<EasyUITreeResponse> treeList = new ArrayList<>();
        List<ItemCategory> itemCategories = itemCategoryMapper.selectByExample(example);
        //得到的数据字段名称和easyui-tree要求的不一致，转换
        for (int i = 0; i <itemCategories.size() ; i++) {
            ItemCategory category = itemCategories.get(i);
            EasyUITreeResponse rs = new EasyUITreeResponse();
            rs.setId(category.getId());
            rs.setText(category.getName());//这里easyui的字段名叫text，而数据库中是name
            rs.setState(category.getIsParent()==true?"closed":"open");
            treeList.add(rs);
        }
        return treeList;
    }
}
