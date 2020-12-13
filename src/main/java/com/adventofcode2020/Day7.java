package com.adventofcode2020;

import com.adventofcode2020.tools.CommonUtils;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Day7 {
    private final static String SOURCE_FILE = "src/main/resources/adventofcode2020/day7.txt";
    private static final String SPECIFIED_BAG = "shiny gold bags";

    //correct answer: 229
    public int countParentBags() throws IOException {
        List<String> inputData = CommonUtils.readFileAsListOfLines(SOURCE_FILE);
        Set<String> countResult = countParentBags(inputData, Collections.singletonList(SPECIFIED_BAG));
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

    //correct answer: 6683
    public int countChildBags() throws IOException {
        List<String> inputData = CommonUtils.readFileAsListOfLines(SOURCE_FILE);
        Map<String, Integer> bagsMap = new LinkedHashMap<>();
        bagsMap.put("total", 0);
        countChildBags(inputData, SPECIFIED_BAG, bagsMap, 1);
        return bagsMap.get("total");
    }

    private void countChildBags(List<String> inputData, String specifiedBag, Map<String, Integer> bagsMap, int count) {
        String specifiedLine = inputData.stream()
                .filter(line -> line.startsWith(specifiedBag))
                .findFirst()
                .get();

        if (specifiedLine.contains("no other bags")) {
            return;
        }

        String[] childLines = specifiedLine.split("contain")[1].split(",");
        for (String childLine : childLines) {
            if (childLine.endsWith(".")) {
                childLine = childLine.substring(0, childLine.length() - 1);
            }
            if (!childLine.endsWith("s")) {
                childLine += "s";
            }
            String bagKey = childLine.substring(3);
            int countBagValue = Integer.parseInt(childLine.substring(1,2));
            bagsMap.put("total", bagsMap.get("total") + countBagValue * count);
            bagsMap.merge(bagKey, countBagValue, Integer::sum);
            countChildBags(inputData, bagKey, bagsMap, countBagValue * count);
        }
    }

}
