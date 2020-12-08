package com.adventofcode2020;

import com.adventofcode2020.tools.CommonUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Day7 {
    private final static String SOURCE_FILE = "src/main/resources/adventofcode2020/day7.txt";
    private static final String SPECIFIED_BAGS = "shiny gold bags";

    //correct answer: 229
    public int countBags() throws IOException {
        List<String> inputData = CommonUtils.readFileAsListOfLines(SOURCE_FILE);
        Set<String> countResult = countParentBags(inputData, Collections.singletonList(SPECIFIED_BAGS));
        return countResult.size();
    }

    private Set<String> countParentBags(List<String> inputData, List<String> specifiedBags) {
        Set<String> result= new HashSet<>();
        for(String bag : specifiedBags) {
            if (bag.endsWith("s")) {
                bag = bag.substring(0, bag.length() - 1);
            }
            final String finalBag = bag;
            List<String> linesContainedSpecBags = inputData.stream()
                    .filter(line -> line.contains(finalBag) && !line.startsWith(finalBag))
                    .collect(Collectors.toList());
            List<String> parentBags = linesContainedSpecBags.stream().map(line -> line.split("contain")[0].trim()).collect(Collectors.toList());
            result.addAll(parentBags);
            if (!parentBags.isEmpty()) {
                result.addAll(countParentBags(inputData, parentBags));
            }
        }
        return result;
    }

}
