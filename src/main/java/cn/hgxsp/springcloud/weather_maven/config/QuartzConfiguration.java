package cn.hgxsp.springcloud.weather_maven.config;

import cn.hgxsp.springcloud.weather_maven.job.WeatherDataSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * DESC：定时任务配置类
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/11/15
 * Time : 9:48
 */
@Component
public class QuartzConfiguration {

    @Bean
    //jobDeatil 定义一个特定的job
    public JobDetail weatherDataSyncJobDetail(){

        return JobBuilder.newJob(WeatherDataSyncJob.class).withIdentity("weatherDataSyncJob")
                .storeDurably().build();
    }

    @Bean
    //Trigger 定义一个job何时触发
    public Trigger weatherDataSyncTrigger(){

        //创建schedBuilder参数
        SimpleScheduleBuilder schedBuilder = SimpleScheduleBuilder.simpleSchedule()
                //可以填写秒数，多少秒执行一次
                .withIntervalInMinutes(1).repeatForever();

        return TriggerBuilder.newTrigger().forJob(weatherDataSyncJobDetail())
                .withIdentity("weatherDataSyncTrigger").withSchedule(schedBuilder).build();
    }



}
