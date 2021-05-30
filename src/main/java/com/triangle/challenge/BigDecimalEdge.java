package com.triangle.challenge;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class BigDecimalEdge implements Edge{

    private final BigDecimal length;

    public BigDecimalEdge(BigDecimal length){
        this.length = length;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BigDecimalEdge that = (BigDecimalEdge) o;
        int scale = Math.max(length.scale(),length.scale());
        return Objects.equals(length.setScale(scale, RoundingMode.HALF_EVEN), that.length.setScale(scale,RoundingMode.HALF_EVEN));
    }

    @Override
    public int hashCode() {
        return Objects.hash(length);
    }
}
