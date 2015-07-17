package com.rodrigodev.xgen4j.model.error.template.model;

import com.rodrigodev.xgen4j.model.common.template.model.TypeTemplateModel;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 * Created by Rodrigo Quesada on 17/07/15.
 */
@Getter
@FieldDefaults(makeFinal = true)
@ToString
public class ParentModel extends TypeTemplateModel {

    private boolean root;

    public ParentModel(@NonNull TypeTemplateModel parent, @NonNull RootTemplateModel root) {
        super(parent);
        this.root = parent.equals(root);
    }
}
