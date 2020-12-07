package com.adventofcode2020;

import com.adventofcode2020.tools.CommonUtils;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Day6 {
    private final static String SOURCE_FILE = "src/main/resources/adventofcode2020/day6.txt";

    //correct answer: 6542
    public int countYesAnswers() throws IOException {
        int count = 0;
        String inputData = CommonUtils.readFileAsString(SOURCE_FILE);
        String[] parsedInputData = inputData.split("\r\n\r\n");
        for (String group : parsedInputData) {
            List<Character> characterList = group.replaceAll("\r\n", "").chars().mapToObj(c -> (char) c).collect(Collectors.toList());
            count += new HashSet<>(characterList).size();
        }
        return count;
    }

    //correct answer: 3299
    public int countGroupYesAnswers() throws IOException {
        int count = 0;
        String inputData = CommonUtils.readFileAsString(SOURCE_FILE);
        String[] parsedInputData = inputData.split("\r\n\r\n");
        for (String group : parsedInputData) {
            String[] lines = group.split("\r\n");
            int countSameCharsInLines = countSimilarAnswers(lines);
            count += countSameCharsInLines;
        }

        return count;
    }

    private int countSimilarAnswers(String[] lines) {
        if (lines.length==1) {
            return lines[0].length();
        }
        int similarYesAnswers = 0;
        char[] firstLineChars = lines[0].toCharArray();
        for (char ch : firstLineChars) {
            boolean allLinesContains = true;
            for (String line : lines) {
                if(!line.contains(String.valueOf(ch))) {
                    allLinesContains = false;
                    break;
                }
            }
            if (allLinesContains) {
                similarYesAnswers ++;
            }
        }
        return similarYesAnswers;
    }
}
