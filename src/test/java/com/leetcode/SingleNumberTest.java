package com.leetcode;

import org.junit.Before;
import org.junit.Test;

public class SingleNumberTest {
    int[] array;

    @Before
    public void initTests() {
        array = new int[]{-1};
    }

    @Test
    public void run() {
        int result = new SingleNumber().singleNumber(array);
        System.out.println(result);
    }
}
