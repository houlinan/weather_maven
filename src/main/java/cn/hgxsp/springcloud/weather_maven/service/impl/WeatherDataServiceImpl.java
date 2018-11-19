package cn.hgxsp.springcloud.weather_maven.service.impl;


import cn.hgxsp.springcloud.weather_maven.resultVO.WeatherResponse;
import cn.hgxsp.springcloud.weather_maven.service.CityDataService;
import cn.hgxsp.springcloud.weather_maven.service.WeatherDataService;
import cn.hgxsp.springcloud.weather_maven.utils.RedisOperator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * DESC：
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/11/1
 * Time : 16:43
 */
@Service
public class WeatherDataServiceImpl implements WeatherDataService {

    @Autowired
    private RestTemplate restTemplate ;

    @Autowired
    private RedisOperator redisOperator ;


    @Value("${getWeatherUrl}")
    private String getWeatherUrl ;

    private static final String GETBYIDTYPE = "citykey=" ;

    private static final String GETBYNAMETYPE = "city=" ;

    @Override
    public WeatherResponse getDataByCityId(String id) {
        return doGetWeather(id , GETBYIDTYPE) ;
    }


    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        return doGetWeather(cityName , GETBYNAMETYPE) ;
    }



    @Override
    public void syncDataByCityId(String cityId) {
        saveWeatherDataToRedis(cityId) ;
    }


    private void saveWeatherDataToRedis(String cityID){
        getDataByCityId(cityID) ;
    }



    /**
    *DESC:获取天气数据封装方法
    *@author hou.linan
    *@date:  2018/11/1 17:10
    *@param:  [value, keyType]
    *@return:  cn.hgxsp.springCloud.weather.resultVO.WeatherResponse
    */
    private WeatherResponse doGetWeather(String value , String keyType){

        String getDataUrl = getWeatherUrl + keyType +  value ;

        String rediskey = keyType + ":" + value ;

        // 先从缓存中获取数据  如果存在则return
        WeatherResponse resp = null;
        String strBody = null;
        ObjectMapper objectMapper = new ObjectMapper();
        if(! redisOperator.hasKey(rediskey)) {

            //发起请求
            ResponseEntity<String> result = restTemplate.getForEntity(getDataUrl, String.class);


            if (result.getStatusCode() == HttpStatus.OK) strBody = result.getBody();

            redisOperator.set(rediskey ,strBody ,  1800  );
        }else{
            strBody = redisOperator.get(rediskey) ;
        }

        try {
            resp = objectMapper.readValue(strBody, WeatherResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null ;
        }

        return resp;

    }





}
