package com.rodrigodev.xgen4j.model.common.template.model;

import com.rodrigodev.xgen4j.model.error.ErrorClassFile;
import com.rodrigodev.xgen4j.model.support.optional.OptionalClassType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.util.Optional;

/**
 * Created by Rodrigo Quesada on 13/07/15.
 */
@Getter
@FieldDefaults(makeFinal = true)
@ToString
public class OptionalTypeTemplateModel extends TypeTemplateModel {

    private String emptyMethod;

    private OptionalTypeTemplateModel(OptionalClassType optionalClassType, String name, String canonicalName) {
        super(name, canonicalName);
        this.emptyMethod = optionalClassType.emptyMethodName();
    }

    private OptionalTypeTemplateModel(OptionalClassType optionalClassType) {
        super(optionalClassType.type().get());
        this.emptyMethod = optionalClassType.emptyMethodName();
    }

    public static OptionalTypeTemplateModelBuilder builder() {
        return new OptionalTypeTemplateModelBuilder();
    }

    @Setter
    @Accessors(fluent = true)
    public static class OptionalTypeTemplateModelBuilder {

        private ErrorClassFile rootErrorClassFile;
        private OptionalClassType optionalClassType;

        public OptionalTypeTemplateModel build() {

            OptionalTypeTemplateModel model;

            Optional<Class<?>> type = optionalClassType.type();
            if (type.isPresent()) {
                model = new OptionalTypeTemplateModel(optionalClassType);
            }
            else {
                model = new OptionalTypeTemplateModel(
                        optionalClassType,
                        optionalClassType.typeName(),
                        optionalClassType.customCanonicalName(rootErrorClassFile.classDefinition().packagePath())
                );
            }

            return model;
        }
    }
}
