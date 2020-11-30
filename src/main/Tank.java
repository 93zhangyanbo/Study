package main;

import java.awt.*;
import java.util.Random;

/**
 * @Description:主战坦克
 * @Auther:ZhangYanBo
 * @Date:2020-11-22-13:50
 */
public class Tank {
    private static final int SPEED = Integer.parseInt(PropertyMgr.get("tankSpeed"));//速度
    public static final int WIDTH = ResourceMgr.GoodTank1U.getWidth();
    public static final int HEIGHT = ResourceMgr.GoodTank1U.getHeight();

    private int x,y;//初始位置
    private Dir dir;//方向
    private boolean moving = true;//是否静止状态
    private boolean living = true;
    private TankFrame tf;
    private Random random = new Random();
    private Group group;
    private Rectangle rect = new Rectangle();
    private boolean light = true;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public boolean isLiving() {
        return living;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Rectangle getRect() {
        return rect;
    }

    public void setRect(Rectangle rect) {
        this.rect = rect;
    }

    public Tank(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf  = tf;
        this.group = group;
        this.light = true;
        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;
    }

    /**
     * 画出坦克
     * @param g
     */
    public void paint(Graphics g) {
        if(!living) tf.enemies.remove(this);
        switch (dir){
            case LEFT:
                g.drawImage(this.group == Group.GOOD ? (this.light == true ? ResourceMgr.GoodTank1L : ResourceMgr.GoodTank2L) : (this.light ==true ? ResourceMgr.BadTank1L : ResourceMgr.BadTank2L),x,y,null);
            break;
            case RIGHT:
                g.drawImage(this.group == Group.GOOD ? (this.light == true ? ResourceMgr.GoodTank1R : ResourceMgr.GoodTank2R) : (this.light ==true ? ResourceMgr.BadTank1R : ResourceMgr.BadTank2R),x,y,null);
                break;
            case UP:
                g.drawImage(this.group == Group.GOOD ? (this.light == true ? ResourceMgr.GoodTank1U : ResourceMgr.GoodTank2U) : (this.light ==true ? ResourceMgr.BadTank1U : ResourceMgr.BadTank2U),x,y,null);
                break;
            case DOWN:
                g.drawImage(this.group == Group.GOOD ? (this.light == true ? ResourceMgr.GoodTank1D : ResourceMgr.GoodTank2D) : (this.light ==true ? ResourceMgr.BadTank1D : ResourceMgr.BadTank2D),x,y,null);
                break;
        }
        this.light = !light;
        move();
    }

    /**
     * 根据坦克动静状态移动坦克
     */
    private void move() {
        if (!moving) return;
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }
        if (this.group == Group.BAD && random.nextInt(100) > 95){
            this.fire();
            redomDir();
        }
        boundsCheck();
        rect.x = this.x;
        rect.y = this.y;
    }

    private void boundsCheck() {
        if(this.x < 1) x = 1;
        if(this.y < 28) y = 28;
        if(this.x > TankFrame.GAME_WIDTH - Tank.WIDTH) x = TankFrame.GAME_WIDTH - Tank.WIDTH;
        if(this.y > TankFrame.GAME_HEIGHT - Tank.HEIGHT) y = TankFrame.GAME_HEIGHT - Tank.HEIGHT;
    }

    private void redomDir() {
        this.dir = Dir.values()[random.nextInt(4)];
    }

    public void fire() {
        int bulletX = this.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bulletY = this.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        tf.bullets.add(new Bullet(bulletX,bulletY,this.dir,this.group ,this.tf));
        if(this.group == Group.GOOD) new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
    }

    public void die() {
        this.living = false;
    }
}

