package com.leetcode;

import java.util.Arrays;

public class RotateArray_189 {

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] newArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newArray[(i + k) % nums.length] = nums[i];
        }
        System.arraycopy(newArray, 0, nums, 0, nums.length);
        System.out.println(Arrays.toString(nums));
    }
}
