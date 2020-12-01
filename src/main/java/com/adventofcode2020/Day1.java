package com.adventofcode2020;

import java.util.List;

/**
 * --- Part One ---
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
 *
 * --- Part Two ---
 * Using the above example again, the three entries that sum to 2020 are 979, 366, and 675.
 * Multiplying them together produces the answer, 241861950.
 **/

public class Day1 {
    private static int YEAR = 2020;
    private static String NO_RESULT = "no valid answer there";

    public String findTwoValidAndMultiply(List<Integer> input) {
        int startIndex = 1;
        for (int number : input) {
            for (int i = startIndex; i < input.size(); i++) {
                int number2 = input.get(i);
                if (number + number2 == YEAR) {
                    int multiple = number * number2;
                    return  "first number: " + number + "; second number: " + number2 + "; result: " + multiple;
                }
            }
            startIndex ++;
        }
        return NO_RESULT;
    }

    public String findThreeValidAndMultiply(List<Integer> input) {
        int startIndex = 1;
        for (int number : input) {
            for (int i = startIndex; i < input.size(); i++) {
                int number2 = input.get(i);
                for (int n = startIndex + 1; n < input.size(); n ++) {
                    int number3 = input.get(n);
                    if (number + number2 + number3 == YEAR) {
                        int multiple = number * number2 * number3;
                        return "first number: " + number + "; second number: " + number2 +
                                "; third number: " + number3 + "; result: " + multiple;
                    }
                }
            }
            startIndex ++;
        }
        return NO_RESULT;
    }
}
