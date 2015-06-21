package com.rodrigodev.xgen;

import com.google.common.io.Files;
import com.rodrigodev.xgen.configuration.ErrorDefinition;
import com.rodrigodev.xgen.writer.ClassWriter;
import com.rodrigodev.xgen.writer.file_definition.ErrorClassDefinition;
import com.rodrigodev.xgen.writer.file_definition.ErrorClassFile;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import lombok.NonNull;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by Rodrigo Quesada on 12/05/15.
 */
public class ExceptionsGenerator {

    public static final String SRC_DIRECTORY = "src/test-gen/java";

    private Configuration configuration;
    private ClassWriter errorClassWriter;
    private Template exceptionClassTemplate;

    public ExceptionsGenerator(@NonNull String baseDirPath) {



            errorClassWriter = new ClassWriter();
            exceptionClassTemplate = configuration.getTemplate("exception-class-def.ftl");

    }

    public void generate(@NonNull ErrorDefinition error) {

        generateErrorClass(error);
        //generateExceptionClass(anError);

        ErrorDefinition[] subErrors = error.getErrors();
        for (ErrorDefinition subError : subErrors) {
            generate(subError);
        }

        try (BufferedWriter exceptionClassWriter = Files.newWriter(
                new File("src/test-gen/java",
                         "com/rodrigodev/xgen/test/gen/exceptions_generator/generate/DirtyException.java"
                ), Charset.defaultCharset()
        )) {
            exceptionClassTemplate.process(null, exceptionClassWriter);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void generateErrorClass(ErrorDefinition error) {

        ErrorClassDefinition errorClass = new ErrorClassDefinition(error);
        ErrorClassFile classFile = new ErrorClassFile(SRC_DIRECTORY, errorClass);
        errorClassWriter.write(classFile);
    }
}
