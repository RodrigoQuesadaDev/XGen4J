package com.rodrigodev.xgen.model.common.template.model;

import lombok.NonNull;
import lombok.Value;

/**
 * Created by Rodrigo Quesada on 24/06/15.
 */
@Value
public class TypeTemplateModel {

    @NonNull private String name;
    @NonNull private String canonicalName;
}
