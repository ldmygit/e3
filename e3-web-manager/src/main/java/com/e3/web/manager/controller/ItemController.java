package com.e3.web.manager.controller;

import com.e3.common.utils.E3Result;
import com.e3.common.utils.EasyUIDatagridRequest;
import com.e3.common.utils.EasyUIDatagridResponse;
import com.e3.service.goods.api.ItemService;
import com.e3.service.goods.pojo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 此类负责商品相关的CRUD
 * Created by xyz on 2018/1/22.
 */
@Controller
@RequestMapping("item")
public class ItemController {

    //面向服务，没有service可以依赖，使用的是dubbo
    //注入dubbo提供的服务
    @Autowired
    ItemService itemService;
    //分页查询商品
    @RequestMapping("list")
    @ResponseBody
    //@RequiresPermissions("listItem")
    public EasyUIDatagridResponse list(EasyUIDatagridRequest es){
        EasyUIDatagridResponse rs = itemService.list(es);
        return rs;
    }

    /**
     * 保存商品，包括商品的基本信息（Item），商品描述（ItemDesc）
     * @param item
     * @return
     */
    @RequestMapping("save")
    @ResponseBody
    public E3Result list(Item item, @RequestParam("desc") String itemDesc){

        E3Result save = itemService.save(item, itemDesc);
        return save;
    }
}
