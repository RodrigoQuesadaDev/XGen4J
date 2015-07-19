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