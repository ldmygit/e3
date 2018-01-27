package com.e3.service.goods.mapper;

import com.e3.service.goods.pojo.Item;
import com.e3.service.goods.pojo.ItemExample;

import java.util.List;

public interface ItemMapper {
    int countByExample(ItemExample example);

    int deleteByExample(ItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Item record);

    int insertSelective(Item record);

    List<Item> selectByExample(ItemExample example);

    Item selectByPrimaryKey(Long id);

//    int updateByExampleSelective(@Param("record") Item record, @Param("example") ItemExample example);
//
//    int updateByExample(@Param("record") Item record, @Param("example") ItemExample example);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);
}