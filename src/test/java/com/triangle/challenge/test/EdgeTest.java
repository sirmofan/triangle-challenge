package com.triangle.challenge.test;

import com.triangle.challenge.Edge;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class EdgeTest {

    @Test
    public void testSameScaleCompareLength(){
        Edge firstEdge = new TestEdge(BigDecimal.ONE);
        Edge secondEdge = new TestEdge(BigDecimal.ONE);

        Assertions.assertTrue(firstEdge.compareLength(secondEdge));

    }

    @Test
    public void testDifferentScaleCompareLength(){
        Edge firstEdge = new TestEdge(BigDecimal.ONE.setScale(2, RoundingMode.UNNECESSARY));
        Edge secondEdge = new TestEdge(BigDecimal.ONE);

        Assertions.assertTrue(firstEdge.compareLength(secondEdge));

    }

    public class TestEdge implements Edge{
        BigDecimal length;

        public TestEdge(BigDecimal length) {
            this.length = length;
        }

        @Override
        public BigDecimal getLengthAsBigBigDecimal() {
            return length;
        }
    }
}
