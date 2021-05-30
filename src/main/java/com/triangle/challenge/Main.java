package com.triangle.challenge;

public class Main {

    public static void main(String[] args) {
        BigDecimalEdgeTriangleBuilder bigDecimalEdgeTriangleBuilder = new BigDecimalEdgeTriangleBuilder();
        Triangle triangle = bigDecimalEdgeTriangleBuilder.buildTriangle(System.in);
        System.out.println("The triangle is of type " + triangle.getTriangleType());
    }

}
