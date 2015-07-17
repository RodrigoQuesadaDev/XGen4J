package com.rodrigodev.xgen4j.model.error.configuration.definition.package_path;

import java.util.regex.Pattern;

/**
 * Created by Rodrigo Quesada on 30/06/15.
 */
public class PackagePathConverter {

    public static final Pattern CAMEL_CASE_START_PATTERN = Pattern.compile("(?<=[\\p{Lower}\\d])\\p{Upper}");
    public static final Pattern HYPHEN_PATTERN = Pattern.compile("-");

    public static String errorNameToPackagePart(String name) {
        name = CAMEL_CASE_START_PATTERN.matcher(name).replaceAll("_$0");
        name = HYPHEN_PATTERN.matcher(name).replaceAll("_");
        return name.toLowerCase();
    }

    public static String codeNameToPackagePart(String name) {
        return HYPHEN_PATTERN.matcher(name).replaceAll("_");
    }
}
