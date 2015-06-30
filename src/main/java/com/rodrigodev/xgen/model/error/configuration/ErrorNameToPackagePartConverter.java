package com.rodrigodev.xgen.model.error.configuration;

import java.util.regex.Pattern;

/**
 * Created by Rodrigo Quesada on 30/06/15.
 */
public class ErrorNameToPackagePartConverter {

    public static final Pattern CAMEL_CASE_START_PATTERN = Pattern.compile("(?<=\\p{Lower})\\p{Upper}");
    public static final Pattern HYPHEN_PATTERN = Pattern.compile("-");

    public static String convert(String name) {
        name = CAMEL_CASE_START_PATTERN.matcher(name).replaceAll("_$0");
        name = HYPHEN_PATTERN.matcher(name).replaceAll("_");
        return name.toLowerCase();
    }
}
