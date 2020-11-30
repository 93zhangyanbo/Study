package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @Description:${DECRIPTION}
 * @Auther:ZhangYanBo
 * @Date:2020-11-22-17:02
 */
class ImageTest {
    @Test
    void test(){
        try {
            BufferedImage image = ImageIO.read(new File("C:/Users/ZhangYanBo/Desktop/timg.jpg"));
            Assertions.assertNotNull(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void test2(){
        try {
            BufferedImage bufferedImage = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
            Assertions.assertNotNull(bufferedImage);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
