package com.triangle.challenge.test;

import com.triangle.challenge.BigDecimalEdge;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalEdgeTest {

    @Test
    public void testEqualsDifferentScales(){
        BigDecimal oneScaleTwo = BigDecimal.ONE.setScale(2, RoundingMode.UNNECESSARY);
        BigDecimalEdge bigDecimalEdgeLengthOneScaleTwo = new BigDecimalEdge(oneScaleTwo);
        BigDecimalEdge bigDecimalEdgeLengthOne = new BigDecimalEdge(BigDecimal.ONE);

        Assertions.assertEquals(bigDecimalEdgeLengthOne, bigDecimalEdgeLengthOneScaleTwo);
    }


    @Test
    public void testHashcodeDifferentScales(){
        BigDecimal oneScaleTwo = BigDecimal.ONE.setScale(2, RoundingMode.UNNECESSARY);
        BigDecimalEdge bigDecimalEdgeLengthOneScaleTwo = new BigDecimalEdge(oneScaleTwo);
        BigDecimalEdge bigDecimalEdgeLengthOne = new BigDecimalEdge(BigDecimal.ONE);

        Assertions.assertEquals(bigDecimalEdgeLengthOne.hashCode(),bigDecimalEdgeLengthOneScaleTwo.hashCode());
    }
}
