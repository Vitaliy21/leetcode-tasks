package com.adventofcode2020;

import com.adventofcode2020.tools.CommonUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day5 {

    private final static String SOURCE_FILE = "src/main/resources/adventofcode2020/day5.txt";

    //correct answer: 866
    public int findMaxSeatId() throws IOException {
        List<Integer> seatsIds = new ArrayList<>();
        List<String> inputData = CommonUtils.readFileAsListOfLines(SOURCE_FILE);
        for (String line : inputData) {
            String rowsCode = line.substring(0, 7);
            int row = decodeNumber(rowsCode, 0, 127);

            String columnCode = line.substring(7);
            int column = decodeNumber(columnCode, 0, 7);

            seatsIds.add(row * 8 + column);
        }

        Collections.sort(seatsIds);
        return seatsIds.get(seatsIds.size()-1);
    }

    private int decodeNumber(String code, int from, int to) {
        if (code.charAt(0) == 'F' || code.charAt(0) == 'L') {
            if(code.length() == 1) {
                return from;
            } else return decodeNumber(code.substring(1), from, ((to+1)-from)/2+from-1);
        } else {
            if(code.length() == 1) {
                return to;
            } else return decodeNumber(code.substring(1), ((to+1)-from)/2+from, to);
        }
    }
}
