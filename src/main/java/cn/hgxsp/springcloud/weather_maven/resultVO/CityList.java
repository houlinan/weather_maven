package cn.hgxsp.springcloud.weather_maven.resultVO;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * DESC：承载城市信息的集合
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/11/15
 * Time : 10:34
 */
@Data
//声明是xml的根元素
@XmlRootElement(name = "c" )
//xml访问类型("按照下面的字段来访问")
@XmlAccessorType(XmlAccessType.FIELD)
public class CityList {

    @XmlElement(name = "d")
    private List<City> cityList ;

}
