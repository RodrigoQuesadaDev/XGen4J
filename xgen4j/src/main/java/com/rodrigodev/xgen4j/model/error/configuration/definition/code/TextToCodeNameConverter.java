package com.rodrigodev.xgen4j.model.error.configuration.definition.code;

import lombok.Getter;
import lombok.experimental.Accessors;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.*;

/**
 * Created by Rodrigo Quesada on 29/06/15.
 */
@Accessors(fluent = true)
public class TextToCodeNameConverter {

    private static final ConversionStrategy[] CONVERSION_STRATEGIES = {new WordOrNumberStrategy(), new NonAlphaNumericStrategy()};
    private static final Pattern MATCHES_ANY_PATTERN = Pattern.compile(
            Arrays.stream(CONVERSION_STRATEGIES).map(ConversionStrategy::regex).collect(Collectors.joining("|")),
            Pattern.UNICODE_CASE
    );

    public static String convert(String text) {
        checkArgument(!text.isEmpty(), "text is empty");

        StringBuilder codeName = new StringBuilder(text.length());

        Matcher matcher = MATCHES_ANY_PATTERN.matcher(text);
        while (matcher.find()) {
            String match = matcher.group();
            for (ConversionStrategy conversionStrategy : CONVERSION_STRATEGIES) {
                if (conversionStrategy.matches(match)) {
                    conversionStrategy.execute(match, codeName);
                    break;
                }
            }
        }
        codeName.deleteCharAt(codeName.length() - 1);

        return codeName.toString();
    }

    private static class WordOrNumberStrategy extends ConversionStrategy {

        private static final String REGEX = "\\p{Upper}\\p{Lower}*|\\p{Alpha}+|\\d+";

        public WordOrNumberStrategy() {
            super(REGEX);
        }

        @Override
        public void execute(String match, StringBuilder codeName) {
            codeName.append(match.toLowerCase());
            codeName.append('-');
        }
    }

    private static class NonAlphaNumericStrategy extends ConversionStrategy {

        private static final String REGEX = "[^\\p{Alnum}]+";

        public NonAlphaNumericStrategy() {
            super(REGEX);
        }

        @Override
        public void execute(String match, StringBuilder codeName) {
            // DO NOTHING!
        }
    }

    private abstract static class ConversionStrategy {

        @Getter private final String regex;
        private final Pattern PATTERN;

        public ConversionStrategy(String regex) {
            this.regex = regex;
            this.PATTERN = Pattern.compile(regex);
        }

        public boolean matches(String text) {
            return PATTERN.matcher(text).matches();
        }

        abstract void execute(String match, StringBuilder codeName);
    }
}