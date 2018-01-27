package com.e3.service.goods.api.impl;

import com.e3.common.utils.E3Result;
import com.e3.common.utils.EasyUIDatagridRequest;
import com.e3.common.utils.EasyUIDatagridResponse;
import com.e3.common.utils.IDUtils;
import com.e3.service.goods.api.ItemService;
import com.e3.service.goods.mapper.ItemDescMapper;
import com.e3.service.goods.mapper.ItemMapper;
import com.e3.service.goods.pojo.Item;
import com.e3.service.goods.pojo.ItemDesc;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by xyz on 2018/1/22.
 */
@Service("itemService")
public class ItemServiceImpl implements ItemService{

    @Autowired
    ItemMapper itemMapper;
    @Autowired
    ItemDescMapper itemDescMapper;
    public EasyUIDatagridResponse list(EasyUIDatagridRequest es) {
        EasyUIDatagridResponse rs = new EasyUIDatagridResponse();
        //使用pageHelper
        //开始分页查询。aop
        PageHelper.startPage(es.getPage(),es.getRows());
        List<Item> items = itemMapper.selectByExample(null);
        PageInfo<Item> pg = new PageInfo<Item>(items);
        //总条数
        rs.setTotal(pg.getTotal());
        //分页记录
        rs.setRows(pg.getList());
        return rs;
    }

    @Transactional
    public E3Result save(Item item,    String desc) {
        item.setCreated(new Date());//创建时间
        item.setUpdated(new Date());//修改时间
        item.setStatus((byte)1);//状态 上下架
        item.setId(IDUtils.genItemId());//使用封装的工具类获取id
        //保存商品基本信息
        itemMapper.insert(item);//要配置selectkey
        //保存商品描述
        ItemDesc itemDesc = new ItemDesc();
        itemDesc.setCreated(new Date());
        itemDesc.setUpdated(new Date());
        itemDesc.setItemId(item.getId());
        itemDesc.setItemDesc(desc);
        itemDescMapper.insert(itemDesc);
        return E3Result.ok();
    }
}
