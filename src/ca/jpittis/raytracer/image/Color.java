package ca.jpittis.raytracer.image;

public class Color {
    public static int toRGB(int r, int g, int b) {
        return (r << 16) | (g << 8) | b;
    }


}
