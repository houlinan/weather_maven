package cn.hgxsp.springcloud.weather_maven.utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;

/**
 * DESC：xml文件处理工具类
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/11/15
 * Time : 10:36
 */
public class XMLBuilder {

    /**
    *DESC: 将xml转换成指定的pojo对象
    *@author hou.linan
    *@date:  2018/11/15 10:38
    *@param:  [clazz, xmlString]
    *@return:  java.lang.Object
    */
    public static Object xmlStrToObject(Class<?> clazz , String xmlString) throws Exception {
        Object xmlObject = null ;

        //读取xml文件
        Reader reader = null ;

        //创建上下文对象
        JAXBContext context = JAXBContext.newInstance(clazz);
        //上下文对象提供了转换对象的方法
        Unmarshaller unmarshaller = context.createUnmarshaller();

        //传入文件流参数
        reader = new StringReader(xmlString) ;
        xmlObject = unmarshaller.unmarshal(reader) ;
        if(reader != null) reader.close();

        return xmlObject ;
    }

}
