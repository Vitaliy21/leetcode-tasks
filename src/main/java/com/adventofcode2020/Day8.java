package com.adventofcode2020;

import com.adventofcode2020.tools.CommonUtils;

import java.io.IOException;
import java.util.List;

public class Day8 {
    private final static String SOURCE_FILE = "src/main/resources/adventofcode2020/day8.txt";
    private static List<String> inputData;
    private static int accumulatorValue = 0;

    //correct answer: 1548
    public int accumulatorValue () throws IOException {
        inputData = CommonUtils.readFileAsListOfLines(SOURCE_FILE);
        boolean[] steps = new boolean[inputData.size()];
        int nextIndex = 0;
        while (true) {
            steps[nextIndex] = true;
            nextIndex = nextStep(nextIndex);
            if (steps[nextIndex]) {
                return accumulatorValue;
            }
        }
    }

    private int nextStep(int index) {
        String stepValue = inputData.get(index);
        if (stepValue.startsWith("nop")) {
            return index + 1;
        } else if (stepValue.startsWith("jmp")) {
            return index + Integer.parseInt(stepValue.substring(4));
        } else {
            accumulatorValue = accumulatorValue + Integer.parseInt(stepValue.substring(4));
            return index + 1;
        }
    }
}
