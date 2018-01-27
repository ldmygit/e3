package com.e3.service.goods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/10/18.
 */
public class GoodsServiceProvider {
    private static final Logger LOGGER = LoggerFactory.getLogger(GoodsServiceProvider.class);
    public static void main(String[] args) {
        try {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-context.xml");
            //没有使用web启动，使用main方法启动IOC容器时，加载了service，mapper，以及dubbo的服务接口
            context.start();

        } catch (Exception e) {
            LOGGER.error("== DubboProvider context start error:",e);
        }

        synchronized (GoodsServiceProvider.class) {
            while (true) {
                try {
                    GoodsServiceProvider.class.wait();
                    System.out.println("商品服务已启动成功！");
                } catch (InterruptedException e) {
                    LOGGER.error("== synchronized error:",e);
                }
            }
        }
    }
}
