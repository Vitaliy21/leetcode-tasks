package com.adventofcode2020.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParamsValidator {

    private static final int min_height_in_cm = 150;
    private static final int max_height_in_cm = 193;
    private static final int min_height_in_in = 59;
    private static final int max_height_in_in = 76;
    private static final String COLOR_PATTERN = "#([0-9a-f]{6})";

    private enum EyesColors {
        amb, blu, brn, gry, grn, hzl, oth
    }

    public static String yearsValidate(String value, int minValid, int maxValid) {
        try {
            int parsedInt = Integer.parseInt(value);
            if (parsedInt >= minValid && parsedInt <= maxValid) {
                return value;
            } else return null;
        } catch (Exception e) {
            return null;
        }
    }

    public static String heightValidate(String value) {
        try {
            int parsedInt = Integer.parseInt(value.substring(0, value.length() - 2));
            if (value.endsWith("cm")) {
                if (parsedInt >= min_height_in_cm && parsedInt <= max_height_in_cm) {
                    return value;
                } else return null;
            } else if (value.endsWith("in")) {
                if (parsedInt >= min_height_in_in && parsedInt <= max_height_in_in) {
                    return value;
                } else return null;
            } else return null;
        } catch (Exception e) {
            return null;
        }
    }

    public static String hairColorValidate(String value) {
        try {
            Pattern colorPattern = Pattern.compile(COLOR_PATTERN);
            Matcher m = colorPattern.matcher(value);
            if (m.matches()) {
                return value;
            } else return null;
        } catch (Exception e) {
            return null;
        }
    }

    public static String eyesColorValidate(String value) {
        try {
            return EyesColors.valueOf(value).toString();
        } catch (Exception e) {
            return null;
        }
    }

    public static String passportIdValidate(String value) {
        try {
            if (value.length() < 9 || value.length() > 9) {
                return null;
            } else {
                Integer.parseInt(value);
                return value;
            }
        } catch (Exception e) {
            return null;
        }
    }

}
