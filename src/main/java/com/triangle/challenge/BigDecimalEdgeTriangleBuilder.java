package com.triangle.challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BigDecimalEdgeTriangleBuilder {


    public Triangle<BigDecimalEdge> buildTriangle(InputStream inputStream)  {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            return parsAndBuildTriangle(bufferedReader);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private Triangle<BigDecimalEdge> parsAndBuildTriangle(BufferedReader bufferedReader) throws IOException {
        List<BigDecimalEdge> edges = new ArrayList<>();
        System.out.println("Enter the length of each triangle side");
        while (edges.size()<3){
            System.out.println("Enter edge length number: " + (edges.size() + 1));
            String line = bufferedReader.readLine();
            BigDecimal length = tryParsNumber(line);
            if(length != null){
                edges.add(new BigDecimalEdge(length));
            }
        }
        return new Triangle<>(edges.get(0),edges.get(1),edges.get(2));
    }

    private BigDecimal tryParsNumber(String line) {
        try {
           return new BigDecimal(line.toCharArray());
        }catch (NumberFormatException numberFormatException){
            System.out.println("Could not pars number");
            System.out.println(numberFormatException.getMessage());
        }
        return null;
    }





}
