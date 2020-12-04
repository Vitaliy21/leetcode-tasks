package com.adventofcode2020.tools;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CommonUtils {

    public static List<String> readFileAsListOfLines(String source) throws IOException {
        return Files.readAllLines(new File(source).toPath(), Charset.defaultCharset());
    }

    public static String readFileAsString(String source) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(source));
        return new String(encoded, StandardCharsets.UTF_8);
    }

}
