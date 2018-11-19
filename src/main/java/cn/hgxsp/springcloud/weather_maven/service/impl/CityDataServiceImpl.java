package cn.hgxsp.springcloud.weather_maven.service.impl;

import cn.hgxsp.springcloud.weather_maven.resultVO.City;
import cn.hgxsp.springcloud.weather_maven.resultVO.CityList;
import cn.hgxsp.springcloud.weather_maven.service.CityDataService;
import cn.hgxsp.springcloud.weather_maven.utils.XMLBuilder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * DESC：城市数据service层实现类
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/11/15
 * Time : 10:50
 */
@Service
public class CityDataServiceImpl implements CityDataService {

    @Override
    public List<City> listCity() throws Exception {
        //读取xml文件
        Resource resource = new ClassPathResource("cityList.xml") ;
        //创建输入流
        BufferedReader br = new BufferedReader(
                new InputStreamReader(resource.getInputStream(),"UTF-8")) ;
        StringBuffer buffer = new StringBuffer() ;

        //读取流中的数据，存入StringBuffer中
        String line = "" ;
        while ((line  = br.readLine()) != null ) buffer.append(line) ;
        br.close();

        //将xml转为java对象
        CityList cityList = (CityList)XMLBuilder.xmlStrToObject(CityList.class , buffer.toString()) ;


        return cityList.getCityList();
    }
}
