package com.adventofcode2020;

import org.junit.Test;

import java.io.IOException;

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
        int result = new Day5().findMaxSeatId();
        System.out.println(result);
    }

}
