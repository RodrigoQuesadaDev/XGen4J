package com.rodrigodev.xgen4j_table_generator.test.common;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

import static com.rodrigodev.xgen4j.common.exception.ExceptionUtils.unchecked;

/**
 * Created by Rodrigo Quesada on 01/04/15.
 */
public class StringUtils {

    private static final String LINE_BREAK_REGEX = "[\n\r]+";
    private static final Pattern LINE_BREAK_PATTERN = Pattern.compile(LINE_BREAK_REGEX);
    private static final Pattern LINE_BREAK_WITHOUT_TRIM = Pattern.compile("\\s*" + LINE_BREAK_REGEX + "\\s*");

    public static String normalizeLineBreaks(String aContent) {
        return LINE_BREAK_PATTERN.matcher(aContent).replaceAll("\n");
    }

    public static String trimLines(String aContent) {
        return LINE_BREAK_WITHOUT_TRIM.matcher(aContent).replaceAll("\n");
    }

    public static InputStream toInputStream(String aValue) {
        return IOUtils.toInputStream(aValue, StandardCharsets.UTF_8);
    }

    public static String fromInputStream(InputStream anInputStream) {
        return unchecked(() -> IOUtils.toString(anInputStream, StandardCharsets.UTF_8));
    }
}
