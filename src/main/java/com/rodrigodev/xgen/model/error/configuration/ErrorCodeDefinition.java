package com.rodrigodev.xgen.model.error.configuration;

import lombok.Getter;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.Accessors;

import java.util.Arrays;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.*;

/**
 * Created by Rodrigo Quesada on 12/05/15.
 */
@Value
@Accessors(fluent = true)
public class ErrorCodeDefinition {

    private static final Pattern VALID_CODE_NAME_PATTERN = Pattern.compile("\\p{Lower}[\\p{Lower}\\d\\-\\.]*",
                                                                           Pattern.UNICODE_CASE);

    public static final String DOT = ".";
    @NonNull private String name;
    @NonNull private Optional<String> number;

    public ErrorCodeDefinition(@NonNull String name, @NonNull Optional<String> number) {
        checkArgument(
                VALID_CODE_NAME_PATTERN.matcher(name).matches(),
                String.format("Error code's name '%s' has invalid format.", name)
        );

        this.name = name;
        this.number = number;
    }

    public ErrorCodeDefinition withParent(ErrorCodeDefinition parentCode) {
        return new ErrorCodeDefinition(addParentName(parentCode.name), parentCode.number());
    }

    private String addParentName(String parentName) {
        return parentName + DOT + name;
    }

    public static String codeNameFrom(@NonNull String text) {
        return TextToCodeNameConverter.convert(text);
    }

    private static class TextToCodeNameConverter {

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
}
