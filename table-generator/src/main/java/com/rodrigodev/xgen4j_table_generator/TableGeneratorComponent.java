package com.rodrigodev.xgen4j_table_generator;

import dagger.Component;

import javax.inject.Singleton;

/**
 * Created by Rodrigo Quesada on 27/06/15.
 */
@Singleton
@Component(modules = {MainModule.class})
public interface TableGeneratorComponent {

    void inject(TableGenerator generator);

    TableGenerator generator();
}