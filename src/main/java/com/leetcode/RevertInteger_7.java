package com.leetcode;

public class RevertInteger_7 {
    public int reverse(int x) {
        boolean negative = false;
        if (x == Integer.MAX_VALUE || x == Integer.MIN_VALUE) {
            return 0;
        }
        if (x<0) {
            negative = true;
            x = Math.abs(x);
        }
        String tempResult = Integer.toString(x);
        int [] result = new int [Integer.toString(x).length()];
        for (int i=0; i < result.length; i++) {
            result[i] = Integer.parseInt(tempResult) % 10;
            tempResult = tempResult.substring(0, tempResult.length()-1);
        }

        if(negative) {
            return -arrayToInt(result);
        } else {
            return arrayToInt(result);
        }

    }

    private int arrayToInt(int[] result) {
        StringBuilder sb = new StringBuilder();
        for (int i : result)
        {
            sb.append(i);
        }
        try {
            return Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
