package com.rodrigodev.xgen.model.error.configuration.definition.name;

import java.util.regex.Pattern;

/**
 * Created by Rodrigo Quesada on 30/06/15.
 */
public class ErrorNameConverter {

    private static final String DOT = ".";
    public static final Pattern CAMEL_CASE_START_PATTERN = Pattern.compile("(?<=\\p{Lower})\\p{Upper}");
    public static final Pattern HYPHEN_PATTERN = Pattern.compile("-");

    public static String convertToPackagePart(String name) {
        name = CAMEL_CASE_START_PATTERN.matcher(name).replaceAll("_$0");
        name = HYPHEN_PATTERN.matcher(name).replaceAll("_");
        return name.toLowerCase();
    }

    public static String addPackagePartFromName(String packagePath, String name) {
        return packagePath + DOT + ErrorNameConverter.convertToPackagePart(name);
    }
}
