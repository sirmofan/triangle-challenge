package com.triangle.challenge;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public interface Edge{

    default boolean compareLength(Edge other){
        BigDecimal length = this.getLengthAsBigBigDecimal();
        BigDecimal otherLength = other.getLengthAsBigBigDecimal();
        int scale = Math.max(length.scale(),length.scale());
        return Objects.equals(length.setScale(scale, RoundingMode.HALF_EVEN), otherLength.setScale(scale,RoundingMode.HALF_EVEN));
    }

    BigDecimal getLengthAsBigBigDecimal();

}
