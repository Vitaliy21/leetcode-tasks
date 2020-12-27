package com;

import com.adventofcode2020.tools.CommonUtils;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Day10 {
    private final static String SOURCE_FILE = "src/main/resources/adventofcode2020/day10.txt";

    public int getMultipliedJolts() throws IOException {
        int diffsBy1 = 1;
        int diffsBy3 = 1;
        List<Integer> inputData = CommonUtils.readFileAsListOfLines(SOURCE_FILE).stream().map(Integer::parseInt).collect(Collectors.toList());
        Collections.sort(inputData);

        Iterator<Integer> iterator = inputData.iterator();
        int current = 0;
        int next;
        while (iterator.hasNext()) {
            next = iterator.next();
            if (current == 0) {
                current = next;
            } else {
                if(next - current == 1) {
                    diffsBy1 += 1;
                    current = next;
                } else if (next - current == 3) {
                    diffsBy3 += 1;
                    current = next;
                } else throw new RuntimeException("Wrong difference");
            }

        }
        return diffsBy1 * diffsBy3;
    }
}
