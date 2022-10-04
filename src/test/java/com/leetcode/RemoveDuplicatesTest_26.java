package com.leetcode;

import org.junit.Test;

public class RemoveDuplicatesTest_26 {
    int [] array = {0,0,1,1,1,2,2,3,3,4};

    @Test
    public void run() {
        int result = new RemoveDuplicates_26().removeDuplicates(array);
        System.out.println(result);
    }
}
