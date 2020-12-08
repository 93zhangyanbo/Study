package main.singleton;

/**
 * @Description:
 * 饿汉式
 *  * 类加载到内存后，就实例化一个单例，JVM保证线程安全
 *  * 简单实用，推荐使用！
 *  * 唯一缺点：不管用到与否，类装载时就完成实例化
 *  * Class.forName("")
 *  * （话说你不用的，你装载它干啥）
 * @Auther:ZhangYanBo
 * @Date:2020-12-06 23:14
 */
public class Mgr01 {
    private static final Mgr01 INSTANCE = new Mgr01();

    private Mgr01(){

    }

    public static Mgr01 getINstance(){
        return INSTANCE;
    }

    public void m(){
        System.out.println("m");
    }

    public static void main(String[] args) {
        Mgr01 m1 = Mgr01.getINstance();
        Mgr01 m2 = Mgr01.getINstance();
        System.out.println(m1 == m2);
    }

}
