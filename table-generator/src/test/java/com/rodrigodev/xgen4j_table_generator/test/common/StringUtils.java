/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Rodrigo Quesada <rodrigoquesada.dev@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

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
