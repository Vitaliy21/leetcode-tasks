package com.leetcode;

public class RemoveDuplicates_26 {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int resultCount = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[resultCount]) {
                resultCount++;
                nums[resultCount] = nums[i];
            }
        }
        return resultCount + 1;
    }
}
