package cn.hgxsp.springcloud.weather_maven.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * DESC：定时通过接口获取天气信息类
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/11/15
 * Time : 9:45
 */
@Slf4j
public class WeatherDataSyncJob extends QuartzJobBean {


    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("weather sync job");
    }


}
