package com.leetcode;

public class CheckRowsColumns_2133 {

    public boolean checkValid(int[][] matrix) {
        //iterate rows
        for (int[] value : matrix) {
            boolean[] rows = new boolean[value.length];
            for (int i : value) {
                if (rows[i - 1]) {
                    return false;
                } else rows[i - 1] = true;
            }
        }

        //iterate columns
        for (int i = 0; i< matrix.length; i++) {
            boolean[]columns = new boolean[matrix.length];
            for (int[] ints : matrix) {
                if (columns[ints[i] - 1]) {
                    return false;
                } else columns[ints[i] - 1] = true;
            }
        }

        return true;
    }
}
