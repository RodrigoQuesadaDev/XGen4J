package com.rodrigodev.xgen.model.error;

import com.rodrigodev.xgen.model.common.clazz.ClassDefinition;
import com.rodrigodev.xgen.model.error.configuration.ErrorDefinition;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

/**
 * Created by Rodrigo Quesada on 25/05/15.
 */
@Accessors(fluent = true)
@FieldDefaults(makeFinal = true)
public abstract class ClassDefinitionForError extends ClassDefinition {

    public static final String UNDERSCORE = "_";
    public static final String NON_WORD_CHAR_REGEX = "[^\\w]";

    @NonNull @Getter private ErrorDefinition errorDefinition;

    public ClassDefinitionForError(@NonNull ErrorDefinition errorDefinition, String nameSuffix) {
        super(generateName(errorDefinition, nameSuffix), errorDefinition.packagePath());
        this.errorDefinition = errorDefinition;
    }

    private static String generateName(ErrorDefinition errorDefinition, String nameSuffix) {
        return errorDefinition.name().replaceAll(NON_WORD_CHAR_REGEX, UNDERSCORE) + nameSuffix;
    }

    public boolean isConcrete() {
        return errorDefinition.description().isPresent();
    }
}
