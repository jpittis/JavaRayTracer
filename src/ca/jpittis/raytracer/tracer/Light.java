package ca.jpittis.raytracer.tracer;

import ca.jpittis.raytracer.vector.Vector;

public class Light {
    private Vector point;

    public Light(Vector point) {
        this.point = point;
    }

    public Vector getPoint() {
        return point;
    }
}
