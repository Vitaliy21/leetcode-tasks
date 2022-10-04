package com.leetcode;

import org.junit.Test;

public class CheckRowsColumnsTest_2133 {

    int [][] matrix = {{1,2,3},{3,1,2},{2,3,1}};

    @Test
    public void run() {
        boolean result = new CheckRowsColumns_2133().checkValid(matrix);
        System.out.println(result);
    }

    @Test
    public void test() {
        System.out.println("hi");
    }
}
