package main;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:坦克大战绘制
 * @Auther:ZhangYanBo
 * @Date:2020-11-20-22:13
 */
public class TankFrame extends Frame {

    Tank tank = new Tank(Integer.parseInt(PropertyMgr.get("initTankX")),Integer.parseInt(PropertyMgr.get("initTankY")), Dir.UP, Group.GOOD,this);
    List<Bullet> bullets = new ArrayList<>();
    List<Tank> enemies = new ArrayList<>();
    List<Explode> explodes = new ArrayList<>();
    static final int GAME_WIDTH=Integer.parseInt(PropertyMgr.get("GAME_WIDTH")), GAME_HEIGHT=Integer.parseInt(PropertyMgr.get("GAME_HEIGHT"));
    /**
     * 画出窗口
     */
    public TankFrame(){
        setSize(GAME_WIDTH,GAME_HEIGHT);
        setResizable(false);
        setTitle("Tank War");
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        addKeyListener(new MyKeyListener());
    }

    Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    /**
     * 画出坦克
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹数量："+ bullets.size(),10,60);
        g.drawString("敌人数量："+ enemies.size(),10,80);
        g.drawString("敌人数量："+ explodes.size(),10,100);
        g.setColor(c);
        tank.paint(g);
        for(int i=0;i<bullets.size();i++){
            bullets.get(i).paint(g);
        }
        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).paint(g);
        }
        for (int i = 0; i < explodes.size(); i++) {
            explodes.get(i).paint(g);
        }
        //碰撞检测
        for (int i = 0; i < bullets.size(); i++) {
            for (int j = 0; j < enemies.size(); j++) {
                bullets.get(i).collideWith(enemies.get(j));
            }
        }
    }

    class MyKeyListener extends KeyAdapter{
        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                case KeyEvent.VK_CONTROL:
                    tank.fire();
                    break;
                default:
                    break;
            }
            setMainTankDir();
//            new Thread(()->new Audio("audio/tank_move.wav").play()).start();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        /**
         * 根据按键给主战坦克设置方向
         */
        private void setMainTankDir() {
            if(!bL && !bR && !bU && !bD){
                tank.setMoving(false);
            }else{
                tank.setMoving(true);
                if(bL) tank.setDir(Dir.LEFT);
                if(bR) tank.setDir(Dir.RIGHT);
                if(bU) tank.setDir(Dir.UP);
                if(bD) tank.setDir(Dir.DOWN);
            }
        }
    }

}
