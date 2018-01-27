package com.e3.web.manager.controller;

import com.e3.common.utils.EasyUITreeResponse;
import com.e3.service.goods.api.ItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by xyz on 2018/1/23.
 */
@Controller
@RequestMapping("item/cat")
public class ItemCategoryController {

    //rpc调用服务,dubbo提供
    @Autowired
    ItemCategoryService itemCategoryService;

    @RequestMapping("list")
    @ResponseBody
    public List<EasyUITreeResponse> listTree(@RequestParam(value="id",defaultValue="0") Long pid){
       return  itemCategoryService.listTree(pid);
    }
}
