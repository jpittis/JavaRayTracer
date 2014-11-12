package ca.jpittis.raytracer.shape;

import ca.jpittis.raytracer.vector.Vector;

public class Line {
    private Vector point;
    private Vector direction;

    public Line(Vector point, Vector direction) {
        this.point = point;
        this.direction = direction;
    }

    public Vector getPoint() {
        return point;
    }

    public Vector getDirection() {
        return direction;
    }
}
