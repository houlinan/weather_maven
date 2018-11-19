package cn.hgxsp.springcloud.weather_maven.service.impl;

import cn.hgxsp.springcloud.weather_maven.resultVO.Weather;
import cn.hgxsp.springcloud.weather_maven.service.WeatherDataService;
import cn.hgxsp.springcloud.weather_maven.service.WeatherReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * DESC：天气服务返回模板引擎接口实现类
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/11/19
 * Time : 10:31
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Autowired
    WeatherDataService weatherDataService ;


    @Override
    public Weather getWeatherByCityId(String cityId) {
        return weatherDataService.getDataByCityId(cityId).getData();
    }
}
