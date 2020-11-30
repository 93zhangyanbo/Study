package main;

/**
 * @Description:坦克大战程序入口
 * @Auther:ZhangYanBo
 * @Date:2020-11-20-21:52
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = new TankFrame();

        int initTankCount = Integer.parseInt(PropertyMgr.get("initTankCount"));

        //初始化敌方坦克
        for (int i = 0; i <initTankCount ; i++) {
            tf.enemies.add(new Tank(50 + i*80,80, Dir.DOWN, Group.BAD, tf));
        }

        while (true){
            Thread.sleep(50);
            tf.repaint();
        }

    }
}
