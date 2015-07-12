package com.rodrigodev.xgen;

import lombok.Builder;
import lombok.Value;
import lombok.experimental.Accessors;

/**
 * Created by Rodrigo Quesada on 12/07/15.
 */
@Value
@Builder
@Accessors(fluent = true)
public class GenerationOptions {

    private boolean checkedExceptions;
}
