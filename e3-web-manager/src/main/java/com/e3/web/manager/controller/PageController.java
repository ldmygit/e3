package com.e3.web.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 这个类是用来做页面跳转的公共类
 * Created by xyz on 2018/1/22.
 */
@Controller
public class PageController {
    @RequestMapping("{page}")
    public String page(@PathVariable("page") String page){
        return page;
    }
}
