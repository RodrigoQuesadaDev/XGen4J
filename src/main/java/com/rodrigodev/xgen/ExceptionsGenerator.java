package com.rodrigodev.xgen;

import com.google.common.io.Files;
import com.rodrigodev.xgen.configuration.ErrorDefinition;
import com.rodrigodev.xgen.writer.ClassWriter;
import com.rodrigodev.xgen.writer.file_definition.ErrorClassDefinition;
import com.rodrigodev.xgen.writer.file_definition.ErrorClassFile;
import com.rodrigodev.xgen.writer.template.error.ErrorClassTemplate;
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
        try {
            //TODO remove this configuration, it does not belong here
            Configuration configuration = new Configuration(Configuration.VERSION_2_3_22);
            configuration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));
            configuration.setDefaultEncoding("UTF-8");
            configuration.setTemplateExceptionHandler(
                    TemplateExceptionHandler.RETHROW_HANDLER);
            exceptionClassTemplate = configuration.getTemplate("exception-class-def.ftl");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void generate(@NonNull ErrorDefinition error) {

        generateErrorClass(error);
        //generateExceptionClass(anError);

        ErrorDefinition[] subErrors = error.errors();
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
        errorClassWriter.write(new ErrorClassTemplate(classFile));
    }
}
