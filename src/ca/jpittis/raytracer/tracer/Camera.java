package ca.jpittis.raytracer.tracer;

import ca.jpittis.raytracer.shape.Line;
import ca.jpittis.raytracer.vector.Vector;

public class Camera {

    private Vector point;
    private Vector direction;

    private int width, height;

    Vector[][] screen;
    Line[][] lines;

    public Camera(Vector direction, Vector point, int width, int height) {
        this.direction = direction;
        this.point = point;
        this.width = width;
        this.height = height;
    }

    private void generateScreen() { // screen always on x y plane
        screen = new Vector[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                screen[x][y] = new Vector((x - (width/2)) * 0.25, (y - (height/2)) * 0.25, 0);
            }
        }
    }

    public void generateLines() {
        generateScreen();

        lines = new Line[width][height];

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Vector lineDirection = new Vector(screen[x][y]);
                lineDirection.subtract(point);
                lines[x][y] = new Line(point, lineDirection);
            }
        }

    }

    public Line[][] getLines() {
        return lines;
    }
}
