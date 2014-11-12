package ca.jpittis.raytracer.image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Image {

    private BufferedImage image;

    public Image(int width, int height) {
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    }

    public void setPixel(int x, int y, int rgb) {
        image.setRGB(x, y, rgb);
    }

    public int getWidth() {
        return image.getWidth();
    }

    public int getHeight() {
        return image.getHeight();
    }

    public void save(String filename) throws IOException {
        File file = new File(filename);
        ImageIO.write(image, "png", file);
    }
}
