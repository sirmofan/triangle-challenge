package com.triangle.challenge.test;

import com.triangle.challenge.BigDecimalEdge;
import com.triangle.challenge.Edge;
import com.triangle.challenge.Triangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TestTriangle {

    @Test
    public void testEquilateral() {
        Triangle triangle = new Triangle(getLengthOneEdge(), getLengthOneEdge(), getLengthOneEdge());
        Assertions.assertEquals("equilateral", triangle.getTriangleType());
    }

    @Test
    public void testIsoscelesXSideEqualsYSide() {
        Triangle triangle = new Triangle(getLengthOneEdge(), getLengthOneEdge(), getLengthTenEdge());
        Assertions.assertEquals("isosceles", triangle.getTriangleType());
    }

    @Test
    public void testIsoscelesYSideEqualsZSide() {
        Triangle triangle = new Triangle(getLengthTenEdge(), getLengthOneEdge(), getLengthOneEdge());
        Assertions.assertEquals("isosceles", triangle.getTriangleType());
    }


    @Test
    public void testIsoscelesZSideEqualsXSide() {
        Triangle triangle = new Triangle(getLengthOneEdge(), getLengthTenEdge(), getLengthOneEdge());
        Assertions.assertEquals("isosceles", triangle.getTriangleType());
    }

    @Test
    public void testEquilateralShouldNotReturnIsoscelesTriangle() {
        Triangle triangle = new Triangle(getLengthOneEdge(), getLengthOneEdge(), getLengthOneEdge());
        Assertions.assertNotEquals("isosceles", triangle.getTriangleType());
    }

    @Test
    public void testScalene() {
        Triangle triangle = new Triangle(getLengthTwoEdge(), getLengthTenEdge(), getLengthOneEdge());
        Assertions.assertEquals("scalene", triangle.getTriangleType());
    }

    @Test
    public void testHashcode(){
       BigDecimalEdge scaleZero  = new BigDecimalEdge(BigDecimal.ONE);
       BigDecimalEdge scaleOne = new BigDecimalEdge(BigDecimal.ONE.setScale(1, RoundingMode.UNNECESSARY));
       Triangle<BigDecimalEdge> triangleScaleZero = new Triangle<>(scaleZero,scaleZero,scaleZero);
       Triangle<BigDecimalEdge> triangleScaleOne = new Triangle<>(scaleOne,scaleOne,scaleOne);

       Assertions.assertEquals(triangleScaleOne.hashCode(),triangleScaleZero.hashCode());
    }

    @Test
    public void testEquals(){
        BigDecimalEdge edge  = new BigDecimalEdge(BigDecimal.ONE);
        Triangle<BigDecimalEdge> triangleOne = new Triangle<>(edge,edge,edge);
        Triangle<BigDecimalEdge> triangleTwo = new Triangle<>(edge,edge,edge);

        Assertions.assertEquals(triangleOne,triangleTwo);
    }


    private Edge getLengthOneEdge() {
        return new BigDecimalEdge(BigDecimal.ONE);
    }

    private Edge getLengthTenEdge() {
        return new BigDecimalEdge(BigDecimal.TEN);
    }

    private Edge getLengthTwoEdge() {
        BigDecimal Two = BigDecimal.ONE.add(BigDecimal.ONE);
        return new BigDecimalEdge(Two);
    }

}
