package main.singleton;

/**
 * @Description:
 * lazy loading
 * 懒汉式
 *  * 虽然达到了按需初始化的目的，但却带来线程不安全的问题
 *  可以通过synchronized解决，但也带来效率下降
 * @Auther:ZhangYanBo
 * @Date:2020-12-06 23:14
 */
public class Mgr05 {
    private static Mgr05 INSTANCE;

    private Mgr05(){

    }

    public static synchronized Mgr05 getINstance(){
        if(INSTANCE == null){
            //妄图通过减小同步代码块的方式提高效率，然而不可行
            synchronized (Mgr05.class){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE = new Mgr05();
            }
        }
        return INSTANCE;
    }

    public void m(){
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(
                    ()-> System.out.println(Mgr05.getINstance().hashCode())
            ).start();
        }
    }
}
