package main;

import java.io.IOException;
import java.util.Properties;

/**
 * @Description:读取配置文件
 * @Auther:ZhangYanBo
 * @Date:2020-11-29-23:04
 */
public class PropertyMgr {
    static Properties properties = new Properties();

    private PropertyMgr(){

    }

    static {
        try {
            properties.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String get(String key){
        return properties == null ? "" : properties.getProperty(key);
    }


}
