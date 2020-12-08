package main.singleton;

/**
 * @Description:
 * 跟01一个意思
 * @Auther:ZhangYanBo
 * @Date:2020-12-06 23:14
 */
public class Mgr02 {
    private static Mgr02 INSTANCE;

    static {
        INSTANCE = new Mgr02();
    }
    private Mgr02(){

    }

    public static Mgr02 getINstance(){
        return INSTANCE;
    }

    public void m(){
        System.out.println("m");
    }

    public static void main(String[] args) {
        Mgr02 m1 = Mgr02.getINstance();
        Mgr02 m2 = Mgr02.getINstance();
        System.out.println(m1 == m2);
    }
}
