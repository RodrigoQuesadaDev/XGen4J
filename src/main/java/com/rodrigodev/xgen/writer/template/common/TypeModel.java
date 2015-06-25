package com.rodrigodev.xgen.writer.template.common;

import lombok.NonNull;
import lombok.Value;

/**
 * Created by Rodrigo Quesada on 24/06/15.
 */
@Value
public class TypeModel {

    @NonNull private String name;
    @NonNull private String canonicalName;
}
