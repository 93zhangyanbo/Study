package main;

import java.awt.*;

/**
 * @Description:坦克的炮弹
 * @Auther:ZhangYanBo
 * @Date:2020-11-22-14:31
 */
public class Bullet {
    private static final int SPEED = Integer.parseInt(main.PropertyMgr.get("bulletSpeed"));
    public static final int WIDTH = main.ResourceMgr.bulletD.getWidth();
    public static final int HEIGHT = main.ResourceMgr.bulletD.getHeight();
    private boolean living = true;
    private int x,y;
    private main.Dir dir;
    private main.TankFrame tf;
    private Group group;
    Rectangle rect = new Rectangle();

    public Bullet(int x, int y, main.Dir dir, Group group, main.TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;
        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;
    }

    public boolean isLiving() {
        return living;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }

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

    public main.Dir getDir() {
        return dir;
    }

    public void setDir(main.Dir dir) {
        this.dir = dir;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void paint(Graphics g){
        //删除已经无效的子弹
        if (!living) {
            tf.bullets.remove(this);
        }
        switch (dir){
            case LEFT:
                g.drawImage(main.ResourceMgr.bulletL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(main.ResourceMgr.bulletR,x,y,null);
                break;
            case UP:
                g.drawImage(main.ResourceMgr.bulletU,x,y,null);
                break;
            case DOWN:
                g.drawImage(main.ResourceMgr.bulletD,x,y,null);
                break;

        }
        move();
    }

    /**
     * 子弹移动
     */
    private void move() {
        switch (dir){
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
        //update rect
        rect.x = this.x;
        rect.y = this.y;
        if (x < 0 || y < 0 || x > main.TankFrame.GAME_WIDTH || y > main.TankFrame.GAME_HEIGHT) living = false;
    }

    public void collideWith(main.Tank tank) {
        if(this.group == tank.getGroup()) return;

        //用一个rect来记录子弹的位置
        if(this.rect.intersects(tank.getRect())) {
            tank.die();
            this.die();
            int eX = tank.getX() + main.Tank.WIDTH/2 - main.Explode.WIDTH/2;
            int eY = tank.getY() + main.Tank.HEIGHT/2 - main.Explode.HEIGHT/2;
            this.tf.explodes.add(new main.Explode(eX,eY,this.tf));
        }

    }

    private void die() {
        this.living = false;
    }
}
