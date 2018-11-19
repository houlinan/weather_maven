package cn.hgxsp.springcloud.weather_maven.service;

import cn.hgxsp.springcloud.weather_maven.resultVO.Weather;

/**
 * DESC：天气服务返回模板引擎接口
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/11/19
 * Time : 10:25
 */
public interface WeatherReportService {

    /**
    *DESC: 根据城市id查询天气
    *@author hou.linan
    *@date:  2018/11/19 10:29
    *@param:  [cityId]
    *@return:  cn.hgxsp.springcloud.weather_maven.resultVO.Weather
    */
    Weather getWeatherByCityId(String cityId);
}
