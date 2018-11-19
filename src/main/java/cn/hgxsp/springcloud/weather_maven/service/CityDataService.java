package cn.hgxsp.springcloud.weather_maven.service;

import cn.hgxsp.springcloud.weather_maven.resultVO.City;

import java.util.List;

/**
 * DESC： 城市数据服务接口类
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/11/15
 * Time : 10:43
 */

public interface CityDataService {

    /**
    *DESC: 获取城市列表集合
    *@author hou.linan
    *@date:  2018/11/15 10:49
    *@param:  []
    *@return:  java.util.List<cn.hgxsp.springcloud.weather_maven.resultVO.City>
    */
    List<City> listCity() throws Exception ;

}
