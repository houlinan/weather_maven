package cn.hgxsp.springcloud.weather_maven.controller;

import cn.hgxsp.springcloud.weather_maven.resultVO.WeatherResponse;
import cn.hgxsp.springcloud.weather_maven.service.CityDataService;
import cn.hgxsp.springcloud.weather_maven.service.WeatherDataService;
import cn.hgxsp.springcloud.weather_maven.service.WeatherReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * DESC：天气数据Controller层
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/11/1
 * Time : 17:05
 */
@Controller
@RequestMapping("/report")
@Slf4j
public class WeatherReportController {

    @Autowired
    WeatherReportService weatherReportService ;

    @Autowired
    CityDataService cityDataService;

    @GetMapping("/getDataById")
    public ModelAndView getDataById(String id , Model model) throws Exception{

        model.addAttribute("title" , "鹤岗小商品-天气预报系统") ;
        model.addAttribute("cityId" , id ) ;
        model.addAttribute("cityList" , cityDataService.listCity() );
        model.addAttribute("report" , weatherReportService.getWeatherByCityId(id)) ;

        return new ModelAndView("weather/report" , "reportModel" , model) ;
    }

}
