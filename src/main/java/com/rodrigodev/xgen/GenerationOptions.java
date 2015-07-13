package com.rodrigodev.xgen;

import com.rodrigodev.xgen.model.support.optional.OptionalClassType;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.Accessors;

import static com.rodrigodev.xgen.model.support.optional.OptionalClassType.JAVA_8;

/**
 * Created by Rodrigo Quesada on 12/07/15.
 */
@Value
@Builder
@Accessors(fluent = true)
public class GenerationOptions {


    private boolean checkedExceptions;
    private OptionalClassType optionalClassType;

    public GenerationOptions(boolean checkedExceptions, OptionalClassType optionalClassType) {
        this.checkedExceptions = checkedExceptions;
        this.optionalClassType = optionalClassType != null ? optionalClassType : JAVA_8;
    }
}
