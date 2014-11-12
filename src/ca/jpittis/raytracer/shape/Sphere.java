package ca.jpittis.raytracer.shape;

import ca.jpittis.raytracer.vector.Vector;

public class Sphere implements Shape {

    private Vector point;
    private double radius;

    private Vector intersection;

    public Sphere(Vector point, double radius) {
        this.point = point;
        this.radius = radius;
    }

    @Override
    public boolean intersects(Line line) {

        Vector linePoint = line.getPoint();
        Vector lineDirection = line.getDirection();

        double a = Math.pow(lineDirection.getX(), 2) +
                Math.pow(lineDirection.getY(), 2) +
                Math.pow(lineDirection.getZ(), 2);

        double b = (2 * (lineDirection.getX() * (linePoint.getX() - point.getX()))) +
                (2 * (lineDirection.getY() * (linePoint.getY() - point.getY()))) +
                (2 * (lineDirection.getZ() * (linePoint.getZ() - point.getZ())));

        double c = Math.pow(linePoint.getX() - point.getX(), 2) +
                Math.pow(linePoint.getY() - point.getY(), 2) +
                Math.pow(linePoint.getZ() - point.getZ(), 2) - Math.pow(radius, 2);

        double discriminant = discriminant(a, b, c);

        if (discriminant > 0) {
            double t1 = ((b * -1) + Math.sqrt(discriminant))/(2*a);
            double t2 = ((b * -1) - Math.sqrt(discriminant))/(2*a);

            Vector point1 = solvePoint(t1, line.getPoint(), line.getDirection());

            intersection = point1;

            return true;
        } else {
            return false;
        }
    }

    private Vector solvePoint(double t, Vector point, Vector direction) {
        double x = point.getX() + (t * direction.getX());
        double y = point.getY() + (t * direction.getY());
        double z = point.getZ() + (t * direction.getZ());
        return new Vector(x, y, z);
    }

    private double discriminant(double a, double b, double c) {
        double discriminant = Math.pow(b, 2) - (4 * a * c);
        return discriminant;
    }

    @Override
    public Vector getIntersection() {
        return intersection;
    }

    @Override
    public Vector getNormalIntersection() {
        Vector normal = new Vector(intersection);
        normal.subtract(point);
        return normal;
    }
}
