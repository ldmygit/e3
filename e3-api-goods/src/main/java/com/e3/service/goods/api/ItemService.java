package com.e3.service.goods.api;

import com.e3.common.utils.E3Result;
import com.e3.common.utils.EasyUIDatagridRequest;
import com.e3.common.utils.EasyUIDatagridResponse;
import com.e3.service.goods.pojo.Item;

/**
 * Created by xyz on 2018/1/22.
 */
public interface ItemService {

    //分页查询商品的接口，通过dubbo会暴露成url地址
    public EasyUIDatagridResponse list(EasyUIDatagridRequest es);

    public E3Result save(Item item, String itemDesc);
}
