package com.rodrigodev.xgen4j_table_generator;

import com.rodrigodev.xgen4j_table_generator.model.information.InformationWrapper;
import com.rodrigodev.xgen4j_table_generator.model.table.TableWriter;
import com.rodrigodev.xgen4j_table_generator.service.file.FileService;
import lombok.NonNull;

import javax.inject.Inject;
import java.io.OutputStream;
import java.nio.file.Paths;

/**
 * Created by Rodrigo Quesada on 15/07/15.
 */
public class TableGenerator {

    public static class InjectedFields {

        @Inject FileService fileService;
        @Inject TableWriter tableWriter;

        @Inject
        public InjectedFields() {
        }
    }

    @Inject InjectedFields inj;

    TableGenerator(@NonNull InjectedFields injectedFields) {
        this.inj = injectedFields;
    }

    public TableGenerator() {
        DaggerTableGeneratorComponent.create().inject(this);
    }

    public void generate(@NonNull InformationWrapper information, @NonNull String filePath) {
        try (OutputStream output = inj.fileService.openFile(Paths.get(filePath).toFile())) {
            inj.tableWriter.write(information, output);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
