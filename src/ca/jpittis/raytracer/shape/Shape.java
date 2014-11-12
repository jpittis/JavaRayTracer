package ca.jpittis.raytracer.shape;

import ca.jpittis.raytracer.vector.Vector;

public interface Shape {
    public boolean intersects(Line line);
    public Vector getIntersection();
    public Vector getNormalIntersection();
}
