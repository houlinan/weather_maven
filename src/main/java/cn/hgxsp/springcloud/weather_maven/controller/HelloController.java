package cn.hgxsp.springcloud.weather_maven.controller;

import cn.hgxsp.springcloud.weather_maven.utils.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * DESC：项目测试类
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/11/1
 * Time : 10:46
 */

@RequestMapping("/test")
@RestController
public class HelloController {

    @Autowired
    RedisOperator redisOperator ;

    @RequestMapping("/hello")
    public String hello() {
        System.out.println();



        
        redisOperator.set("11111" ,"32132131232132112sdadasd");
        return "hello";
    }


}
