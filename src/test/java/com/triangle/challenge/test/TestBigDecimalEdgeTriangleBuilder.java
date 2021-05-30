package com.triangle.challenge.test;

import com.triangle.challenge.BigDecimalEdge;
import com.triangle.challenge.Triangle;
import com.triangle.challenge.BigDecimalEdgeTriangleBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestBigDecimalEdgeTriangleBuilder {

    @Test
    public void testReadThreeNumbers() {
        String input = "1\n1\n1\n";
        InputStream targetStream = new ByteArrayInputStream(input.getBytes());


        BigDecimalEdgeTriangleBuilder bigDecimalEdgeTriangleBuilder = new BigDecimalEdgeTriangleBuilder();
        BigDecimalEdge one = new BigDecimalEdge(BigDecimal.ONE);
        Triangle<BigDecimalEdge> expected = new Triangle<>(one, one, one);

        Triangle<BigDecimalEdge> triangle = bigDecimalEdgeTriangleBuilder.buildTriangle(targetStream);

        Assertions.assertEquals(expected,triangle);
    }

    @Test
    public void testIOException() throws IOException {
        InputStream targetStream = mock(InputStream.class);
        when(targetStream.read()).thenThrow(new IOException());
        BigDecimalEdgeTriangleBuilder bigDecimalEdgeTriangleBuilder = new BigDecimalEdgeTriangleBuilder();

        Triangle<BigDecimalEdge> triangle = bigDecimalEdgeTriangleBuilder.buildTriangle(targetStream);

        Assertions.assertNull(triangle);
    }

    @Test
    public void testWrongFormatException() {
        String input = "1\n1\nh\n1\n";
        InputStream targetStream = new ByteArrayInputStream(input.getBytes());


        BigDecimalEdgeTriangleBuilder bigDecimalEdgeTriangleBuilder = new BigDecimalEdgeTriangleBuilder();
        BigDecimalEdge one = new BigDecimalEdge(BigDecimal.ONE);
        Triangle<BigDecimalEdge> expected = new Triangle<>(one, one, one);

        Triangle<BigDecimalEdge> triangle = bigDecimalEdgeTriangleBuilder.buildTriangle(targetStream);

        Assertions.assertEquals(expected,triangle);
    }
}
