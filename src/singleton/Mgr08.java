package singleton;

/**
 * @Description:
 * 不仅可以解决线程同步，还可以防止反序列化。
 * 为什么单例需要防止反序列化
 * java反射可以拿到class文件，load到内存并创建对象（反序列化方式）
 * 枚举单例完美的原因，枚举类没有构造方法
 * @Auther:ZhangYanBo
 * @Date:2020-12-06 23:14
 */
public enum Mgr08 {

    INSTANCE;

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(
                    ()-> System.out.println(Mgr08.INSTANCE.hashCode())
            ).start();
        }
    }
}
