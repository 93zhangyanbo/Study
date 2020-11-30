package main;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Description:静态资源管理类
 * @Auther:ZhangYanBo
 * @Date:2020-11-22-17:46
 */
public class ResourceMgr {
    public static BufferedImage GoodTank1L, GoodTank1R, GoodTank1U, GoodTank1D;
    public static BufferedImage GoodTank2L, GoodTank2R, GoodTank2U, GoodTank2D;
    public static BufferedImage BadTank1L, BadTank1R, BadTank1U, BadTank1D;
    public static BufferedImage BadTank2L, BadTank2R, BadTank2U, BadTank2D;
    public static BufferedImage bulletL, bulletR, bulletU, bulletD;
    public static BufferedImage[] explodes = new BufferedImage[16];
    static {
        try {
            GoodTank1U = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
            GoodTank1L = ImageUtil.rotateImage(GoodTank1U,-90);
            GoodTank1R = ImageUtil.rotateImage(GoodTank1U,90);
            GoodTank1D = ImageUtil.rotateImage(GoodTank1U,180);

            GoodTank2U = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank2.png"));
            GoodTank2L = ImageUtil.rotateImage(GoodTank2U,-90);
            GoodTank2R = ImageUtil.rotateImage(GoodTank2U,90);
            GoodTank2D = ImageUtil.rotateImage(GoodTank2U,180);

            BadTank1U = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
            BadTank1L = ImageUtil.rotateImage(BadTank1U,-90);
            BadTank1R = ImageUtil.rotateImage(BadTank1U,90);
            BadTank1D = ImageUtil.rotateImage(BadTank1U,180);

            BadTank2U = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank2.png"));
            BadTank2L = ImageUtil.rotateImage(BadTank2U,-90);
            BadTank2R = ImageUtil.rotateImage(BadTank2U,90);
            BadTank2D = ImageUtil.rotateImage(BadTank2U,180);

            bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.png"));
            bulletL = ImageUtil.rotateImage(bulletU,-90);
            bulletR = ImageUtil.rotateImage(bulletU,90);
            bulletD = ImageUtil.rotateImage(bulletU,180);
            for (int i = 0; i < 16; i++) {
                explodes[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e"+(i+1)+".gif"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
