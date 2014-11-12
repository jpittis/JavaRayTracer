package ca.jpittis.raytracer;

import ca.jpittis.raytracer.image.Color;
import ca.jpittis.raytracer.image.Image;
import ca.jpittis.raytracer.shape.Line;
import ca.jpittis.raytracer.shape.Shape;
import ca.jpittis.raytracer.shape.Sphere;
import ca.jpittis.raytracer.tracer.Camera;
import ca.jpittis.raytracer.tracer.Light;
import ca.jpittis.raytracer.vector.Vector;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Image image = new Image(600, 600);

        Camera camera = new Camera(new Vector(0, 0, 1), new Vector(0, 0, -200), 600, 600);
        camera.generateLines();
        Line[][] lines = camera.getLines();

        Light light = new Light(new Vector(250, 300, 0));

        Shape shape = new Sphere(new Vector(20, 20, 400), 150);

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int color;
                if (shape.intersects(lines[x][y])) {
                    Vector normal = shape.getNormalIntersection();
                    Vector lightVector = new Vector(shape.getIntersection());
                    lightVector.subtract(light.getPoint());
                    double dot = normal.getUnit().dot(lightVector.getUnit());
                    if (dot > 0) {
                        int colorLight = (int) Math.round(dot * 255);
                        color = Color.toRGB(colorLight, colorLight, colorLight);
                    } else {
                        color = Color.toRGB(0, 0, 0);
                    }
                } else {
                    color = Color.toRGB(0, 0, 0);
                }
                image.setPixel(x, y, color);
            }
        }

        image.save("output.png");
    }
}
