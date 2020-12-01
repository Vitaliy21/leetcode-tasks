package com.adventofcode2020;

import java.util.List;

/**
 * Specifically, they need you to find the two entries that sum to 2020 and then multiply those two numbers together.
 * For example, suppose your expense report contained the following:
 * 1721
 * 979
 * 366
 * 299
 * 675
 * 1456
 * In this list, the two entries that sum to 2020 are 1721 and 299. Multiplying them together produces 1721 * 299 = 514579,
 * so the correct answer is 514579.
 **/

public class Day1a {
    private static int YEAR = 2020;

    public String findValidAndMultiply(List<Integer> input) {
        String result = "no valid answer there";
        int startIndex = 1;
        for (int number : input) {
            for (int i = startIndex; i < input.size(); i++) {
                int number2 = input.get(i);
                if (number + number2 == YEAR) {
                    int multiple = number * number2;
                    result = "first number: " + number + "; second number: " + number2 + "; result: " + multiple;
                    return result;
                }
            }
            startIndex ++;
        }
        return result;
    }
}
