package com.adventofcode2020;

import com.adventofcode2020.tools.CommonUtils;

import java.io.IOException;
import java.util.ArrayList;
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

    //correct answer: 1375 (index: 226)
    public int accumulatorValue2 () throws IOException {
        inputData = CommonUtils.readFileAsListOfLines(SOURCE_FILE);

        //store 'nop' or 'jmp' indexes
        List<Integer> nopOrJmpValues = new ArrayList<>();
        for (String line : inputData) {
            if(line.startsWith("nop") || line.startsWith("jmp")) {
                nopOrJmpValues.add(inputData.indexOf(line));
            }
        }

        //find index on which nop-jmp changing will allow come to last line
        for (int index : nopOrJmpValues) {
            changeNopJmp(index);
            if (isOnLastLine()) {
                break;
            } else  changeNopJmp(index);
        }

        //countAccumulatorValue
        boolean[] steps = new boolean[inputData.size()];
        int nextIndex = 0;
        while (true) {
            if (nextIndex == inputData.size()-1) {
                nextStep(nextIndex);
                return accumulatorValue;
            }
            steps[nextIndex] = true;
            nextIndex = nextStep(nextIndex);
        }
    }

    private void changeNopJmp(int index) {
        if (inputData.get(index).startsWith("nop")) {
            inputData.set(index, "jmp" + inputData.get(index).substring(3));
        } else if (inputData.get(index).startsWith("jmp")) {
            inputData.set(index, "nop" + inputData.get(index).substring(3));
        }
    }

    private boolean isOnLastLine() {
        try {
            boolean[] steps = new boolean[inputData.size()];
            int nextIndex = 0;
            while (true) {
                steps[nextIndex] = true;
                nextIndex = nextStepWithoutAccumCount(nextIndex);
                if (steps[nextIndex]) {
                    return false;
                }
            }
        } catch (Exception e) {
            return true;
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

    private int nextStepWithoutAccumCount(int index) throws Exception {
        if (index == inputData.size()-1) {
            throw new Exception();
        }
        String stepValue = inputData.get(index);
        if (stepValue.startsWith("nop")) {
            return index + 1;
        } else if (stepValue.startsWith("jmp")) {
            return index + Integer.parseInt(stepValue.substring(4));
        } else {
            return index + 1;
        }
    }

}
