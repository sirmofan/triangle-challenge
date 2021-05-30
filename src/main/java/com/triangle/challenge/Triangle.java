package com.triangle.challenge;


import java.util.Objects;

public class Triangle<T extends Edge> {

    private final T x;
    private final T y;
    private final T z;

    public Triangle(T x, T y, T z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public String getTriangleType() {
        if (x.equals(y) && y.equals(z) && z.equals(x)) {
            return "equilateral";
        } else if (x.equals(y) || y.equals(z) || z.equals(x)) {
            return "isosceles";
        } else {
            return "scalene";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Objects.equals(x, triangle.x) && Objects.equals(y, triangle.y) && Objects.equals(z, triangle.z);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }
}
