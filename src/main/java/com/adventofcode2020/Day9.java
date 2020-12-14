package com.adventofcode2020;

import com.adventofcode2020.tools.CommonUtils;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Day9 {
    private final static String SOURCE_FILE = "src/main/resources/adventofcode2020/day9.txt";
    private static int preamble = 25;
    private static int delta = 25;

    //correct answer: 104054607
    public long getNumberThatHaveNotSum() throws IOException {
        List<Long> inputData = CommonUtils.readFileAsListOfLines(SOURCE_FILE).stream().map(Long::parseLong).collect(Collectors.toList());
        int startIndex = preamble;
        for (int i = startIndex; i<= inputData.size()-1; i++) {
            List<Long> subList = inputData.subList(preamble - delta, preamble);
            if (!isContainSum(subList, inputData.get(preamble))) {
                return inputData.get(preamble);
            }
            preamble ++;
        }
        return 0;
    }

    private boolean isContainSum(List<Long> subList, long integer) {
        for (long elem : subList) {
            for (int i = 1; i <= subList.size() - 1; i++) {
                if (elem + subList.get(i) == integer) {
                    return true;
                }
            }
        }
        return false;
    }
}
