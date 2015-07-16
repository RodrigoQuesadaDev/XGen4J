package com.rodrigodev.xgen4j_table_generator;

import com.rodrigodev.xgen4j_table_generator.TableGenerator.InjectedFields;
import com.rodrigodev.xgen4j_table_generator.service.ServiceModule;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Rodrigo Quesada on 27/06/15.
 */
@Module(includes = ServiceModule.class)
public class MainModule {

    @Provides
    public TableGenerator provideExceptionsGenerator(InjectedFields injectedFields) {
        return new TableGenerator(injectedFields);
    }
}
