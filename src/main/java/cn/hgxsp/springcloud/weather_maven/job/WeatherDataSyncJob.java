package cn.hgxsp.springcloud.weather_maven.job;

import cn.hgxsp.springcloud.weather_maven.resultVO.City;
import cn.hgxsp.springcloud.weather_maven.service.CityDataService;
import cn.hgxsp.springcloud.weather_maven.service.WeatherDataService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

/**
 * DESC：定时通过接口获取天气信息类
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/11/15
 * Time : 9:45
 */
@Slf4j
public class WeatherDataSyncJob extends QuartzJobBean {


    @Autowired
    private CityDataService cityDataService ;

    @Autowired
    private WeatherDataService weatherDataService ;


    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("weather sync job");
        List<City> cities = null ;
        try {
            cities = cityDataService.listCity();
        }catch (Exception e){
//            e.printStackTrace();
        }

        cities.forEach(e -> {
            log.info("weather sync job : 现在开始同步城市：【{}】" , e.getCityName());
            weatherDataService.syncDataByCityId(e.getCityId());
        });




    }


}
