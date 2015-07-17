package com.rodrigodev.xgen4j.common.lang;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by Rodrigo Quesada on 25/05/15.
 */
public class PackageUtil {

    private static final char DOT_CHAR = '.';
    private static final String DOT = ".";

    public static String toFilePath(String packagePath) {
        return packagePath.replace(DOT_CHAR, File.separatorChar);
    }

    public static String join(String... packageParts) {
        return Arrays.stream(packageParts).collect(Collectors.joining(DOT));
    }
}
