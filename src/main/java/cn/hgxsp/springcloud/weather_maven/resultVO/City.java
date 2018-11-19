package cn.hgxsp.springcloud.weather_maven.resultVO;

import lombok.Data;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * DESC：城市信息实体类
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/11/15
 * Time : 10:28
 */
@Data
//声明是xml的根元素
@XmlRootElement(name = "d" )
//xml访问类型("按照下面的字段来访问")
@XmlAccessorType(XmlAccessType.FIELD)
public class City {

    @XmlAttribute(name = "d1")
    private String cityId ;

    @XmlAttribute(name = "d2")
    private String cityName ;

    @XmlAttribute(name = "d3")
    private String cityCode ;

    @XmlAttribute(name = "d4")
    private String province ;

}
