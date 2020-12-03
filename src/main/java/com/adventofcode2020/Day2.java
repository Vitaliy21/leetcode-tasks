package com.adventofcode2020;

import com.adventofcode2020.dto.PasswordDto;
import com.adventofcode2020.tools.CommonUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * --- Part One ---
 * To try to debug the problem, they have created a list (your puzzle input) of passwords (according to the corrupted database)
 * and the corporate policy when that password was set.
 *
 * For example, suppose you have the following list:
 *
 * 1-3 a: abcde
 * 1-3 b: cdefg
 * 2-9 c: ccccccccc
 *
 * Each line gives the password policy and then the password. The password policy indicates the lowest
 * and highest number of times a given letter must appear for the password to be valid. For example,
 * 1-3 a means that the password must contain a at least 1 time and at most 3 times.
 *
 * In the above example, 2 passwords are valid. The middle password, cdefg, is not;
 * it contains no instances of b, but needs at least 1. The first and third passwords are valid: they contain one a or nine c,
 * both within the limits of their respective policies.
 *
 * How many passwords are valid according to their policies?
 *
 * --- Part Two ---
 * Each policy actually describes two positions in the password, where 1 means the first character,
 * 2 means the second character, and so on. (Be careful; Toboggan Corporate Policies have no concept of "index zero"!)
 * Exactly one of these positions must contain the given letter. Other occurrences of the letter are irrelevant for the purposes of policy enforcement.
 *
 * Given the same example list from above:
 *
 * 1-3 a: abcde is valid: position 1 contains a and position 3 does not.
 * 1-3 b: cdefg is invalid: neither position 1 nor position 3 contains b.
 * 2-9 c: ccccccccc is invalid: both position 2 and position 9 contain c.
 *
 * How many passwords are valid according to the new interpretation of the policies?
 **/

public class Day2 {

    private final static String SOURCE_FILE = "src/main/resources/adventofcode2020/day2.txt";

    //correct answer: 493
    public int countValidPasswords() throws IOException {
        int resultCount = 0;
        List<String> inputData = CommonUtils.readFileAsListOfLines(SOURCE_FILE);
        List<PasswordDto> passwordObjects = convertLinesToObjects(inputData);
        for (PasswordDto passwordDto : passwordObjects) {
            if (isPasswordValid(passwordDto)) {
                resultCount ++;
            }
        }
        return resultCount;
    }

    //correct answer: 593
    public int countValidPasswords2() throws IOException {
        int resultCount = 0;
        List<String> inputData = CommonUtils.readFileAsListOfLines(SOURCE_FILE);
        List<PasswordDto> passwordObjects = convertLinesToObjects(inputData);
        for (PasswordDto passwordDto : passwordObjects) {
            if (isPasswordValid2(passwordDto)) {
                resultCount ++;
            }
        }
        return resultCount;
    }

    private boolean isPasswordValid2(PasswordDto passwordDto) {
        char firstSymbol = passwordDto.getPassword().charAt(passwordDto.getLowestCount()-1);
        char secondSymbol = passwordDto.getPassword().charAt(passwordDto.getHighestCount()-1);
        boolean firstEquals = String.valueOf(firstSymbol).equals(passwordDto.getSymbol());
        boolean secondEquals = String.valueOf(secondSymbol).equals(passwordDto.getSymbol());
        if (firstEquals) {
            return !secondEquals;
        } else return secondEquals;
    }

    private boolean isPasswordValid(PasswordDto passwordDto) {
        int count = StringUtils.countMatches(passwordDto.getPassword(), passwordDto.getSymbol());
        return count >= passwordDto.getLowestCount() && count <= passwordDto.getHighestCount();
    }

    private List<PasswordDto> convertLinesToObjects(List<String> lines) {
        List<PasswordDto> result = new ArrayList<>();
        for (String line : lines) {
            String[] parts = line.split(" ");
            PasswordDto object = new PasswordDto();
            object.setLowestCount(Integer.parseInt(parts[0].split("-")[0]));
            object.setHighestCount(Integer.parseInt(parts[0].split("-")[1]));
            object.setSymbol(parts[1].substring(0,1));
            object.setPassword(parts[2]);
            result.add(object);
        }
        return result;
    }
}
