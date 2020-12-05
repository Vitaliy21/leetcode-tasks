package com.adventofcode2020.tools;

import com.adventofcode2020.dto.PassportDto;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day4 {

    private final static String SOURCE_FILE = "src/main/resources/adventofcode2020/day4.txt";

    //correct answer: 226
    public int countValidPassports() throws IOException {
        String inputData = CommonUtils.readFileAsString(SOURCE_FILE);
        List<String> parsedInputData = Arrays.asList(inputData.split("\r\n\r\n"));

        List<PassportDto> validPassports = parsedInputData.stream().map(this::parseToObject)
                .filter(p -> p.getBirthYear() != null && p.getExpirationYear()!=null && p.getPassportId()!=null
                        && p.getEyeColor()!=null && p.getHairColor()!=null
                        && p.getHeight()!=null && p.getIssueYear()!=null)
                .collect(Collectors.toList());

        return validPassports.size();
    }

    //correct answer: 160
    public int countValidPassportsWithAdditionalValidation() throws IOException {
        String inputData = CommonUtils.readFileAsString(SOURCE_FILE);
        List<String> parsedInputData = Arrays.asList(inputData.split("\r\n\r\n"));

        List<PassportDto> validPassports = parsedInputData.stream().map(this::parseToObjectWithValidation)
                .filter(p -> p.getBirthYear() != null && p.getExpirationYear()!=null && p.getPassportId()!=null
                        && p.getEyeColor()!=null && p.getHairColor()!=null
                        && p.getHeight()!=null && p.getIssueYear()!=null)
                .collect(Collectors.toList());

        return validPassports.size();
    }

    private PassportDto parseToObject(String element) {
        List<String> fields = Arrays.asList(element.split(" |\r\n"));
        Map<String, String> fieldsMap = fields.stream().collect(Collectors.toMap(s -> s.substring(0,3), s -> s.substring(4)));
        PassportDto passportDto = new PassportDto();
        passportDto.setBirthYear(fieldsMap.get("byr"));
        passportDto.setIssueYear(fieldsMap.get("iyr"));
        passportDto.setExpirationYear(fieldsMap.get("eyr"));
        passportDto.setHeight(fieldsMap.get("hgt"));
        passportDto.setHairColor(fieldsMap.get("hcl"));
        passportDto.setEyeColor(fieldsMap.get("ecl"));
        passportDto.setPassportId(fieldsMap.get("pid"));
        passportDto.setCountryId(fieldsMap.get("cid"));
        return passportDto;
    }

    private PassportDto parseToObjectWithValidation(String element) {
        List<String> fields = Arrays.asList(element.split(" |\r\n"));
        Map<String, String> fieldsMap = fields.stream().collect(Collectors.toMap(s -> s.substring(0,3), s -> s.substring(4)));
        PassportDto passportDto = new PassportDto();
        passportDto.setBirthYear(ParamsValidator.yearsValidate(fieldsMap.get("byr"), 1920, 2002));
        passportDto.setIssueYear(ParamsValidator.yearsValidate(fieldsMap.get("iyr"), 2010, 2020));
        passportDto.setExpirationYear(ParamsValidator.yearsValidate(fieldsMap.get("eyr"), 2020, 2030));
        passportDto.setHeight(ParamsValidator.heightValidate(fieldsMap.get("hgt")));
        passportDto.setHairColor(ParamsValidator.hairColorValidate(fieldsMap.get("hcl")));
        passportDto.setEyeColor(ParamsValidator.eyesColorValidate(fieldsMap.get("ecl")));
        passportDto.setPassportId(ParamsValidator.passportIdValidate(fieldsMap.get("pid")));
        passportDto.setCountryId(fieldsMap.get("cid"));
        return passportDto;
    }

}
