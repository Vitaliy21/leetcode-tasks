package com.adventofcode2020;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class TestsRunner {

    @Test
    public void day1RunFirst() {
        String result = new Day1().findTwoValidAndMultiply();
        System.out.println(result);
    }

    @Test
    public void day1RunSecond() {
        String result = new Day1().findThreeValidAndMultiply();
        System.out.println(result);
    }

    @Test
    public void day2RunFirst() throws IOException {
        int result = new Day2().countValidPasswords();
        System.out.println(result);
    }

    @Test
    public void day2RunSecond() throws IOException {
        int result = new Day2().countValidPasswords2();
        System.out.println(result);
    }

    @Test
    public void day4RunFirst() throws IOException {
        int result = new Day4().countValidPassports();
        System.out.println(result);
    }

    @Test
    public void day4RunSecond() throws IOException {
        int result = new Day4().countValidPassportsWithAdditionalValidation();
        System.out.println(result);
    }

    @Test
    public void day5RunFirst() throws IOException {
        List<Integer> result = new Day5().findSeatsIds();
        System.out.println(result.get(result.size()-1));
    }

    @Test
    public void day5RunSecond() throws IOException {
        int result = new Day5().findYourSeatId();
        System.out.println(result);
    }

    @Test
    public void day6RunFirst() throws IOException {
        int result = new Day6().countYesAnswers();
        System.out.println(result);
    }

    @Test
    public void day6RunSecond() throws IOException {
        int result = new Day6().countGroupYesAnswers();
        System.out.println(result);
    }

    @Test
    public void day7RunFirst() throws IOException {
        int result = new Day7().countParentBags();
        System.out.println(result);
    }

    @Test
    public void day7RunSecond() throws IOException {
        int result = new Day7().countChildBags();
        System.out.println(result);
    }

    @Test
    public void day8RunFirst() throws IOException {
        int result = new Day8().accumulatorValue();
        System.out.println(result);
    }

    @Test
    public void day8RunSecond() throws IOException {
        int result = new Day8().accumulatorValue2();
        System.out.println(result);
    }

    @Test
    public void day9RunFirst() throws IOException {
        long result = new Day9().getNumberThatHaveNotSum();
        System.out.println(result);
    }

}
