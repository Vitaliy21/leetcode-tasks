package com.leetcode;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int[] resultPositive = new int[nums.length + 1];
        int[] resultNegative = new int[nums.length + 1];
        for (int number : nums) {
            if (number >= 0) {
                putToResult(number, resultPositive);
            } else {
                putToResult(Math.abs(number), resultNegative);
            }
        }
        int index = 0;
        for (int number : resultPositive) {
            if (number == 1) {
                return index;
            } else index ++;
        }

        index = 0;
        for (int number : resultNegative) {
            if (number == 1) {
                return index;
            } else index --;
        }

        return 0;
    }

    private void putToResult(int number, int[] array) {
        if (array[number] == 0) {
            array[number] = 1;
        } else {
            array[number] = 2;
        }
    }
}
