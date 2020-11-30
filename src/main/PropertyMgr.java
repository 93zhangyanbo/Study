package main;

import java.io.IOException;
import java.util.Properties;

/**
 * @Description:读取配置文件
 * @Auther:ZhangYanBo
 * @Date:2020-11-29-23:04
 */
public class PropertyMgr {
    /*static Properties properties = new Properties();

    static {
        try {
            properties.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }*/

    /*饿汉式*/
    /*类加载到内存后，就实例化一个单利，JVM保证线程安全
    * 简单实用，推荐使用
    * 唯一缺点：不管用到与否，类装载时就完成实例化
    * */

    public static String get(String key){
        return properties == null ? "" : properties.getProperty(key);
    }

    public static void main(String[] args) {
        System.out.println(properties.get("initTankCount"));
    }

}
