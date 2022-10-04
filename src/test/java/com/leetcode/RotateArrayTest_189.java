package com.leetcode;

import org.junit.Test;

public class RotateArrayTest_189 {
    int [] array = {1,2,3,4,5,6,7};
    int k = 3;

    @Test
    public void run() {
        new RotateArray_189().rotate(array, k);
    }
}
