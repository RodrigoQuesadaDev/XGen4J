package com.rodrigodev.xgen.writer.file_definition;

import com.rodrigodev.xgen.configuration.ErrorDefinition;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.Accessors;

/**
 * Created by Rodrigo Quesada on 25/05/15.
 */
@Accessors(fluent = true)
public abstract class ClassDefinitionForError extends ClassDefinition {

    @NonNull @Getter private ErrorDefinition errorDefinition;

    public ClassDefinitionForError(@NonNull ErrorDefinition errorDefinition, String nameSuffix) {
        super(generateName(errorDefinition, nameSuffix), errorDefinition.basePackage());
        this.errorDefinition = errorDefinition;
    }

    private static String generateName(ErrorDefinition errorDefinition, String nameSuffix) {
        return errorDefinition.name() + nameSuffix;
    }

    public boolean isConcrete() {
        return errorDefinition.description().isPresent();
    }
}
