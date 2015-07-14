package com.rodrigodev.xgen4j;

import com.rodrigodev.xgen4j.model.support.optional.OptionalClassType;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.Accessors;

import static com.rodrigodev.xgen4j.model.support.optional.OptionalClassType.JAVA_8;

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
