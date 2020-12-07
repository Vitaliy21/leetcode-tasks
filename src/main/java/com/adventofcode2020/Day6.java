package com.adventofcode2020;

import com.adventofcode2020.tools.CommonUtils;

import java.io.IOException;
import java.util.Arrays;
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
}
