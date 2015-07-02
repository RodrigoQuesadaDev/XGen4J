package com.rodrigodev.xgen.model.error.configuration.code;

import lombok.NonNull;
import lombok.Value;
import lombok.experimental.Accessors;

import java.util.Optional;
import java.util.regex.Pattern;

import static com.google.common.base.Preconditions.*;

/**
 * Created by Rodrigo Quesada on 12/05/15.
 */
@Value
@Accessors(fluent = true)
public class ErrorCodeDefinition {

    private static final Pattern VALID_CODE_NAME_PATTERN = Pattern.compile("\\p{Lower}[\\p{Lower}\\d\\-]*",
                                                                           Pattern.UNICODE_CASE);

    @NonNull private String name;
    @NonNull private Optional<Integer> number;

    public ErrorCodeDefinition(@NonNull String name, @NonNull Optional<Integer> number) {
        checkArgument(
                VALID_CODE_NAME_PATTERN.matcher(name).matches(),
                String.format("Error code's name '%s' has invalid format.", name)
        );

        this.name = name;
        this.number = number;
    }

    public ErrorCodeDefinition withNumber(int codeNumber) {
        return new ErrorCodeDefinition(name, Optional.of(codeNumber));
    }

    public static String codeNameFrom(@NonNull String text) {
        return TextToCodeNameConverter.convert(text);
    }
}
